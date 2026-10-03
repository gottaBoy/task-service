/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppViewDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModuleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBar;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBarBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewStyle;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewStyleBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPDTViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPDTViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewRefService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewRefServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageService;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import net.ibizsys.pscore.srv.config.entity.PSViewEngineBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTemplBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModule;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModuleBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewType;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubViewTypeBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewWizardGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewWizardGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestCaseServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewServiceBase<ET extends PSAppView>
extends PSCoreSysServiceBase<ET> {
    private static final Log log = LogFactory.getLog(PSAppViewServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_INDEXDE = "IndexDE";
    public static final String ACTION_INITDYNAVIEW = "InitDynaView";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_JITPREVIEW2 = "JITPREVIEW2";
    private PSAppViewDEModel pSAppViewDEModel;
    private PSAppViewDAO pSAppViewDAO;

    public PSAppViewDEModel getPSAppViewDEModel() {
        if (this.pSAppViewDEModel == null) {
            try {
                this.pSAppViewDEModel = (PSAppViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppViewDEModel();
    }

    public PSAppViewDAO getPSAppViewDAO() {
        if (this.pSAppViewDAO == null) {
            try {
                this.pSAppViewDAO = (PSAppViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_INDEXDE, (boolean)true) == 0) {
            return this.fetchIndexDE(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_INDEXDE, (boolean)true) == 0) {
            return this.fetchTempIndexDE(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITDYNAVIEW, (boolean)true) == 0) {
            this.initDynaView((ET)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((ET)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW2, (boolean)true) == 0) {
            this.jITPreview2((ET)iEntity);
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

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, true);
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

    public DBFetchResult fetchIndexDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_INDEXDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempIndexDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_INDEXDE, true);
        return dBFetchResult;
    }

    public void initDynaView(ET ET) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITDYNAVIEW, 0, ET, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(ET, ACTION_INITDYNAVIEW);
        final ET ET2 = ET;
        this.doServiceWork(new IServiceWork(){
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppViewServiceBase.this.getService(), PSAppViewServiceBase.ACTION_INITDYNAVIEW, 40, ET2, null).getResult() != 1) {
                    PSAppViewServiceBase.this.onInitDynaView(ET2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITDYNAVIEW, 99, ET, null);
        }
    }

    protected void onInitDynaView(ET ET) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitDynaView]");
    }

    public void jITPreview(ET ET) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, ET, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(ET, ACTION_JITPREVIEW);
        final ET ET2 = ET;
        this.doServiceWork(new IServiceWork(){
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppViewServiceBase.this.getService(), PSAppViewServiceBase.ACTION_JITPREVIEW, 40, ET2, null).getResult() != 1) {
                    PSAppViewServiceBase.this.onJITPreview(ET2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, ET, null);
        }
    }

    protected void onJITPreview(ET ET) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void jITPreview2(ET ET) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW2, 0, ET, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(ET, ACTION_JITPREVIEW2);
        final ET ET2 = ET;
        this.doServiceWork(new IServiceWork(){
            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSAppViewServiceBase.this.getService(), PSAppViewServiceBase.ACTION_JITPREVIEW2, 40, ET2, null).getResult() != 1) {
                    PSAppViewServiceBase.this.onJITPreview2(ET2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW2, 99, ET, null);
        }
    }

    protected void onJITPreview2(ET ET) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW2]");
    }

    protected void onFillParentInfo(ET ET, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(ET, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iService.getDEModel().createEntity();
            pSAppLocalDE.set("PSAPPLOCALDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppLocalDE);
            } else {
                iService.get(pSAppLocalDE);
            }
            this.onFillParentInfo_PSAppLocalDE(ET, pSAppLocalDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService", (SessionFactory)this.getSessionFactory());
            PSAppModule pSAppModule = (PSAppModule)iService.getDEModel().createEntity();
            pSAppModule.set("PSAPPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppModule);
            } else {
                iService.get(pSAppModule);
            }
            this.onFillParentInfo_PSAppModule(ET, pSAppModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSAPPTITLEBAR_PSAPPTITLEBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService", (SessionFactory)this.getSessionFactory());
            PSAppTitleBar pSAppTitleBar = (PSAppTitleBar)iService.getDEModel().createEntity();
            pSAppTitleBar.set("PSAPPTITLEBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppTitleBar);
            } else {
                iService.get(pSAppTitleBar);
            }
            this.onFillParentInfo_PSAppTitleBar(ET, pSAppTitleBar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSAPPVIEWSTYLE_PSAPPVIEWSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService", (SessionFactory)this.getSessionFactory());
            PSAppViewStyle pSAppViewStyle = (PSAppViewStyle)iService.getDEModel().createEntity();
            pSAppViewStyle.set("PSAPPVIEWSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppViewStyle);
            } else {
                iService.get(pSAppViewStyle);
            }
            this.onFillParentInfo_PSAppViewStyle(ET, pSAppViewStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(ET, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(ET, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService", (SessionFactory)this.getSessionFactory());
            PSDynaDEViewTempl pSDynaDEViewTempl = (PSDynaDEViewTempl)iService.getDEModel().createEntity();
            pSDynaDEViewTempl.set("PSDYNADEVIEWTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaDEViewTempl);
            } else {
                iService.get(pSDynaDEViewTempl);
            }
            this.onFillParentInfo_PSDynaDEViewTempl(ET, pSDynaDEViewTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSHELPMODULE_PSHELPMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.helpdesign.service.PSHelpModuleService", (SessionFactory)this.getSessionFactory());
            PSHelpModule pSHelpModule = (PSHelpModule)iService.getDEModel().createEntity();
            pSHelpModule.set("PSHELPMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSHelpModule);
            } else {
                iService.get(pSHelpModule);
            }
            this.onFillParentInfo_PSHelpModule(ET, pSHelpModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(ET, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSLANGUAGERES_SUBCAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_SubCapPSLanRes(ET, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSLANGUAGERES_TITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TitlePSLanRes(ET, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(ET, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSUBVIEWTYPE_PSSUBVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService", (SessionFactory)this.getSessionFactory());
            PSSubViewType pSSubViewType = (PSSubViewType)iService.getDEModel().createEntity();
            pSSubViewType.set("PSSUBVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubViewType);
            } else {
                iService.get(pSSubViewType);
            }
            this.onFillParentInfo_PSSubViewType(ET, pSSubViewType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(ET, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(ET, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(ET, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(ET, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(ET, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUniRes);
            } else {
                iService.get(pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(ET, pSSysUniRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(ET, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSVIEWENGINE_PSVIEWENGINEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewEngineService", (SessionFactory)this.getSessionFactory());
            PSViewEngine pSViewEngine = (PSViewEngine)iService.getDEModel().createEntity();
            pSViewEngine.set("PSVIEWENGINEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewEngine);
            } else {
                iService.get(pSViewEngine);
            }
            this.onFillParentInfo_PSViewEngine(ET, pSViewEngine);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(ET, pSViewMsgGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSVIEWWIZARDGROUP_PSVIEWWIZARDGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewWizardGroupService", (SessionFactory)this.getSessionFactory());
            PSViewWizardGroup pSViewWizardGroup = (PSViewWizardGroup)iService.getDEModel().createEntity();
            pSViewWizardGroup.set("PSVIEWWIZARDGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewWizardGroup);
            } else {
                iService.get(pSViewWizardGroup);
            }
            this.onFillParentInfo_PSViewWizardGroup(ET, pSViewWizardGroup);
            return;
        }
        super.onFillParentInfo(ET, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(ET ET, PSACHandler pSACHandler) throws Exception {
        ((PSAppViewBase)ET).setPSACHandlerId(pSACHandler.getPSACHandlerId());
        ((PSAppViewBase)ET).setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSAppLocalDE(ET ET, PSAppLocalDE pSAppLocalDE) throws Exception {
        ((PSAppViewBase)ET).setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
        ((PSAppViewBase)ET).setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
    }

    protected void onFillParentInfo_PSAppModule(ET ET, PSAppModule pSAppModule) throws Exception {
        ((PSAppViewBase)ET).setModColor(pSAppModule.getColor());
        ((PSAppViewBase)ET).setPSAppModuleId(pSAppModule.getPSAppModuleId());
        ((PSAppViewBase)ET).setPSAppModuleName(pSAppModule.getPSAppModuleName());
        if (pSAppModule.getPSSysApp() != null) {
            this.onFillParentInfo_PSSysApp(ET, pSAppModule.getPSSysApp());
        }
    }

    protected void onFillParentInfo_PSAppTitleBar(ET ET, PSAppTitleBar pSAppTitleBar) throws Exception {
        ((PSAppViewBase)ET).setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
        ((PSAppViewBase)ET).setPSAppTitleBarName(pSAppTitleBar.getPSAppTitleBarName());
    }

    protected void onFillParentInfo_PSAppViewStyle(ET ET, PSAppViewStyle pSAppViewStyle) throws Exception {
        ((PSAppViewBase)ET).setPSAppViewStyleId(pSAppViewStyle.getPSAppViewStyleId());
        ((PSAppViewBase)ET).setPSAppViewStyleName(pSAppViewStyle.getPSAppViewStyleName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(ET ET, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ((PSAppViewBase)ET).setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        ((PSAppViewBase)ET).setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDEViewBase(ET ET, PSDEViewBase pSDEViewBase) throws Exception {
        ((PSAppViewBase)ET).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        ((PSAppViewBase)ET).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        ((PSAppViewBase)ET).setPSDEViewType(pSDEViewBase.getPSDEViewBaseType());
    }

    protected void onFillParentInfo_PSDynaDEViewTempl(ET ET, PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ((PSAppViewBase)ET).setPSDynaDEViewTemplId(pSDynaDEViewTempl.getPSDynaDEViewTemplId());
        ((PSAppViewBase)ET).setPSDynaDEViewTemplName(pSDynaDEViewTempl.getPSDynaDEViewTemplName());
        ((PSAppViewBase)ET).setPSDynaDEViewType(pSDynaDEViewTempl.getViewType());
    }

    protected void onFillParentInfo_PSHelpModule(ET ET, PSHelpModule pSHelpModule) throws Exception {
        ((PSAppViewBase)ET).setPSHelpModuleId(pSHelpModule.getPSHelpModuleId());
        ((PSAppViewBase)ET).setPSHelpModuleName(pSHelpModule.getPSHelpModuleName());
    }

    protected void onFillParentInfo_CapPSLanRes(ET ET, PSLanguageRes pSLanguageRes) throws Exception {
        ((PSAppViewBase)ET).setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        ((PSAppViewBase)ET).setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SubCapPSLanRes(ET ET, PSLanguageRes pSLanguageRes) throws Exception {
        ((PSAppViewBase)ET).setSubCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        ((PSAppViewBase)ET).setSubCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TitlePSLanRes(ET ET, PSLanguageRes pSLanguageRes) throws Exception {
        ((PSAppViewBase)ET).setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        ((PSAppViewBase)ET).setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSPFStyle(ET ET, PSPFStyle pSPFStyle) throws Exception {
        ((PSAppViewBase)ET).setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        ((PSAppViewBase)ET).setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSSubViewType(ET ET, PSSubViewType pSSubViewType) throws Exception {
        ((PSAppViewBase)ET).setPSSubViewTypeId(pSSubViewType.getPSSubViewTypeId());
        ((PSAppViewBase)ET).setPSSubViewTypeName(pSSubViewType.getPSSubViewTypeName());
    }

    protected void onFillParentInfo_PSSysApp(ET ET, PSSysApp pSSysApp) throws Exception {
        ((PSAppViewBase)ET).setPSPFId(pSSysApp.getPSPFId());
        ((PSAppViewBase)ET).setPSSysAppId(pSSysApp.getPSSysAppId());
        ((PSAppViewBase)ET).setPSSysAppName(pSSysApp.getPSSysAppName());
        ((PSAppViewBase)ET).setPSSystemId(pSSysApp.getPSSystemId());
    }

    protected void onFillParentInfo_PSSysCss(ET ET, PSSysCss pSSysCss) throws Exception {
        ((PSAppViewBase)ET).setPSSysCssId(pSSysCss.getPSSysCssId());
        ((PSAppViewBase)ET).setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(ET ET, PSSysDynaModel pSSysDynaModel) throws Exception {
        ((PSAppViewBase)ET).setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        ((PSAppViewBase)ET).setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(ET ET, PSSysImage pSSysImage) throws Exception {
        ((PSAppViewBase)ET).setPSSysImageId(pSSysImage.getPSSysImageId());
        ((PSAppViewBase)ET).setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysReqItem(ET ET, PSSysReqItem pSSysReqItem) throws Exception {
        ((PSAppViewBase)ET).setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        ((PSAppViewBase)ET).setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysUniRes(ET ET, PSSysUniRes pSSysUniRes) throws Exception {
        ((PSAppViewBase)ET).setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        ((PSAppViewBase)ET).setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillParentInfo_PSSysViewPanel(ET ET, PSSysViewPanel pSSysViewPanel) throws Exception {
        ((PSAppViewBase)ET).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        ((PSAppViewBase)ET).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSViewEngine(ET ET, PSViewEngine pSViewEngine) throws Exception {
        ((PSAppViewBase)ET).setPSViewEngineId(pSViewEngine.getPSViewEngineId());
        ((PSAppViewBase)ET).setPSViewEngineName(pSViewEngine.getPSViewEngineName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(ET ET, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ((PSAppViewBase)ET).setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        ((PSAppViewBase)ET).setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillParentInfo_PSViewWizardGroup(ET ET, PSViewWizardGroup pSViewWizardGroup) throws Exception {
        ((PSAppViewBase)ET).setPSViewWizardGroupId(pSViewWizardGroup.getPSViewWizardGroupId());
        ((PSAppViewBase)ET).setPSViewWizardGroupName(pSViewWizardGroup.getPSViewWizardGroupName());
    }

    protected void onFillEntityFullInfo(ET ET, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(ET, bl);
        this.onFillEntityFullInfo_PSACHandler(ET, bl);
        this.onFillEntityFullInfo_PSAppLocalDE(ET, bl);
        this.onFillEntityFullInfo_PSAppModule(ET, bl);
        this.onFillEntityFullInfo_PSAppTitleBar(ET, bl);
        this.onFillEntityFullInfo_PSAppViewStyle(ET, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(ET, bl);
        this.onFillEntityFullInfo_PSDEViewBase(ET, bl);
        this.onFillEntityFullInfo_PSDynaDEViewTempl(ET, bl);
        this.onFillEntityFullInfo_PSHelpModule(ET, bl);
        this.onFillEntityFullInfo_CapPSLanRes(ET, bl);
        this.onFillEntityFullInfo_SubCapPSLanRes(ET, bl);
        this.onFillEntityFullInfo_TitlePSLanRes(ET, bl);
        this.onFillEntityFullInfo_PSPFStyle(ET, bl);
        this.onFillEntityFullInfo_PSSubViewType(ET, bl);
        this.onFillEntityFullInfo_PSSysApp(ET, bl);
        this.onFillEntityFullInfo_PSSysCss(ET, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(ET, bl);
        this.onFillEntityFullInfo_PSSysImage(ET, bl);
        this.onFillEntityFullInfo_PSSysReqItem(ET, bl);
        this.onFillEntityFullInfo_PSSysUniRes(ET, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(ET, bl);
        this.onFillEntityFullInfo_PSViewEngine(ET, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(ET, bl);
        this.onFillEntityFullInfo_PSViewWizardGroup(ET, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppLocalDE(ET ET, boolean bl) throws Exception {
        if (((PSAppViewBase)ET).isPSAppLocalDEIdDirty()) {
            if (((PSAppViewBase)ET).getPSAppLocalDEId() != null) {
                if (((PSAppViewBase)ET).getPSAppLocalDEId() == null || ((PSAppViewBase)ET).getPSAppLocalDEName() == null) {
                    PSAppLocalDE pSAppLocalDE = ((PSAppViewBase)ET).getPSAppLocalDE();
                    ((PSAppViewBase)ET).setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
                }
            } else {
                ((PSAppViewBase)ET).setPSAppLocalDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSAppModule(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppTitleBar(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppViewStyle(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaDEViewTempl(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSHelpModule(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(ET ET, boolean bl) throws Exception {
        if (((PSAppViewBase)ET).isCapPSLanResIdDirty()) {
            if (((PSAppViewBase)ET).getCapPSLanResId() != null) {
                if (((PSAppViewBase)ET).getCapPSLanResId() == null || ((PSAppViewBase)ET).getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = ((PSAppViewBase)ET).getCapPSLanRes();
                    ((PSAppViewBase)ET).setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                ((PSAppViewBase)ET).setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SubCapPSLanRes(ET ET, boolean bl) throws Exception {
        if (((PSAppViewBase)ET).isSubCapPSLanResIdDirty()) {
            if (((PSAppViewBase)ET).getSubCapPSLanResId() != null) {
                if (((PSAppViewBase)ET).getSubCapPSLanResId() == null || ((PSAppViewBase)ET).getSubCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = ((PSAppViewBase)ET).getSubCapPSLanRes();
                    ((PSAppViewBase)ET).setSubCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                ((PSAppViewBase)ET).setSubCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TitlePSLanRes(ET ET, boolean bl) throws Exception {
        if (((PSAppViewBase)ET).isTitlePSLanResIdDirty()) {
            if (((PSAppViewBase)ET).getTitlePSLanResId() != null) {
                if (((PSAppViewBase)ET).getTitlePSLanResId() == null || ((PSAppViewBase)ET).getTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = ((PSAppViewBase)ET).getTitlePSLanRes();
                    ((PSAppViewBase)ET).setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                ((PSAppViewBase)ET).setTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFStyle(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSubViewType(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewEngine(ET ET, boolean bl) throws Exception {
        if (((PSAppViewBase)ET).isPSViewEngineIdDirty()) {
            if (((PSAppViewBase)ET).getPSViewEngineId() != null) {
                if (((PSAppViewBase)ET).getPSViewEngineId() == null || ((PSAppViewBase)ET).getPSViewEngineName() == null) {
                    PSViewEngine pSViewEngine = ((PSAppViewBase)ET).getPSViewEngine();
                    ((PSAppViewBase)ET).setPSViewEngineName(pSViewEngine.getPSViewEngineName());
                }
            } else {
                ((PSAppViewBase)ET).setPSViewEngineName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(ET ET, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewWizardGroup(ET ET, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(ET ET, boolean bl) throws Exception {
        super.onWriteBackParent(ET, bl);
    }

    public ArrayList<ET> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<ET> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<ET> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, "", -1);
    }

    public ArrayList<ET> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, string, -1);
    }

    public ArrayList<ET> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPLOCALDEID", (Object)pSAppLocalDEBase.getPSAppLocalDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppLocalDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppLocalDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSAppModule(PSAppModuleBase pSAppModuleBase) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, "", -1);
    }

    public ArrayList<ET> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string) throws Exception {
        return this.selectByPSAppModule(pSAppModuleBase, string, -1);
    }

    public ArrayList<ET> selectByPSAppModule(PSAppModuleBase pSAppModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMODULEID", (Object)pSAppModuleBase.getPSAppModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSAppTitleBar(PSAppTitleBarBase pSAppTitleBarBase) throws Exception {
        return this.selectByPSAppTitleBar(pSAppTitleBarBase, "", -1);
    }

    public ArrayList<ET> selectByPSAppTitleBar(PSAppTitleBarBase pSAppTitleBarBase, String string) throws Exception {
        return this.selectByPSAppTitleBar(pSAppTitleBarBase, string, -1);
    }

    public ArrayList<ET> selectByPSAppTitleBar(PSAppTitleBarBase pSAppTitleBarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPTITLEBARID", (Object)pSAppTitleBarBase.getPSAppTitleBarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppTitleBarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppTitleBarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSAppViewStyle(PSAppViewStyleBase pSAppViewStyleBase) throws Exception {
        return this.selectByPSAppViewStyle(pSAppViewStyleBase, "", -1);
    }

    public ArrayList<ET> selectByPSAppViewStyle(PSAppViewStyleBase pSAppViewStyleBase, String string) throws Exception {
        return this.selectByPSAppViewStyle(pSAppViewStyleBase, string, -1);
    }

    public ArrayList<ET> selectByPSAppViewStyle(PSAppViewStyleBase pSAppViewStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWSTYLEID", (Object)pSAppViewStyleBase.getPSAppViewStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<ET> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<ET> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<ET> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<ET> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<ET> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSDynaDEViewTempl(PSDynaDEViewTemplBase pSDynaDEViewTemplBase) throws Exception {
        return this.selectByPSDynaDEViewTempl(pSDynaDEViewTemplBase, "", -1);
    }

    public ArrayList<ET> selectByPSDynaDEViewTempl(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, String string) throws Exception {
        return this.selectByPSDynaDEViewTempl(pSDynaDEViewTemplBase, string, -1);
    }

    public ArrayList<ET> selectByPSDynaDEViewTempl(PSDynaDEViewTemplBase pSDynaDEViewTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEVIEWTEMPLID", (Object)pSDynaDEViewTemplBase.getPSDynaDEViewTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDEViewTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDEViewTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase) throws Exception {
        return this.selectByPSHelpModule(pSHelpModuleBase, "", -1);
    }

    public ArrayList<ET> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string) throws Exception {
        return this.selectByPSHelpModule(pSHelpModuleBase, string, -1);
    }

    public ArrayList<ET> selectByPSHelpModule(PSHelpModuleBase pSHelpModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSHELPMODULEID", (Object)pSHelpModuleBase.getPSHelpModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSHelpModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSHelpModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<ET> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<ET> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectBySubCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySubCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<ET> selectBySubCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySubCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<ET> selectBySubCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBCAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<ET> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<ET> selectByTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<ET> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<ET> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSSubViewType(PSSubViewTypeBase pSSubViewTypeBase) throws Exception {
        return this.selectByPSSubViewType(pSSubViewTypeBase, "", -1);
    }

    public ArrayList<ET> selectByPSSubViewType(PSSubViewTypeBase pSSubViewTypeBase, String string) throws Exception {
        return this.selectByPSSubViewType(pSSubViewTypeBase, string, -1);
    }

    public ArrayList<ET> selectByPSSubViewType(PSSubViewTypeBase pSSubViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSUBVIEWTYPEID", (Object)pSSubViewTypeBase.getPSSubViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSubViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSubViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<ET> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<ET> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<ET> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<ET> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<ET> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<ET> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase) throws Exception {
        return this.selectByPSViewEngine(pSViewEngineBase, "", -1);
    }

    public ArrayList<ET> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase, String string) throws Exception {
        return this.selectByPSViewEngine(pSViewEngineBase, string, -1);
    }

    public ArrayList<ET> selectByPSViewEngine(PSViewEngineBase pSViewEngineBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWENGINEID", (Object)pSViewEngineBase.getPSViewEngineId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewEngineCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewEngineCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<ET> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<ET> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<ET> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public ArrayList<ET> selectByPSViewWizardGroup(PSViewWizardGroupBase pSViewWizardGroupBase) throws Exception {
        return this.selectByPSViewWizardGroup(pSViewWizardGroupBase, "", -1);
    }

    public ArrayList<ET> selectByPSViewWizardGroup(PSViewWizardGroupBase pSViewWizardGroupBase, String string) throws Exception {
        return this.selectByPSViewWizardGroup(pSViewWizardGroupBase, string, -1);
    }

    public ArrayList<ET> selectByPSViewWizardGroup(PSViewWizardGroupBase pSViewWizardGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWWIZARDGROUPID", (Object)pSViewWizardGroupBase.getPSViewWizardGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewWizardGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewWizardGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSACHandler(pSACHandler);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSACHandlerId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSAppViewServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSAppViewServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPLOCALDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppLocalDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSAPPLOCALDE_PSAPPLOCALDEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSAppLocalDE), arrayList.get(0)));
        }
    }

    public void resetPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSAppLocalDEId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppViewServiceBase.this.internalRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppViewServiceBase.this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void internalRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppModule(pSAppModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSAppModule), arrayList.get(0)));
        }
    }

    public void resetPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppModule(pSAppModule);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSAppModuleId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSAppModule(PSAppModule pSAppModule) throws Exception {
        final PSAppModule pSAppModule2 = pSAppModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSAppModule(pSAppModule2);
                PSAppViewServiceBase.this.internalRemoveByPSAppModule(pSAppModule2);
                PSAppViewServiceBase.this.onAfterRemoveByPSAppModule(pSAppModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void internalRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppModule(pSAppModule);
        this.onBeforeRemoveByPSAppModule(pSAppModule, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSAppModule(pSAppModule, arrayList);
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule) throws Exception {
    }

    protected void onBeforeRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppModule(PSAppModule pSAppModule, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSAppTitleBar(PSAppTitleBar pSAppTitleBar) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppTitleBar(pSAppTitleBar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPTITLEBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppTitleBar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSAPPTITLEBAR_PSAPPTITLEBARID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSAppTitleBar), arrayList.get(0)));
        }
    }

    public void resetPSAppTitleBar(PSAppTitleBar pSAppTitleBar) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppTitleBar(pSAppTitleBar);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSAppTitleBarId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSAppTitleBar(PSAppTitleBar pSAppTitleBar) throws Exception {
        final PSAppTitleBar pSAppTitleBar2 = pSAppTitleBar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSAppTitleBar(pSAppTitleBar2);
                PSAppViewServiceBase.this.internalRemoveByPSAppTitleBar(pSAppTitleBar2);
                PSAppViewServiceBase.this.onAfterRemoveByPSAppTitleBar(pSAppTitleBar2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppTitleBar(PSAppTitleBar pSAppTitleBar) throws Exception {
    }

    protected void internalRemoveByPSAppTitleBar(PSAppTitleBar pSAppTitleBar) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppTitleBar(pSAppTitleBar);
        this.onBeforeRemoveByPSAppTitleBar(pSAppTitleBar, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSAppTitleBar(pSAppTitleBar, arrayList);
    }

    protected void onAfterRemoveByPSAppTitleBar(PSAppTitleBar pSAppTitleBar) throws Exception {
    }

    protected void onBeforeRemoveByPSAppTitleBar(PSAppTitleBar pSAppTitleBar, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppTitleBar(PSAppTitleBar pSAppTitleBar, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppViewStyle(pSAppViewStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEWSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppViewStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSAPPVIEWSTYLE_PSAPPVIEWSTYLEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSAppViewStyle), arrayList.get(0)));
        }
    }

    public void resetPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppViewStyle(pSAppViewStyle);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSAppViewStyleId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        final PSAppViewStyle pSAppViewStyle2 = pSAppViewStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSAppViewStyle(pSAppViewStyle2);
                PSAppViewServiceBase.this.internalRemoveByPSAppViewStyle(pSAppViewStyle2);
                PSAppViewServiceBase.this.onAfterRemoveByPSAppViewStyle(pSAppViewStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
    }

    protected void internalRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSAppViewStyle(pSAppViewStyle);
        this.onBeforeRemoveByPSAppViewStyle(pSAppViewStyle, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSAppViewStyle(pSAppViewStyle, arrayList);
    }

    protected void onAfterRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppViewStyle(PSAppViewStyle pSAppViewStyle, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSCtrlLogicGroupId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSAppViewServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSAppViewServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSDEViewBaseId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSAppViewServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSAppViewServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSDynaDEViewTempl(pSDynaDEViewTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADEVIEWTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaDEViewTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSDynaDEViewTempl), arrayList.get(0)));
        }
    }

    public void resetPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSDynaDEViewTempl(pSDynaDEViewTempl);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSDynaDEViewTemplId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        final PSDynaDEViewTempl pSDynaDEViewTempl2 = pSDynaDEViewTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl2);
                PSAppViewServiceBase.this.internalRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl2);
                PSAppViewServiceBase.this.onAfterRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
    }

    protected void internalRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSDynaDEViewTempl(pSDynaDEViewTempl);
        this.onBeforeRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSDynaDEViewTempl(pSDynaDEViewTempl, arrayList);
    }

    protected void onAfterRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDEViewTempl(PSDynaDEViewTempl pSDynaDEViewTempl, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSHelpModule(pSHelpModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSHELPMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSHelpModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSHELPMODULE_PSHELPMODULEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSHelpModule), arrayList.get(0)));
        }
    }

    public void resetPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSHelpModule(pSHelpModule);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSHelpModuleId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        final PSHelpModule pSHelpModule2 = pSHelpModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSHelpModule(pSHelpModule2);
                PSAppViewServiceBase.this.internalRemoveByPSHelpModule(pSHelpModule2);
                PSAppViewServiceBase.this.onAfterRemoveByPSHelpModule(pSHelpModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void internalRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSHelpModule(pSHelpModule);
        this.onBeforeRemoveByPSHelpModule(pSHelpModule, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSHelpModule(pSHelpModule, arrayList);
    }

    protected void onAfterRemoveByPSHelpModule(PSHelpModule pSHelpModule) throws Exception {
    }

    protected void onBeforeRemoveByPSHelpModule(PSHelpModule pSHelpModule, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSHelpModule(PSHelpModule pSHelpModule, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setCapPSLanResId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSAppViewServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSAppViewServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectBySubCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSLANGUAGERES_SUBCAPPSLANRESID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectBySubCapPSLanRes(pSLanguageRes);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setSubCapPSLanResId(null);
            this.update(pSAppView2);
        }
    }

    public void removeBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveBySubCapPSLanRes(pSLanguageRes2);
                PSAppViewServiceBase.this.internalRemoveBySubCapPSLanRes(pSLanguageRes2);
                PSAppViewServiceBase.this.onAfterRemoveBySubCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectBySubCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySubCapPSLanRes(pSLanguageRes, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveBySubCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSLANGUAGERES_TITLEPSLANRESID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setTitlePSLanResId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes2);
                PSAppViewServiceBase.this.internalRemoveByTitlePSLanRes(pSLanguageRes2);
                PSAppViewServiceBase.this.onAfterRemoveByTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSPFStyleId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSAppViewServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSAppViewServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSubViewType(pSSubViewType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBVIEWTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubViewType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSUBVIEWTYPE_PSSUBVIEWTYPEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSubViewType), arrayList.get(0)));
        }
    }

    public void resetPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSubViewType(pSSubViewType);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSubViewTypeId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        final PSSubViewType pSSubViewType2 = pSSubViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSubViewType(pSSubViewType2);
                PSAppViewServiceBase.this.internalRemoveByPSSubViewType(pSSubViewType2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSubViewType(pSSubViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
    }

    protected void internalRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSubViewType(pSSubViewType);
        this.onBeforeRemoveByPSSubViewType(pSSubViewType, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSubViewType(pSSubViewType, arrayList);
    }

    protected void onAfterRemoveByPSSubViewType(PSSubViewType pSSubViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSSubViewType(PSSubViewType pSSubViewType, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSubViewType(PSSubViewType pSSubViewType, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysApp(pSSysApp);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysAppId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppViewServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysCss(pSSysCss);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysCssId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSAppViewServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysDynaModelId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSAppViewServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysImage(pSSysImage);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysImageId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSAppViewServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysReqItemId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppViewServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysUniResId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppViewServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSSysViewPanelId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSAppViewServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSAppViewServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    public void resetPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewEngine(pSViewEngine);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSViewEngineId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        final PSViewEngine pSViewEngine2 = pSViewEngine;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSViewEngine(pSViewEngine2);
                PSAppViewServiceBase.this.internalRemoveByPSViewEngine(pSViewEngine2);
                PSAppViewServiceBase.this.onAfterRemoveByPSViewEngine(pSViewEngine2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    protected void internalRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewEngine(pSViewEngine);
        this.onBeforeRemoveByPSViewEngine(pSViewEngine, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSViewEngine(pSViewEngine, arrayList);
    }

    protected void onAfterRemoveByPSViewEngine(PSViewEngine pSViewEngine) throws Exception {
    }

    protected void onBeforeRemoveByPSViewEngine(PSViewEngine pSViewEngine, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewEngine(PSViewEngine pSViewEngine, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSViewMsgGroupId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSAppViewServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSAppViewServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<ET> arrayList) throws Exception {
    }

    public void testRemoveByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewWizardGroup(pSViewWizardGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWWIZARDGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewWizardGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEW_PSVIEWWIZARDGROUP_PSVIEWWIZARDGROUPID", "", iDataEntityModel.getName(), "PSAPPVIEW", iDataEntityModel.getDataInfo(pSViewWizardGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewWizardGroup(pSViewWizardGroup);
        for (ET pSAppView : arrayList) {
            ET pSAppView2 = (ET)this.getDEModel().createEntity();
            pSAppView2.setPSAppViewId(pSAppView.getPSAppViewId());
            pSAppView2.setPSViewWizardGroupId(null);
            this.update(pSAppView2);
        }
    }

    public void removeByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup) throws Exception {
        final PSViewWizardGroup pSViewWizardGroup2 = pSViewWizardGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewServiceBase.this.onBeforeRemoveByPSViewWizardGroup(pSViewWizardGroup2);
                PSAppViewServiceBase.this.internalRemoveByPSViewWizardGroup(pSViewWizardGroup2);
                PSAppViewServiceBase.this.onAfterRemoveByPSViewWizardGroup(pSViewWizardGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup) throws Exception {
    }

    protected void internalRemoveByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup) throws Exception {
        ArrayList<ET> arrayList = this.selectByPSViewWizardGroup(pSViewWizardGroup);
        this.onBeforeRemoveByPSViewWizardGroup(pSViewWizardGroup, arrayList);
        for (ET pSAppView : arrayList) {
            this.remove(pSAppView);
        }
        this.onAfterRemoveByPSViewWizardGroup(pSViewWizardGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup, ArrayList<ET> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewWizardGroup(PSViewWizardGroup pSViewWizardGroup, ArrayList<ET> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(ET ET) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppIndexViewServiceBase)pSCoreSysServiceBase).testRemoveByDefPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByOpenPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPDTViewServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPVPartServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppSBItemService)ServiceGlobal.getService(PSAppSBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        ((PSAppSBItemServiceBase)pSCoreSysServiceBase).removeByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).testRemoveByRootPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUserModeServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppViewCodeService)ServiceGlobal.getService(PSAppViewCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        ((PSAppViewCodeServiceBase)pSCoreSysServiceBase).removeByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppViewLogicService)ServiceGlobal.getService(PSAppViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        ((PSAppViewLogicServiceBase)pSCoreSysServiceBase).removeByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppViewRefService)ServiceGlobal.getService(PSAppViewRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewRefServiceBase)pSCoreSysServiceBase).testRemoveByMajorPSAppView((PSAppView)ET);
        ((PSAppViewRefServiceBase)pSCoreSysServiceBase).removeByMajorPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSAppViewRefService)ServiceGlobal.getService(PSAppViewRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewRefServiceBase)pSCoreSysServiceBase).testRemoveByMinorPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByOpenPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
        ((PSMobAppStartPageServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        ((PSMobAppStartPageServiceBase)pSCoreSysServiceBase).removeByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestCaseServiceBase)pSCoreSysServiceBase).testRemoveByPSAppView((PSAppView)ET);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByOpenPSAppView((PSAppView)ET);
        super.onBeforeRemove(ET);
    }

    protected void replaceParentInfo(ET ET, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(ET, cloneSession);
        if (((PSAppViewBase)ET).getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)((PSAppViewBase)ET).getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(ET, (PSACHandler)iEntity);
        }
        if (((PSAppViewBase)ET).getPSAppLocalDEId() != null && (iEntity = cloneSession.getEntity("PSAPPLOCALDE", (Object)((PSAppViewBase)ET).getPSAppLocalDEId())) != null) {
            this.onFillParentInfo_PSAppLocalDE(ET, (PSAppLocalDE)iEntity);
        }
        if (((PSAppViewBase)ET).getPSAppModuleId() != null && (iEntity = cloneSession.getEntity("PSAPPMODULE", (Object)((PSAppViewBase)ET).getPSAppModuleId())) != null) {
            this.onFillParentInfo_PSAppModule(ET, (PSAppModule)iEntity);
        }
        if (((PSAppViewBase)ET).getPSAppTitleBarId() != null && (iEntity = cloneSession.getEntity("PSAPPTITLEBAR", (Object)((PSAppViewBase)ET).getPSAppTitleBarId())) != null) {
            this.onFillParentInfo_PSAppTitleBar(ET, (PSAppTitleBar)iEntity);
        }
        if (((PSAppViewBase)ET).getPSAppViewStyleId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEWSTYLE", (Object)((PSAppViewBase)ET).getPSAppViewStyleId())) != null) {
            this.onFillParentInfo_PSAppViewStyle(ET, (PSAppViewStyle)iEntity);
        }
        if (((PSAppViewBase)ET).getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)((PSAppViewBase)ET).getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(ET, (PSCtrlLogicGroup)iEntity);
        }
        if (((PSAppViewBase)ET).getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)((PSAppViewBase)ET).getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(ET, (PSDEViewBase)iEntity);
        }
        if (((PSAppViewBase)ET).getPSDynaDEViewTemplId() != null && (iEntity = cloneSession.getEntity("PSDYNADEVIEWTEMPL", (Object)((PSAppViewBase)ET).getPSDynaDEViewTemplId())) != null) {
            this.onFillParentInfo_PSDynaDEViewTempl(ET, (PSDynaDEViewTempl)iEntity);
        }
        if (((PSAppViewBase)ET).getPSHelpModuleId() != null && (iEntity = cloneSession.getEntity("PSHELPMODULE", (Object)((PSAppViewBase)ET).getPSHelpModuleId())) != null) {
            this.onFillParentInfo_PSHelpModule(ET, (PSHelpModule)iEntity);
        }
        if (((PSAppViewBase)ET).getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)((PSAppViewBase)ET).getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(ET, (PSLanguageRes)iEntity);
        }
        if (((PSAppViewBase)ET).getSubCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)((PSAppViewBase)ET).getSubCapPSLanResId())) != null) {
            this.onFillParentInfo_SubCapPSLanRes(ET, (PSLanguageRes)iEntity);
        }
        if (((PSAppViewBase)ET).getTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)((PSAppViewBase)ET).getTitlePSLanResId())) != null) {
            this.onFillParentInfo_TitlePSLanRes(ET, (PSLanguageRes)iEntity);
        }
        if (((PSAppViewBase)ET).getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)((PSAppViewBase)ET).getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(ET, (PSPFStyle)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSubViewTypeId() != null && (iEntity = cloneSession.getEntity("PSSUBVIEWTYPE", (Object)((PSAppViewBase)ET).getPSSubViewTypeId())) != null) {
            this.onFillParentInfo_PSSubViewType(ET, (PSSubViewType)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)((PSAppViewBase)ET).getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(ET, (PSSysApp)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)((PSAppViewBase)ET).getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(ET, (PSSysCss)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)((PSAppViewBase)ET).getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(ET, (PSSysDynaModel)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)((PSAppViewBase)ET).getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(ET, (PSSysImage)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)((PSAppViewBase)ET).getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(ET, (PSSysReqItem)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)((PSAppViewBase)ET).getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(ET, (PSSysUniRes)iEntity);
        }
        if (((PSAppViewBase)ET).getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)((PSAppViewBase)ET).getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(ET, (PSSysViewPanel)iEntity);
        }
        if (((PSAppViewBase)ET).getPSViewEngineId() != null && (iEntity = cloneSession.getEntity("PSVIEWENGINE", (Object)((PSAppViewBase)ET).getPSViewEngineId())) != null) {
            this.onFillParentInfo_PSViewEngine(ET, (PSViewEngine)iEntity);
        }
        if (((PSAppViewBase)ET).getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)((PSAppViewBase)ET).getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(ET, (PSViewMsgGroup)iEntity);
        }
        if (((PSAppViewBase)ET).getPSViewWizardGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWWIZARDGROUP", (Object)((PSAppViewBase)ET).getPSViewWizardGroupId())) != null) {
            this.onFillParentInfo_PSViewWizardGroup(ET, (PSViewWizardGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(ET ET, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(ET, bl);
    }

    protected void onCheckEntity(boolean bl, ET ET, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AccUserMode(bl, ET, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppViewSN(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppViewState(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DyncMode(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewStyle(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutPanelMode(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreventXSS(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModuleId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTitleBarId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUtilViewType(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewStyleId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewType(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEViewTemplId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSHelpModuleId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSubViewTypeId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewEngineId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewEngineName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewWizardGroupId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowCaptionBar(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCapPSLanResId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCapPSLanResName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCaption(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SyncCodeName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysRefFlag(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResId(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitlePSLanResName(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIStyle(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRefFlag(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, ET, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, ET, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AccUserMode(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isAccUserModeDirty() : !((PSAppViewBase)ET).isAccUserModeDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getAccUserMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AccUserMode_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACCUSERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppViewSN(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isAppViewSNDirty() : !((PSAppViewBase)ET).isAppViewSNDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getAppViewSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppViewSN_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppViewState(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isAppViewStateDirty() : !((PSAppViewBase)ET).isAppViewStateDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getAppViewState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AppViewState_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isCapPSLanResIdDirty() : !((PSAppViewBase)ET).isCapPSLanResIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isCapPSLanResNameDirty() : !((PSAppViewBase)ET).isCapPSLanResNameDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isCaptionDirty() : !((PSAppViewBase)ET).isCaptionDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Color(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isColorDirty() : !((PSAppViewBase)ET).isColorDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isDynaModelFlagDirty() : !((PSAppViewBase)ET).isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_DyncMode(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isDyncModeDirty() : !((PSAppViewBase)ET).isDyncModeDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getDyncMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DyncMode_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewStyle(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isEnableViewStyleDirty() : !((PSAppViewBase)ET).isEnableViewStyleDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getEnableViewStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewStyle_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutPanelMode(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isLayoutPanelModeDirty() : !((PSAppViewBase)ET).isLayoutPanelModeDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getLayoutPanelMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LayoutPanelMode_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTPANELMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isMemoDirty() : !((PSAppViewBase)ET).isMemoDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PreventXSS(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPreventXSSDirty() : !((PSAppViewBase)ET).isPreventXSSDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getPreventXSS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreventXSS_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVENTXSS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSACHandlerIdDirty() : !((PSAppViewBase)ET).isPSACHandlerIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppLocalDEId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppLocalDEIdDirty() : !((PSAppViewBase)ET).isPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppLocalDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppLocalDEName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppLocalDENameDirty() : !((PSAppViewBase)ET).isPSAppLocalDENameDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppLocalDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppModuleId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppModuleIdDirty() : !((PSAppViewBase)ET).isPSAppModuleIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppModuleId_PSAppModule(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSAppModuleId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTitleBarId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppTitleBarIdDirty() : !((PSAppViewBase)ET).isPSAppTitleBarIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppTitleBarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTitleBarId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTITLEBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUtilViewType(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppUtilViewTypeDirty() : !((PSAppViewBase)ET).isPSAppUtilViewTypeDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppUtilViewType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppUtilViewType_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppViewIdDirty() && !bl2 : !((PSAppViewBase)ET).isPSAppViewIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppViewNameDirty() && !bl2 : !((PSAppViewBase)ET).isPSAppViewNameDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWNAME");
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppViewDEModel(), "PSAPPVIEWNAME", string3, ET, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPVIEWNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewStyleId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppViewStyleIdDirty() : !((PSAppViewBase)ET).isPSAppViewStyleIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppViewStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewStyleId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewType(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSAppViewTypeDirty() && !bl2 : !((PSAppViewBase)ET).isPSAppViewTypeDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSAppViewType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewType_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSCtrlLogicGroupIdDirty() : !((PSAppViewBase)ET).isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSDEViewBaseIdDirty() : !((PSAppViewBase)ET).isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEViewTemplId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSDynaDEViewTemplIdDirty() : !((PSAppViewBase)ET).isPSDynaDEViewTemplIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSDynaDEViewTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEViewTemplId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEVIEWTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSDynaInstIdDirty() : !((PSAppViewBase)ET).isPSDynaInstIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSHelpModuleId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSHelpModuleIdDirty() : !((PSAppViewBase)ET).isPSHelpModuleIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSHelpModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSHelpModuleId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSHELPMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSPFStyleIdDirty() : !((PSAppViewBase)ET).isPSPFStyleIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSubViewTypeId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSubViewTypeIdDirty() : !((PSAppViewBase)ET).isPSSubViewTypeIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSubViewTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSubViewTypeId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSUBVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysAppIdDirty() && !bl2 : !((PSAppViewBase)ET).isPSSysAppIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysCssIdDirty() : !((PSAppViewBase)ET).isPSSysCssIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysDynaModelIdDirty() : !((PSAppViewBase)ET).isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysImageIdDirty() : !((PSAppViewBase)ET).isPSSysImageIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysReqItemIdDirty() : !((PSAppViewBase)ET).isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysUniResIdDirty() : !((PSAppViewBase)ET).isPSSysUniResIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSSysViewPanelIdDirty() : !((PSAppViewBase)ET).isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewEngineId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSViewEngineIdDirty() : !((PSAppViewBase)ET).isPSViewEngineIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSViewEngineId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewEngineId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWENGINEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewEngineName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSViewEngineNameDirty() : !((PSAppViewBase)ET).isPSViewEngineNameDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSViewEngineName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewEngineName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWENGINENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSViewMsgGroupIdDirty() : !((PSAppViewBase)ET).isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewWizardGroupId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isPSViewWizardGroupIdDirty() : !((PSAppViewBase)ET).isPSViewWizardGroupIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getPSViewWizardGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewWizardGroupId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWWIZARDGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowCaptionBar(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isShowCaptionBarDirty() : !((PSAppViewBase)ET).isShowCaptionBarDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getShowCaptionBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowCaptionBar_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWCAPTIONBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCapPSLanResId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isSubCapPSLanResIdDirty() : !((PSAppViewBase)ET).isSubCapPSLanResIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getSubCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCapPSLanResId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCapPSLanResName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isSubCapPSLanResNameDirty() : !((PSAppViewBase)ET).isSubCapPSLanResNameDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getSubCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCapPSLanResName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCaption(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isSubCaptionDirty() : !((PSAppViewBase)ET).isSubCaptionDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getSubCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCaption_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SyncCodeName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isSyncCodeNameDirty() : !((PSAppViewBase)ET).isSyncCodeNameDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getSyncCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SyncCodeName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYNCCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysRefFlag(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isSysRefFlagDirty() : !((PSAppViewBase)ET).isSysRefFlagDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getSysRefFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysRefFlag_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSREFFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isTitleDirty() : !((PSAppViewBase)ET).isTitleDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResId(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isTitlePSLanResIdDirty() : !((PSAppViewBase)ET).isTitlePSLanResIdDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResId_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitlePSLanResName(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isTitlePSLanResNameDirty() : !((PSAppViewBase)ET).isTitlePSLanResNameDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitlePSLanResName_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isToDoTaskDirty() : !((PSAppViewBase)ET).isToDoTaskDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_UIStyle(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUIStyleDirty() : !((PSAppViewBase)ET).isUIStyleDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getUIStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIStyle_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UISTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUserParamsDirty() : !((PSAppViewBase)ET).isUserParamsDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserRefFlag(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUserRefFlagDirty() : !((PSAppViewBase)ET).isUserRefFlagDirty()) {
            return null;
        }
        Integer n = ((PSAppViewBase)ET).getUserRefFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserRefFlag_Default(ET, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERREFFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUserTagDirty() : !((PSAppViewBase)ET).isUserTagDirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUserTag2Dirty() : !((PSAppViewBase)ET).isUserTag2Dirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUserTag3Dirty() : !((PSAppViewBase)ET).isUserTag3Dirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(ET, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, ET ET, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !((PSAppViewBase)ET).isUserTag4Dirty() : !((PSAppViewBase)ET).isUserTag4Dirty()) {
            return null;
        }
        String string = ((PSAppViewBase)ET).getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(ET, bl2, bl3);
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

    protected void onSyncEntity(ET ET, boolean bl) throws Exception {
        super.onSyncEntity(ET, bl);
    }

    protected void onSyncIndexEntities(ET ET, boolean bl) throws Exception {
        super.onSyncIndexEntities(ET, bl);
    }

    public Object getDataContextValue(ET ET, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(ET, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = ((PSAppViewBase)ET).getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(ET, arrayList, n);
        this.onExportMajorModel_SubCapPSLanRes(ET, arrayList, n);
        this.onExportMajorModel_TitlePSLanRes(ET, arrayList, n);
        super.onExportMajorModel(ET, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (((PSAppViewBase)ET).getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)((PSAppViewBase)ET).getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SubCapPSLanRes(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (((PSAppViewBase)ET).getSubCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)((PSAppViewBase)ET).getSubCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TitlePSLanRes(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (((PSAppViewBase)ET).getTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)((PSAppViewBase)ET).getTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACCUSERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AccUserMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPVIEWSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppViewSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPVIEWSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppViewState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DyncMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTPANELMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutPanelMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENTXSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreventXSS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSAPPMODULE", (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleId_PSAppModule(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTITLEBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTitleBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTITLEBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTitleBarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUTILVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUtilViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEVIEWTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEViewTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEVIEWTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEViewTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEVIEWTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEViewType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSHELPMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSHelpModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSUBVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSubViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWENGINEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewEngineId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWENGINENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewEngineName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWWIZARDGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewWizardGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWWIZARDGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewWizardGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWCAPTIONBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowCaptionBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYNCCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SyncCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSREFFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysRefFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitlePSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UISTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIStyle_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERREFFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserRefFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AccUserMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACCUSERMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppViewSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPVIEWSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppViewState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_DyncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LayoutPanelMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreventXSS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSAppLocalDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppLocalDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppModuleId_PSAppModule(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSAPPMODULEID", "PSAPPMODULE", DATASET_CURAPP, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5e94\u7528\u6a21\u5757\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTitleBarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTITLEBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTitleBarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTITLEBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppUtilViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPUTILVIEWTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false) && this.checkFieldRegExRule("PSAPPVIEWNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEViewTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEVIEWTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEViewTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEVIEWTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEViewType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEVIEWTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSHelpModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSHelpModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSHELPMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSubViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSUBVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewEngineId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWENGINEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewEngineName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWENGINENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSViewWizardGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWWIZARDGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewWizardGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWWIZARDGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShowCaptionBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SubCapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubCapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBCAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SyncCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysRefFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToDoTask_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TODOTASK", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UISTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_UserRefFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected boolean onMergeChild(String string, String string2, ET ET) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, ET)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(ET ET) throws Exception {
        IService iService;
        Object object = ((PSAppViewBase)ET).get("PSDEVIEWBASEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPVIEW_PSDEVIEWBASE_PSDEVIEWBASEID", object);
        }
        if ((object = ((PSAppViewBase)ET).get("PSDYNADEVIEWTEMPLID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEViewTemplService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPVIEW_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID", object);
        }
        if ((object = ((PSAppViewBase)ET).get("PSSYSAPPID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(ET);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(ET ET, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPVIEW");
        if (!bl) {
            ((PSAppViewBase)ET).setCreateDate(null);
            ((PSAppViewBase)ET).setCreateMan(null);
            ((PSAppViewBase)ET).setPSAppViewId(null);
            ((PSAppViewBase)ET).setPSDynaDEViewTemplName(null);
            ((PSAppViewBase)ET).setSysRefFlag(null);
            ((PSAppViewBase)ET).setUpdateDate(null);
            ((PSAppViewBase)ET).setUpdateMan(null);
            super.exportCurXmlModel(ET, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, ET ET, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, ET, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPVIEW_PSAPPMODULE_PSAPPMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPMODULE", (boolean)true) == 0) {
            iEntity.set("PSAPPMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSAPPMODULEID", "PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(ET ET) {
        if (!StringHelper.isNullOrEmpty((String)((PSAppViewBase)ET).getPSAppViewName())) {
            return ((PSAppViewBase)ET).getPSAppViewName();
        }
        if (!StringHelper.isNullOrEmpty((String)((PSAppViewBase)ET).getPSAppViewName())) {
            return ((PSAppViewBase)ET).getPSAppViewName();
        }
        return super.getModelV2Tag(ET);
    }

    @Override
    public boolean setModelV2Tag(ET ET, String string) {
        ((PSAppViewBase)ET).setPSAppViewName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPVIEWNAME", "");
        map.put("PSAPPVIEWNAME", "");
        map.put("PSAPPVIEWNAME", "");
        map.put("PSAPPMODULEID", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(ET ET, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        ET.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo(ET, true);
        ((PSAppViewBase)ET).set("PSAPPVIEWNAME", string);
        if (this.select(ET, true)) {
            return true;
        }
        simpleEntity.copyTo(ET, true);
        return super.getModelV2Entity(ET, string);
    }

    @Override
    protected boolean testCompileCurModelV2(ET ET, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(ET, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSTESTCASE_PSAPPVIEW_PSAPPVIEWID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(ET ET, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSAPPVIEW_PSAPPVIEWID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPVIEW#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)((PSAppViewBase)ET).getPSAppViewId()))).exists()) {
            PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSSysTestCaseService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSSysTestCase pSSysTestCase = new PSSysTestCase();
                PSModelV2Helper.fromJSONObject((IDataObject)pSSysTestCase, objectNode, false);
                String string6 = pSSysTestCaseService.getModelV2Tag(pSSysTestCase);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSTESTCASE", (Object)pSSysTestCase.getPSSysTestCaseId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSSysTestCaseService.exportModelV2(pSSysTestCase, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(ET, string, string2);
    }

    @Override
    protected void onExportCurModelV2(ET ET, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTESTCASE_PSAPPVIEW_PSAPPVIEWID")) {
            Object object;
            PSSysTestCase pSSysTestCase2;
            Object object2;
            Object object3;
            Object object4;
            PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSAPPVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTESTCASE", (Object)((PSAppViewBase)ET).getPSAppViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        object2 = line;
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                object3 = StringHelper.format((String)"PSAPPVIEW#%1$s", (Object)((PSAppViewBase)ET).getPSAppViewId());
                for (PSSysTestCase testCase : pSSysTestCaseService.selectByPSAppView((PSAppViewBase)ET)) {
                    pSSysTestCase2 = testCase;
                    object = pSSysTestCaseService.getModelV2ResScope(pSSysTestCase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(pSSysTestCase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSSysTestCaseService.getModelV2Name(false);
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
                        if (objectNode.has("pssystestcasename")) {
                            string = objectNode.get("pssystestcasename").asText();
                        }
                        if (objectNode2.has("pssystestcasename")) {
                            string2 = objectNode2.get("pssystestcasename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode item : arrayList) {
                    PSSysTestCase testCase = new PSSysTestCase();
                    PSModelV2Helper.fromJSONObject((IDataObject)testCase, item, false);
                    ((ArrayNode)object3).add((JsonNode)pSSysTestCaseService.exportModelV2(testCase, string));
                }
            }
        }
        super.onExportCurModelV2(ET, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(ET ET) throws Exception {
        super.onEmptyModelV2(ET);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysTestCaseService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(ET ET, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysTestCase pSSysTestCase = new PSSysTestCase();
        pSSysTestCase.set("PSAPPVIEWID", ((PSAppViewBase)ET).getPSAppViewId());
        PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysTestCaseService.getModelV2Entity(pSSysTestCase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(ET, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(ET ET, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSAppViewServiceBase.isSimpleImportExportMode("")) {
            PSSysTestCaseService pSSysTestCaseService = (PSSysTestCaseService)ServiceGlobal.getService(PSSysTestCaseService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSSysTestCaseService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSSysTestCase pSSysTestCase = new PSSysTestCase();
                    pSSysTestCase.setPSAppViewId(((PSAppViewBase)ET).getPSAppViewId());
                    pSSysTestCase.setPSAppViewName(((PSAppViewBase)ET).getPSAppViewName());
                    pSSysTestCaseService.compileModelV2(pSSysTestCase, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSSysTestCase pSSysTestCase = new PSSysTestCase();
                        pSSysTestCase.setPSAppViewId(((PSAppViewBase)ET).getPSAppViewId());
                        pSSysTestCase.setPSAppViewName(((PSAppViewBase)ET).getPSAppViewName());
                        pSSysTestCaseService.compileModelV2(pSSysTestCase, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(ET, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(ET ET, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(ET, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(ET ET, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(ET, list);
    }

    @Override
    public Object getDataType(ET ET) throws Exception {
        return ((PSAppViewBase)ET).getPSAppViewType();
    }
}
