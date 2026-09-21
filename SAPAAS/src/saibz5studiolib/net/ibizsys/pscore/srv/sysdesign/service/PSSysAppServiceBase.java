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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFuncBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLan;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLanBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLogic;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLogicBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModuleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPDTView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPDTViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPFPlugin;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPFPluginBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPkg;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPkgBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortlet;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortletBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppResource;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppResourceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoardBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBar;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBarBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyleBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUITheme;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIThemeBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUserMode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUserModeBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtil;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilPage;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilPageBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWF;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppWFBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppStartPage;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppStartPageBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppCtrlStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppCtrlStyleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPDTViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPDTViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPFPluginService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPFPluginServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPkgService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPkgServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortletServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppResourceService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppResourceServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIThemeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIThemeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewStyleServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService;
import net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageService;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppStartPageServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCDN;
import net.ibizsys.pscore.srv.config.entity.PSPFCDNBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysAppDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserMode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserModeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemRunServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioThemeBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrjBase;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjService;
import net.ibizsys.pscore.srv.systest.service.PSSysTestPrjServiceBase;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppService;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXEntAppServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysAppServiceBase
extends PSCoreSysServiceBase<PSSysApp> {
    private static final Log log = LogFactory.getLog(PSSysAppServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSMOBAPP = "CurSysMobApp";
    public static final String DATASET_CURSYSMOBWFAPP = "CurSysMobWFApp";
    public static final String DATASET_CURSYSWFAPP = "CurSysWFApp";
    public static final String DATASET_CURSYSWEBAPP = "CurSysWebApp";
    public static final String DATASET_CURSYSWEBWFAPP = "CurSysWebWFApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String DATASET_MOBAPP = "MobApp";
    public static final String DATASET_WEBAPP = "WebApp";
    public static final String ACTION_GETCUR = "GetCur";
    public static final String ACTION_GETQUICKAPPDEVIEW = "GetQuickAppDEView";
    public static final String ACTION_INITPSAPPMODULES = "InitPSAppModules";
    public static final String ACTION_OPENQUICKAPP = "OpenQuickApp";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysAppDEModel pSSysAppDEModel;
    private PSSysAppDAO pSSysAppDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService";
    }

    public PSSysAppDEModel getPSSysAppDEModel() {
        if (this.pSSysAppDEModel == null) {
            try {
                this.pSSysAppDEModel = (PSSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAppDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysAppDEModel();
    }

    public PSSysAppDAO getPSSysAppDAO() {
        if (this.pSSysAppDAO == null) {
            try {
                this.pSSysAppDAO = (PSSysAppDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysAppDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAppDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysAppDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMOBAPP, (boolean)true) == 0) {
            return this.fetchCurSysMobApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSMOBWFAPP, (boolean)true) == 0) {
            return this.fetchCurSysMobWFApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWFAPP, (boolean)true) == 0) {
            return this.fetchCurSysWFApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWEBAPP, (boolean)true) == 0) {
            return this.fetchCurSysWebApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWEBWFAPP, (boolean)true) == 0) {
            return this.fetchCurSysWebWFApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_MOBAPP, (boolean)true) == 0) {
            return this.fetchMobApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WEBAPP, (boolean)true) == 0) {
            return this.fetchWebApp(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_GETCUR, (boolean)true) == 0) {
            this.getCur((PSSysApp)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETQUICKAPPDEVIEW, (boolean)true) == 0) {
            this.getQuickAppDEView((PSSysApp)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_INITPSAPPMODULES, (boolean)true) == 0) {
            this.initPSAppModules((PSSysApp)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_OPENQUICKAPP, (boolean)true) == 0) {
            this.openQuickApp((PSSysApp)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysMobApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMOBAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysMobWFApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSMOBWFAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWFApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWFAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWebApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWEBAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWebWFApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWEBWFAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchMobApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_MOBAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchWebApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WEBAPP, false);
        return dBFetchResult;
    }

    public void getCur(PSSysApp pSSysApp) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETCUR, 0, (IEntity)pSSysApp, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysApp, ACTION_GETCUR);
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysAppServiceBase.this.getService(), PSSysAppServiceBase.ACTION_GETCUR, 40, (IEntity)pSSysApp2, null).getResult() != 1) {
                    PSSysAppServiceBase.this.onGetCur(pSSysApp2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETCUR, 99, (IEntity)pSSysApp, null);
        }
    }

    protected void onGetCur(PSSysApp pSSysApp) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetCur]");
    }

    public void getQuickAppDEView(PSSysApp pSSysApp) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETQUICKAPPDEVIEW, 0, (IEntity)pSSysApp, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysApp, ACTION_GETQUICKAPPDEVIEW);
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysAppServiceBase.this.getService(), PSSysAppServiceBase.ACTION_GETQUICKAPPDEVIEW, 40, (IEntity)pSSysApp2, null).getResult() != 1) {
                    PSSysAppServiceBase.this.onGetQuickAppDEView(pSSysApp2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETQUICKAPPDEVIEW, 99, (IEntity)pSSysApp, null);
        }
    }

    protected void onGetQuickAppDEView(PSSysApp pSSysApp) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetQuickAppDEView]");
    }

    public void initPSAppModules(PSSysApp pSSysApp) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITPSAPPMODULES, 0, (IEntity)pSSysApp, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysApp, ACTION_INITPSAPPMODULES);
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysAppServiceBase.this.getService(), PSSysAppServiceBase.ACTION_INITPSAPPMODULES, 40, (IEntity)pSSysApp2, null).getResult() != 1) {
                    PSSysAppServiceBase.this.onInitPSAppModules(pSSysApp2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITPSAPPMODULES, 99, (IEntity)pSSysApp, null);
        }
    }

    protected void onInitPSAppModules(PSSysApp pSSysApp) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitPSAppModules]");
    }

    public void openQuickApp(PSSysApp pSSysApp) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_OPENQUICKAPP, 0, (IEntity)pSSysApp, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysApp, ACTION_OPENQUICKAPP);
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysAppServiceBase.this.getService(), PSSysAppServiceBase.ACTION_OPENQUICKAPP, 40, (IEntity)pSSysApp2, null).getResult() != 1) {
                    PSSysAppServiceBase.this.onOpenQuickApp(pSSysApp2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_OPENQUICKAPP, 99, (IEntity)pSSysApp, null);
        }
    }

    protected void onOpenQuickApp(PSSysApp pSSysApp) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[OpenQuickApp]");
    }

    protected void onFillParentInfo(PSSysApp pSSysApp, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSAPPTYPE_PSAPPTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory());
            PSAppType pSAppType = (PSAppType)iService.getDEModel().createEntity();
            pSAppType.set("PSAPPTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppType);
            } else {
                iService.get((IEntity)pSAppType);
            }
            this.onFillParentInfo_PSAppType(pSSysApp, pSAppType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysApp, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSLANGUAGERES_MDCTRLEMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_MDCtrlEmptyTextPSLanRes(pSSysApp, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysApp, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSPFCDN_PSPFCDNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCDNService", (SessionFactory)this.getSessionFactory());
            PSPFCDN pSPFCDN = (PSPFCDN)iService.getDEModel().createEntity();
            pSPFCDN.set("PSPFCDNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFCDN);
            } else {
                iService.get((IEntity)pSPFCDN);
            }
            this.onFillParentInfo_PSPFCDN(pSSysApp, pSPFCDN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFStyle);
            } else {
                iService.get((IEntity)pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSSysApp, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSSysApp, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSTUDIOTHEME_PSSTUDIOTHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService", (SessionFactory)this.getSessionFactory());
            PSStudioTheme pSStudioTheme = (PSStudioTheme)iService.getDEModel().createEntity();
            pSStudioTheme.set("PSSTUDIOTHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSStudioTheme);
            } else {
                iService.get((IEntity)pSStudioTheme);
            }
            this.onFillParentInfo_PSStudioTheme(pSSysApp, pSStudioTheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysApp, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysApp, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSSysApp, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSysApp, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSysApp, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService", (SessionFactory)this.getSessionFactory());
            PSSysServiceAPI pSSysServiceAPI = (PSSysServiceAPI)iService.getDEModel().createEntity();
            pSSysServiceAPI.set("PSSYSSERVICEAPIID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysServiceAPI);
            } else {
                iService.get((IEntity)pSSysServiceAPI);
            }
            this.onFillParentInfo_PSSysServiceAPI(pSSysApp, pSSysServiceAPI);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_DEPSSysSFPlugin(pSSysApp, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSSysApp, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPub);
            } else {
                iService.get((IEntity)pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSSysApp, pSSysSFPub);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysApp, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSAPP_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSSysApp, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysApp, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppType(PSSysApp pSSysApp, PSAppType pSAppType) throws Exception {
        pSSysApp.setPSAppTypeId(pSAppType.getPSAppTypeId());
        pSSysApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSSysApp pSSysApp, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSSysApp.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSSysApp.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_MDCtrlEmptyTextPSLanRes(PSSysApp pSSysApp, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysApp.setMDCtrlEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysApp.setMDCtrlEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSSysApp pSSysApp, PSModule pSModule) throws Exception {
        pSSysApp.setPSModuleId(pSModule.getPSModuleId());
        pSSysApp.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSPFCDN(PSSysApp pSSysApp, PSPFCDN pSPFCDN) throws Exception {
        pSSysApp.setPSPFCDNId(pSPFCDN.getPSPFCDNId());
        pSSysApp.setPSPFCDNName(pSPFCDN.getPSPFCDNName());
    }

    protected void onFillParentInfo_PSPFStyle(PSSysApp pSSysApp, PSPFStyle pSPFStyle) throws Exception {
        pSSysApp.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSSysApp.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
        if (pSPFStyle.getPSPF() != null) {
            this.onFillParentInfo_PSPF(pSSysApp, pSPFStyle.getPSPF());
        }
    }

    protected void onFillParentInfo_PSPF(PSSysApp pSSysApp, PSPF pSPF) throws Exception {
        pSSysApp.setPSPFId(pSPF.getPSPFId());
        pSSysApp.setPSPFName(pSPF.getPSPFName());
        if (pSPF.getPSAppType() != null) {
            this.onFillParentInfo_PSAppType(pSSysApp, pSPF.getPSAppType());
        }
    }

    protected void onFillParentInfo_PSStudioTheme(PSSysApp pSSysApp, PSStudioTheme pSStudioTheme) throws Exception {
        pSSysApp.setPSStudioThemeId(pSStudioTheme.getPSStudioThemeId());
        pSSysApp.setPSStudioThemeName(pSStudioTheme.getPSStudioThemeName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysApp pSSysApp, PSSysCss pSSysCss) throws Exception {
        pSSysApp.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysApp.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysApp pSSysApp, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysApp.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysApp.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(PSSysApp pSSysApp, PSSysImage pSSysImage) throws Exception {
        pSSysApp.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSSysApp.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSysApp pSSysApp, PSSysReqItem pSSysReqItem) throws Exception {
        pSSysApp.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSysApp.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysResource(PSSysApp pSSysApp, PSSysResource pSSysResource) throws Exception {
        pSSysApp.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysApp.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysServiceAPI(PSSysApp pSSysApp, PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSysApp.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
        pSSysApp.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
    }

    protected void onFillParentInfo_DEPSSysSFPlugin(PSSysApp pSSysApp, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysApp.setDEPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysApp.setDEPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSSysApp pSSysApp, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSSysApp.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSSysApp.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysSFPub(PSSysApp pSSysApp, PSSysSFPub pSSysSFPub) throws Exception {
        pSSysApp.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSysApp.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillParentInfo_PSSystem(PSSysApp pSSysApp, PSSystem pSSystem) throws Exception {
        pSSysApp.setPSSystemId(pSSystem.getPSSystemId());
        pSSysApp.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSSysApp pSSysApp, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSSysApp.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSSysApp.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSSysApp pSSysApp, boolean bl) throws Exception {
        if (bl) {
            if (pSSysApp.getAppPKGName() == null) {
                pSSysApp.setAppPKGName((String)this.getDefaultValue(this.getWebContext(), "USER", "App", 25));
            }
            if (pSSysApp.getPSAppEditorTemplsCnt() == null) {
                pSSysApp.setPSAppEditorTemplsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppFuncsCnt() == null) {
                pSSysApp.setPSAppFuncsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppMenusCnt() == null) {
                pSSysApp.setPSAppMenusCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppModulesCnt() == null) {
                pSSysApp.setPSAppModulesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppPkgsCnt() == null) {
                pSSysApp.setPSAppPkgsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppTitleBarsCnt() == null) {
                pSSysApp.setPSAppTitleBarsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppUIThemesCnt() == null) {
                pSSysApp.setPSAppUIThemesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppUserModesCnt() == null) {
                pSSysApp.setPSAppUserModesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppUtilPagesCnt() == null) {
                pSSysApp.setPSAppUtilPagesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppViewCodesCnt() == null) {
                pSSysApp.setPSAppViewCodesCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSAppViewsCnt() == null) {
                pSSysApp.setPSAppViewsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getPSSysAppName() == null) {
                pSSysApp.setPSSysAppName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5e94\u7528", 25));
            }
            if (pSSysApp.getPSSysTasksCnt() == null) {
                pSSysApp.setPSSysTasksCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysApp.getValidFlag() == null) {
                pSSysApp.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysApp, bl);
        this.onFillEntityFullInfo_PSAppType(pSSysApp, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSSysApp, bl);
        this.onFillEntityFullInfo_MDCtrlEmptyTextPSLanRes(pSSysApp, bl);
        this.onFillEntityFullInfo_PSModule(pSSysApp, bl);
        this.onFillEntityFullInfo_PSPFCDN(pSSysApp, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSSysApp, bl);
        this.onFillEntityFullInfo_PSPF(pSSysApp, bl);
        this.onFillEntityFullInfo_PSStudioTheme(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysImage(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysServiceAPI(pSSysApp, bl);
        this.onFillEntityFullInfo_DEPSSysSFPlugin(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSSysApp, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysApp, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSSysApp, bl);
    }

    protected void onFillEntityFullInfo_PSAppType(PSSysApp pSSysApp, boolean bl) throws Exception {
        if (pSSysApp.isPSAppTypeIdDirty()) {
            if (pSSysApp.getPSAppTypeId() != null) {
                if (pSSysApp.getPSAppTypeId() == null || pSSysApp.getPSAppTypeName() == null) {
                    PSAppType pSAppType = pSSysApp.getPSAppType();
                    pSSysApp.setPSAppTypeName(pSAppType.getPSAppTypeName());
                }
            } else {
                pSSysApp.setPSAppTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDCtrlEmptyTextPSLanRes(PSSysApp pSSysApp, boolean bl) throws Exception {
        if (pSSysApp.isMDCtrlEmptyTextPSLanResIdDirty()) {
            if (pSSysApp.getMDCtrlEmptyTextPSLanResId() != null) {
                if (pSSysApp.getMDCtrlEmptyTextPSLanResId() == null || pSSysApp.getMDCtrlEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysApp.getMDCtrlEmptyTextPSLanRes();
                    pSSysApp.setMDCtrlEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysApp.setMDCtrlEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFCDN(PSSysApp pSSysApp, boolean bl) throws Exception {
        if (pSSysApp.isPSPFCDNIdDirty()) {
            if (pSSysApp.getPSPFCDNId() != null) {
                if (pSSysApp.getPSPFCDNId() == null || pSSysApp.getPSPFCDNName() == null) {
                    PSPFCDN pSPFCDN = pSSysApp.getPSPFCDN();
                    pSSysApp.setPSPFCDNName(pSPFCDN.getPSPFCDNName());
                }
            } else {
                pSSysApp.setPSPFCDNName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSStudioTheme(PSSysApp pSSysApp, boolean bl) throws Exception {
        if (pSSysApp.isPSStudioThemeIdDirty()) {
            if (pSSysApp.getPSStudioThemeId() != null) {
                if (pSSysApp.getPSStudioThemeId() == null || pSSysApp.getPSStudioThemeName() == null) {
                    PSStudioTheme pSStudioTheme = pSSysApp.getPSStudioTheme();
                    pSSysApp.setPSStudioThemeName(pSStudioTheme.getPSStudioThemeName());
                }
            } else {
                pSSysApp.setPSStudioThemeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysServiceAPI(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DEPSSysSFPlugin(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSSysApp pSSysApp, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysApp pSSysApp, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysApp, bl);
    }

    public ArrayList<PSSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPTYPEID", (Object)pSAppTypeBase.getPSAppTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByMDCtrlEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByMDCtrlEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByMDCtrlEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByMDCtrlEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByMDCtrlEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDCTRLEMPTYTEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDCtrlEmptyTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDCtrlEmptyTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSPFCDN(PSPFCDNBase pSPFCDNBase) throws Exception {
        return this.selectByPSPFCDN(pSPFCDNBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSPFCDN(PSPFCDNBase pSPFCDNBase, String string) throws Exception {
        return this.selectByPSPFCDN(pSPFCDNBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSPFCDN(PSPFCDNBase pSPFCDNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFCDNID", (Object)pSPFCDNBase.getPSPFCDNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCDNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCDNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase) throws Exception {
        return this.selectByPSStudioTheme(pSStudioThemeBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase, String string) throws Exception {
        return this.selectByPSStudioTheme(pSStudioThemeBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOTHEMEID", (Object)pSStudioThemeBase.getPSStudioThemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioThemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioThemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string) throws Exception {
        return this.selectByPSSysServiceAPI(pSSysServiceAPIBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysServiceAPI(PSSysServiceAPIBase pSSysServiceAPIBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSERVICEAPIID", (Object)pSSysServiceAPIBase.getPSSysServiceAPIId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysServiceAPICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysServiceAPICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByDEPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByDEPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByDEPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DEPSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDEPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDEPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysApp> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysApp> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSSysApp> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSSysApp> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public void testRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSAppType(pSAppType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSAPPTYPE_PSAPPTYPEID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSAppType), arrayList.get(0)));
        }
    }

    public void resetPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSAppType(pSAppType);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSAppTypeId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSAppType(PSAppType pSAppType) throws Exception {
        final PSAppType pSAppType2 = pSAppType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSAppType(pSAppType2);
                PSSysAppServiceBase.this.internalRemoveByPSAppType(pSAppType2);
                PSSysAppServiceBase.this.onAfterRemoveByPSAppType(pSAppType2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void internalRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSAppType(pSAppType);
        this.onBeforeRemoveByPSAppType(pSAppType, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSAppType(pSAppType, arrayList);
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSCtrlLogicGroupId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysAppServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysAppServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByMDCtrlEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSLANGUAGERES_MDCTRLEMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByMDCtrlEmptyTextPSLanRes(pSLanguageRes);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setMDCtrlEmptyTextPSLanResId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByMDCtrlEmptyTextPSLanRes(pSLanguageRes2);
                PSSysAppServiceBase.this.internalRemoveByMDCtrlEmptyTextPSLanRes(pSLanguageRes2);
                PSSysAppServiceBase.this.onAfterRemoveByMDCtrlEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByMDCtrlEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByMDCtrlEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByMDCtrlEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDCtrlEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSModule(pSModule);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSModuleId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysAppServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysAppServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
    }

    public void resetPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPFCDN(pSPFCDN);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSPFCDNId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        final PSPFCDN pSPFCDN2 = pSPFCDN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSPFCDN(pSPFCDN2);
                PSSysAppServiceBase.this.internalRemoveByPSPFCDN(pSPFCDN2);
                PSSysAppServiceBase.this.onAfterRemoveByPSPFCDN(pSPFCDN2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
    }

    protected void internalRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPFCDN(pSPFCDN);
        this.onBeforeRemoveByPSPFCDN(pSPFCDN, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSPFCDN(pSPFCDN, arrayList);
    }

    protected void onAfterRemoveByPSPFCDN(PSPFCDN pSPFCDN) throws Exception {
    }

    protected void onBeforeRemoveByPSPFCDN(PSPFCDN pSPFCDN, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFCDN(PSPFCDN pSPFCDN, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSPFStyleId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSSysAppServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSSysAppServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPF(pSPF);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSPFId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSSysAppServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSSysAppServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    public void resetPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSStudioTheme(pSStudioTheme);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSStudioThemeId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        final PSStudioTheme pSStudioTheme2 = pSStudioTheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSStudioTheme(pSStudioTheme2);
                PSSysAppServiceBase.this.internalRemoveByPSStudioTheme(pSStudioTheme2);
                PSSysAppServiceBase.this.onAfterRemoveByPSStudioTheme(pSStudioTheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    protected void internalRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSStudioTheme(pSStudioTheme);
        this.onBeforeRemoveByPSStudioTheme(pSStudioTheme, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSStudioTheme(pSStudioTheme, arrayList);
    }

    protected void onAfterRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysCssId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysAppServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysDynaModelId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysAppServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysImageId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSSysAppServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysReqItemId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysAppServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysResourceId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSysAppServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSERVICEAPI");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysServiceAPI);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSSERVICEAPI_PSSYSSERVICEAPIID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysServiceAPI), arrayList.get(0)));
        }
    }

    public void resetPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysServiceAPIId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        final PSSysServiceAPI pSSysServiceAPI2 = pSSysServiceAPI;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysAppServiceBase.this.internalRemoveByPSSysServiceAPI(pSSysServiceAPI2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void internalRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysServiceAPI(pSSysServiceAPI);
        this.onBeforeRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysServiceAPI(pSSysServiceAPI, arrayList);
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    protected void onBeforeRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysServiceAPI(PSSysServiceAPI pSSysServiceAPI, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setDEPSSysSFPluginId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAppServiceBase.this.internalRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAppServiceBase.this.onAfterRemoveByDEPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByDEPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByDEPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByDEPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDEPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysSFPluginId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAppServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysSFPub(pSSysSFPub, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPUB");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPub);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSSFPUB_PSSYSSFPUBID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSysSFPub), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSysSFPubId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysAppServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSSystemId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysAppServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysAppServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSAPP_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSSYSAPP", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSSysApp pSSysApp : arrayList) {
            PSSysApp pSSysApp2 = (PSSysApp)this.getDEModel().createEntity();
            pSSysApp2.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSSysApp2.setPSViewMsgGroupId(null);
            this.update(pSSysApp2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysAppServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysAppServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysAppServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysApp> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSSysApp pSSysApp : arrayList) {
            this.remove((IEntity)pSSysApp);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysApp> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysApp pSSysApp) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppCtrlStyleService)ServiceGlobal.getService(PSAppCtrlStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppCtrlStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppCtrlStyleServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppDERSService)ServiceGlobal.getService(PSAppDERSService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppDERSServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppDEViewRefService)ServiceGlobal.getService(PSAppDEViewRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppDEViewRefServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppDEViewRefServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppEditorTemplService)ServiceGlobal.getService(PSAppEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppEditorTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppEditorTemplServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLanServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppLanServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppLogicServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppModuleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppModuleServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPDTViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPFPluginServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppResourceServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppStoryBoardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppSubAppService)ServiceGlobal.getService(PSAppSubAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppSubAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppSubAppServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUIThemeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppUIThemeServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUserModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppUserModeServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppViewCodeService)ServiceGlobal.getService(PSAppViewCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppViewCodeServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppViewStyleService)ServiceGlobal.getService(PSAppViewStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppViewStyleServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppViewServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppWFVerServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppWFVerServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppWFServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSAppWFServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSDCMobPackCertService)ServiceGlobal.getService(PSDCMobPackCertService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMobPackCertServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSDCMobPackCertServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFUIModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDynaAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSDynaAppServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
        ((PSMobAppPackServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSMobAppPackServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
        ((PSMobAppStartPageServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysModelChgLogService)ServiceGlobal.getService(PSSysModelChgLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysModelChgLogServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysDeployAppService)ServiceGlobal.getService(PSSysDeployAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDeployAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysERMapNodeService)ServiceGlobal.getService(PSSysERMapNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysERMapNodeServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysERMapService)ServiceGlobal.getService(PSSysERMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysERMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysERMapServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysIssueService)ServiceGlobal.getService(PSSysIssueService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysIssueServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysIssueServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysProjectServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysProjectServiceBase)pSCoreSysServiceBase).removeByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTaskServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemRunServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSystemRunService)ServiceGlobal.getService(PSSystemRunService.class, (SessionFactory)this.getSessionFactory());
        ((PSSystemRunServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp2(pSSysApp);
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysUCMapService)ServiceGlobal.getService(PSSysUCMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUCMapServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysUCMapServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUniResServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysViewLogicService)ServiceGlobal.getService(PSSysViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysViewLogicServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSDEUAWizardService)ServiceGlobal.getService(PSDEUAWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        ((PSDEUAWizardServiceBase)pSCoreSysServiceBase).resetPSSysApp(pSSysApp);
        pSCoreSysServiceBase = (PSWXEntAppService)ServiceGlobal.getService(PSWXEntAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSWXEntAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysApp(pSSysApp);
        super.onBeforeRemove(pSSysApp);
    }

    protected void replaceParentInfo(PSSysApp pSSysApp, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysApp, cloneSession);
        if (pSSysApp.getPSAppTypeId() != null && (iEntity = cloneSession.getEntity("PSAPPTYPE", (Object)pSSysApp.getPSAppTypeId())) != null) {
            this.onFillParentInfo_PSAppType(pSSysApp, (PSAppType)iEntity);
        }
        if (pSSysApp.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSSysApp.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysApp, (PSCtrlLogicGroup)iEntity);
        }
        if (pSSysApp.getMDCtrlEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysApp.getMDCtrlEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_MDCtrlEmptyTextPSLanRes(pSSysApp, (PSLanguageRes)iEntity);
        }
        if (pSSysApp.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysApp.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysApp, (PSModule)iEntity);
        }
        if (pSSysApp.getPSPFCDNId() != null && (iEntity = cloneSession.getEntity("PSPFCDN", (Object)pSSysApp.getPSPFCDNId())) != null) {
            this.onFillParentInfo_PSPFCDN(pSSysApp, (PSPFCDN)iEntity);
        }
        if (pSSysApp.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSSysApp.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSSysApp, (PSPFStyle)iEntity);
        }
        if (pSSysApp.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSSysApp.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSSysApp, (PSPF)iEntity);
        }
        if (pSSysApp.getPSStudioThemeId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOTHEME", (Object)pSSysApp.getPSStudioThemeId())) != null) {
            this.onFillParentInfo_PSStudioTheme(pSSysApp, (PSStudioTheme)iEntity);
        }
        if (pSSysApp.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysApp.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysApp, (PSSysCss)iEntity);
        }
        if (pSSysApp.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysApp.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysApp, (PSSysDynaModel)iEntity);
        }
        if (pSSysApp.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSSysApp.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSSysApp, (PSSysImage)iEntity);
        }
        if (pSSysApp.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysApp.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSysApp, (PSSysReqItem)iEntity);
        }
        if (pSSysApp.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysApp.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSysApp, (PSSysResource)iEntity);
        }
        if (pSSysApp.getPSSysServiceAPIId() != null && (iEntity = cloneSession.getEntity("PSSYSSERVICEAPI", (Object)pSSysApp.getPSSysServiceAPIId())) != null) {
            this.onFillParentInfo_PSSysServiceAPI(pSSysApp, (PSSysServiceAPI)iEntity);
        }
        if (pSSysApp.getDEPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysApp.getDEPSSysSFPluginId())) != null) {
            this.onFillParentInfo_DEPSSysSFPlugin(pSSysApp, (PSSysSFPlugin)iEntity);
        }
        if (pSSysApp.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSSysApp.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSSysApp, (PSSysSFPlugin)iEntity);
        }
        if (pSSysApp.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysApp.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSSysApp, (PSSysSFPub)iEntity);
        }
        if (pSSysApp.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysApp.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysApp, (PSSystem)iEntity);
        }
        if (pSSysApp.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSSysApp.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSSysApp, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysApp pSSysApp, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysApp, bl);
        pSSysApp.resetAppPKGName();
        pSSysApp.resetAppTag();
        pSSysApp.resetAppTag2();
        pSSysApp.resetAppTag3();
        pSSysApp.resetAppTag4();
    }

    protected void onCheckEntity(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ACMinChars(bl, pSSysApp, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppFolder(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppMode(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppPKGName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppSN(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag2(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag3(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppTag4(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppVersion(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AppViewPriority(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AutoAddAppView(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomInfo(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BtnNoPrivDM(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeFolder(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeNameMode(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPort(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultPub(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEPSSysSFPluginId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableC12ToC24(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableStoryBoard(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUIModelEx(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnaLocalService(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FIEmptyText(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FINoPrivDM(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FIUpdatePrivTag(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GCNoPrivDM(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColEnableFilter(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridColEnableLink(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridEnableCustomized(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridForceFit(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridRowActiveMode(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderInfo(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconFile(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainMenuSide(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDCtrlEmptyText(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDCtrlEmptyTextPSLanResId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDCtrlEmptyTextPSLanResName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrientationMode(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PFStyleParam(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreventXSS(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppEditorTemplsCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppFuncsCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenusCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppModulesCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppPkgsCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTitleBarsCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUIThemesCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUserModesCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppUtilPagesCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewCodesCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewsCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysAppId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCDNId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCDNName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioThemeId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioThemeName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysServiceAPIId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTasksCnt(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubRefViewOnly(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubSysRefViewOnly(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveFlag(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StartPageFile(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubCaption(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UACLogin(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIStyle(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysApp, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysApp, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ACMinChars(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isACMinCharsDirty() : !pSSysApp.isACMinCharsDirty()) {
            return null;
        }
        Integer n = pSSysApp.getACMinChars();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ACMinChars_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACMINCHARS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppFolder(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppFolderDirty() : !pSSysApp.isAppFolderDirty()) {
            return null;
        }
        String string = pSSysApp.getAppFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppFolder_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppMode(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppModeDirty() : !pSSysApp.isAppModeDirty()) {
            return null;
        }
        String string = pSSysApp.getAppMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppMode_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppPKGName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppPKGNameDirty() && !bl2 : !pSSysApp.isAppPKGNameDirty()) {
            return null;
        }
        String string = pSSysApp.getAppPKGName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppPKGName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysAppDEModel(), "APPPKGNAME", string3, pSSysApp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("APPPKGNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppSN(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppSNDirty() : !pSSysApp.isAppSNDirty()) {
            return null;
        }
        String string = pSSysApp.getAppSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppSN_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppTagDirty() : !pSSysApp.isAppTagDirty()) {
            return null;
        }
        String string = pSSysApp.getAppTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag2(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppTag2Dirty() : !pSSysApp.isAppTag2Dirty()) {
            return null;
        }
        String string = pSSysApp.getAppTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag2_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag3(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppTag3Dirty() : !pSSysApp.isAppTag3Dirty()) {
            return null;
        }
        String string = pSSysApp.getAppTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag3_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppTag4(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppTag4Dirty() : !pSSysApp.isAppTag4Dirty()) {
            return null;
        }
        String string = pSSysApp.getAppTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppTag4_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppVersion(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppVersionDirty() : !pSSysApp.isAppVersionDirty()) {
            return null;
        }
        String string = pSSysApp.getAppVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppVersion_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AppViewPriority(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAppViewPriorityDirty() : !pSSysApp.isAppViewPriorityDirty()) {
            return null;
        }
        Integer n = pSSysApp.getAppViewPriority();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AppViewPriority_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPVIEWPRIORITY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AutoAddAppView(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isAutoAddAppViewDirty() : !pSSysApp.isAutoAddAppViewDirty()) {
            return null;
        }
        Integer n = pSSysApp.getAutoAddAppView();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AutoAddAppView_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AUTOADDAPPVIEW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomInfo(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isBottomInfoDirty() : !pSSysApp.isBottomInfoDirty()) {
            return null;
        }
        String string = pSSysApp.getBottomInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomInfo_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BtnNoPrivDM(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isBtnNoPrivDMDirty() : !pSSysApp.isBtnNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSSysApp.getBtnNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BtnNoPrivDM_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BTNNOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isCaptionDirty() : !pSSysApp.isCaptionDirty()) {
            return null;
        }
        String string = pSSysApp.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeFolder(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isCodeFolderDirty() : !pSSysApp.isCodeFolderDirty()) {
            return null;
        }
        String string = pSSysApp.getCodeFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeFolder_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeNameMode(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isCodeNameModeDirty() : !pSSysApp.isCodeNameModeDirty()) {
            return null;
        }
        String string = pSSysApp.getCodeNameMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeNameMode_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAMEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultPort(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isDefaultPortDirty() : !pSSysApp.isDefaultPortDirty()) {
            return null;
        }
        Integer n = pSSysApp.getDefaultPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultPort_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultPub(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isDefaultPubDirty() : !pSSysApp.isDefaultPubDirty()) {
            return null;
        }
        Integer n = pSSysApp.getDefaultPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultPub_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSSYSTEMID";
                String string2 = this.checkFieldDupRule(this.getPSSysAppDEModel(), "DEFAULTPUB", string, pSSysApp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTPUB");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEPSSysSFPluginId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isDEPSSysSFPluginIdDirty() : !pSSysApp.isDEPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysApp.getDEPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DEPSSysSFPluginId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableC12ToC24(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isEnableC12ToC24Dirty() : !pSSysApp.isEnableC12ToC24Dirty()) {
            return null;
        }
        Integer n = pSSysApp.getEnableC12ToC24();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableC12ToC24_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEC12TOC24");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isEnableDynaSysDirty() : !pSSysApp.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSSysApp.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableStoryBoard(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isEnableStoryBoardDirty() : !pSSysApp.isEnableStoryBoardDirty()) {
            return null;
        }
        Integer n = pSSysApp.getEnableStoryBoard();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableStoryBoard_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESTORYBOARD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUIModelEx(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isEnableUIModelExDirty() : !pSSysApp.isEnableUIModelExDirty()) {
            return null;
        }
        Integer n = pSSysApp.getEnableUIModelEx();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUIModelEx_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUIMODELEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnaLocalService(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isEnaLocalServiceDirty() : !pSSysApp.isEnaLocalServiceDirty()) {
            return null;
        }
        Integer n = pSSysApp.getEnaLocalService();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnaLocalService_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENALOCALSERVICE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FIEmptyText(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isFIEmptyTextDirty() : !pSSysApp.isFIEmptyTextDirty()) {
            return null;
        }
        String string = pSSysApp.getFIEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FIEmptyText_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIEMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FINoPrivDM(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isFINoPrivDMDirty() : !pSSysApp.isFINoPrivDMDirty()) {
            return null;
        }
        Integer n = pSSysApp.getFINoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FINoPrivDM_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FINOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FIUpdatePrivTag(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isFIUpdatePrivTagDirty() : !pSSysApp.isFIUpdatePrivTagDirty()) {
            return null;
        }
        Integer n = pSSysApp.getFIUpdatePrivTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FIUpdatePrivTag_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIUPDATEPRIVTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GCNoPrivDM(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isGCNoPrivDMDirty() : !pSSysApp.isGCNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSSysApp.getGCNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GCNoPrivDM_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GCNOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColEnableFilter(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isGridColEnableFilterDirty() : !pSSysApp.isGridColEnableFilterDirty()) {
            return null;
        }
        Integer n = pSSysApp.getGridColEnableFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridColEnableFilter_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLENABLEFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridColEnableLink(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isGridColEnableLinkDirty() : !pSSysApp.isGridColEnableLinkDirty()) {
            return null;
        }
        Integer n = pSSysApp.getGridColEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridColEnableLink_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDCOLENABLELINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridEnableCustomized(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isGridEnableCustomizedDirty() : !pSSysApp.isGridEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSSysApp.getGridEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridEnableCustomized_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDENABLECUSTOMIZED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridForceFit(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isGridForceFitDirty() : !pSSysApp.isGridForceFitDirty()) {
            return null;
        }
        Integer n = pSSysApp.getGridForceFit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridForceFit_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDFORCEFIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridRowActiveMode(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isGridRowActiveModeDirty() : !pSSysApp.isGridRowActiveModeDirty()) {
            return null;
        }
        Integer n = pSSysApp.getGridRowActiveMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridRowActiveMode_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDROWACTIVEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderInfo(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isHeaderInfoDirty() : !pSSysApp.isHeaderInfoDirty()) {
            return null;
        }
        String string = pSSysApp.getHeaderInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderInfo_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconFile(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isIconFileDirty() : !pSSysApp.isIconFileDirty()) {
            return null;
        }
        String string = pSSysApp.getIconFile();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconFile_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONFILE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isLogicNameDirty() : !pSSysApp.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysApp.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_MainMenuSide(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isMainMenuSideDirty() : !pSSysApp.isMainMenuSideDirty()) {
            return null;
        }
        String string = pSSysApp.getMainMenuSide();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainMenuSide_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINMENUSIDE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDCtrlEmptyText(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isMDCtrlEmptyTextDirty() : !pSSysApp.isMDCtrlEmptyTextDirty()) {
            return null;
        }
        String string = pSSysApp.getMDCtrlEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDCtrlEmptyText_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDCTRLEMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDCtrlEmptyTextPSLanResId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isMDCtrlEmptyTextPSLanResIdDirty() : !pSSysApp.isMDCtrlEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysApp.getMDCtrlEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDCtrlEmptyTextPSLanResId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDCTRLEMPTYTEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDCtrlEmptyTextPSLanResName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isMDCtrlEmptyTextPSLanResNameDirty() : !pSSysApp.isMDCtrlEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysApp.getMDCtrlEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDCtrlEmptyTextPSLanResName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDCTRLEMPTYTEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isMemoDirty() : !pSSysApp.isMemoDirty()) {
            return null;
        }
        String string = pSSysApp.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isOrderValueDirty() : !pSSysApp.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysApp.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrientationMode(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isOrientationModeDirty() : !pSSysApp.isOrientationModeDirty()) {
            return null;
        }
        String string = pSSysApp.getOrientationMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrientationMode_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORIENTATIONMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PFStyleParam(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPFStyleParamDirty() : !pSSysApp.isPFStyleParamDirty()) {
            return null;
        }
        String string = pSSysApp.getPFStyleParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PFStyleParam_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PFSTYLEPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreventXSS(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPreventXSSDirty() : !pSSysApp.isPreventXSSDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPreventXSS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreventXSS_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppEditorTemplsCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppEditorTemplsCntDirty() : !pSSysApp.isPSAppEditorTemplsCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppEditorTemplsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppEditorTemplsCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPEDITORTEMPLSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppFuncsCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppFuncsCntDirty() : !pSSysApp.isPSAppFuncsCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppFuncsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppFuncsCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPFUNCSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppMenusCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppMenusCntDirty() : !pSSysApp.isPSAppMenusCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppMenusCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppMenusCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppModulesCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppModulesCntDirty() : !pSSysApp.isPSAppModulesCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppModulesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppModulesCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMODULESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppPkgsCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppPkgsCntDirty() : !pSSysApp.isPSAppPkgsCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppPkgsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppPkgsCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPKGSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTitleBarsCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppTitleBarsCntDirty() : !pSSysApp.isPSAppTitleBarsCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppTitleBarsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppTitleBarsCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTITLEBARSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTypeId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppTypeIdDirty() && !bl2 : !pSSysApp.isPSAppTypeIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSAppTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTypeName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppTypeNameDirty() && !bl2 : !pSSysApp.isPSAppTypeNameDirty()) {
            return null;
        }
        String string = pSSysApp.getPSAppTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUIThemesCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppUIThemesCntDirty() : !pSSysApp.isPSAppUIThemesCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppUIThemesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppUIThemesCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUITHEMESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUserModesCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppUserModesCntDirty() : !pSSysApp.isPSAppUserModesCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppUserModesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppUserModesCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUSERMODESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppUtilPagesCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppUtilPagesCntDirty() : !pSSysApp.isPSAppUtilPagesCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppUtilPagesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppUtilPagesCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPUTILPAGESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewCodesCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppViewCodesCntDirty() : !pSSysApp.isPSAppViewCodesCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppViewCodesCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppViewCodesCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWCODESCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewsCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSAppViewsCntDirty() : !pSSysApp.isPSAppViewsCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSAppViewsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSAppViewsCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSCtrlLogicGroupIdDirty() : !pSSysApp.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevSlnSysAppId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSDevSlnSysAppIdDirty() : !pSSysApp.isPSDevSlnSysAppIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSDevSlnSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysAppId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSModuleIdDirty() : !pSSysApp.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFCDNId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSPFCDNIdDirty() : !pSSysApp.isPSPFCDNIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSPFCDNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCDNId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCDNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFCDNName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSPFCDNNameDirty() : !pSSysApp.isPSPFCDNNameDirty()) {
            return null;
        }
        String string = pSSysApp.getPSPFCDNName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCDNName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCDNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSPFIdDirty() && !bl2 : !pSSysApp.isPSPFIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSPFStyleIdDirty() && !bl2 : !pSSysApp.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSPFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSStudioThemeId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSStudioThemeIdDirty() : !pSSysApp.isPSStudioThemeIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSStudioThemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioThemeId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOTHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioThemeName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSStudioThemeNameDirty() : !pSSysApp.isPSStudioThemeNameDirty()) {
            return null;
        }
        String string = pSSysApp.getPSStudioThemeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioThemeName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOTHEMENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysAppIdDirty() && !bl2 : !pSSysApp.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysAppNameDirty() && !bl2 : !pSSysApp.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysAppDEModel(), "PSSYSAPPNAME", string3, pSSysApp, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSAPPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysCssIdDirty() : !pSSysApp.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysDynaModelIdDirty() : !pSSysApp.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysImageIdDirty() : !pSSysApp.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysReqItemIdDirty() : !pSSysApp.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysResourceIdDirty() : !pSSysApp.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysServiceAPIId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysServiceAPIIdDirty() : !pSSysApp.isPSSysServiceAPIIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysServiceAPIId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysServiceAPIId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSERVICEAPIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysSFPluginIdDirty() : !pSSysApp.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysSFPubIdDirty() : !pSSysApp.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSysSFPubId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTasksCnt(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSysTasksCntDirty() : !pSSysApp.isPSSysTasksCntDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPSSysTasksCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSSysTasksCnt_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTASKSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSSystemIdDirty() && !bl2 : !pSSysApp.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPSViewMsgGroupIdDirty() : !pSSysApp.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSSysApp.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubRefViewOnly(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPubRefViewOnlyDirty() : !pSSysApp.isPubRefViewOnlyDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPubRefViewOnly();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubRefViewOnly_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBREFVIEWONLY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubSysRefViewOnly(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isPubSysRefViewOnlyDirty() : !pSSysApp.isPubSysRefViewOnlyDirty()) {
            return null;
        }
        Integer n = pSSysApp.getPubSysRefViewOnly();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubSysRefViewOnly_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBSYSREFVIEWONLY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveFlag(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isRemoveFlagDirty() : !pSSysApp.isRemoveFlagDirty()) {
            return null;
        }
        Integer n = pSSysApp.getRemoveFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveFlag_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isServiceCodeNameDirty() : !pSSysApp.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSSysApp.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StartPageFile(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isStartPageFileDirty() : !pSSysApp.isStartPageFileDirty()) {
            return null;
        }
        String string = pSSysApp.getStartPageFile();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StartPageFile_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STARTPAGEFILE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubCaption(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isSubCaptionDirty() : !pSSysApp.isSubCaptionDirty()) {
            return null;
        }
        String string = pSSysApp.getSubCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubCaption_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_Title(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isTitleDirty() : !pSSysApp.isTitleDirty()) {
            return null;
        }
        String string = pSSysApp.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UACLogin(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUACLoginDirty() : !pSSysApp.isUACLoginDirty()) {
            return null;
        }
        Integer n = pSSysApp.getUACLogin();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UACLogin_Default((IEntity)pSSysApp, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UACLOGIN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIStyle(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUIStyleDirty() : !pSSysApp.isUIStyleDirty()) {
            return null;
        }
        String string = pSSysApp.getUIStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIStyle_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUserCatDirty() : !pSSysApp.isUserCatDirty()) {
            return null;
        }
        String string = pSSysApp.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUserParamsDirty() : !pSSysApp.isUserParamsDirty()) {
            return null;
        }
        String string = pSSysApp.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUserTagDirty() : !pSSysApp.isUserTagDirty()) {
            return null;
        }
        String string = pSSysApp.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUserTag2Dirty() : !pSSysApp.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysApp.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUserTag3Dirty() : !pSSysApp.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysApp.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isUserTag4Dirty() : !pSSysApp.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysApp.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysApp pSSysApp, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysApp.isValidFlagDirty() : !pSSysApp.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysApp.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysApp, bl2, bl3);
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

    protected void onSyncEntity(PSSysApp pSSysApp, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysApp, bl);
    }

    protected void onSyncIndexEntities(PSSysApp pSSysApp, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysApp, bl);
    }

    public Object getDataContextValue(PSSysApp pSSysApp, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysApp, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysApp.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysApp pSSysApp, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysApp, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACMINCHARS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ACMinChars_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppPKGName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPVERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppVersion_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APPVIEWPRIORITY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppViewPriority_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AUTOADDAPPVIEW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AutoAddAppView_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BTNNOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BtnNoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAMEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeNameMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEPSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEPSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEC12TOC24", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableC12ToC24_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESTORYBOARD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableStoryBoard_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUIMODELEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUIModelEx_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENALOCALSERVICE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnaLocalService_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIEMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FIEmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FINOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FINoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIUPDATEPRIVTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FIUpdatePrivTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GCNOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GCNoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLENABLEFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColEnableFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDCOLENABLELINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridColEnableLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridEnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDFORCEFIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridForceFit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDROWACTIVEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridRowActiveMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONFILE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconFile_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINMENUSIDE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainMenuSide_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDCTRLEMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDCtrlEmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDCTRLEMPTYTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDCtrlEmptyTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDCTRLEMPTYTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDCtrlEmptyTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORIENTATIONMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrientationMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PFSTYLEPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PFStyleParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENTXSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreventXSS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPEDITORTEMPLSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppEditorTemplsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPFUNCSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppFuncsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenusCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMODULESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppModulesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPKGSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPkgsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTITLEBARSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTitleBarsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUITHEMESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUIThemesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUSERMODESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUserModesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPUTILPAGESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppUtilPagesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWCODESCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewCodesCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCDNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCDNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCDNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCDNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOTHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioThemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOTHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioThemeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSERVICEAPINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysServiceAPIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTASKSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTasksCnt_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PUBREFVIEWONLY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubRefViewOnly_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBSYSREFVIEWONLY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubSysRefViewOnly_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STARTPAGEFILE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StartPageFile_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UACLOGIN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UACLogin_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ACMinChars_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AppFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPFOLDER", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("APPFOLDER", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppPKGName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPPKGNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("APPPKGNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppVersion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPVERSION", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AppViewPriority_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AutoAddAppView_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BottomInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BtnNoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEFOLDER", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeNameMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAMEMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected String onTestValueRule_DefaultPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEPSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEPSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableC12ToC24_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableStoryBoard_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUIModelEx_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnaLocalService_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FIEmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIEMPTYTEXT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FINoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FIUpdatePrivTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GCNoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GridColEnableFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GridColEnableLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GridEnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GridForceFit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GridRowActiveMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeaderInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconFile_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONFILE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainMenuSide_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINMENUSIDE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDCtrlEmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDCTRLEMPTYTEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDCtrlEmptyTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDCTRLEMPTYTEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDCtrlEmptyTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDCTRLEMPTYTEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrientationMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORIENTATIONMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PFStyleParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PFSTYLEPARAM", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreventXSS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppEditorTemplsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppFuncsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppMenusCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppModulesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppPkgsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppTitleBarsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppUIThemesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppUserModesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppUtilPagesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppViewCodesCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSAppViewsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDevSlnSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSPFCDNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCDNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFCDNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCDNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSStudioThemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOTHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioThemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOTHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysServiceAPIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysServiceAPIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSERVICEAPINAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTasksCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PubRefViewOnly_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PubSysRefViewOnly_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RemoveFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("SERVICECODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StartPageFile_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STARTPAGEFILE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UACLogin_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysApp pSSysApp) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPEDITORTEMPL_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppEditorTempls(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppFuncs(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppMenus(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppModules(pSSysApp)) {
            bl = true;
        }
        log.error((Object)"\u5b50\u5173\u7cfb  DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID \u6ca1\u6709\u5b9a\u4e49\u5173\u7cfb\u4ee3\u7801\u540d\u79f0\uff0c\u65e0\u6cd5\u8f93\u51fa\u6267\u884c\u4ee3\u7801");
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppTitleBars(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppUIThemes(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppUserModes(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppUtilPages(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWCODE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppViewCodes(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSAppViews(pSSysApp)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && this.onMergeChild_PSSysTasks(pSSysApp)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSSysApp)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSAppEditorTempls(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPEDITORTEMPLSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppFuncs(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPFUNCSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppMenus(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPMENUSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppModules(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPMODULESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppTitleBars(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPTITLEBARSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppUIThemes(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPUITHEMESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUIThemeService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppUserModes(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPUSERMODESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUserModeService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppUtilPages(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPUTILPAGESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppViewCodes(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPVIEWCODESCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSAppViews(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSAPPVIEWSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected boolean onMergeChild_PSSysTasks(PSSysApp pSSysApp) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSSYSTASKSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSSysApp.getPSSysAppId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSSYSAPPID", (Object)pSSysApp.getPSSysAppId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSSysApp, false);
        return true;
    }

    protected void onUpdateParent(PSSysApp pSSysApp) throws Exception {
        Object object = pSSysApp.get("PSSYSTEMID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSAPP_PSSYSTEM_PSSYSTEMID", object);
        }
        super.onUpdateParent((IEntity)pSSysApp);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysApp pSSysApp, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSAPP");
        if (!bl) {
            pSSysApp.setCreateDate(null);
            pSSysApp.setCreateMan(null);
            pSSysApp.setPSAppEditorTemplsCnt(null);
            pSSysApp.setPSAppFuncsCnt(null);
            pSSysApp.setPSAppMenusCnt(null);
            pSSysApp.setPSAppModulesCnt(null);
            pSSysApp.setPSAppPkgsCnt(null);
            pSSysApp.setPSAppUIThemesCnt(null);
            pSSysApp.setPSAppUserModesCnt(null);
            pSSysApp.setPSAppUtilPagesCnt(null);
            pSSysApp.setPSAppViewCodesCnt(null);
            pSSysApp.setPSAppViewsCnt(null);
            pSSysApp.setPSSysAppId(null);
            pSSysApp.setUpdateDate(null);
            pSSysApp.setUpdateMan(null);
            super.exportCurXmlModel(pSSysApp, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysApp pSSysApp, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysApp, string);
        objectNode.remove("psappeditortemplscnt");
        objectNode.remove("psappfuncscnt");
        objectNode.remove("psappmenuscnt");
        objectNode.remove("psappmodulescnt");
        objectNode.remove("psapppkgscnt");
        objectNode.remove("psapptitlebarscnt");
        objectNode.remove("psappuithemescnt");
        objectNode.remove("psappusermodescnt");
        objectNode.remove("psapputilpagescnt");
        objectNode.remove("psappviewcodescnt");
        objectNode.remove("psappviewscnt");
        objectNode.remove("pssystaskscnt");
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
            return "DER1N_PSSYSAPP_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSAPP_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysApp pSSysApp) {
        if (!StringHelper.isNullOrEmpty((String)pSSysApp.getAppPKGName())) {
            return pSSysApp.getAppPKGName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysApp.getPSSysAppName())) {
            return pSSysApp.getPSSysAppName();
        }
        return super.getModelV2Tag(pSSysApp);
    }

    @Override
    public boolean setModelV2Tag(PSSysApp pSSysApp, String string) {
        pSSysApp.setAppPKGName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("APPPKGNAME", "");
        map.put("PSSYSAPPNAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysApp pSSysApp, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysApp.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysApp, true);
        pSSysApp.set("APPPKGNAME", string);
        if (this.select(pSSysApp, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysApp, true);
        return super.getModelV2Entity(pSSysApp, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysApp pSSysApp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysApp, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 30;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 40;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPPFPLUGIN_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSMOBAPPPACK_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 70;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPLOGIC_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        if (StringHelper.compare((String)"DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 80;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysApp pSSysApp, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPMODULE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppModule();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppModuleService)pSCoreSysServiceBase).getModelV2Tag((PSAppModule)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPMODULE", (Object)entityBase.getPSAppModuleId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSSYSTESTPRJ", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSSysTestPrj();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSSysTestPrj)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSSYSTESTPRJ", (Object)entityBase.getPSSysTestPrjId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPLOCALDE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppLocalDE();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppLocalDE)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPLOCALDE", (Object)entityBase.getPSAppLocalDEId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPMENU", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppMenu();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppMenuServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppMenu)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPMENU", (Object)entityBase.getPSAppMenuId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPRESOURCE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppResource();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppResourceServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppResource)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPRESOURCE", (Object)entityBase.getPSAppResourceId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPSTORYBOARD", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppStoryBoard();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppStoryBoardServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppStoryBoard)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPSTORYBOARD", (Object)entityBase.getPSAppStoryBoardId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPTITLEBAR", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppTitleBar();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppTitleBar)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPTITLEBAR", (Object)entityBase.getPSAppTitleBarId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID")) {
            file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPDEVIEW", (Object)pSSysApp.getPSSysAppId()));
            if (file2.exists()) {
                pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPDEVIEW", (Object)entityBase.getPSAppDEViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPDYNADEVIEW", (Object)pSSysApp.getPSSysAppId()))).exists()) {
                pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppDynaDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPDYNADEVIEW", (Object)entityBase.getPSAppDynaDEViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPINDEXVIEW", (Object)pSSysApp.getPSSysAppId()))).exists()) {
                pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppIndexView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPINDEXVIEW", (Object)entityBase.getPSAppIndexViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPANELVIEW", (Object)pSSysApp.getPSSysAppId()))).exists()) {
                pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppPanelView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPANELVIEW", (Object)entityBase.getPSAppPanelViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPORTALVIEW", (Object)pSSysApp.getPSSysAppId()))).exists()) {
                pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppPortalView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPORTALVIEW", (Object)entityBase.getPSAppPortalViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
            if ((file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUTILVIEW", (Object)pSSysApp.getPSSysAppId()))).exists()) {
                pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
                string5 = pSCoreSysServiceBase.getModelV2Name(false);
                string4 = string + File.separator + string5;
                file = new File(string4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                arrayList = PSModelV2Helper.readFile2(file2);
                for (String string6 : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)string6)) continue;
                    objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                    entityBase = new PSAppUtilView();
                    PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                    string3 = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2Tag(entityBase);
                    if (StringHelper.isNullOrEmpty((String)string3)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUTILVIEW", (Object)entityBase.getPSAppUtilViewId()));
                    }
                    string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                    file = new File(string4 + File.separator + string3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
                }
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPFUNC", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppFunc();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppFuncServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppFunc)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPFUNC", (Object)entityBase.getPSAppFuncId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPLAN", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppLan();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppLanServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppLan)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPLAN", (Object)entityBase.getPSAppLanId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPDTVIEW", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppPDTView();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppPDTViewServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppPDTView)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPDTVIEW", (Object)entityBase.getPSAppPDTViewId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPPFPLUGIN_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPFPLUGIN", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppPFPlugin();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppPFPluginServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppPFPlugin)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPFPLUGIN", (Object)entityBase.getPSAppPFPluginId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPORTLET", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppPortlet();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppPortletServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppPortlet)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPORTLET", (Object)entityBase.getPSAppPortletId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUISTYLE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppUIStyle();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppUIStyle)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUISTYLE", (Object)entityBase.getPSAppUIStyleId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUITHEME", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppUITheme();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppUIThemeServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppUITheme)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUITHEME", (Object)entityBase.getPSAppUIThemeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUSERMODE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppUserMode();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppUserModeServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppUserMode)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUSERMODE", (Object)entityBase.getPSAppUserModeId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUTILPAGE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppUtilPage();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppUtilPage)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUTILPAGE", (Object)entityBase.getPSAppUtilPageId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSMOBAPPPACK_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSMOBAPPPACK", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSMobAppPack();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSMobAppPackServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSMobAppPack)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSMOBAPPPACK", (Object)entityBase.getPSMobAppPackId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSMOBAPPSTARTPAGE", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSMobAppStartPage();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSMobAppStartPageServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSMobAppStartPage)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSMOBAPPSTARTPAGE", (Object)entityBase.getPSMobAppStartPageId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPLOGIC_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPLOGIC", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppLogic();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppLogicServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppLogic)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPLOGIC", (Object)entityBase.getPSAppLogicId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPPKG", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppPkg();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppPkgServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppPkg)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPPKG", (Object)entityBase.getPSAppPkgId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPUTIL", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppUtil();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppUtilServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppUtil)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPUTIL", (Object)entityBase.getPSAppUtilId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSAPPWF", (Object)pSSysApp.getPSSysAppId()))).exists()) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSAppWF();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSAppWFServiceBase)pSCoreSysServiceBase).getModelV2Tag((PSAppWF)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSAPPWF", (Object)entityBase.getPSAppWFId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSSysApp, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysApp pSSysApp, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSAppModule> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPMODULE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSAppModule>();
                object4 = ((PSAppModuleServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppModule)object2.next();
                    object = ((PSAppModuleServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappmodulename")) {
                            string = objectNode.get("psappmodulename").asText();
                        }
                        if (objectNode2.has("psappmodulename")) {
                            string2 = objectNode2.get("psappmodulename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppModule();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSTESTPRJ", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysTestPrj)object2.next();
                    object = ((PSSysTestPrjServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssystestprjname")) {
                            string = objectNode.get("pssystestprjname").asText();
                        }
                        if (objectNode2.has("pssystestprjname")) {
                            string2 = objectNode2.get("pssystestprjname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysTestPrj();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPLOCALDE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppLocalDE)object2.next();
                    object = ((PSAppLocalDEServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapplocaldename")) {
                            string = objectNode.get("psapplocaldename").asText();
                        }
                        if (objectNode2.has("psapplocaldename")) {
                            string2 = objectNode2.get("psapplocaldename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppLocalDE();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPMENU", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppMenuServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppMenu)object2.next();
                    object = ((PSAppMenuServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappmenuname")) {
                            string = objectNode.get("psappmenuname").asText();
                        }
                        if (objectNode2.has("psappmenuname")) {
                            string2 = objectNode2.get("psappmenuname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppMenu();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPRESOURCE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppResourceServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppResource)object2.next();
                    object = ((PSAppResourceServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappresourcename")) {
                            string = objectNode.get("psappresourcename").asText();
                        }
                        if (objectNode2.has("psappresourcename")) {
                            string2 = objectNode2.get("psappresourcename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppResource();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPSTORYBOARD", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppStoryBoardServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppStoryBoard)object2.next();
                    object = ((PSAppStoryBoardServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappstoryboardname")) {
                            string = objectNode.get("psappstoryboardname").asText();
                        }
                        if (objectNode2.has("psappstoryboardname")) {
                            string2 = objectNode2.get("psappstoryboardname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppStoryBoard();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPTITLEBAR", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppTitleBar)object2.next();
                    object = ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapptitlebarname")) {
                            string = objectNode.get("psapptitlebarname").asText();
                        }
                        if (objectNode2.has("psapptitlebarname")) {
                            string2 = objectNode2.get("psapptitlebarname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppTitleBar();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPDEVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppDEView)object2.next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappdeviewname")) {
                            string = objectNode.get("psappdeviewname").asText();
                        }
                        if (objectNode2.has("psappdeviewname")) {
                            string2 = objectNode2.get("psappdeviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
            pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPDYNADEVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppDynaDEView)object2.next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappdynadeviewname")) {
                            string = objectNode.get("psappdynadeviewname").asText();
                        }
                        if (objectNode2.has("psappdynadeviewname")) {
                            string2 = objectNode2.get("psappdynadeviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppDynaDEView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
            pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPINDEXVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppIndexView)object2.next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappindexviewname")) {
                            string = objectNode.get("psappindexviewname").asText();
                        }
                        if (objectNode2.has("psappindexviewname")) {
                            string2 = objectNode2.get("psappindexviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppIndexView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
            pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPANELVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppPanelView)object2.next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapppanelviewname")) {
                            string = objectNode.get("psapppanelviewname").asText();
                        }
                        if (objectNode2.has("psapppanelviewname")) {
                            string2 = objectNode2.get("psapppanelviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppPanelView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
            pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPORTALVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppPortalView)object2.next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappportalviewname")) {
                            string = objectNode.get("psappportalviewname").asText();
                        }
                        if (objectNode2.has("psappportalviewname")) {
                            string2 = objectNode2.get("psappportalviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppPortalView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
            pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUTILVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppUtilView)object2.next();
                    object = ((PSAppViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapputilviewname")) {
                            string = objectNode.get("psapputilviewname").asText();
                        }
                        if (objectNode2.has("psapputilviewname")) {
                            string2 = objectNode2.get("psapputilviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppUtilView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPFUNC", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppFuncServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppFunc)object2.next();
                    object = ((PSAppFuncServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappfuncname")) {
                            string = objectNode.get("psappfuncname").asText();
                        }
                        if (objectNode2.has("psappfuncname")) {
                            string2 = objectNode2.get("psappfuncname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppFunc();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPLAN", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppLanServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppLan)object2.next();
                    object = ((PSAppLanServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapplanname")) {
                            string = objectNode.get("psapplanname").asText();
                        }
                        if (objectNode2.has("psapplanname")) {
                            string2 = objectNode2.get("psapplanname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppLan();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPDTVIEW", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppPDTViewServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppPDTView)object2.next();
                    object = ((PSAppPDTViewServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapppdtviewname")) {
                            string = objectNode.get("psapppdtviewname").asText();
                        }
                        if (objectNode2.has("psapppdtviewname")) {
                            string2 = objectNode2.get("psapppdtviewname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppPDTView();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPPFPLUGIN_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPFPLUGIN", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppPFPluginServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppPFPlugin)object2.next();
                    object = ((PSAppPFPluginServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapppfpluginname")) {
                            string = objectNode.get("psapppfpluginname").asText();
                        }
                        if (objectNode2.has("psapppfpluginname")) {
                            string2 = objectNode2.get("psapppfpluginname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppPFPlugin();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPORTLET", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppPortletServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppPortlet)object2.next();
                    object = ((PSAppPortletServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappportletname")) {
                            string = objectNode.get("psappportletname").asText();
                        }
                        if (objectNode2.has("psappportletname")) {
                            string2 = objectNode2.get("psappportletname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppPortlet();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUISTYLE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppUIStyle)object2.next();
                    object = ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappuistylename")) {
                            string = objectNode.get("psappuistylename").asText();
                        }
                        if (objectNode2.has("psappuistylename")) {
                            string2 = objectNode2.get("psappuistylename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppUIStyle();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUITHEME", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppUIThemeServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppUITheme)object2.next();
                    object = ((PSAppUIThemeServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappuithemename")) {
                            string = objectNode.get("psappuithemename").asText();
                        }
                        if (objectNode2.has("psappuithemename")) {
                            string2 = objectNode2.get("psappuithemename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppUITheme();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUSERMODE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppUserModeServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppUserMode)object2.next();
                    object = ((PSAppUserModeServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappusermodename")) {
                            string = objectNode.get("psappusermodename").asText();
                        }
                        if (objectNode2.has("psappusermodename")) {
                            string2 = objectNode2.get("psappusermodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppUserMode();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUTILPAGE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppUtilPage)object2.next();
                    object = ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapputilpagename")) {
                            string = objectNode.get("psapputilpagename").asText();
                        }
                        if (objectNode2.has("psapputilpagename")) {
                            string2 = objectNode2.get("psapputilpagename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppUtilPage();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSMOBAPPPACK_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSMOBAPPPACK", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSMobAppPackServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSMobAppPack)object2.next();
                    object = ((PSMobAppPackServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psmobapppackname")) {
                            string = objectNode.get("psmobapppackname").asText();
                        }
                        if (objectNode2.has("psmobapppackname")) {
                            string2 = objectNode2.get("psmobapppackname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSMobAppPack();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSMOBAPPSTARTPAGE", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSMobAppStartPageServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSMobAppStartPage)object2.next();
                    object = ((PSMobAppStartPageServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psmobappstartpagename")) {
                            string = objectNode.get("psmobappstartpagename").asText();
                        }
                        if (objectNode2.has("psmobappstartpagename")) {
                            string2 = objectNode2.get("psmobappstartpagename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSMobAppStartPage();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPLOGIC_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPLOGIC", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppLogicServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppLogic)object2.next();
                    object = ((PSAppLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapplogicname")) {
                            string = objectNode.get("psapplogicname").asText();
                        }
                        if (objectNode2.has("psapplogicname")) {
                            string2 = objectNode2.get("psapplogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPPKG", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppPkgServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppPkg)object2.next();
                    object = ((PSAppPkgServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapppkgname")) {
                            string = objectNode.get("psapppkgname").asText();
                        }
                        if (objectNode2.has("psapppkgname")) {
                            string2 = objectNode2.get("psapppkgname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppPkg();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPUTIL", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppUtilServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppUtil)object2.next();
                    object = ((PSAppUtilServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psapputilname")) {
                            string = objectNode.get("psapputilname").asText();
                        }
                        if (objectNode2.has("psapputilname")) {
                            string2 = objectNode2.get("psapputilname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppUtil();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID")) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSAPP#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSAPPWF", (Object)pSSysApp.getPSSysAppId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSAppModule)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSAppWFServiceBase)pSCoreSysServiceBase).selectByPSSysApp(pSSysApp);
                object3 = StringHelper.format((String)"PSSYSAPP#%1$s", (Object)pSSysApp.getPSSysAppId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSAppWF)object2.next();
                    object = ((PSAppWFServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSAppModule)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psappwfname")) {
                            string = objectNode.get("psappwfname").asText();
                        }
                        if (objectNode2.has("psappwfname")) {
                            string2 = objectNode2.get("psappwfname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSAppWF();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysApp, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysApp pSSysApp) throws Exception {
        super.onEmptyModelV2(pSSysApp);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysApp pSSysApp, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSAppModule();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysTestPrj();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppLocalDE();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppMenu();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppResource();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppStoryBoard();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppTitleBar();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppDEView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppDynaDEView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppIndexView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPanelView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPortalView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUtilView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppFunc();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppLan();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPDTView();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPFPlugin();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPortlet();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUIStyle();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUITheme();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUserMode();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUtilPage();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSMobAppPack();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSMobAppStartPage();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppLogic();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppPkg();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppUtil();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSAppWF();
        entityBase.set("PSSYSAPPID", pSSysApp.getPSSysAppId());
        pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysApp, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysApp pSSysApp, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSAppModule();
                    ((PSAppModuleBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppModuleBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string4);
                if (((File)object2).exists()) {
                    object = ((File)object2).listFiles();
                    for (Object object3 : object) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppModule();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    object2 = (ObjectNode)arrayNode.get(n2);
                    object = new PSSysTestPrj();
                    ((PSSysTestPrjBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSSysTestPrjBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string5);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSSysTestPrj();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null && (arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase())) == null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"psappdataentities");
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppLocalDE();
                    ((PSAppLocalDEBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppLocalDEBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string6);
                if (!((File)object2).exists()) {
                    string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)"PSAPPDATAENTITIES");
                    object2 = new File(string6);
                }
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppLocalDE();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppMenu();
                    ((PSAppMenuBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppMenuBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    ((PSAppMenuBase)object).setPSSystemId(pSSysApp.getPSSystemId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string7);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppMenu();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        entityBase.setPSSystemId(pSSysApp.getPSSystemId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppResource();
                    ((PSAppResourceBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppResourceBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string8);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppResource();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppStoryBoard();
                    ((PSAppStoryBoardBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppStoryBoardBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string9 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string9);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppStoryBoard();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppTitleBar();
                    ((PSAppTitleBarBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppTitleBarBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string10 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string10);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppTitleBar();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppDEView();
                    ((PSAppViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string11 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string11);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppDEView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppDynaDEView();
                    ((PSAppViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string12 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string12);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppDynaDEView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppIndexView();
                    ((PSAppViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string13 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string13);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppIndexView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppPanelView();
                    ((PSAppViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string14 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string14);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppPanelView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppPortalView();
                    ((PSAppViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string15 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string15);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppPortalView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppUtilView();
                    ((PSAppViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string16 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string16);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppUtilView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppFunc();
                    ((PSAppFuncBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppFuncBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string17 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string17);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppFunc();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppLan();
                    ((PSAppLanBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppLanBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string18 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string18);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppLan();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppPDTView();
                    ((PSAppPDTViewBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppPDTViewBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string19 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string19);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppPDTView();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppPFPlugin();
                    ((PSAppPFPluginBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppPFPluginBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string20 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string20);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppPFPlugin();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppPortlet();
                    ((PSAppPortletBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppPortletBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string21 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string21);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppPortlet();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppUIStyle();
                    ((PSAppUIStyleBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppUIStyleBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string22 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string22);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppUIStyle();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppUITheme();
                    ((PSAppUIThemeBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppUIThemeBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string23 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string23);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppUITheme();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppUserMode();
                    ((PSAppUserModeBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppUserModeBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string24 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string24);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppUserMode();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppUtilPage();
                    ((PSAppUtilPageBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppUtilPageBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string25 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string25);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppUtilPage();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSMobAppPack();
                    ((PSMobAppPackBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSMobAppPackBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string26 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string26);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSMobAppPack();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSMobAppStartPage();
                    ((PSMobAppStartPageBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSMobAppStartPageBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string27 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string27);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSMobAppStartPage();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppLogic();
                    ((PSAppLogicBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppLogicBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string28 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string28);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppLogic();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppPkg();
                    ((PSAppPkgBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppPkgBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string29 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string29);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppPkg();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppUtil();
                    ((PSAppUtilBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppUtilBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string30 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string30);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppUtil();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSSysAppServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object2 = (ObjectNode)arrayNode.get(i);
                    object = new PSAppWF();
                    ((PSAppWFBase)object).setPSSysAppId(pSSysApp.getPSSysAppId());
                    ((PSAppWFBase)object).setPSSysAppName(pSSysApp.getPSSysAppName());
                    pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
                }
            } else {
                String string31 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object2 = new File(string31);
                if (((File)object2).exists()) {
                    for (Object object3 : object = ((File)object2).listFiles()) {
                        if (!((File)object3).isDirectory()) continue;
                        entityBase = new PSAppWF();
                        entityBase.setPSSysAppId(pSSysApp.getPSSysAppId());
                        entityBase.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysApp, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysApp pSSysApp, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppModules(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppLocalDEs(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppMenus(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppResources(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppStoryBoards(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppTitleBars(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppViews(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppFuncs(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppLans(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppPDTViews(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPPFPLUGIN_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppPFPlugins(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppPortlets(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppUIStyles(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppUIThemes(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppUserModes(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppUtilPages(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSMobAppStartPages(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPLOGIC_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppLogics(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppUtils(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSAppWFs(pSSysApp, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysApp, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSAppModules(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPMODULE", true), (boolean)false) == 0) {
            PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
            PSAppModule pSAppModule = new PSAppModule();
            pSAppModule.setPSAppModuleId(pSMOSFile.getPSModelId());
            if (!pSAppModuleService.get((IEntity)pSAppModule, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppModule.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppModuleService.exportModelV2(pSAppModule);
            pSAppModule.reset();
            if (!pSAppModuleService.setModelV2ResScope((IEntity)pSAppModule, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppModuleService.importModelV2(pSAppModule, objectNode);
            SessionFactoryManager.commit();
            return pSAppModuleService.getFile((IEntity)pSAppModule);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppLocalDEs(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPLOCALDE", true), (boolean)false) == 0) {
            PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = new PSAppLocalDE();
            pSAppLocalDE.setPSAppLocalDEId(pSMOSFile.getPSModelId());
            if (!pSAppLocalDEService.get((IEntity)pSAppLocalDE, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppLocalDE.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppLocalDEService.exportModelV2(pSAppLocalDE);
            pSAppLocalDE.reset();
            if (!pSAppLocalDEService.setModelV2ResScope((IEntity)pSAppLocalDE, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppLocalDEService.importModelV2(pSAppLocalDE, objectNode);
            SessionFactoryManager.commit();
            return pSAppLocalDEService.getFile((IEntity)pSAppLocalDE);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppMenus(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPMENU", true), (boolean)false) == 0) {
            PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = new PSAppMenu();
            pSAppMenu.setPSAppMenuId(pSMOSFile.getPSModelId());
            if (!pSAppMenuService.get((IEntity)pSAppMenu, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppMenu.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppMenuService.exportModelV2(pSAppMenu);
            pSAppMenu.reset();
            if (!pSAppMenuService.setModelV2ResScope((IEntity)pSAppMenu, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppMenuService.importModelV2(pSAppMenu, objectNode);
            SessionFactoryManager.commit();
            return pSAppMenuService.getFile((IEntity)pSAppMenu);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppResources(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPRESOURCE", true), (boolean)false) == 0) {
            PSAppResourceService pSAppResourceService = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
            PSAppResource pSAppResource = new PSAppResource();
            pSAppResource.setPSAppResourceId(pSMOSFile.getPSModelId());
            if (!pSAppResourceService.get((IEntity)pSAppResource, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppResource.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppResourceService.exportModelV2(pSAppResource);
            pSAppResource.reset();
            if (!pSAppResourceService.setModelV2ResScope((IEntity)pSAppResource, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppResourceService.importModelV2(pSAppResource, objectNode);
            SessionFactoryManager.commit();
            return pSAppResourceService.getFile((IEntity)pSAppResource);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppStoryBoards(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPSTORYBOARD", true), (boolean)false) == 0) {
            PSAppStoryBoardService pSAppStoryBoardService = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
            PSAppStoryBoard pSAppStoryBoard = new PSAppStoryBoard();
            pSAppStoryBoard.setPSAppStoryBoardId(pSMOSFile.getPSModelId());
            if (!pSAppStoryBoardService.get((IEntity)pSAppStoryBoard, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppStoryBoard.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppStoryBoardService.exportModelV2(pSAppStoryBoard);
            pSAppStoryBoard.reset();
            if (!pSAppStoryBoardService.setModelV2ResScope((IEntity)pSAppStoryBoard, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppStoryBoardService.importModelV2(pSAppStoryBoard, objectNode);
            SessionFactoryManager.commit();
            return pSAppStoryBoardService.getFile((IEntity)pSAppStoryBoard);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppTitleBars(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPTITLEBAR", true), (boolean)false) == 0) {
            PSAppTitleBarService pSAppTitleBarService = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
            PSAppTitleBar pSAppTitleBar = new PSAppTitleBar();
            pSAppTitleBar.setPSAppTitleBarId(pSMOSFile.getPSModelId());
            if (!pSAppTitleBarService.get((IEntity)pSAppTitleBar, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppTitleBar.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppTitleBarService.exportModelV2(pSAppTitleBar);
            pSAppTitleBar.reset();
            if (!pSAppTitleBarService.setModelV2ResScope((IEntity)pSAppTitleBar, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppTitleBarService.importModelV2(pSAppTitleBar, objectNode);
            SessionFactoryManager.commit();
            return pSAppTitleBarService.getFile((IEntity)pSAppTitleBar);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppViews(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPVIEW", true), (boolean)false) == 0) {
            PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = new PSAppView();
            pSAppView.setPSAppViewId(pSMOSFile.getPSModelId());
            if (!pSAppViewService.get((IEntity)pSAppView, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppView.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppViewService.exportModelV2(pSAppView);
            pSAppView.reset();
            if (!pSAppViewService.setModelV2ResScope((IEntity)pSAppView, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppViewService.importModelV2(pSAppView, objectNode);
            SessionFactoryManager.commit();
            return pSAppViewService.getFile((IEntity)pSAppView);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppFuncs(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPFUNC", true), (boolean)false) == 0) {
            PSAppFuncService pSAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
            PSAppFunc pSAppFunc = new PSAppFunc();
            pSAppFunc.setPSAppFuncId(pSMOSFile.getPSModelId());
            if (!pSAppFuncService.get((IEntity)pSAppFunc, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppFunc.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppFuncService.exportModelV2(pSAppFunc);
            pSAppFunc.reset();
            if (!pSAppFuncService.setModelV2ResScope((IEntity)pSAppFunc, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppFuncService.importModelV2(pSAppFunc, objectNode);
            SessionFactoryManager.commit();
            return pSAppFuncService.getFile((IEntity)pSAppFunc);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppLans(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPLAN", true), (boolean)false) == 0) {
            PSAppLanService pSAppLanService = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
            PSAppLan pSAppLan = new PSAppLan();
            pSAppLan.setPSAppLanId(pSMOSFile.getPSModelId());
            if (!pSAppLanService.get((IEntity)pSAppLan, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppLan.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppLanService.exportModelV2(pSAppLan);
            pSAppLan.reset();
            if (!pSAppLanService.setModelV2ResScope((IEntity)pSAppLan, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppLanService.importModelV2(pSAppLan, objectNode);
            SessionFactoryManager.commit();
            return pSAppLanService.getFile((IEntity)pSAppLan);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppPDTViews(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPPDTVIEW", true), (boolean)false) == 0) {
            PSAppPDTViewService pSAppPDTViewService = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPDTView pSAppPDTView = new PSAppPDTView();
            pSAppPDTView.setPSAppPDTViewId(pSMOSFile.getPSModelId());
            if (!pSAppPDTViewService.get((IEntity)pSAppPDTView, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppPDTView.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppPDTViewService.exportModelV2(pSAppPDTView);
            pSAppPDTView.reset();
            if (!pSAppPDTViewService.setModelV2ResScope((IEntity)pSAppPDTView, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppPDTViewService.importModelV2(pSAppPDTView, objectNode);
            SessionFactoryManager.commit();
            return pSAppPDTViewService.getFile((IEntity)pSAppPDTView);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppPFPlugins(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPPFPLUGIN", true), (boolean)false) == 0) {
            PSAppPFPluginService pSAppPFPluginService = (PSAppPFPluginService)ServiceGlobal.getService(PSAppPFPluginService.class, (SessionFactory)this.getSessionFactory());
            PSAppPFPlugin pSAppPFPlugin = new PSAppPFPlugin();
            pSAppPFPlugin.setPSAppPFPluginId(pSMOSFile.getPSModelId());
            if (!pSAppPFPluginService.get((IEntity)pSAppPFPlugin, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppPFPlugin.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppPFPluginService.exportModelV2(pSAppPFPlugin);
            pSAppPFPlugin.reset();
            if (!pSAppPFPluginService.setModelV2ResScope((IEntity)pSAppPFPlugin, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppPFPluginService.importModelV2(pSAppPFPlugin, objectNode);
            SessionFactoryManager.commit();
            return pSAppPFPluginService.getFile((IEntity)pSAppPFPlugin);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppPortlets(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPPORTLET", true), (boolean)false) == 0) {
            PSAppPortletService pSAppPortletService = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
            PSAppPortlet pSAppPortlet = new PSAppPortlet();
            pSAppPortlet.setPSAppPortletId(pSMOSFile.getPSModelId());
            if (!pSAppPortletService.get((IEntity)pSAppPortlet, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppPortlet.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppPortletService.exportModelV2(pSAppPortlet);
            pSAppPortlet.reset();
            if (!pSAppPortletService.setModelV2ResScope((IEntity)pSAppPortlet, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppPortletService.importModelV2(pSAppPortlet, objectNode);
            SessionFactoryManager.commit();
            return pSAppPortletService.getFile((IEntity)pSAppPortlet);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSPORTLET", true), (boolean)false) == 0) {
            PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
            PSSysPortlet pSSysPortlet = new PSSysPortlet();
            pSSysPortlet.setPSSysPortletId(pSMOSFile.getPSModelId());
            if (!pSSysPortletService.get((IEntity)pSSysPortlet, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSAppPortletService pSAppPortletService = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
            PSAppPortlet pSAppPortlet = new PSAppPortlet();
            pSAppPortlet.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSAppPortlet.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
            this.fillPasteEntity((IEntity)pSAppPortlet, "PASTETAG");
            pSAppPortletService.create(pSAppPortlet);
            SessionFactoryManager.commit();
            return pSAppPortletService.getFile((IEntity)pSAppPortlet);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppUIStyles(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPUISTYLE", true), (boolean)false) == 0) {
            PSAppUIStyleService pSAppUIStyleService = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
            PSAppUIStyle pSAppUIStyle = new PSAppUIStyle();
            pSAppUIStyle.setPSAppUIStyleId(pSMOSFile.getPSModelId());
            if (!pSAppUIStyleService.get((IEntity)pSAppUIStyle, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppUIStyle.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppUIStyleService.exportModelV2(pSAppUIStyle);
            pSAppUIStyle.reset();
            if (!pSAppUIStyleService.setModelV2ResScope((IEntity)pSAppUIStyle, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppUIStyleService.importModelV2(pSAppUIStyle, objectNode);
            SessionFactoryManager.commit();
            return pSAppUIStyleService.getFile((IEntity)pSAppUIStyle);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppUIThemes(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPUITHEME", true), (boolean)false) == 0) {
            PSAppUIThemeService pSAppUIThemeService = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
            PSAppUITheme pSAppUITheme = new PSAppUITheme();
            pSAppUITheme.setPSAppUIThemeId(pSMOSFile.getPSModelId());
            if (!pSAppUIThemeService.get((IEntity)pSAppUITheme, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppUITheme.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppUIThemeService.exportModelV2(pSAppUITheme);
            pSAppUITheme.reset();
            if (!pSAppUIThemeService.setModelV2ResScope((IEntity)pSAppUITheme, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppUIThemeService.importModelV2(pSAppUITheme, objectNode);
            SessionFactoryManager.commit();
            return pSAppUIThemeService.getFile((IEntity)pSAppUITheme);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppUserModes(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPUSERMODE", true), (boolean)false) == 0) {
            PSAppUserModeService pSAppUserModeService = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
            PSAppUserMode pSAppUserMode = new PSAppUserMode();
            pSAppUserMode.setPSAppUserModeId(pSMOSFile.getPSModelId());
            if (!pSAppUserModeService.get((IEntity)pSAppUserMode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppUserMode.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppUserModeService.exportModelV2(pSAppUserMode);
            pSAppUserMode.reset();
            if (!pSAppUserModeService.setModelV2ResScope((IEntity)pSAppUserMode, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppUserModeService.importModelV2(pSAppUserMode, objectNode);
            SessionFactoryManager.commit();
            return pSAppUserModeService.getFile((IEntity)pSAppUserMode);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSUSERMODE", true), (boolean)false) == 0) {
            PSSysUserModeService pSSysUserModeService = (PSSysUserModeService)ServiceGlobal.getService(PSSysUserModeService.class, (SessionFactory)this.getSessionFactory());
            PSSysUserMode pSSysUserMode = new PSSysUserMode();
            pSSysUserMode.setPSSysUserModeId(pSMOSFile.getPSModelId());
            if (!pSSysUserModeService.get((IEntity)pSSysUserMode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSAppUserModeService pSAppUserModeService = (PSAppUserModeService)ServiceGlobal.getService(PSAppUserModeService.class, (SessionFactory)this.getSessionFactory());
            PSAppUserMode pSAppUserMode = new PSAppUserMode();
            pSAppUserMode.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSAppUserMode.setPSSysUserModeId(pSSysUserMode.getPSSysUserModeId());
            this.fillPasteEntity((IEntity)pSAppUserMode, "PASTETAG");
            pSAppUserModeService.create(pSAppUserMode);
            SessionFactoryManager.commit();
            return pSAppUserModeService.getFile((IEntity)pSAppUserMode);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppUtilPages(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPUTILPAGE", true), (boolean)false) == 0) {
            PSAppUtilPageService pSAppUtilPageService = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
            PSAppUtilPage pSAppUtilPage = new PSAppUtilPage();
            pSAppUtilPage.setPSAppUtilPageId(pSMOSFile.getPSModelId());
            if (!pSAppUtilPageService.get((IEntity)pSAppUtilPage, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppUtilPage.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppUtilPageService.exportModelV2(pSAppUtilPage);
            pSAppUtilPage.reset();
            if (!pSAppUtilPageService.setModelV2ResScope((IEntity)pSAppUtilPage, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppUtilPageService.importModelV2(pSAppUtilPage, objectNode);
            SessionFactoryManager.commit();
            return pSAppUtilPageService.getFile((IEntity)pSAppUtilPage);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSMobAppStartPages(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSMOBAPPSTARTPAGE", true), (boolean)false) == 0) {
            PSMobAppStartPageService pSMobAppStartPageService = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
            PSMobAppStartPage pSMobAppStartPage = new PSMobAppStartPage();
            pSMobAppStartPage.setPSMobAppStartPageId(pSMOSFile.getPSModelId());
            if (!pSMobAppStartPageService.get((IEntity)pSMobAppStartPage, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSMobAppStartPage.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSMobAppStartPageService.exportModelV2(pSMobAppStartPage);
            pSMobAppStartPage.reset();
            if (!pSMobAppStartPageService.setModelV2ResScope((IEntity)pSMobAppStartPage, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSMobAppStartPageService.importModelV2(pSMobAppStartPage, objectNode);
            SessionFactoryManager.commit();
            return pSMobAppStartPageService.getFile((IEntity)pSMobAppStartPage);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppLogics(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPLOGIC", true), (boolean)false) == 0) {
            PSAppLogicService pSAppLogicService = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
            PSAppLogic pSAppLogic = new PSAppLogic();
            pSAppLogic.setPSAppLogicId(pSMOSFile.getPSModelId());
            if (!pSAppLogicService.get((IEntity)pSAppLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppLogic.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppLogicService.exportModelV2(pSAppLogic);
            pSAppLogic.reset();
            if (!pSAppLogicService.setModelV2ResScope((IEntity)pSAppLogic, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppLogicService.importModelV2(pSAppLogic, objectNode);
            SessionFactoryManager.commit();
            return pSAppLogicService.getFile((IEntity)pSAppLogic);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppUtils(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPUTIL", true), (boolean)false) == 0) {
            PSAppUtilService pSAppUtilService = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
            PSAppUtil pSAppUtil = new PSAppUtil();
            pSAppUtil.setPSAppUtilId(pSMOSFile.getPSModelId());
            if (!pSAppUtilService.get((IEntity)pSAppUtil, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppUtil.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppUtilService.exportModelV2(pSAppUtil);
            pSAppUtil.reset();
            if (!pSAppUtilService.setModelV2ResScope((IEntity)pSAppUtil, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppUtilService.importModelV2(pSAppUtil, objectNode);
            SessionFactoryManager.commit();
            return pSAppUtilService.getFile((IEntity)pSAppUtil);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSAppWFs(PSSysApp pSSysApp, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSAPPWF", true), (boolean)false) == 0) {
            PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            PSAppWF pSAppWF = new PSAppWF();
            pSAppWF.setPSAppWFId(pSMOSFile.getPSModelId());
            if (!pSAppWFService.get((IEntity)pSAppWF, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSAppWF.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSAppWFService.exportModelV2(pSAppWF);
            pSAppWF.reset();
            if (!pSAppWFService.setModelV2ResScope((IEntity)pSAppWF, "PSSYSAPP", pSSysApp.getPSSysAppId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSAppWFService.importModelV2(pSAppWF, objectNode);
            SessionFactoryManager.commit();
            return pSAppWFService.getFile((IEntity)pSAppWF);
        }
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWORKFLOW", true), (boolean)false) == 0) {
            PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = new PSWorkflow();
            pSWorkflow.setPSWorkflowId(pSMOSFile.getPSModelId());
            if (!pSWorkflowService.get((IEntity)pSWorkflow, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            PSAppWFService pSAppWFService = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            PSAppWF pSAppWF = new PSAppWF();
            pSAppWF.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSAppWF.setPSWorkflowId(pSWorkflow.getPSWorkflowId());
            this.fillPasteEntity((IEntity)pSAppWF, "PASTETAG");
            pSAppWFService.create(pSAppWF);
            SessionFactoryManager.commit();
            return pSAppWFService.getFile((IEntity)pSAppWF);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSAppModules(pSSysApp, list);
        this.onFillPasteHelps_PSAppLocalDEs(pSSysApp, list);
        this.onFillPasteHelps_PSAppMenus(pSSysApp, list);
        this.onFillPasteHelps_PSAppResources(pSSysApp, list);
        this.onFillPasteHelps_PSAppStoryBoards(pSSysApp, list);
        this.onFillPasteHelps_PSAppTitleBars(pSSysApp, list);
        this.onFillPasteHelps_PSAppViews(pSSysApp, list);
        this.onFillPasteHelps_PSAppFuncs(pSSysApp, list);
        this.onFillPasteHelps_PSAppLans(pSSysApp, list);
        this.onFillPasteHelps_PSAppPDTViews(pSSysApp, list);
        this.onFillPasteHelps_PSAppPFPlugins(pSSysApp, list);
        this.onFillPasteHelps_PSAppPortlets(pSSysApp, list);
        this.onFillPasteHelps_PSAppUIStyles(pSSysApp, list);
        this.onFillPasteHelps_PSAppUIThemes(pSSysApp, list);
        this.onFillPasteHelps_PSAppUserModes(pSSysApp, list);
        this.onFillPasteHelps_PSAppUtilPages(pSSysApp, list);
        this.onFillPasteHelps_PSMobAppStartPages(pSSysApp, list);
        this.onFillPasteHelps_PSAppLogics(pSSysApp, list);
        this.onFillPasteHelps_PSAppUtils(pSSysApp, list);
        this.onFillPasteHelps_PSAppWFs(pSSysApp, list);
        super.onFillPasteHelps(pSSysApp, list);
    }

    protected void onFillPasteHelps_PSAppModules(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPMODULE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u6a21\u5757]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppLocalDEs(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPLOCALDE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u5b9e\u4f53]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppMenus(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPMENU");
        pSHelpSection.setSectionParam2("DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u83dc\u5355]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppResources(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPRESOURCE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u8d44\u6e90]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppStoryBoards(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPSTORYBOARD");
        pSHelpSection.setSectionParam2("DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u6545\u4e8b\u677f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppTitleBars(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPTITLEBAR");
        pSHelpSection.setSectionParam2("DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u6807\u9898\u680f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppViews(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPVIEW");
        pSHelpSection.setSectionParam2("DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u89c6\u56fe]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppFuncs(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPFUNC");
        pSHelpSection.setSectionParam2("DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u529f\u80fd]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppLans(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPLAN");
        pSHelpSection.setSectionParam2("DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u591a\u8bed\u8a00]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppPDTViews(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPPDTVIEW");
        pSHelpSection.setSectionParam2("DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u9884\u7f6e\u89c6\u56fe]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppPFPlugins(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPPFPLUGIN");
        pSHelpSection.setSectionParam2("DER1N_PSAPPPFPLUGIN_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u524d\u7aef\u63d2\u4ef6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppPortlets(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPPORTLET");
        pSHelpSection.setSectionParam2("DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u95e8\u6237\u90e8\u4ef6]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPPORTLET");
        pSHelpSection.setSectionParam2("DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setUserTag("DER1N_PSAPPPORTLET_PSSYSPORTLET_PSSYSPORTLETID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u7684[\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6]\u6784\u5efa[\u5e94\u7528\u95e8\u6237\u90e8\u4ef6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppUIStyles(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPUISTYLE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u754c\u9762\u6a21\u5f0f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppUIThemes(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPUITHEME");
        pSHelpSection.setSectionParam2("DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u754c\u9762\u4e3b\u9898]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppUserModes(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPUSERMODE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u7528\u6237\u6a21\u5f0f]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPUSERMODE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPUSERMODE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setUserTag("DER1N_PSAPPUSERMODE_PSSYSUSERMODE_PSSYSUSERMODEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u7528\u6237\u6a21\u5f0f\u7684[\u7cfb\u7edf\u7528\u6237\u6a21\u5f0f]\u6784\u5efa[\u5e94\u7528\u7528\u6237\u6a21\u5f0f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppUtilPages(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPUTILPAGE");
        pSHelpSection.setSectionParam2("DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u529f\u80fd\u9875\u9762]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSMobAppStartPages(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSMOBAPPSTARTPAGE");
        pSHelpSection.setSectionParam2("DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u79fb\u52a8\u5e94\u7528\u8d44\u6e90]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppLogics(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSAPPLOGIC_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppUtils(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPUTIL");
        pSHelpSection.setSectionParam2("DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u529f\u80fd\u7ec4\u4ef6]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSAppWFs(PSSysApp pSSysApp, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPWF");
        pSHelpSection.setSectionParam2("DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u7a0b\u5e8f]\u7684[\u5e94\u7528\u5de5\u4f5c\u6d41]");
        list.add(pSHelpSection);
        pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSAPPWF");
        pSHelpSection.setSectionParam2("DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID");
        pSHelpSection.setUserTag("DER1N_PSAPPWF_PSWORKFLOW_PSWORKFLOWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5f53\u524d\u7cfb\u7edf\u5de5\u4f5c\u6d41\u7684[\u7cfb\u7edf\u5de5\u4f5c\u6d41]\u6784\u5efa[\u5e94\u7528\u5de5\u4f5c\u6d41]");
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
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u6a21\u5757>", "DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u6a21\u5757>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappmodules");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPMODULE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u89c6\u56fe>", "DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u89c6\u56fe>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappviews");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPVIEW");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u529f\u80fd>", "DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u529f\u80fd>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappfuncs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPFUNC");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u5b9e\u4f53>", "DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u5b9e\u4f53>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapplocaldes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPLOCALDE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u5e94\u7528\u5de5\u4f5c\u6d41>", "DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u5de5\u4f5c\u6d41>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappwfs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPWF");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && iPSMOSFileFilter == null && StringHelper.isNullOrEmpty((String)string)) {
            pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileName("[\u5f00\u53d1]");
            pSMOSFile2.setFileTag("GROUP");
            pSMOSFile2.setFileTag2("");
            pSMOSFile2.setFileTag3("");
            pSMOSFile2.setFileTag4("");
            pSMOSFile2.setMemo("");
            hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u5e94\u7528\u83dc\u5355>", "DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5e94\u7528\u83dc\u5355>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappmenus");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPMENU");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u529f\u80fd\u89c6\u56fe>", "DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u529f\u80fd\u89c6\u56fe>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapputilpages");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPUTILPAGE");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u9884\u7f6e\u89c6\u56fe>", "DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u9884\u7f6e\u89c6\u56fe>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapppdtviews");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPPDTVIEW");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u8d44\u6e90>", "DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u8d44\u6e90>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappresources");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPRESOURCE");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u770b\u677f\u90e8\u4ef6>", "DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u770b\u677f\u90e8\u4ef6>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappportlets");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPPORTLET");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u6545\u4e8b\u677f>", "DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6545\u4e8b\u677f>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappstoryboards");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPSTORYBOARD");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u754c\u9762\u4e3b\u9898>", "DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u754c\u9762\u4e3b\u9898>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappuithemes");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPUITHEME");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u591a\u8bed\u8a00>", "DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u591a\u8bed\u8a00>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapplans");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPLAN");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u79fb\u52a8\u7aef\u8d44\u6e90>", "DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u79fb\u52a8\u7aef\u8d44\u6e90>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psmobappstartpages");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSMOBAPPSTARTPAGE");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u754c\u9762\u5de5\u5177\u7bb1]", "<\u754c\u9762\u6a21\u5f0f>", "DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u754c\u9762\u6a21\u5f0f>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psappuistyles");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPUISTYLE");
            pSMOSFile2.setFileTag4("[\u754c\u9762\u5de5\u5177\u7bb1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u529f\u80fd\u914d\u7f6e>", "DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u529f\u80fd\u914d\u7f6e>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapputils");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPUTIL");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u7ec4\u4ef6\u5305>", "DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u7ec4\u4ef6\u5305>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psapppkgs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSAPPPKG");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u5f00\u53d1\u4efb\u52a1>", "DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u5f00\u53d1\u4efb\u52a1>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystasks");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSSYSTASK");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, "[\u5f00\u53d1]", "<\u6d4b\u8bd5\u9879\u76ee>", "DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
            pSMOSFile2 = new PSMOSFile();
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u6d4b\u8bd5\u9879\u76ee>");
            } else if (PSSysAppServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("pssystestprjs");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID|PSSYSAPPID");
            pSMOSFile2.setFileTag3("PSSYSTESTPRJ");
            pSMOSFile2.setFileTag4("[\u5f00\u53d1]");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "")) {
                pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
                selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
                selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSSysAppServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
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
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u6a21\u5757>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppModules", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u89c6\u56fe>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppViews", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u529f\u80fd>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppFuncs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u83dc\u5355>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppMenus", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u529f\u80fd\u89c6\u56fe>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppUtilPages", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u9884\u7f6e\u89c6\u56fe>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppPDTViews", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppPDTViewService)ServiceGlobal.getService(PSAppPDTViewService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u8d44\u6e90>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppResources", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppResourceService)ServiceGlobal.getService(PSAppResourceService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u770b\u677f\u90e8\u4ef6>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppPortlets", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppPortletService)ServiceGlobal.getService(PSAppPortletService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u6545\u4e8b\u677f>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppStoryBoards", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppStoryBoardService)ServiceGlobal.getService(PSAppStoryBoardService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u754c\u9762\u4e3b\u9898>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppUIThemes", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppUIThemeService)ServiceGlobal.getService(PSAppUIThemeService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u591a\u8bed\u8a00>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppLans", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u5b9e\u4f53>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppLocalDEs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u79fb\u52a8\u7aef\u8d44\u6e90>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSMobAppStartPages", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSMobAppStartPageService)ServiceGlobal.getService(PSMobAppStartPageService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u754c\u9762\u5de5\u5177\u7bb1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u754c\u9762\u6a21\u5f0f>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppUIStyles", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u5e94\u7528\u5de5\u4f5c\u6d41>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppWFs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppWFService)ServiceGlobal.getService(PSAppWFService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u529f\u80fd\u914d\u7f6e>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSAppUtils", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppUtilService)ServiceGlobal.getService(PSAppUtilService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u7ec4\u4ef6\u5305>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"psapppkgs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSAppPkgService)ServiceGlobal.getService(PSAppPkgService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u5f00\u53d1\u4efb\u52a1>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSSysTasks", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
            arrayList = pSCoreSysServiceBase.selectEx((ISelectContext)selectContext);
            for (EntityBase entityBase : arrayList) {
                pSMOSFile2 = pSCoreSysServiceBase.getFile(pSMOSFile, (IEntity)entityBase, bl);
                if (pSMOSFile2 == null) continue;
                arrayList2.add(pSMOSFile2);
            }
        }
        if (PSSysAppServiceBase.getMOSVer() == 1 && StringHelper.compare((String)string, (String)"[\u5f00\u53d1]", (boolean)false) == 0 && StringHelper.compare((String)string2, (String)"<\u6d4b\u8bd5\u9879\u76ee>", (boolean)false) == 0 || PSSysAppServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"pssystestprjs", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSSysTestPrjService)ServiceGlobal.getService(PSSysTestPrjService.class, (SessionFactory)this.getSessionFactory());
            selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSCoreSysServiceBase, "DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID", "PSSYSAPPID", pSMOSFile.getPSModelId(), "", "");
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
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPMODULE_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u6a21\u5757>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappmodules";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPVIEW_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u89c6\u56fe>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappviews";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPFUNC_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u529f\u80fd>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappfuncs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPMENU_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u5e94\u7528\u83dc\u5355>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappmenus";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPUTILPAGE_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u529f\u80fd\u89c6\u56fe>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psapputilpages";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPPDTVIEW_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u9884\u7f6e\u89c6\u56fe>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psapppdtviews";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPRESOURCE_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u8d44\u6e90>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappresources";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u770b\u677f\u90e8\u4ef6>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappportlets";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPSTORYBOARD_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u6545\u4e8b\u677f>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappstoryboards";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPUITHEME_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u754c\u9762\u4e3b\u9898>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappuithemes";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPLAN_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u591a\u8bed\u8a00>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psapplans";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPLOCALDE_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u5b9e\u4f53>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psapplocaldes";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSMOBAPPSTARTPAGE_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u79fb\u52a8\u7aef\u8d44\u6e90>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psmobappstartpages";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPUISTYLE_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u754c\u9762\u5de5\u5177\u7bb1]/<\u754c\u9762\u6a21\u5f0f>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappuistyles";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPWF_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "<\u5e94\u7528\u5de5\u4f5c\u6d41>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psappwfs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPUTIL_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u529f\u80fd\u914d\u7f6e>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psapputils";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSAPPPKG_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u7ec4\u4ef6\u5305>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "psapppkgs";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTASK_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u5f00\u53d1\u4efb\u52a1>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "pssystasks";
            }
        }
        if (StringHelper.compare((String)string, (String)"DER1N_PSSYSTESTPRJ_PSSYSAPP_PSSYSAPPID", (boolean)false) == 0) {
            if (PSSysAppServiceBase.getMOSVer() == 1) {
                return "[\u5f00\u53d1]/<\u6d4b\u8bd5\u9879\u76ee>";
            }
            if (PSSysAppServiceBase.getMOSVer() == 2) {
                return "pssystestprjs";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    public Object getDataType(PSSysApp pSSysApp) throws Exception {
        return pSSysApp.getPSAppTypeId();
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysApp pSSysApp, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("APPPKGNAME", "App");
        defaultValueMap.put("PSSYSAPPNAME", "\u5e94\u7528");
    }
}

