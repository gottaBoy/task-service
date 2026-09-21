/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IView
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppViewService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLoadLog
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLog
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLoadLogService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLogService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.util.StringUtils
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.AppMenu.PSAppMenuModelGlobalModel;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.BI.PSAppBISchemeImpl;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.CodeList.PSAppCodeListImpl;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppEditorTempl;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.Control.IPSControlContainerView;
import SA.SRFDA.PS.Core.App.Control.PSAppCounterImpl;
import SA.SRFDA.PS.Core.App.Control.PSAppEditorTemplGlobalModel;
import SA.SRFDA.PS.Core.App.Control.PSAppPortletCatImpl;
import SA.SRFDA.PS.Core.App.Control.PSAppPortletContainerViewImpl;
import SA.SRFDA.PS.Core.App.Control.PSAppPortletGlobalModel;
import SA.SRFDA.PS.Core.App.Control.PSAppPortletImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDERSImpl;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDERSImpl2;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDERSImpl3;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModel;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.Func.PSAppFuncGlobalModel;
import SA.SRFDA.PS.Core.App.Func.PSAppFuncImpl;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSAppLogic;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.IPSAppPkg;
import SA.SRFDA.PS.Core.App.IPSAppResource;
import SA.SRFDA.PS.Core.App.IPSAppUIStyle;
import SA.SRFDA.PS.Core.App.IPSAppUtilPage;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationLogic;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.IPSApplicationUI;
import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.PSAppUILogicGlobalModel;
import SA.SRFDA.PS.Core.App.Mob.IPSAppLocalDE;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppIcon;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackCert;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppStartPage;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppIconGlobalModel;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppPackCertGlobalModel;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppPackGlobalModel;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppStartPageGlobalModel;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.Msg.PSAppMsgTemplImpl;
import SA.SRFDA.PS.Core.App.PSAppLanGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppLogicGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppMethodDTOImpl;
import SA.SRFDA.PS.Core.App.PSAppModuleGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppPDTViewGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppPkgGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppResourceGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppUIStyleGlobalModel;
import SA.SRFDA.PS.Core.App.PSAppUIStyleImpl;
import SA.SRFDA.PS.Core.App.PSAppUtilPageGlobalModel;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationLogicImpl;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.PSApplicationUIProxy;
import SA.SRFDA.PS.Core.App.PSSubAppRefGlobalModel;
import SA.SRFDA.PS.Core.App.PSSysAppDEUIActionGlobalModel;
import SA.SRFDA.PS.Core.App.PSSysAppDEUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.App.PSSysAppDEUILogicGroupGlobalModel;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
import SA.SRFDA.PS.Core.App.Pub.PSAppViewCodeGlobalModel;
import SA.SRFDA.PS.Core.App.Res.IPSAppDEFInputTipSet;
import SA.SRFDA.PS.Core.App.Res.IPSAppEditorStyleRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppSubViewTypeRef;
import SA.SRFDA.PS.Core.App.Res.PSAppDEFInputTipSetImpl;
import SA.SRFDA.PS.Core.App.Res.PSAppEditorStyleRefImpl;
import SA.SRFDA.PS.Core.App.Res.PSAppPFPluginRefImpl;
import SA.SRFDA.PS.Core.App.Res.PSAppSubViewTypeRefImpl;
import SA.SRFDA.PS.Core.App.Theme.IPSAppUITheme;
import SA.SRFDA.PS.Core.App.Theme.PSAppUIThemeGlobalModel;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.App.UserMode.PSAppUserModeGlobalModel;
import SA.SRFDA.PS.Core.App.Util.IPSAppDynaDashboardUtil;
import SA.SRFDA.PS.Core.App.Util.IPSAppFilterStorageUtil;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.App.Util.PSAppUtilGlobalModel;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.ValueRule.PSAppValueRuleImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppPortalView;
import SA.SRFDA.PS.Core.App.View.IPSAppRedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppUtilView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppViewStyle;
import SA.SRFDA.PS.Core.App.View.PSAppDEDataSetViewMsgImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewGlobalModel;
import SA.SRFDA.PS.Core.App.View.PSAppViewMsgGroupImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewMsgImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewStyleGlobalModel;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.App.WF.PSAppWFGlobalModel;
import SA.SRFDA.PS.Core.App.WF.PSAppWFVerGlobalModel;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBContainerPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.ViewPanel.PSDEViewPanelImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.Log.IPSLogItem;
import SA.SRFDA.PS.Core.Log.PSLogItemImpl;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVerCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFPkgVerProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPFPubSupportable;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSPFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.View.IPSDEDataSetViewMsg;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSAppPFPlugin;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import SA.SRFDA.PS.Data.PSSystemApplication;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLoadLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLog;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLoadLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLogService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.util.StringUtils;

public class PSApplicationImpl
extends PSSystemObjectImpl
implements IPSApplication,
IPSApplicationRuntime,
IPSApplicationUI,
IPSPFPubSupportable,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSApplicationImpl.class);
    public static final String MODELGROUP_MODEL = "\u6a21\u578b&\u63a5\u53e3";
    public static final String MODELGROUP_UI = "\u5e94\u7528\u89c6\u56fe";
    public static final String MODELGROUP_LOGIC = "\u5e94\u7528\u903b\u8f91";
    public static final String MODELGROUP_UILOGIC = "\u754c\u9762\u903b\u8f91";
    public static final String MODELGROUP_MOB = "\u79fb\u52a8\u7aef";
    public static final String MODELGROUP_WF = "\u5de5\u4f5c\u6d41";
    public static final String MODELGROUP_ADVUTIL = "\u9ad8\u7ea7\u7ec4\u4ef6";
    public static final String MODELGROUP_MSG = "\u6d88\u606f";
    public static final String MODELGROUP_ACCCTRL = "\u8bbf\u95ee\u63a7\u5236";
    public static final String MODELGROUP_TEST = "\u6d4b\u8bd5";
    public static final String MODELGROUP_ADVMODEL = "\u6a21\u578b\u9ad8\u7ea7";
    public static final String MODELGROUP_PFSF = "\u6a21\u677f\u6269\u5c55";
    public static final String[] MODELGROUPS = new String[]{"\u57fa\u672c", "\u6a21\u578b&\u63a5\u53e3", "\u5e94\u7528\u89c6\u56fe", "\u5e94\u7528\u903b\u8f91", "\u754c\u9762\u903b\u8f91", "\u79fb\u52a8\u7aef", "\u5de5\u4f5c\u6d41", "\u9ad8\u7ea7\u7ec4\u4ef6", "\u6d88\u606f", "\u8bbf\u95ee\u63a7\u5236", "\u6d4b\u8bd5", "\u6a21\u578b\u9ad8\u7ea7", "\u6a21\u677f\u6269\u5c55", "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    public static final int MODELORDER_MODEL = 150;
    public static final int MODELORDER_UI = 180;
    public static final int MODELORDER_LOGIC = 210;
    public static final int MODELORDER_UILOGIC = 310;
    public static final int MODELORDER_MOB = 360;
    public static final int MODELORDER_WF = 410;
    public static final int MODELORDER_ADVUTIL = 440;
    public static final int MODELORDER_MSG = 470;
    public static final int MODELORDER_ACCCTRL = 500;
    public static final int MODELORDER_TEST = 530;
    public static final int MODELORDER_ADVMODEL = 560;
    public static final int MODELORDER_PFSF = 590;
    public static final String PFSTYLEPARAM_DEFAULTCONTROLSTYLE = "DEFAULTCONTROLSTYLE";
    public static final String PFSTYLEPARAM_DEFAULTAPPVIEWCSS = "DEFAULTAPPVIEWCSS";
    public static final String PFSTYLEPARAM_DEFAULTAPPVIEWPRIORITY = "DEFAULTAPPVIEWPRIORITY";
    public static final String PFSTYLEPARAM_ENABLEUIMODELEX = "ENABLEUIMODELEX";
    public static final String PFSTYLEPARAM_DEFAULTOSSCAT = "DEFAULTOSSCAT";
    public static final String PFSTYLEPARAM_CODENAMEMODE = "CODENAMEMODE";
    public static final String PFSTYLEPARAM_ENABLEBISCHEME = "ENABLEBISCHEME";
    public static final String PFSTYLEPARAM_SUBAPPACCESSKEY = "SUBAPPACCESSKEY";
    public static final String DYNAPARAM_SRFLOADDEUAGROUPS = "SRFLOADDEUAGROUPS";
    public static final String DYNAPARAM_SRFDEFAULTSERVICEURL = "SRFDEFAULTSERVICEURL";
    private static final Map<String, String> GlobaDEUIActionMap = new HashMap<String, String>();
    protected PSSystemApplication psSystemApplication = null;
    protected PSAppViewGlobalModel psApplicationViewGlobalModel = new PSAppViewGlobalModel();
    protected PSAppModuleGlobalModel psAppModuleGlobalModel = new PSAppModuleGlobalModel();
    protected PSAppFuncGlobalModel psAppFuncGlobalModel = new PSAppFuncGlobalModel();
    protected PSAppUserModeGlobalModel psAppUserModeGlobalModel = new PSAppUserModeGlobalModel();
    protected PSAppMenuModelGlobalModel psAppMenuModelGlobalModel = new PSAppMenuModelGlobalModel();
    protected PSAppViewStyleGlobalModel psAppViewStyleGlobalModel = new PSAppViewStyleGlobalModel();
    protected PSAppEditorTemplGlobalModel psAppEditorTemplGlobalModel = new PSAppEditorTemplGlobalModel();
    protected PSAppViewCodeGlobalModel psAppViewCodeGlobalModel = new PSAppViewCodeGlobalModel();
    protected PSSubAppRefGlobalModel psSubAppRefGlobalModel = new PSSubAppRefGlobalModel();
    protected PSAppUtilPageGlobalModel psAppUtilPageGlobalModel = new PSAppUtilPageGlobalModel();
    protected PSAppPDTViewGlobalModel psAppPDTViewGlobalModel = new PSAppPDTViewGlobalModel();
    protected PSAppUIStyleGlobalModel psAppUIStyleGlobalModel = new PSAppUIStyleGlobalModel();
    protected PSAppLanGlobalModel psAppLanGlobalModel = new PSAppLanGlobalModel();
    protected PSAppPkgGlobalModel psAppPkgGlobalModel = new PSAppPkgGlobalModel();
    protected PSMobAppStartPageGlobalModel psMobAppStartPageGlobalModel = new PSMobAppStartPageGlobalModel();
    protected PSMobAppIconGlobalModel psMobAppIconGlobalModel = new PSMobAppIconGlobalModel();
    protected PSMobAppPackGlobalModel psMobAppPackGlobalModel = new PSMobAppPackGlobalModel();
    protected PSMobAppPackCertGlobalModel psMobAppPackCertGlobalModel = new PSMobAppPackCertGlobalModel();
    protected PSAppUIThemeGlobalModel psAppUIThemeGlobalModel = new PSAppUIThemeGlobalModel();
    protected PSAppDataEntityGlobalModel psAppDataEntityGlobalModel = new PSAppDataEntityGlobalModel();
    protected PSAppUILogicGlobalModel psAppUILogicGlobalModel = new PSAppUILogicGlobalModel();
    protected PSAppWFGlobalModel psAppWFGlobalModel = new PSAppWFGlobalModel();
    protected PSAppWFVerGlobalModel psAppWFVerGlobalModel = new PSAppWFVerGlobalModel();
    protected PSAppResourceGlobalModel psAppResourceGlobalModel = new PSAppResourceGlobalModel();
    protected PSSysAppDEUIActionGlobalModel psSysAppDEUIActionGlobalModel = new PSSysAppDEUIActionGlobalModel();
    protected PSSysAppDEUIActionGroupGlobalModel psSysAppDEUIActionGroupGlobalModel = new PSSysAppDEUIActionGroupGlobalModel();
    protected PSSysAppDEUILogicGroupGlobalModel psSysAppDEUILogicGroupGlobalModel = new PSSysAppDEUILogicGroupGlobalModel();
    protected PSAppUtilGlobalModel psAppUtilGlobalModel = new PSAppUtilGlobalModel();
    protected PSAppPortletGlobalModel psAppPortletGlobalModel = new PSAppPortletGlobalModel();
    protected PSAppLogicGlobalModel psAppLogicGlobalModel = new PSAppLogicGlobalModel();
    private ArrayList<IPSSysTestPrj> psSysTestPrjList = null;
    private ArrayList<IPSSysServiceAPI> psSysServiceAPIList = null;
    private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
    private boolean bDefaultFlag = false;
    private IPSPF iPSPF = null;
    private IPSPFStyle iPSPFStyle = null;
    private IPSPF defaultPSPF = null;
    private IPSPFStyle defaultPSPFStyle = null;
    private Properties pfStyleParams = null;
    private boolean bUseServiceApi = false;
    private boolean bMobileApp = false;
    private Map<String, IPSPFStyle> psPFStyleMap = new LinkedHashMap<String, IPSPFStyle>();
    private String strAppFolder = null;
    private String strMainMenuAlign = "";
    protected ArrayList<IPSPFPkgVer> psPFPkgVerList = new ArrayList();
    private IPSPFCDN iPSPFCDN = null;
    private String strUpdatePSAppViewSysRefFlagSql = "UPDATE T_SRFPSAPPVIEW SET SYSREFFLAG = ? WHERE PSAPPVIEWID=?";
    private String strResetPSAppViewSysRefFlagSql = "UPDATE T_SRFPSAPPVIEW SET SYSREFFLAG = 0 WHERE PSSYSAPPID=? AND SYSREFFLAG IS NULL";
    private boolean bPubSysRefViewOnly = false;
    private ArrayList<IPSLogItem> psLogItemList = new ArrayList();
    private boolean bLoading = false;
    private int nButtonNoPrivDisplayMode = 2;
    private IPSAppView defaultPSAppView = null;
    private IPSAppIndexView defaultPSAppIndexView = null;
    private boolean bEnableCol12ToCol24 = false;
    private ArrayList<IPSAppView> refPSAppViewList = null;
    private boolean bAutoAddAppDEView = false;
    private boolean bGridForceFit = false;
    private boolean bGridEnableCustomized = true;
    private int nGridRowActiveMode = 2;
    private PSApplicationUIProxy psApplicationUIProxy = null;
    private String strServiceCodeName = null;
    private boolean bEnableUACLogin = false;
    private IPSSysSFPub iPSSysSFPub = null;
    private boolean bPreviewMode = false;
    private Map<String, Integer> psAppViewUsageMap = new LinkedHashMap<String, Integer>();
    private IPSAppUIStyle iPSAppUIStyle = null;
    private boolean bEnableDynaSys = false;
    private int nFormItemNoPrivDisplayMode = 1;
    private int nGridColumnNoPrivDisplayMode = 1;
    private boolean bOutputFormItemUpdateTag = false;
    private String strUIStyle = "DEFAULT";
    private String strBackendMode = "VIEW";
    private boolean bEnableFolderKey = false;
    private String strProjectPath = null;
    private IPSSysCss defaultAppViewPSSysCss = null;
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private ArrayList<IPSAppDERS> psAppDERSList = new ArrayList();
    private Map<String, IPSAppCounter> psAppCounterMap = new ConcurrentHashMap<String, IPSAppCounter>();
    private Map<String, IPSAppCodeList> psAppCodeListMap = new ConcurrentHashMap<String, IPSAppCodeList>();
    private Map<String, IPSAppMsgTempl> psAppMsgTemplMap = new ConcurrentHashMap<String, IPSAppMsgTempl>();
    private Map<String, IPSAppValueRule> psAppValueRuleMap = new ConcurrentHashMap<String, IPSAppValueRule>();
    private Map<String, IPSAppViewMsg> psAppViewMsgMap = new ConcurrentHashMap<String, IPSAppViewMsg>();
    private Map<String, IPSAppViewMsgGroup> psAppViewMsgGroupMap = new ConcurrentHashMap<String, IPSAppViewMsgGroup>();
    private String strAppMode = "DEFAULT";
    private boolean bWFAppMode = false;
    private ArrayList<IPSControlContainerView> containerPSAppViewList = new ArrayList();
    private Map<String, IPSAppPortletCat> psAppPortletCatMap = new ConcurrentHashMap<String, IPSAppPortletCat>();
    private List<IPSAppPortlet> psAppPortletList = null;
    private List<IPSAppPortlet> appPSAppPortletList = null;
    private List<IPSAppPortletCat> appPSAppPortletCatList = null;
    private Map<String, IPSAppDEUIAction> psAppDEUIActionMap = new ConcurrentHashMap<String, IPSAppDEUIAction>();
    private Map<String, IPSAppDEUIActionGroup> psAppDEUIActionGroupMap = new ConcurrentHashMap<String, IPSAppDEUIActionGroup>();
    private Map<String, IPSAppPFPluginRef> psAppPFPluginRefMap = new ConcurrentHashMap<String, IPSAppPFPluginRef>();
    private Map<String, IPSAppEditorStyleRef> psAppEditorStyleRefMap = new ConcurrentHashMap<String, IPSAppEditorStyleRef>();
    private Map<String, IPSAppSubViewTypeRef> psAppSubViewTypeRefMap = new ConcurrentHashMap<String, IPSAppSubViewTypeRef>();
    private Map<String, IPSAppDEFInputTipSet> psAppDEFInputTipSetMap = new ConcurrentHashMap<String, IPSAppDEFInputTipSet>();
    private int nGridColumnEnableLink = 2;
    private int nGridColumnEnableFilter = 2;
    private int nHttpPort = 0;
    private IPSPFPubHelp iPSPFPubHelp = null;
    private String strMDCtrlEmptyText = null;
    private IPSLanguageRes mdCtrlEmptyTextPSLanguageRes = null;
    private static Random RANDOM;
    private Map<String, IPSLanguageRes> psLanguageResMap = new ConcurrentHashMap<String, IPSLanguageRes>();
    private List<IPSApplicationLogic> psApplicationLogicList = null;
    private Map<String, IPSAppPDTView> replacePSAppPDTViewMap = null;
    private boolean bEnableServiceAPIDTO = false;
    private Map<String, Object> accessKeyMap = new LinkedHashMap<String, Object>();
    private int nACMinChars = 0;
    private boolean bLoadPSAppDEUIActionGroupNow = false;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysResource iPSSysResource = null;
    private static List<IPSSubAppRef> EmptyPSSubAppRefList;
    private Map<String, IPSAppMethodDTO> psAppMethodDTOMap = new TreeMap<String, IPSAppMethodDTO>();
    private int nDynaSysMode = 0;
    private boolean bDynaSysModeDefined = false;
    private Map<String, IPSAppBIScheme> psAppBISchemeMap = new TreeMap<String, IPSAppBIScheme>();
    private Integer nDefaultAppViewCssId = null;
    private String strAppType = null;

    static {
        GlobaDEUIActionMap.put("DATA_CREATEOBJECT", "\u5efa\u7acb\u6570\u636e");
        GlobaDEUIActionMap.put("DATA_SAVECHANGES", "\u4fdd\u5b58\u53d8\u66f4");
        GlobaDEUIActionMap.put("DATA_CANCELCHANGES", "\u53d6\u6d88\u53d8\u66f4");
        GlobaDEUIActionMap.put("DATA_REMOVEOBJECT", "\u5220\u9664\u6570\u636e");
        GlobaDEUIActionMap.put("DATA_SYNCHRONIZE", "\u540c\u6b65\u6570\u636e");
        GlobaDEUIActionMap.put("VIEW_OKACTION", "\u786e\u5b9a\uff08\u89c6\u56fe\uff09");
        GlobaDEUIActionMap.put("VIEW_CANCELACTION", "\u53d6\u6d88\uff08\u89c6\u56fe\uff09");
        GlobaDEUIActionMap.put("VIEW_YESACTION", "\u662f\uff08\u89c6\u56fe\uff09");
        GlobaDEUIActionMap.put("VIEW_NOACTION", "\u5426\uff08\u89c6\u56fe\uff09");
        GlobaDEUIActionMap.put("UTIL_ADDSELECTION", "\u6dfb\u52a0\u9009\u4e2d\u6570\u636e\uff08\u6570\u636e\u9009\u62e9\uff09");
        GlobaDEUIActionMap.put("UTIL_REMOVESELECTION", "\u79fb\u9664\u9009\u4e2d\u6570\u636e\uff08\u6570\u636e\u9009\u62e9\uff09");
        GlobaDEUIActionMap.put("UTIL_ADDALL", "\u6dfb\u52a0\u5168\u90e8\u6570\u636e\uff08\u6570\u636e\u9009\u62e9\uff09");
        GlobaDEUIActionMap.put("UTIL_REMOVEALL", "\u79fb\u9664\u5168\u90e8\u6570\u636e\uff08\u6570\u636e\u9009\u62e9\uff09");
        GlobaDEUIActionMap.put("UTIL_PREVSTEP", "\u4e0a\u4e00\u6b65\uff08\u5411\u5bfc\uff09");
        GlobaDEUIActionMap.put("UTIL_NEXTSTEP", "\u4e0b\u4e00\u6b65\uff08\u5411\u5bfc\uff09");
        GlobaDEUIActionMap.put("UTIL_FINISH", "\u5b8c\u6210\uff08\u5411\u5bfc\uff09");
        GlobaDEUIActionMap.put("UTIL_SEARCH", "\u641c\u7d22\uff08\u641c\u7d22\u680f\uff09");
        GlobaDEUIActionMap.put("UTIL_RESET", "\u91cd\u7f6e\uff08\u641c\u7d22\u680f\uff09");
        GlobaDEUIActionMap.put("APP_LOGIN", "\u767b\u5f55\u64cd\u4f5c");
        GlobaDEUIActionMap.put("APP_LOGOUT", "\u767b\u51fa\u64cd\u4f5c");
        RANDOM = new Random();
        EmptyPSSubAppRefList = new ArrayList<IPSSubAppRef>();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemApplication psSystemApplication) throws Exception {
        try {
            String strPFStyleParams;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSystemApplication = psSystemApplication;
            this.setId(this.psSystemApplication.getPSSYSAPPID());
            this.setName(this.psSystemApplication.getPSSYSAPPNAME());
            ArrayList<PSDevSlnTempl> psDevSlnTemplList = ((IPSSystemRuntime)((Object)iPSSystem)).getPSDevSlnTemplList();
            if (psDevSlnTemplList != null && psDevSlnTemplList.size() > 0) {
                String strPSDevSlnSysAppId = KeyValueHelper.genUniqueId((String)iPSSystem.getPSDevSlnSysId(), (String)this.psSystemApplication.getPSSYSAPPID());
                for (PSDevSlnTempl psDevSlnTempl : psDevSlnTemplList) {
                    if (StringHelper.isNullOrEmpty((String)psDevSlnTempl.getPSDEVSLNSYSAPPID()) || StringHelper.compare((String)psDevSlnTempl.getPSDEVSLNSYSAPPID(), (String)strPSDevSlnSysAppId, (boolean)true) != 0) continue;
                    psSystemApplication.setPSPFID(psDevSlnTempl.getPSPFID());
                    psSystemApplication.setPSPFSTYLEID(psDevSlnTempl.getPSPFSTYLEID());
                    psSystemApplication.setPSPFSTYLENAME(psDevSlnTempl.getPSDEVSLNTEMPLNAME());
                }
            }
            this.setPSObjectData(this.psSystemApplication);
            if (!StringHelper.isNullOrEmpty((String)this.getId())) {
                this.bEnableFolderKey = this.getId().indexOf("S") == 0;
            }
            this.strAppType = this.psSystemApplication.getPSAPPTYPEID();
            if (!this.psSystemApplication.isDEFAULTPUBNull()) {
                this.bDefaultFlag = this.psSystemApplication.getDEFAULTPUB();
            }
            this.iPSSysSFPub = StringHelper.isNullOrEmpty((String)this.psSystemApplication.getPSSYSSFPUBID()) ? this.getPSSystem().getDefaultPSSysSFPub() : this.getPSSystem().getPSSysSFPub(this.psSystemApplication.getPSSYSSFPUBID());
            if (this.getPSSysSFPub() != null && this.getPSSysSFPub().getPSSFStyle() instanceof IPSSFStyle2) {
                this.strBackendMode = "SERVICE";
                this.strProjectPath = this.getPSSysSFPub().getPSSFStyle().getStyleParam("%APP_PRJ%", null);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getAPPMODE())) {
                this.strAppMode = this.psSystemApplication.getAPPMODE();
            }
            if (StringHelper.compare((String)this.getAppMode(), (String)"WFAPP", (boolean)false) == 0) {
                this.bWFAppMode = true;
            }
            if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().isPreviewMode()) {
                this.bPreviewMode = true;
            }
            this.strAppFolder = this.psSystemApplication.getAPPFOLDER();
            if (StringHelper.isNullOrEmpty((String)this.strAppFolder)) {
                this.strAppFolder = this.getPKGCodeName();
            }
            this.strMainMenuAlign = this.psSystemApplication.getMAINMENUSIDE();
            if (!this.psSystemApplication.isBTNNOPRIVDMNull()) {
                this.nButtonNoPrivDisplayMode = this.psSystemApplication.getBTNNOPRIVDM();
            }
            if (!this.psSystemApplication.isFINOPRIVDMNull()) {
                this.nFormItemNoPrivDisplayMode = this.psSystemApplication.getFINOPRIVDM();
            }
            if (!this.psSystemApplication.isGCNOPRIVDMNull()) {
                this.nGridColumnNoPrivDisplayMode = this.psSystemApplication.getGCNOPRIVDM();
            }
            if (!this.psSystemApplication.isENABLEC12TOC24Null()) {
                this.bEnableCol12ToCol24 = this.psSystemApplication.getENABLEC12TOC24();
            }
            if (!this.psSystemApplication.isPUBREFVIEWONLYNull()) {
                this.bPubSysRefViewOnly = this.psSystemApplication.getPUBREFVIEWONLY();
            }
            if (!this.psSystemApplication.isAUTOADDAPPVIEWNull()) {
                this.bAutoAddAppDEView = this.psSystemApplication.getAUTOADDAPPVIEW();
            } else if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getPSDynaInstId())) {
                this.bAutoAddAppDEView = true;
            }
            if (!this.psSystemApplication.isGRIDFORCEFITNull()) {
                this.bGridForceFit = this.psSystemApplication.getGRIDFORCEFIT();
            }
            if (!this.psSystemApplication.isGRIDENABLECUSTOMIZEDNull()) {
                this.bGridEnableCustomized = this.psSystemApplication.getGRIDENABLECUSTOMIZED();
            }
            if (!this.psSystemApplication.isGRIDROWACTIVEMODENull()) {
                this.nGridRowActiveMode = this.psSystemApplication.getGRIDROWACTIVEMODE();
            }
            if (!this.psSystemApplication.isFIUPDATEPRIVTAGNull()) {
                this.bOutputFormItemUpdateTag = this.psSystemApplication.getFIUPDATEPRIVTAG();
            }
            if (!this.psSystemApplication.isUACLOGINNull()) {
                this.bEnableUACLogin = this.psSystemApplication.getUACLOGIN();
            }
            if (!this.psSystemApplication.isENABLEDYNASYSNull()) {
                this.bEnableDynaSys = this.psSystemApplication.getENABLEDYNASYS();
                this.nDynaSysMode = this.bEnableDynaSys ? 1 : 0;
                this.bDynaSysModeDefined = true;
            } else {
                this.bEnableDynaSys = this.getPSSystem().isEnableDynaSys();
            }
            this.strServiceCodeName = this.psSystemApplication.getSERVICECODENAME();
            this.nHttpPort = this.psSystemApplication.getDEFAULTPORT();
            if (this.nHttpPort <= 0 || this.nHttpPort > 65535) {
                this.nHttpPort = 0;
            }
            this.strMDCtrlEmptyText = this.psSystemApplication.getMDCTRLEMPTYTEXT();
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getMDCTRLEMPTYTEXTPSLANRESID())) {
                this.mdCtrlEmptyTextPSLanguageRes = this.getPSLanguageRes(this.psSystemApplication.getMDCTRLEMPTYTEXTPSLANRESID());
            }
            this.psApplicationUIProxy = new PSApplicationUIProxy(this);
            this.iPSPF = this.getPSModelStorage().getPSPF(this.psSystemApplication.getPSPFID());
            this.iPSPFStyle = this.getPSSystemUtil().getPSPFStyle(this.psSystemApplication.getPSPFID(), this.psSystemApplication.getPSPFSTYLEID(), this.getCodeName());
            this.defaultPSPF = this.iPSPF;
            this.defaultPSPFStyle = this.iPSPFStyle;
            PSAppUIStyleImpl psAppUIStyleImpl = null;
            if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().isPreviewMode()) {
                PSAppUIStyle psAppUIStyle = new PSAppUIStyle();
                psAppUIStyle.setPSAPPUISTYLEID("PREVIEW");
                psAppUIStyle.setPSAPPUISTYLENAME("\u5e94\u7528\u9884\u89c8\u6a21\u5f0f");
                psAppUIStyle.setUISTYLE("PREVIEW");
                if (this.iPSPF.getPSAppType() != null) {
                    if (StringHelper.compare((String)"WEBAPP_HTML5", (String)this.iPSPF.getPSAppType().getId(), (boolean)true) == 0) {
                        psAppUIStyle.setPSPFID("PREVIEW_PC");
                        psAppUIStyle.setPSPFSTYLEID("F226FC2C-4011-4747-B237-745BA046F7B0");
                    } else {
                        psAppUIStyle.setPSPFID("PREVIEW_MOB");
                        psAppUIStyle.setPSPFSTYLEID("430FDC4E-0A69-425A-B403-2C00A059BB65");
                    }
                }
                psAppUIStyleImpl = new PSAppUIStyleImpl();
                psAppUIStyleImpl.init(this.getDAGlobalHelper(), this, psAppUIStyle);
            }
            this.psAppUIStyleGlobalModel.Init(iDAGlobalHelper, this);
            if (!this.bPreviewMode && !StringHelper.isNullOrEmpty((String)this.psSystemApplication.getUISTYLE())) {
                this.psAppUIStyleGlobalModel.getAllModelHelpers();
                this.iPSAppUIStyle = (IPSAppUIStyle)this.psAppUIStyleGlobalModel.FindModelHelper(this.psSystemApplication.getUISTYLE(), true);
            }
            if (psAppUIStyleImpl != null) {
                this.iPSAppUIStyle = psAppUIStyleImpl;
            }
            if (this.iPSAppUIStyle != null) {
                this.iPSPF = this.iPSAppUIStyle.getPSPF();
                this.iPSPFStyle = this.iPSAppUIStyle.getPSPFStyle();
                this.strUIStyle = this.iPSAppUIStyle.getUIStyle();
            } else if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getUISTYLE())) {
                this.strUIStyle = this.psSystemApplication.getUISTYLE();
            }
            if (this.iPSPF.getPSAppType() != null) {
                this.bUseServiceApi = this.iPSPF.getPSAppType().isUseServiceApi();
                this.bMobileApp = this.iPSPF.getPSAppType().isMobileApp();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psSystemApplication.getPSSYSIMAGEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getPSPFCDNID())) {
                this.iPSPFCDN = this.getPSModelStorage().getPSPFCDN(this.psSystemApplication.getPSPFCDNID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getPSSYSSERVICEAPIID())) {
                this.iPSSysServiceAPI = this.getPSSystem().getPSSysServiceAPI(this.psSystemApplication.getPSSYSSERVICEAPIID());
            }
            this.bUseServiceApi = this.getPSSysServiceAPI() != null;
            if (!this.psSystemApplication.isSERVICEDTOFLAGNull()) {
                this.bEnableServiceAPIDTO = this.psSystemApplication.getSERVICEDTOFLAG();
            } else if (this.getPSSysServiceAPI() != null) {
                this.bEnableServiceAPIDTO = this.getPSSysServiceAPI().isEnableServiceAPIDTO();
            } else if (this.getPSSystem().isEnableModelRT()) {
                this.bEnableServiceAPIDTO = true;
            }
            if (!this.psSystemApplication.isGRIDCOLENABLELINKNull()) {
                this.nGridColumnEnableLink = this.psSystemApplication.getGRIDCOLENABLELINK();
            }
            if (!this.psSystemApplication.isGRIDCOLENABLEFILTERNull()) {
                this.nGridColumnEnableFilter = this.psSystemApplication.getGRIDCOLENABLEFILTER();
            }
            if (!this.psSystemApplication.isACMINCHARSNull() && this.psSystemApplication.getACMINCHARS() > 0) {
                this.nACMinChars = this.psSystemApplication.getACMINCHARS();
            }
            if (!StringHelper.isNullOrEmpty((String)(strPFStyleParams = this.iPSPFStyle.getPFStyleParams()))) {
                strPFStyleParams = String.valueOf(strPFStyleParams) + "\r\n";
            }
            strPFStyleParams = String.valueOf(strPFStyleParams) + this.psSystemApplication.getPFSTYLEPARAM();
            this.pfStyleParams = PropertiesHelper.Load((String)strPFStyleParams);
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getPSSYSRESOURCEID())) {
                this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSystemApplication.getPSSYSRESOURCEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSystemApplication.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSystemApplication.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            this.psAppDataEntityGlobalModel.Init(iDAGlobalHelper, this);
            this.psSysAppDEUIActionGlobalModel.Init(iDAGlobalHelper, this);
            this.psSysAppDEUIActionGroupGlobalModel.Init(iDAGlobalHelper, this);
            this.psSysAppDEUILogicGroupGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppUIThemeGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppUtilPageGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppPDTViewGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppLanGlobalModel.Init(iDAGlobalHelper, this);
            this.psSubAppRefGlobalModel.Init(iDAGlobalHelper, this);
            this.psApplicationViewGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppModuleGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppViewStyleGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppEditorTemplGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppFuncGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppWFGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppWFVerGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppViewCodeGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppMenuModelGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppUserModeGlobalModel.Init(iDAGlobalHelper, this);
            this.psMobAppStartPageGlobalModel.Init(iDAGlobalHelper, this);
            this.psMobAppIconGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppPkgGlobalModel.Init(iDAGlobalHelper, this);
            this.psMobAppPackCertGlobalModel.Init(iDAGlobalHelper, this);
            this.psMobAppPackGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppUILogicGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppResourceGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppUtilGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppPortletGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppLogicGlobalModel.Init(iDAGlobalHelper, this);
            if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().isPreviewMode()) {
                this.bAutoAddAppDEView = true;
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSAppDERSs();
        this.preparePSPFPkgVers();
        String strDefaultAppViewCssId = this.getPFStyleParam(PFSTYLEPARAM_DEFAULTAPPVIEWCSS, "");
        if (!StringHelper.isNullOrEmpty((String)strDefaultAppViewCssId)) {
            this.defaultAppViewPSSysCss = this.getPSSystem().getPSSysCss(strDefaultAppViewCssId);
        }
    }

    protected void preparePSPFPkgVers() throws Exception {
        LinkedHashMap<String, IPSPFPkgVer> psPFPkgVerMap = new LinkedHashMap<String, IPSPFPkgVer>();
        Iterator<IPSPFPkgVer> psPFPkgVers = this.getPSPFStyle().getPSPFPkgVers();
        while (psPFPkgVers.hasNext()) {
            IPSPFPkgVerCDN iPSPFPkgVerCDN;
            IPSPFPkgVer iPSPFPkgVer = psPFPkgVers.next();
            if (this.getPSPFCDN() != null && (iPSPFPkgVerCDN = this.getPSPF().getPSPFPkgVerCDN(iPSPFPkgVer.getId(), this.getPSPFCDN().getId(), this.getPSSystem().getPSDevCenterId(), true)) != null) {
                iPSPFPkgVer = new PSPFPkgVerProxy(iPSPFPkgVerCDN, iPSPFPkgVer.getOrderValue());
            }
            psPFPkgVerMap.put(iPSPFPkgVer.getPSPFPkg().getId(), iPSPFPkgVer);
        }
        Iterator<IPSAppPkg> psAppPkgs = this.getPSAppPkgs();
        while (psAppPkgs.hasNext()) {
            IPSAppPkg iPSAppPkg = psAppPkgs.next();
            if (iPSAppPkg.getPSPFPkg() != null) {
                psPFPkgVerMap.put(iPSAppPkg.getPSPFPkg().getId(), iPSAppPkg);
                continue;
            }
            this.psPFPkgVerList.add(iPSAppPkg);
        }
        this.psPFPkgVerList.addAll(((HashMap)psPFPkgVerMap).values());
        Collections.sort(this.psPFPkgVerList, new Comparator<IPSPFPkgVer>(){

            @Override
            public int compare(IPSPFPkgVer arg0, IPSPFPkgVer arg1) {
                int nValue = arg0.getOrderValue() - arg1.getOrderValue();
                if (nValue == 0) {
                    return 0;
                }
                return nValue;
            }
        });
    }

    /*
     * Unable to fully structure code
     */
    protected void preparePSAppDERSs() throws Exception {
        block15: {
            block14: {
                this.psAppDERSList.clear();
                list = new Vector<PSAppDERS>();
                callResult = this.getPSModelHelper().getAllPSAppDERSs(this.getId(), list);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
                }
                psDataEntities = this.getAllPSAppDataEntities();
                if (psDataEntities == null) {
                    return;
                }
                psAppDERSMap = new LinkedHashMap<String, PSApplicationObjectImpl>();
                if (this.isEnableUIModelEx()) break block14;
                for (PSAppDERS psAppDERS : list) {
                    psAppDERSImpl = new PSAppDERSImpl();
                    psAppDERSImpl.init(this.getDAGlobalHelper(), this, psAppDERS);
                    strTag = StringHelper.format((String)"%1$s-%2$s", (Object)psAppDERSImpl.getPPSAppDataEntityId(), (Object)psAppDERSImpl.getCPSAppDataEntityId());
                    if (psAppDERSMap.containsKey(strTag)) continue;
                    psAppDERSMap.put(strTag, psAppDERSImpl);
                    this.psAppDERSList.add(psAppDERSImpl);
                }
                break block15;
            }
            psDataEntities = this.getAllPSAppDataEntities();
            while (psDataEntities.hasNext()) {
                iPSAppDataEntity = psDataEntities.next();
                if ((iPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_DTOONLY.intValue() || iPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_LOCALONLY.intValue() || iPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_LOCALANDREMOTE.intValue() || iPSAppDataEntity.getPSDEServiceAPI() != null && iPSAppDataEntity.getPSDEServiceAPI().getAPIMode() == 9) && (psDERBases = iPSAppDataEntity.getPSDataEntity().getMinorPSDERs()) != null) ** GOTO lbl46
                continue;
lbl-1000:
                // 1 sources

                {
                    iPSDERBase = psDERBases.next();
                    strDERType = iPSDERBase.getDERType();
                    if ("DERCUSTOM".equals(strDERType)) {
                        strDERType = ((IPSDERCustom)iPSDERBase).getDERSubType();
                    }
                    if (!"DER11".equals(strDERType) && !"DER1N".equals(strDERType) || (majorPSAppDataEntity = this.getPSAppDataEntity(iPSDERBase.getMajorPSDataEntity(), true)) == null) continue;
                    bNested = false;
                    if (iPSDERBase instanceof IPSDER1N) {
                        iPSDER1N = (IPSDER1N)iPSDERBase;
                        bNested = iPSDER1N.isNestedRS() != false || iPSDER1N.getTempDataOrder() >= 0;
                    } else if (iPSDERBase instanceof IPSDERCustom) {
                        iPSDERCustom = (IPSDERCustom)iPSDERBase;
                        v0 = bNested = (iPSDERCustom.getMasterRS() & 8) == 8;
                    }
                    if (!bNested && majorPSAppDataEntity.getStorageMode() != IPSAppDataEntity.STORAGEMODE_DTOONLY.intValue() && majorPSAppDataEntity.getStorageMode() != IPSAppDataEntity.STORAGEMODE_LOCALONLY.intValue() && majorPSAppDataEntity.getStorageMode() != IPSAppDataEntity.STORAGEMODE_LOCALANDREMOTE.intValue() && (majorPSAppDataEntity.getPSDEServiceAPI() == null || majorPSAppDataEntity.getPSDEServiceAPI().getAPIMode() != 9)) continue;
                    psAppDERSImpl3 = new PSAppDERSImpl3();
                    psAppDERSImpl3.init(this.getDAGlobalHelper(), this, iPSDERBase, majorPSAppDataEntity, iPSAppDataEntity);
                    this.psAppDERSList.add(psAppDERSImpl3);
lbl46:
                    // 4 sources

                    ** while (psDERBases.hasNext())
                }
lbl47:
                // 1 sources

            }
        }
        psSysServiceAPIs = this.getAllPSSysServiceAPIs();
        if (psSysServiceAPIs == null) {
            return;
        }
        psDataEntitityMap = new LinkedHashMap<String, IPSAppDataEntity>();
        psDataEntities = this.getAllPSAppDataEntities();
        while (psDataEntities.hasNext()) {
            iPSAppDataEntity = psDataEntities.next();
            if (iPSAppDataEntity.getPSDEServiceAPI() == null || psDataEntitityMap.containsKey(iPSAppDataEntity.getPSDEServiceAPI().getId()) && !iPSAppDataEntity.isMajor()) continue;
            psDataEntitityMap.put(iPSAppDataEntity.getPSDEServiceAPI().getId(), iPSAppDataEntity);
        }
        while (psSysServiceAPIs.hasNext()) {
            iPSSysServiceAPI = psSysServiceAPIs.next();
            psDEServiceAPIRSs = iPSSysServiceAPI.getPSDEServiceAPIRSs();
            if (psDEServiceAPIRSs != null) ** GOTO lbl79
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                majorPSDEServiceAPI = iPSDEServiceAPIRS.getMajorPSDEServiceAPI();
                minorPSDEServiceAPI = iPSDEServiceAPIRS.getMinorPSDEServiceAPI();
                if (majorPSDEServiceAPI == null || minorPSDEServiceAPI == null) {
                    throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb[%1$s]\u903b\u8f91\u6709\u8bef\uff0c\u6ca1\u6709\u4e3b\u63a5\u53e3\u6216\u662f\u4ece\u63a5\u53e3\u5bf9\u8c61", (Object)iPSDEServiceAPIRS.getName()));
                }
                majorPSAppDataEntity = (IPSAppDataEntity)psDataEntitityMap.get(majorPSDEServiceAPI.getId());
                minorPSAppDataEntity = (IPSAppDataEntity)psDataEntitityMap.get(minorPSDEServiceAPI.getId());
                if (majorPSAppDataEntity == null || minorPSAppDataEntity == null || psAppDERSMap.containsKey(strTag = StringHelper.format((String)"%1$s-%2$s", (Object)majorPSAppDataEntity.getId(), (Object)minorPSAppDataEntity.getId()))) continue;
                psAppDERSImpl2 = new PSAppDERSImpl2();
                psAppDERSImpl2.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIRS, majorPSAppDataEntity, minorPSAppDataEntity);
                this.psAppDERSList.add(psAppDERSImpl2);
                psAppDERSMap.put(strTag, psAppDERSImpl2);
lbl79:
                // 3 sources

                ** while (psDEServiceAPIRSs.hasNext())
            }
lbl80:
            // 1 sources

        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5e94\u7528", fields={"DEFAULTPUB"}, ignorert=3)
    public boolean getDefaultFlag() {
        return this.bDefaultFlag;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f", dynamodelmode=12, fields={"PSPFID"})
    public String getPFType() {
        if (this.iPSPF != null) {
            return this.iPSPF.getId();
        }
        return this.psSystemApplication.getPSPFID();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u6837\u5f0f", dynamodelmode=12, fields={"PSPFSTYLEID"})
    public String getPFStyle() {
        if (this.iPSPFStyle != null && !StringHelper.isNullOrEmpty((String)this.iPSPFStyle.getId())) {
            return this.iPSPFStyle.getId();
        }
        return this.psSystemApplication.getPSPFSTYLEID();
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId) throws Exception {
        return this.getPSAppView(strPSApplicationViewId, strOriginViewId, false, null);
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId, IPSAppView refPSAppView) throws Exception {
        return this.getPSAppView(strPSApplicationViewId, strOriginViewId, false, refPSAppView);
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId, boolean bTryMode) throws Exception {
        return this.getPSAppView(strPSApplicationViewId, strOriginViewId, bTryMode, null);
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, String strOriginViewId, boolean bTryMode, IPSAppView refPSAppView) throws Exception {
        IPSAppView iPSAppView;
        if (this.replacePSAppPDTViewMap != null) {
            IPSAppPDTView iPSAppPDTView = this.replacePSAppPDTViewMap.get(strPSApplicationViewId);
            if (iPSAppPDTView != null) {
                return iPSAppPDTView.getPSAppView();
            }
            iPSAppPDTView = this.replacePSAppPDTViewMap.get(strOriginViewId);
            if (iPSAppPDTView != null) {
                return iPSAppPDTView.getPSAppView();
            }
        }
        if ((iPSAppView = this.psApplicationViewGlobalModel.FindModelHelper(strPSApplicationViewId, true)) == null && !bTryMode) {
            if (!StringHelper.isNullOrEmpty((String)strOriginViewId)) {
                PSDEViewBase psDEViewBase = new PSDEViewBase();
                CallResult callResult = this.getPSModelHelper().getPSDEViewBase(strOriginViewId, psDEViewBase);
                if (callResult.isOk()) {
                    throw PSApplicationException.create(this, 40012, strPSApplicationViewId, strOriginViewId);
                }
            }
            throw PSApplicationException.create(this, 40012, strPSApplicationViewId, strOriginViewId);
        }
        return iPSAppView;
    }

    @Override
    public IPSAppView getPSAppView(String strPSApplicationViewId, boolean bTryMode) throws Exception {
        IPSAppPDTView iPSAppPDTView;
        if (this.replacePSAppPDTViewMap != null && (iPSAppPDTView = this.replacePSAppPDTViewMap.get(strPSApplicationViewId)) != null) {
            return iPSAppPDTView.getPSAppView();
        }
        IPSAppView iPSAppView = this.psApplicationViewGlobalModel.FindModelHelper(strPSApplicationViewId, bTryMode);
        return iPSAppView;
    }

    @Override
    public void resetPSAppView(String strPSApplicationViewId) {
        this.psApplicationViewGlobalModel.ResetModel(strPSApplicationViewId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5757\u96c6\u5408", child=true, dumpref=true, rtdump=2, ignorepf=true, dynamodelmode=8, group="\u57fa\u672c", order=240)
    public Iterator<IPSAppModule> getAllPSAppModules() throws Exception {
        return this.psAppModuleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppModule getPSAppModule(String strPSAppModuleId) throws Exception {
        return (IPSAppModule)this.psAppModuleGlobalModel.FindModelHelper(strPSAppModuleId);
    }

    @Override
    public void resetPSAppModule(String strPSAppModuleId) {
        this.psAppModuleGlobalModel.ResetModel(strPSAppModuleId);
    }

    @Override
    public IPSSubAppRef getPSSubAppRef(String strPSSubAppRefId) throws Exception {
        return (IPSSubAppRef)this.psSubAppRefGlobalModel.FindModelHelper(strPSSubAppRefId);
    }

    @Override
    public void resetPSSubAppRef(String strPSSubAppRefId) {
        this.psSubAppRefGlobalModel.ResetModel(strPSSubAppRefId);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u5305\u540d\u79f0", fields={"APPPKGNAME"})
    public String getPKGCodeName() {
        if (PSJITWebContext.getInstance() != null) {
            return PSJITWebContext.getInstance().getPSAppName();
        }
        return this.psSystemApplication.getAPPPKGNAME();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"APPPKGNAME"})
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psSystemApplication.getAPPPKGNAME();
    }

    @Override
    public String getCodeFolder() {
        return this.psSystemApplication.getCODEFOLDER();
    }

    @Override
    public IPSAppViewStyle getPSAppViewStyle(String strPSAppViewStyleId) throws Exception {
        return (IPSAppViewStyle)this.psAppViewStyleGlobalModel.FindModelHelper(strPSAppViewStyleId);
    }

    @Override
    public void resetPSAppViewStyle(String strPSAppViewStyleId) {
        this.psAppViewStyleGlobalModel.ResetModel(strPSAppViewStyleId);
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType iPSEditorType, String strContainerType, IPSPFPubCode iPSPFPubCode, String strStyle) throws Exception {
        try {
            String strPSAppEditorTemplId = Helper.GenUniqueId((String)this.getId(), (String)iPSEditorType.getId(), (String)strStyle, (String)strContainerType, (String)iPSPFPubCode.getId());
            IPSAppEditorTempl iPSAppEditorTempl = (IPSAppEditorTempl)this.psAppEditorTemplGlobalModel.FindModelHelper(strPSAppEditorTemplId, true);
            if (iPSAppEditorTempl != null) {
                return iPSAppEditorTempl;
            }
            if (StringHelper.compare((String)iPSEditorType.getStandardPSEditorType(), (String)iPSEditorType.getId(), (boolean)false) != 0 && (iPSAppEditorTempl = (IPSAppEditorTempl)this.psAppEditorTemplGlobalModel.FindModelHelper(strPSAppEditorTemplId = Helper.GenUniqueId((String)this.getId(), (String)iPSEditorType.getStandardPSEditorType(), (String)strStyle, (String)strContainerType, (String)iPSPFPubCode.getId()), true)) != null) {
                return iPSAppEditorTempl;
            }
            return this.getPSPFStyle().getPSPFEditorTempl(iPSEditorType, strContainerType, iPSPFPubCode);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u7f16\u8f91\u5668\u6a21\u677f[%1$s/%2$s/%3$s/%4$s]\u53d1\u751f\u9519\u8bef", (Object)iPSEditorType.getId(), (Object)strContainerType, (Object)iPSPFPubCode.getName(), (Object)strStyle));
            throw ex;
        }
    }

    @Override
    public IPSAppFunc getPSAppFunc(String strPSAppFuncId) throws Exception {
        return (IPSAppFunc)this.psAppFuncGlobalModel.FindModelHelper(strPSAppFuncId);
    }

    @Override
    public IPSAppFunc getPSAppFunc(String strPSAppFuncId, boolean bTryMode) throws Exception {
        return (IPSAppFunc)this.psAppFuncGlobalModel.FindModelHelper(strPSAppFuncId, bTryMode);
    }

    @Override
    public IPSAppFunc getPSAppFunc(String strPSAppFuncId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
        IPSAppFunc iPSAppFunc = this.getPSAppFunc(strPSAppFuncId, bTryMode);
        if (iPSAppFunc != null) {
            PSApplicationImpl.registerRefPSModelObject(iPSAppFunc, refPSModelObject);
        }
        return iPSAppFunc;
    }

    @Override
    public void resetPSAppFunc(String strPSAppFuncId) {
        this.psAppFuncGlobalModel.ResetModel(strPSAppFuncId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u96c6\u5408", child=true, group="\u5e94\u7528\u903b\u8f91", order=220)
    public Iterator<IPSAppFunc> getAllPSAppFuncs() throws Exception {
        return this.psAppFuncGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppFunc registerPSAppFunc(PSAppFunc psAppFunc) throws Exception {
        IPSAppFunc iPSAppFunc = this.getPSAppFunc(psAppFunc.getPSAPPFUNCID(), true);
        if (iPSAppFunc == null) {
            iPSAppFunc = new PSAppFuncImpl();
            iPSAppFunc.init(this.getDAGlobalHelper(), this, psAppFunc);
            this.psAppFuncGlobalModel.appendAllModelHelpers(iPSAppFunc);
        }
        return iPSAppFunc;
    }

    public IView getView(String strViewId) throws Exception {
        return this.getPSAppView(strViewId, null);
    }

    @Override
    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u96c6\u5408", child=true, dumpref=true, rtdump=2, ignorert=3, modelreftype="APPLICATION", group="\u5e94\u7528\u89c6\u56fe", order=190)
    public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
        return this.psApplicationViewGlobalModel.getAllModelHelpers();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u96c6\u5408\uff08\u88ab\u5f15\u7528\uff09")
    public Iterator<IPSAppView> getAllRefPSAppViews() throws Exception {
        if (this.refPSAppViewList != null) {
            return this.refPSAppViewList.iterator();
        }
        PSApplicationImpl pSApplicationImpl = this;
        synchronized (pSApplicationImpl) {
            ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
            Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                if (!iPSAppView.getRefFlag()) continue;
                psAppViewList.add(iPSAppView);
            }
            if (this.refPSAppViewList == null) {
                this.refPSAppViewList = psAppViewList;
            }
        }
        return this.refPSAppViewList.iterator();
    }

    @Override
    public IPSAppViewCode getPSAppViewCode(String strPSAppViewCodeId, boolean bTryMode) throws Exception {
        return (IPSAppViewCode)this.psAppViewCodeGlobalModel.FindModelHelper(strPSAppViewCodeId, bTryMode);
    }

    @Override
    public void resetPSAppViewCode(String strPSAppViewCodeId) {
        this.psAppViewCodeGlobalModel.ResetModel(strPSAppViewCodeId);
    }

    @Override
    public Iterator<IPSAppViewCode> getAllPSAppViewCodes() throws Exception {
        return this.psAppViewCodeGlobalModel.getAllModelHelpers();
    }

    @Override
    public synchronized void load(int nLoadLevel) throws Exception {
        try {
            Iterator<IPSSysTestPrj> psSysTestPrjs;
            Iterator<IPSSysBIScheme> psSysBISchemes;
            Iterator<IPSAppWFVer> psAppWFVers;
            Iterator<IPSAppWF> psAppWFs;
            Iterator<IPSSubViewType> psSubViewTypes;
            boolean bLoop;
            IPSAppDEUIAction iPSAppDEUIAction;
            Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs;
            if (nLoadLevel <= this.nLoadedLevel) {
                return;
            }
            if (this.isLoading()) {
                throw new Exception("\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u65e0\u6cd5\u91cd\u590d\u52a0\u8f7d");
            }
            if (!this.getPSSystem().isDynaInstMode()) {
                PSAppDEViewRefService psAppDEViewRefService = (PSAppDEViewRefService)ServiceGlobal.getService(PSAppDEViewRefService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                PSSysApp psSysApp = new PSSysApp();
                psSysApp.setPSSysAppId(this.getId());
                psAppDEViewRefService.removeByPSSysApp(psSysApp);
            }
            this.bLoading = true;
            this.psLogItemList.clear();
            this.nLoadingLevel = nLoadLevel;
            this.getAllPSAppModules();
            this.getAllPSAppLans();
            this.getAllPSAppUtils();
            this.getAllPSAppUtilPages();
            this.getAllPSAppUIStyles();
            this.getAllPSAppUIThemes();
            this.getAllPSAppValueRules();
            this.getAllPSAppResources();
            Vector<PSAppPFPlugin> pfAppPFPluginList = new Vector<PSAppPFPlugin>();
            CallResult callResult = this.getPSModelHelper().getAllPSAppPFPlugins(this.getId(), pfAppPFPluginList);
            if (callResult.isError()) {
                throw new Exception(String.format("\u83b7\u53d6\u5e94\u7528\u524d\u7aef\u63d2\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", callResult.getErrorInfo()));
            }
            for (PSAppPFPlugin psAppPFPlugin : pfAppPFPluginList) {
                this.getPSSysPFPlugin(psAppPFPlugin.getPSSYSPFPLUGINID(), "APP", psAppPFPlugin.getCODENAME(), null);
            }
            Iterator<IPSAppPDTView> psAppPDTViews = this.getAllPSAppPDTViews();
            if (psAppPDTViews != null) {
                while (psAppPDTViews.hasNext()) {
                    String strPSDEViewBaseId;
                    IPSAppPDTView iPSAppPDTView = psAppPDTViews.next();
                    if (iPSAppPDTView.getPSSysPDTView() == null || !iPSAppPDTView.getPSSysPDTView().isFromDEViewToPDTView() || StringHelper.isNullOrEmpty((String)(strPSDEViewBaseId = iPSAppPDTView.getPSSysPDTView().getPSDEViewBaseId()))) continue;
                    if (this.replacePSAppPDTViewMap == null) {
                        this.replacePSAppPDTViewMap = new LinkedHashMap<String, IPSAppPDTView>();
                    }
                    this.replacePSAppPDTViewMap.put(strPSDEViewBaseId, iPSAppPDTView);
                    this.replacePSAppPDTViewMap.put(KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSDEViewBaseId), iPSAppPDTView);
                }
            }
            if ((psAppSubViewTypeRefs = this.getAllPSAppSubViewTypeRefs()) != null) {
                while (psAppSubViewTypeRefs.hasNext()) {
                    IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
                    iPSAppSubViewTypeRef.check();
                }
            }
            Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
            this.getPSSystemUtil().testPSModelLimit(this, "PSAPPDATAENTITY", this.psAppDataEntityGlobalModel.getAllModelHelperCount());
            if (psAppDataEntities != null) {
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    iPSAppDataEntity.loadAll();
                }
                String strLoadDEUAGroups = this.getUserParam(DYNAPARAM_SRFLOADDEUAGROUPS, null);
                if (!StringHelper.isNullOrEmpty((String)strLoadDEUAGroups) && !StringHelper.isNullOrEmpty((String)(strLoadDEUAGroups = strLoadDEUAGroups.trim()))) {
                    String[] uagroups;
                    String[] stringArray = uagroups = strLoadDEUAGroups.split("[;]");
                    int n = uagroups.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String strUAGroup = stringArray[n2];
                        if (!StringHelper.isNullOrEmpty((String)strUAGroup)) {
                            psAppDataEntities = this.getAllPSAppDataEntities();
                            while (psAppDataEntities.hasNext()) {
                                IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                                iPSAppDataEntity.getPSAppDEUIActionGroup(strUAGroup, true);
                            }
                        }
                        ++n2;
                    }
                }
            }
            Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
            this.getPSSystemUtil().testPSModelLimit(this, "PSAPPVIEW", this.psApplicationViewGlobalModel.getAllModelHelperCount());
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                iPSAppView.check();
            }
            Iterator<IPSDEUIAction> globalPSDEActions = this.getPSSystem().getAllPSDEUIActions();
            if (globalPSDEActions != null) {
                while (globalPSDEActions.hasNext()) {
                    IPSDEUIAction iPSDEUIAction = globalPSDEActions.next();
                    String strPredefinedType = iPSDEUIAction.getPredefinedType();
                    if (StringHelper.isNullOrEmpty((String)strPredefinedType) || !GlobaDEUIActionMap.containsKey(strPredefinedType)) continue;
                    this.getPSAppDEUIAction(iPSDEUIAction.getId());
                }
            }
            this.getAllPSAppDEUIActions();
            this.bLoadPSAppDEUIActionGroupNow = true;
            this.getAllPSAppDEUIActionGroups();
            this.bLoadPSAppDEUIActionGroupNow = false;
            this.getAllPSAppWFs();
            this.getAllPSAppWFVers();
            this.getAllPSAppLogics();
            this.getAllPSAppUILogics();
            this.getAllPSAppDEUILogicGroups();
            this.getAllPSAppViews();
            this.getAllPSAppViewCodes();
            Iterator<IPSAppFunc> psAppFuncs = this.getAllPSAppFuncs();
            if (psAppFuncs != null) {
                while (psAppFuncs.hasNext()) {
                    IPSAppFunc iPSAppFunc = psAppFuncs.next();
                    if (StringHelper.isNullOrEmpty((String)iPSAppFunc.getAccessKey())) continue;
                    this.accessKeyMap.put(iPSAppFunc.getAccessKey(), null);
                }
            }
            this.getAllPSAppUserModes();
            this.getAllPSAppLocalDEs();
            Iterator<IPSAppMenuModel> psAppMenuModels = this.getAllPSAppMenuModels();
            if (psAppMenuModels != null) {
                while (psAppMenuModels.hasNext()) {
                    IPSAppMenuModel iPSAppMenuModel = psAppMenuModels.next();
                    Iterator<IPSAppMenuItem> psAppMenuItems = iPSAppMenuModel.getPSAppMenuItems();
                    if (psAppMenuItems == null) continue;
                    while (psAppMenuItems.hasNext()) {
                        this.fillPSAppMenuItemAccessKey(psAppMenuItems.next());
                    }
                }
            }
            Iterator<IPSAppDataEntity> psAppDataEntities2 = this.getAllPSAppDataEntities();
            while (psAppDataEntities2.hasNext()) {
                IPSAppDataEntity iPSAppDataEntity = psAppDataEntities2.next();
                Iterator<IPSAppDEUIAction> psAppDEUIActions = iPSAppDataEntity.getAllPSAppDEUIActions();
                if (psAppDEUIActions == null) continue;
                while (psAppDEUIActions.hasNext()) {
                    IPSAppDEUIAction nextPSAppDEUIAction;
                    iPSAppDEUIAction = psAppDEUIActions.next();
                    IPSUIAction nextPSUIAction = iPSAppDEUIAction.getNextPSUIAction();
                    if (!(nextPSUIAction instanceof IPSAppDEUIAction) || (nextPSAppDEUIAction = (IPSAppDEUIAction)nextPSUIAction).getPSAppDataEntity() == null) continue;
                    nextPSAppDEUIAction.getPSAppDataEntity().getPSAppDEUIAction(nextPSAppDEUIAction.getId(), false);
                }
            }
            int nLastTotal = -1;
            block15: while (true) {
                Iterator<IPSAppDEUILogic> psAppDEUILogics;
                ArrayList<IPSAppDEUILogic> list = new ArrayList<IPSAppDEUILogic>();
                ArrayList<IPSAppDEUIAction> list2 = new ArrayList<IPSAppDEUIAction>();
                ArrayList<IPSAppDEACMode> list3 = new ArrayList<IPSAppDEACMode>();
                psAppDataEntities2 = this.getAllPSAppDataEntities();
                while (psAppDataEntities2.hasNext()) {
                    Iterator<IPSAppDEACMode> psAppDEACModes;
                    Iterator<IPSAppDEUIAction> psAppDEUIActions;
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities2.next();
                    psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics();
                    if (psAppDEUILogics != null) {
                        while (psAppDEUILogics.hasNext()) {
                            list.add(psAppDEUILogics.next());
                        }
                    }
                    if ((psAppDEUIActions = iPSAppDataEntity.getAllPSAppDEUIActions()) != null) {
                        while (psAppDEUIActions.hasNext()) {
                            list2.add(psAppDEUIActions.next());
                        }
                    }
                    if ((psAppDEACModes = iPSAppDataEntity.getAllPSAppDEACModes()) == null) continue;
                    while (psAppDEACModes.hasNext()) {
                        list3.add(psAppDEACModes.next());
                    }
                }
                if (nLastTotal == -1) {
                    nLastTotal = list.size() + list2.size() + list3.size();
                } else {
                    int nTotal = list.size() + list2.size() + list3.size();
                    if (nTotal == 0 || nLastTotal == nTotal) break;
                    nLastTotal = nTotal;
                }
                for (IPSAppDEUILogic iPSAppDEUILogic : list) {
                    iPSAppDEUILogic.check();
                }
                for (IPSAppDEUIAction iPSAppDEUIAction2 : list2) {
                    iPSAppDEUIAction2.check();
                }
                psAppDEUILogics = list3.iterator();
                while (true) {
                    if (!psAppDEUILogics.hasNext()) continue block15;
                    IPSAppDEACMode iPSAppDEACMode = (IPSAppDEACMode)((Object)psAppDEUILogics.next());
                    iPSAppDEACMode.check();
                }
                break;
            }
            psAppDataEntities2 = this.getAllPSAppDataEntities();
            while (psAppDataEntities2.hasNext()) {
                Iterator<IPSAppDEReport> psAppDEReports;
                Iterator<IPSDEOPPriv> psDEOPPrivs;
                IPSAppDataEntity iPSAppDataEntity = psAppDataEntities2.next();
                Iterator<IPSAppDEUIAction> psAppDEUIActions = iPSAppDataEntity.getAllPSAppDEUIActions();
                if (psAppDEUIActions != null) {
                    while (psAppDEUIActions.hasNext()) {
                        IPSAppDEUIAction iPSAppDEUIAction3 = psAppDEUIActions.next();
                        IPSDEOPPriv iPSDEOPPriv = iPSAppDEUIAction3.getPSDEOPPriv();
                        if (iPSDEOPPriv == null || !iPSDEOPPriv.isMapSysUniRes() || StringHelper.isNullOrEmpty((String)iPSDEOPPriv.getMapSysUniResCode())) continue;
                        this.accessKeyMap.put(iPSDEOPPriv.getMapSysUniResCode(), null);
                    }
                }
                if ((psDEOPPrivs = iPSAppDataEntity.getPSDataEntity().getAllPSDEOPPrivs()) != null) {
                    while (psDEOPPrivs.hasNext()) {
                        IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                        if (!iPSDEOPPriv.isMapSysUniRes() || StringHelper.isNullOrEmpty((String)iPSDEOPPriv.getMapSysUniResCode())) continue;
                        this.accessKeyMap.put(iPSDEOPPriv.getMapSysUniResCode(), null);
                    }
                }
                if ((psAppDEReports = iPSAppDataEntity.getAllPSAppDEReports()) == null) continue;
                while (psAppDEReports.hasNext()) {
                    IPSAppDEReport iPSAppDEReport = psAppDEReports.next();
                    if (StringHelper.isNullOrEmpty((String)iPSAppDEReport.getSysUniResCode())) continue;
                    this.accessKeyMap.put(iPSAppDEReport.getSysUniResCode(), null);
                }
            }
            Iterator<IPSAppDEUIAction> psAppDEUIActions = this.getAllPSAppDEUIActions();
            if (psAppDEUIActions != null) {
                while (psAppDEUIActions.hasNext()) {
                    iPSAppDEUIAction = psAppDEUIActions.next();
                    IPSDEOPPriv iPSDEOPPriv = iPSAppDEUIAction.getPSDEOPPriv();
                    if (iPSDEOPPriv == null || !iPSDEOPPriv.isMapSysUniRes() || StringHelper.isNullOrEmpty((String)iPSDEOPPriv.getMapSysUniResCode())) continue;
                    this.accessKeyMap.put(iPSDEOPPriv.getMapSysUniResCode(), null);
                }
            }
            HashMap<String, IPSAppMethodDTO> psAppMethodDTOMap = new HashMap<String, IPSAppMethodDTO>();
            do {
                ArrayList<IPSAppMethodDTO> list = new ArrayList<IPSAppMethodDTO>();
                Iterator<IPSAppMethodDTO> psAppMethodDTOs = this.getAllPSAppMethodDTOs();
                if (psAppMethodDTOs != null) {
                    while (psAppMethodDTOs.hasNext()) {
                        IPSAppMethodDTO iPSAppMethodDTO = psAppMethodDTOs.next();
                        list.add(iPSAppMethodDTO);
                    }
                }
                bLoop = false;
                for (IPSAppMethodDTO iPSAppMethodDTO : list) {
                    if (psAppMethodDTOMap.containsKey(iPSAppMethodDTO.getCodeName())) continue;
                    iPSAppMethodDTO.check();
                    psAppMethodDTOMap.put(iPSAppMethodDTO.getCodeName(), iPSAppMethodDTO);
                    bLoop = true;
                }
            } while (bLoop);
            this.getAllPSMobAppStartPages();
            this.getAllPSMobAppIcons();
            this.getAllPSAppPortlets();
            this.registerPSApplicationLogics();
            HashMap<String, String> psViewTypeMap = new HashMap<String, String>();
            Iterator<IPSAppView> psAppViews2 = this.getAllPSAppViews();
            while (psAppViews2.hasNext()) {
                IPSAppView iPSAppView = psAppViews2.next();
                iPSAppView.checkViewEnv();
                if (!StringHelper.isNullOrEmpty((String)iPSAppView.getAccessKey())) {
                    this.accessKeyMap.put(iPSAppView.getAccessKey(), null);
                }
                psViewTypeMap.put(iPSAppView.getViewType(), "");
                if (this.bDynaSysModeDefined || this.nDynaSysMode != 0 || iPSAppView.getDynaSysMode() == 0) continue;
                this.nDynaSysMode = iPSAppView.getDynaSysMode();
            }
            if (this.isEnableUIModelEx() && (psSubViewTypes = this.getPSSystem().getAllPSSubViewTypes()) != null) {
                while (psSubViewTypes.hasNext()) {
                    IPSSubViewType iPSSubViewType = psSubViewTypes.next();
                    if (!iPSSubViewType.isReplaceDefault() || !psViewTypeMap.containsKey(iPSSubViewType.getViewType())) continue;
                    this.getPSSubViewType(iPSSubViewType.getId(), iPSSubViewType.getViewType());
                }
            }
            if ((psAppWFs = this.getAllPSAppWFs()) != null) {
                while (psAppWFs.hasNext()) {
                    IPSAppWF iPSAppWF = psAppWFs.next();
                    if (iPSAppWF == null) continue;
                    iPSAppWF.check();
                }
            }
            if ((psAppWFVers = this.getAllPSAppWFVers()) != null) {
                while (psAppWFVers.hasNext()) {
                    IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
                    if (iPSAppWFVer == null) continue;
                    iPSAppWFVer.check();
                }
            }
            if (this.isEnableUIModelEx() && this.isEnableBIScheme() && (psSysBISchemes = this.getPSSystem().getAllPSSysBISchemes()) != null) {
                while (psSysBISchemes.hasNext()) {
                    Iterator<? extends IPSSysBIReport> psSysBIReports;
                    IPSAppBICube iPSAppBICube;
                    IPSSysBIScheme iPSSysBIScheme = psSysBISchemes.next();
                    Iterator<? extends IPSSysBICube> psSysBICubes = iPSSysBIScheme.getAllPSSysBICubes();
                    if (psSysBICubes != null) {
                        while (psSysBICubes.hasNext()) {
                            IPSAppDataEntity iPSAppDataEntity;
                            IPSSysBICube iPSSysBICube = psSysBICubes.next();
                            if (iPSSysBICube.getPSDataEntity() == null || (iPSAppDataEntity = this.getPSAppDataEntity(iPSSysBICube.getPSDataEntity(), true)) == null || StringHelper.isNullOrEmpty((String)(iPSAppBICube = this.getPSAppBIScheme(iPSSysBIScheme).getPSAppBICube(iPSSysBICube, false)).getAccessKey())) continue;
                            this.accessKeyMap.put(iPSAppBICube.getAccessKey(), null);
                        }
                    }
                    if ((psSysBIReports = iPSSysBIScheme.getAllPSSysBIReports()) != null) {
                        while (psSysBIReports.hasNext()) {
                            IPSAppBIReport iPSAppBIReport;
                            IPSSysBIReport iPSSysBIReport = psSysBIReports.next();
                            if (iPSSysBIReport.getPSSysBICube() == null || (iPSAppBICube = this.getPSAppBIScheme(iPSSysBIScheme).getPSAppBICube(iPSSysBIReport.getPSSysBICube(), true)) == null || StringHelper.isNullOrEmpty((String)(iPSAppBIReport = this.getPSAppBIScheme(iPSSysBIScheme).getPSAppBIReport(iPSSysBIReport, false)).getAccessKey())) continue;
                            this.accessKeyMap.put(iPSAppBIReport.getAccessKey(), null);
                        }
                    }
                    iPSSysBIScheme.check();
                }
            }
            if (this.isEnableDynaDashboard()) {
                this.preparePSAppPortlets();
            }
            if ((psSysTestPrjs = this.getAllPSSysTestPrjs()) != null) {
                while (psSysTestPrjs.hasNext()) {
                    IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                    iPSSysTestPrj.check();
                }
            }
            this.logPSModelLoadLog(0, null, null);
            this.nLoadedLevel = nLoadLevel;
            this.bLoading = false;
        }
        catch (Exception ex) {
            this.logPSModelLoadLog(1, null, ex);
            this.getPSSystemUtil().log(1, this, ex.getMessage());
            this.bLoading = false;
            this.nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
            this.nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
            throw ex;
        }
    }

    protected void preparePSAppPortlets() throws Exception {
        if (this.psAppPortletGlobalModel.getAllModelHelperCount() > 0) {
            PSAppPortletContainerViewImpl psAppPortletContainerViewImpl = new PSAppPortletContainerViewImpl();
            psAppPortletContainerViewImpl.init(this.getDAGlobalHelper(), this);
            psAppPortletContainerViewImpl.checkViewEnv();
            this.containerPSAppViewList.add(psAppPortletContainerViewImpl);
        }
        this.psAppPortletList = new ArrayList<IPSAppPortlet>();
        this.appPSAppPortletList = new ArrayList<IPSAppPortlet>();
        LinkedHashMap<String, IPSSysPortlet> psSysPortletMap = new LinkedHashMap<String, IPSSysPortlet>();
        Iterator psAppPortlets = this.psAppPortletGlobalModel.getAllModelHelpers();
        if (psAppPortlets != null) {
            while (psAppPortlets.hasNext()) {
                IPSAppPortlet iPSAppPortlet = (IPSAppPortlet)psAppPortlets.next();
                if (iPSAppPortlet.getPSControl() == null) continue;
                this.psAppPortletList.add(iPSAppPortlet);
                if (iPSAppPortlet.getPSSysPortlet() == null) continue;
                psSysPortletMap.put(iPSAppPortlet.getPSSysPortlet().getId(), iPSAppPortlet.getPSSysPortlet());
            }
        }
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            ArrayList<IPSControl> psControlList = iPSAppView.getAllPSControls();
            if (psControlList == null) continue;
            for (IPSControl iPSControl : psControlList) {
                IPSDashboard iPSDashboard;
                Iterator<IPSDBPortletPart> psDBPortletParts;
                if (!(iPSControl instanceof IPSDashboard) || (psDBPortletParts = (iPSDashboard = (IPSDashboard)iPSControl).getAllPSPortlets()) == null) continue;
                while (psDBPortletParts.hasNext()) {
                    IPSDBSysPortletPart iPSDBSysPortletPart;
                    IPSDBPortletPart iPSDBPortletPart = psDBPortletParts.next();
                    if (iPSDBPortletPart instanceof IPSDBContainerPortletPart || iPSDBPortletPart instanceof IPSDBSysPortletPart && (iPSDBSysPortletPart = (IPSDBSysPortletPart)iPSDBPortletPart).getPSSysPortlet() != null && psSysPortletMap.containsKey(iPSDBSysPortletPart.getPSSysPortlet().getId())) continue;
                    PSAppPortletImpl psAppPortletImpl = new PSAppPortletImpl();
                    psAppPortletImpl.init(this.getDAGlobalHelper(), (IPSApplication)this, iPSDBPortletPart);
                    this.psAppPortletList.add(psAppPortletImpl);
                    if (psAppPortletImpl.getPSSysPortlet() == null) continue;
                    psSysPortletMap.put(psAppPortletImpl.getPSSysPortlet().getId(), psAppPortletImpl.getPSSysPortlet());
                }
            }
        }
        for (IPSAppPortlet iPSAppPortlet : this.psAppPortletList) {
            if (!iPSAppPortlet.isEnableAppDashboard()) continue;
            this.appPSAppPortletList.add(iPSAppPortlet);
        }
        Collections.sort(this.appPSAppPortletList, new Comparator<IPSAppPortlet>(){

            @Override
            public int compare(IPSAppPortlet o1, IPSAppPortlet o2) {
                return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
            }
        });
    }

    @Override
    public boolean isLoading() {
        return this.bLoading;
    }

    @Override
    public synchronized int getLoadedLevel() {
        return this.nLoadedLevel;
    }

    @Override
    public synchronized int getLoadingLevel() {
        return this.nLoadingLevel;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u5e94\u7528\u5f15\u7528\u96c6\u5408", child=true)
    public Iterator<IPSSubAppRef> getAllPSSubAppRefs() throws Exception {
        return EmptyPSSubAppRefList.iterator();
    }

    @Override
    public IPSSubAppRef getPSSubAppRefBySubApp(String strPSSubAppId, boolean bTryMode) throws Exception {
        return this.psSubAppRefGlobalModel.getPSSubAppRefBySubApp(strPSSubAppId, bTryMode);
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u9875\u9762\u96c6\u5408", child=true, group="\u5e94\u7528\u89c6\u56fe", order=195)
    public Iterator<IPSAppUtilPage> getAllPSAppUtilPages() throws Exception {
        return this.psAppUtilPageGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId) throws Exception {
        return this.getPSAppUtilPage(strPSAppUtilPageId, false);
    }

    @Override
    public IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId, boolean bTryMode) throws Exception {
        String strKey;
        IPSAppUtilPage iPSAppUtilPage;
        if (StringHelper.length((String)strPSAppUtilPageId) <= 20 && (iPSAppUtilPage = (IPSAppUtilPage)this.psAppUtilPageGlobalModel.FindModelHelper(strKey = KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSAppUtilPageId), true)) != null) {
            return iPSAppUtilPage;
        }
        return (IPSAppUtilPage)this.psAppUtilPageGlobalModel.FindModelHelper(strPSAppUtilPageId, bTryMode);
    }

    @Override
    public void resetPSAppUtilPage(String strPSAppUtilPageId) {
        this.psAppUtilPageGlobalModel.ResetModel(strPSAppUtilPageId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u6a21\u5f0f\u96c6\u5408", child=true, dynamodelmode=8, group="\u5e94\u7528\u89c6\u56fe", order=206)
    public Iterator<IPSAppUIStyle> getAllPSAppUIStyles() throws Exception {
        return this.psAppUIStyleGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppUIStyle getPSAppUIStyle(String strPSAppUIStyleId) throws Exception {
        return (IPSAppUIStyle)this.psAppUIStyleGlobalModel.FindModelHelper(strPSAppUIStyleId);
    }

    @Override
    public void resetPSAppUIStyle(String strPSAppUIStyleId) {
        this.psAppUIStyleGlobalModel.ResetModel(strPSAppUIStyleId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u4e3b\u9898\u96c6\u5408", child=true, group="\u5e94\u7528\u89c6\u56fe", order=205)
    public Iterator<IPSAppUITheme> getAllPSAppUIThemes() throws Exception {
        return this.psAppUIThemeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppUITheme getPSAppUITheme(String strPSAppUIThemeId) throws Exception {
        return (IPSAppUITheme)this.psAppUIThemeGlobalModel.FindModelHelper(strPSAppUIThemeId);
    }

    @Override
    public void resetPSAppUITheme(String strPSAppUIThemeId) {
        this.psAppUIThemeGlobalModel.ResetModel(strPSAppUIThemeId);
    }

    @Override
    public Object getPFStyleParam(String strKey) throws Exception {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getPFStyleParam(strKey);
        }
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey);
    }

    @Override
    public boolean getPFStyleParam(String strKey, boolean bDefault) throws Exception {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getPFStyleParam(strKey, bDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (boolean)bDefault);
    }

    @Override
    public String getPFStyleParam(String strKey, String strDefault) throws Exception {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getPFStyleParam(strKey, strDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (String)strDefault);
    }

    @Override
    public int getPFStyleParam(String strKey, int nDefault) throws Exception {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getPFStyleParam(strKey, nDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (int)nDefault);
    }

    @Override
    public double getPFStyleParam(String strKey, double fDefault) throws Exception {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getPFStyleParam(strKey, fDefault);
        }
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (double)fDefault);
    }

    @Override
    @PSModelRTMeta(description="\u4f7f\u7528\u670d\u52a1\u63a5\u53e3")
    public boolean isUseServiceApi() {
        return this.bUseServiceApi;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u5e94\u7528")
    public boolean isMobileApp() {
        return this.bMobileApp;
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public IPSAppView getPSAppViewByDEViewId(String strPSDEViewId, boolean bTryMode) throws Exception {
        IPSAppPDTView iPSAppPDTView;
        if (this.replacePSAppPDTViewMap != null && (iPSAppPDTView = this.replacePSAppPDTViewMap.get(strPSDEViewId)) != null) {
            return iPSAppPDTView.getPSAppView();
        }
        String strPSApplicationViewId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSDEViewId);
        IPSAppView iPSAppView = this.psApplicationViewGlobalModel.FindModelHelper(strPSApplicationViewId, true);
        if (iPSAppView == null && !bTryMode) {
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            CallResult callResult = this.getPSModelHelper().getPSDEViewBase(strPSDEViewId, psDEViewBase);
            if (callResult.isOk()) {
                if (this.getPSSystem().isDynaInstMode()) {
                    PSAppView psAppView = new PSAppView();
                    psAppView.setPSDEVIEWBASEID(psDEViewBase.getPSDEVIEWBASEID());
                    psAppView.setPSDEVIEWBASENAME(psDEViewBase.getPSDEVIEWBASENAME());
                    String strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getId(), (String)psDEViewBase.getPSDEVIEWBASEID());
                    String strPSAppDEViewName = String.format("Usr%1$07d%2$s", RANDOM.nextInt(9999999), psDEViewBase.getCODENAME());
                    IPSAppModule iPSAppModule = this.getDefaultPSAppModule();
                    if (iPSAppModule != null) {
                        psAppView.setPSAPPMODULEID(iPSAppModule.getId());
                        psAppView.setPSAPPMODULENAME(iPSAppModule.getName());
                    }
                    psAppView.setPSAPPVIEWID(strPSAppDEViewId);
                    psAppView.setPSAPPVIEWNAME(strPSAppDEViewName);
                    psAppView.setPSDEVIEWTYPE(psDEViewBase.getPSDEVIEWBASETYPE());
                    psAppView.setPSAPPVIEWTYPE("APPDEVIEW");
                    return this.psApplicationViewGlobalModel.registerPSAppView(psAppView);
                }
                String strInfo = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]\uff0c\u8bf7\u786e\u8ba4\u5b9e\u4f53\u89c6\u56fe[%2$s][%3$s]\u5df2\u7ecf\u6dfb\u52a0\u5230\u5e94\u7528[%4$s]\u4e2d", (Object)strPSApplicationViewId, (Object)psDEViewBase.getPSDENAME(), (Object)psDEViewBase.getPSDEVIEWBASENAME(), (Object)this.getName());
                throw new PSApplicationException(this, 40012, strInfo, strPSApplicationViewId, strPSDEViewId);
            }
            String strInfo = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]\uff0c\u6307\u5b9a\u4e86\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u89c6\u56fe[%2$s]", (Object)strPSApplicationViewId, (Object)strPSDEViewId);
            throw new PSApplicationException(this, 40012, strInfo, strPSApplicationViewId, null);
        }
        return iPSAppView;
    }

    @Override
    public IPSAppUserMode getPSAppUserMode(String strPSAppUserModeId) throws Exception {
        return (IPSAppUserMode)this.psAppUserModeGlobalModel.FindModelHelper(strPSAppUserModeId);
    }

    @Override
    public void resetPSAppUserMode(String strPSAppUserModeId) {
        this.psAppUserModeGlobalModel.ResetModel(strPSAppUserModeId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u7528\u6237\u6a21\u5f0f\u96c6\u5408", child=true, dynamodelmode=8, group="\u8bbf\u95ee\u63a7\u5236", order=520)
    public Iterator<IPSAppUserMode> getAllPSAppUserModes() throws Exception {
        return this.psAppUserModeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppMenuModel getPSAppMenuModel(String strPSAppMenuModelId) throws Exception {
        return (IPSAppMenuModel)this.psAppMenuModelGlobalModel.FindModelHelper(strPSAppMenuModelId);
    }

    @Override
    public void resetPSAppMenuModel(String strPSAppMenuModelId) {
        this.psAppMenuModelGlobalModel.ResetModel(strPSAppMenuModelId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u6a21\u578b\u96c6\u5408", child=true, dumpref=true, ignorert=3, group="\u754c\u9762\u903b\u8f91", order=322)
    public Iterator<IPSAppMenuModel> getAllPSAppMenuModels() throws Exception {
        return this.psAppMenuModelGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getModelType() {
        return "PSSYSAPP";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u7248\u672c")
    public String getAppVersion() {
        return "1.0.0.0";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFStyle getPSPFStyle(String strPSPFStyleId) throws Exception {
        IPSPFStyle iPSPFStyle = this.getPSPFStyle();
        if (StringHelper.compare((String)iPSPFStyle.getId(), (String)strPSPFStyleId, (boolean)false) == 0) {
            return iPSPFStyle;
        }
        if (this.getPSPFStyle() instanceof IPSPFStyle2) {
            throw new Exception("\u5e94\u7528\u4e0d\u652f\u6301\u591a\u6837\u5f0f\u6a21\u5f0f");
        }
        Map<String, IPSPFStyle> map = this.psPFStyleMap;
        synchronized (map) {
            iPSPFStyle = this.psPFStyleMap.get(strPSPFStyleId);
        }
        if (iPSPFStyle != null) {
            return iPSPFStyle;
        }
        iPSPFStyle = this.getPSPF().getPSPFStyle(strPSPFStyleId);
        map = this.psPFStyleMap;
        synchronized (map) {
            this.psPFStyleMap.put(strPSPFStyleId, iPSPFStyle);
        }
        return iPSPFStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u76ee\u5f55\u540d\u79f0")
    public String getAppFolder() {
        if (PSJITWebContext.getInstance() != null) {
            return PSJITWebContext.getInstance().getPSAppName();
        }
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getAppFolder();
        }
        return this.strAppFolder;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8bed\u8a00\u96c6\u5408", child=true, dumpref=true, ignorert=3)
    public Iterator<IPSAppLan> getAllPSAppLans() throws Exception {
        return this.psAppLanGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppLan getPSAppLan(String strPSAppLanId) throws Exception {
        return (IPSAppLan)this.psAppLanGlobalModel.FindModelHelper(strPSAppLanId);
    }

    @Override
    public void resetPSAppLan(String strPSAppLanId) {
        this.psAppLanGlobalModel.ResetModel(strPSAppLanId);
    }

    @Override
    public String getMainMenuAlign() {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getMainMenuAlign();
        }
        return this.strMainMenuAlign;
    }

    @Override
    public Iterator<IPSAppPkg> getPSAppPkgs() throws Exception {
        return this.psAppPkgGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSPFPkgVer> getPSPFPkgVers() throws Exception {
        return this.psPFPkgVerList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u7ec4\u4ef6\u5305\u96c6\u5408", child=true, ignorepf=true, dynamodelmode=8, group="\u6a21\u677f\u6269\u5c55", order=616)
    public Iterator<IPSAppPkg> getAllPSAppPkgs() throws Exception {
        return this.psAppPkgGlobalModel.getAllModelHelpers();
    }

    @Override
    public Iterator<IPSPFPkgVer> getAllPSPFPkgVers() throws Exception {
        return this.psPFPkgVerList.iterator();
    }

    @Override
    public boolean isEnableMultiLan() {
        return this.psAppLanGlobalModel.isEnableMultiLan();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528CDN")
    public IPSPFCDN getPSPFCDN() {
        return this.iPSPFCDN;
    }

    @Override
    public int check() throws Exception {
        Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs;
        Iterator<IPSAppMethodDTO> psAppMethodDTOs;
        if (this.getLoadedLevel() <= IPSSystem.LOADLEVEL_NONE) {
            throw new Exception("\u5e94\u7528\u8fd8\u672a\u52a0\u8f7d");
        }
        super.check();
        this.psAppModuleGlobalModel.checkAll();
        this.psAppLanGlobalModel.checkAll();
        this.psAppUtilPageGlobalModel.checkAll();
        this.psAppFuncGlobalModel.checkAll();
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            iPSAppView.check();
        }
        Iterator<IPSSysTestPrj> psSysTestPrjs = this.getAllPSSysTestPrjs();
        if (psSysTestPrjs != null) {
            while (psSysTestPrjs.hasNext()) {
                IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                iPSSysTestPrj.check();
            }
        }
        if ((psAppMethodDTOs = this.getAllPSAppMethodDTOs()) != null) {
            while (psAppMethodDTOs.hasNext()) {
                IPSAppMethodDTO iPSAppMethodDTO = psAppMethodDTOs.next();
                iPSAppMethodDTO.check();
            }
        }
        if ((psAppSubViewTypeRefs = this.getAllPSAppSubViewTypeRefs()) != null) {
            while (psAppSubViewTypeRefs.hasNext()) {
                IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
                iPSAppSubViewTypeRef.check();
            }
        }
        return -1;
    }

    protected void calcRelatedPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> relatedPSAppViewMap) throws Exception {
        if (relatedPSAppViewMap.containsKey(iPSAppView.getId())) {
            return;
        }
        relatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
        ArrayList<IPSAppView> relatedPSAppViewList = new ArrayList<IPSAppView>();
        iPSAppView.fillRelatedPSAppViews(relatedPSAppViewList);
        for (IPSAppView relatedPSAppView : relatedPSAppViewList) {
            this.calcRelatedPSAppViews(relatedPSAppView, relatedPSAppViewMap);
        }
    }

    @Override
    public void calcPSAppViewSysRefFlag() throws Exception {
        Iterator<IPSAppWFVer> psAppWFVers;
        Iterator<IPSAppWF> psAppWFs;
        Iterator<IPSAppPortlet> psAppPortlets;
        log.debug((Object)StringHelper.format((String)"\u8ba1\u7b97\u5e94\u7528[%1$s]\u7cfb\u7edf\u5f15\u7528\u89c6\u56fe", (Object)this.getName()));
        HashMap<String, IPSAppView> relatedPSAppViewMap = new HashMap<String, IPSAppView>();
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            if (!iPSAppView.isUserRefMode()) continue;
            this.calcRelatedPSAppViews(iPSAppView, relatedPSAppViewMap);
        }
        ArrayList<IPSAppView> relatedList = new ArrayList<IPSAppView>();
        Iterator<IPSAppUserMode> psAppUserModes = this.getAllPSAppUserModes();
        if (psAppUserModes != null) {
            while (psAppUserModes.hasNext()) {
                IPSAppMenuModel iPSAppMenuModel;
                Iterator<IPSAppFunc> psAppFuncs;
                IPSAppUserMode iPSAppUserMode = psAppUserModes.next();
                if (iPSAppUserMode.getPSAppMenuModel() == null || (psAppFuncs = (iPSAppMenuModel = iPSAppUserMode.getPSAppMenuModel()).getPSAppFuncs()) == null) continue;
                while (psAppFuncs.hasNext()) {
                    IPSAppFunc iPSAppFunc = psAppFuncs.next();
                    iPSAppFunc.fillRelatedPSAppViews(relatedList);
                }
            }
        }
        if ((psAppPortlets = this.getAllPSAppPortlets()) != null) {
            while (psAppPortlets.hasNext()) {
                IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                if (iPSAppPortlet.getPSControl() == null) continue;
                iPSAppPortlet.getPSControl().fillRelatedPSAppViews(relatedList);
            }
        }
        if ((psAppWFs = this.getAllPSAppWFs()) != null) {
            while (psAppWFs.hasNext()) {
                IPSAppWF iPSAppWF = psAppWFs.next();
                Iterator<IPSAppView> psAppViews2 = iPSAppWF.getAllPSAppViews();
                if (psAppViews2 == null) continue;
                while (psAppViews2.hasNext()) {
                    relatedList.add(psAppViews2.next());
                }
            }
        }
        if ((psAppWFVers = this.getAllPSAppWFVers()) != null) {
            while (psAppWFVers.hasNext()) {
                IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
                Iterator<Object> psAppViews2 = iPSAppWFVer.getAllPSAppViews();
                if (psAppViews2 == null) continue;
                while (psAppViews2.hasNext()) {
                    relatedList.add((IPSAppView)psAppViews2.next());
                }
            }
        }
        for (IPSAppView iPSAppView : relatedList) {
            this.calcRelatedPSAppViews(iPSAppView, relatedPSAppViewMap);
        }
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.iPSSystem.getPSSysModelInstId());
        IService psAppViewService = ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)sessionFactory);
        this.resetAllPSAppViewSysRefFlag(psAppViewService);
        int nTotal = 0;
        int nUsed = 0;
        psAppViews = this.getAllPSAppViews();
        boolean bChanged = false;
        while (psAppViews.hasNext()) {
            ++nTotal;
            IPSAppView iPSAppView = psAppViews.next();
            if (relatedPSAppViewMap.containsKey(iPSAppView.getId())) {
                ++nUsed;
                if (iPSAppView.getSysRefFlag()) continue;
                this.updatePSAppViewSysRefFlag(psAppViewService, iPSAppView, true);
                ((IPSAppViewRuntime)((Object)iPSAppView)).updateSysRefFlag(true);
                bChanged = true;
                continue;
            }
            if (!iPSAppView.getSysRefFlag()) continue;
            this.updatePSAppViewSysRefFlag(psAppViewService, iPSAppView, false);
            ((IPSAppViewRuntime)((Object)iPSAppView)).updateSysRefFlag(false);
            bChanged = true;
        }
        if (bChanged) {
            PSSysModelLogService psSysModelLogService = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, (SessionFactory)sessionFactory);
            PSSysModelLog psSysModelLog = new PSSysModelLog();
            psSysModelLog.setPSSystemId(this.getPSSystem().getId());
            psSysModelLog.setPSSystemName("(N/A)");
            psSysModelLog.setPSSysModelLogName("PSAPPVIEW");
            psSysModelLogService.save((IEntity)psSysModelLog, false);
            log.debug((Object)StringHelper.format((String)"\u7cfb\u7edf\u5f15\u7528\u89c6\u56fe\u6709\u53d8\u5316\uff0c\u66f4\u65b0\u7f13\u5b58\u6807\u8bb0"));
        }
        log.debug((Object)StringHelper.format((String)"\u8ba1\u7b97\u7cfb\u7edf\u5f15\u7528\u89c6\u56fe\u5b8c\u6210\uff0c\u603b\u5171[%1$s]\uff0c\u5f15\u7528[%2$s]", (Object)nTotal, (Object)nUsed));
    }

    protected void updatePSAppViewSysRefFlag(IService psAppViewService, IPSAppView iPSAppView, boolean bSysRefFlag) throws Exception {
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.add((Object)(bSysRefFlag ? 1 : 0), 9);
        sqlParamList.add((Object)iPSAppView.getId(), 25);
        psAppViewService.executeRaw(this.strUpdatePSAppViewSysRefFlagSql, sqlParamList);
    }

    protected void resetAllPSAppViewSysRefFlag(IService psAppViewService) throws Exception {
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.add((Object)this.getId(), 25);
        psAppViewService.executeRaw(this.strResetPSAppViewSysRefFlagSql, sqlParamList);
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u53d1\u5e03\u5f15\u7528\u89c6\u56fe", dump=false)
    public boolean isPubRefViewOnly() {
        return this.bPubSysRefViewOnly;
    }

    @Override
    public IPSMobAppStartPage getPSMobAppStartPage(String strPSMobAppStartPageId, boolean bTryMode) throws Exception {
        return (IPSMobAppStartPage)this.psMobAppStartPageGlobalModel.FindModelHelper(strPSMobAppStartPageId, bTryMode);
    }

    @Override
    public void resetPSMobAppStartPage(String strPSMobAppStartPageId) {
        this.psMobAppStartPageGlobalModel.ResetModel(strPSMobAppStartPageId);
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u8d77\u59cb\u9875\u96c6\u5408", group="\u79fb\u52a8\u7aef", order=370)
    public Iterator<IPSMobAppStartPage> getAllPSMobAppStartPages() throws Exception {
        return this.psMobAppStartPageGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSMobAppPack getPSMobAppPack(String strPSMobAppPackId) throws Exception {
        return (IPSMobAppPack)this.psMobAppPackGlobalModel.FindModelHelper(strPSMobAppPackId);
    }

    @Override
    public void resetPSMobAppPack(String strPSMobAppPackId) {
        this.psMobAppPackGlobalModel.ResetModel(strPSMobAppPackId);
    }

    @Override
    public IPSMobAppIcon getPSMobAppIcon(String strPSMobAppIconId, boolean bTryMode) throws Exception {
        return (IPSMobAppIcon)this.psMobAppIconGlobalModel.FindModelHelper(strPSMobAppIconId, bTryMode);
    }

    @Override
    public void resetPSMobAppIcon(String strPSMobAppIconId) {
        this.psMobAppIconGlobalModel.ResetModel(strPSMobAppIconId);
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u56fe\u6807\u96c6\u5408", group="\u79fb\u52a8\u7aef", order=375)
    public Iterator<IPSMobAppIcon> getAllPSMobAppIcons() throws Exception {
        return this.psMobAppIconGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSMobAppPackCert getPSMobAppPackCert(String strPSMobAppPackCertId) throws Exception {
        return (IPSMobAppPackCert)this.psMobAppPackCertGlobalModel.FindModelHelper(strPSMobAppPackCertId);
    }

    @Override
    public void resetPSMobAppPackCert(String strPSMobAppPackCertId) {
        this.psMobAppPackCertGlobalModel.ResetModel(strPSMobAppPackCertId);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
        PSLogItemImpl psLogItemImpl = new PSLogItemImpl();
        psLogItemImpl.setLogLevel(nLogLevel);
        psLogItemImpl.setLogInfo(strInfo);
        psLogItemImpl.setPSObject(iPSModelObject);
        psLogItemImpl.setUserData(strUserData);
        psLogItemImpl.setUserData2(strUserData2);
        this.psLogItemList.add(psLogItemImpl);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }

    protected void logPSModelLoadLog(int nLogLevel, String strInfo, Throwable exception) {
        try {
            if (this.getPSSystem().isDynaInstMode()) {
                return;
            }
            final StringBuilderEx sb = new StringBuilderEx();
            for (IPSLogItem iPSLogItem : this.psLogItemList) {
                sb.append("%1$s\r\n", (Object)PSLogItemImpl.toString(iPSLogItem));
                if (iPSLogItem.getLogLevel() <= nLogLevel) continue;
                nLogLevel = iPSLogItem.getLogLevel();
            }
            final int nLogLevel2 = nLogLevel;
            final StringBuilderEx sb2 = new StringBuilderEx();
            if (!StringHelper.isNullOrEmpty((String)strInfo)) {
                sb2.append("%1$s\r\n", (Object)strInfo);
            }
            if (exception != null) {
                sb2.append("\u6a21\u578b\u52a0\u8f7d\u53d1\u751f\u5f02\u5e38\uff1a");
                exception.printStackTrace(new PrintWriter(sb2.getWriter()));
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSysModelLoadLog psSysModelLoadLog = new PSSysModelLoadLog();
                    PSSysModelLoadLogService psSysModelLoadLogService = (PSSysModelLoadLogService)ServiceGlobal.getService(PSSysModelLoadLogService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)PSApplicationImpl.this.getRuntimePSSysModelInstId()));
                    psSysModelLoadLog.setPSObjType("PSSYSAPP");
                    psSysModelLoadLog.setPSSystemId(PSApplicationImpl.this.getPSSystem().getId());
                    psSysModelLoadLog.setPSSystemName(PSApplicationImpl.this.getPSSystem().getName());
                    psSysModelLoadLog.setPSObjId(PSApplicationImpl.this.getId());
                    psSysModelLoadLog.setPSObjName(PSApplicationImpl.this.getName());
                    psSysModelLoadLog.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                    psSysModelLoadLog.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
                    switch (nLogLevel2) {
                        case 0: {
                            psSysModelLoadLog.setLogLevel("OK");
                            break;
                        }
                        case 4: {
                            psSysModelLoadLog.setLogLevel("WARN");
                            break;
                        }
                        case 1: {
                            psSysModelLoadLog.setLogLevel("ERROR");
                        }
                    }
                    psSysModelLoadLog.setPSSysModelLoadLogName(StringHelper.format((String)"[%1$s]\u52a0\u8f7d\u65e5\u5fd7", (Object)PSApplicationImpl.this.getName()));
                    psSysModelLoadLog.setLogInfo(sb.toString());
                    psSysModelLoadLog.setExceptionInfo(sb2.toString());
                    psSysModelLoadLogService.save((IEntity)psSysModelLoadLog);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public int getButtonNoPrivDisplayMode() {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getButtonNoPrivDisplayMode();
        }
        return this.nButtonNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u8bbe\u7f6e")
    public IPSApplicationUI getPSApplicationUI() {
        return this.psApplicationUIProxy;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u6a21\u5f0f")
    public IPSAppUIStyle getPSAppUIStyle() {
        return this.iPSAppUIStyle;
    }

    @Override
    public Iterator<IPSSysCss> getAllPSSysCsses(boolean bRefOnly) throws Exception {
        LinkedHashMap<String, IPSSysCss> psSysCssMap = new LinkedHashMap<String, IPSSysCss>();
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            Iterator<IPSSysCss> psSysCsses;
            IPSAppView iPSAppView = psAppViews.next();
            if (bRefOnly && !iPSAppView.getRefFlag() || (psSysCsses = iPSAppView.getPSSysCsses()) == null) continue;
            while (psSysCsses.hasNext()) {
                IPSSysCss iPSSysCss = psSysCsses.next();
                psSysCssMap.put(iPSSysCss.getId(), iPSSysCss);
            }
        }
        return psSysCssMap.values().iterator();
    }

    @Override
    public Iterator<IPSSysImage> getAllPSSysImages(boolean bRefOnly) throws Exception {
        LinkedHashMap<String, IPSSysImage> psSysImageMap = new LinkedHashMap<String, IPSSysImage>();
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            Iterator<IPSSysImage> psSysImages;
            IPSAppView iPSAppView = psAppViews.next();
            if (bRefOnly && !iPSAppView.getRefFlag() || (psSysImages = iPSAppView.getPSSysImages()) == null) continue;
            while (psSysImages.hasNext()) {
                IPSSysImage iPSSysImage = psSysImages.next();
                psSysImageMap.put(iPSSysImage.getId(), iPSSysImage);
            }
        }
        return psSysImageMap.values().iterator();
    }

    @Override
    public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins(boolean bRefOnly) throws Exception {
        LinkedHashMap<String, IPSSysPFPlugin> psPFPluginMap = new LinkedHashMap<String, IPSSysPFPlugin>();
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            Iterator<IPSSysPFPlugin> psPFPlugines;
            IPSAppView iPSAppView = psAppViews.next();
            if (bRefOnly && !iPSAppView.getRefFlag() || (psPFPlugines = iPSAppView.getPSSysPFPlugins()) == null) continue;
            while (psPFPlugines.hasNext()) {
                IPSSysPFPlugin iPSPFPlugin = psPFPlugines.next();
                psPFPluginMap.put(iPSPFPlugin.getId(), iPSPFPlugin);
            }
        }
        return psPFPluginMap.values().iterator();
    }

    @Override
    public Iterator<? extends IPSAppViewMsgGroup> getAllPSAppViewMsgGroups(boolean bRefOnly) throws Exception {
        if (bRefOnly) {
            LinkedHashMap<String, IPSAppViewMsgGroup> psViewMsgGroupMap = new LinkedHashMap<String, IPSAppViewMsgGroup>();
            Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                if (bRefOnly && !iPSAppView.getRefFlag() || iPSAppView.getPSViewMsgGroup() == null || !(iPSAppView.getPSViewMsgGroup() instanceof IPSAppViewMsgGroup)) continue;
                psViewMsgGroupMap.put(iPSAppView.getPSViewMsgGroup().getId(), (IPSAppViewMsgGroup)iPSAppView.getPSViewMsgGroup());
            }
            return psViewMsgGroupMap.values().iterator();
        }
        return PSModelUtil.sort(this.psAppViewMsgGroupMap, IPSAppViewMsgGroup.class).iterator();
    }

    @Override
    @Deprecated
    public Iterator<? extends IPSViewMsgGroup> getAllPSViewMsgGroups(boolean bRefOnly) throws Exception {
        return this.getAllPSAppViewMsgGroups(bRefOnly);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5f15\u7528\u7cfb\u7edf\u6837\u5f0f\u8868\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysCss> getAllPSSysCsses() throws Exception {
        return this.getAllPSSysCsses(this.isPubRefViewOnly());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5f15\u7528\u7cfb\u7edf\u56fe\u7247\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysImage> getAllPSSysImages() throws Exception {
        return this.getAllPSSysImages(this.isPubRefViewOnly());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u524d\u7aef\u63d2\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins() throws Exception {
        return this.getAllPSSysPFPlugins(this.isPubRefViewOnly());
    }

    @Override
    public Iterator<? extends IPSAppViewMsgGroup> getAllPSViewMsgGroups() throws Exception {
        return this.getAllPSAppViewMsgGroups(this.isPubRefViewOnly());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u52a8\u89c6\u56fe", group="\u5e94\u7528\u89c6\u56fe", order=182)
    public IPSAppView getDefaultPSAppView() throws Exception {
        IPSAppView iPSAppView;
        if (this.getPSAppUIStyle() != null && this.getPSAppUIStyle().getDefaultPSAppView() != null) {
            return this.getPSAppUIStyle().getDefaultPSAppView();
        }
        if (this.defaultPSAppView != null) {
            return this.defaultPSAppView;
        }
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            iPSAppView = psAppViews.next();
            if (!(iPSAppView instanceof IPSAppIndexView) || !((IPSAppIndexView)iPSAppView).isDefaultPage()) continue;
            this.defaultPSAppView = iPSAppView;
            return this.defaultPSAppView;
        }
        psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            iPSAppView = psAppViews.next();
            if (!(iPSAppView instanceof IPSAppPortalView) || !((IPSAppPortalView)iPSAppView).isDefaultPage()) continue;
            this.defaultPSAppView = iPSAppView;
            return this.defaultPSAppView;
        }
        return null;
    }

    @Override
    public boolean isEnableCol12ToCol24() {
        return this.bEnableCol12ToCol24;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u52a8\u9996\u9875\u89c6\u56fe", dumpref=true, outputdoc="false", doc="\u8ba1\u7b97\u9ed8\u8ba4\u7684\u5e94\u7528\u9996\u9875\u89c6\u56fe", ignorert=3)
    public IPSAppIndexView getDefaultPSAppIndexView() throws Exception {
        if (this.getPSAppUIStyle() != null && this.getPSAppUIStyle().getDefaultPSAppIndexView() != null) {
            return this.getPSAppUIStyle().getDefaultPSAppIndexView();
        }
        if (this.defaultPSAppIndexView != null) {
            return this.defaultPSAppIndexView;
        }
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            if (!(iPSAppView instanceof IPSAppIndexView) || !((IPSAppIndexView)iPSAppView).isDefaultPage()) continue;
            this.defaultPSAppIndexView = (IPSAppIndexView)iPSAppView;
            return this.defaultPSAppIndexView;
        }
        return null;
    }

    @Override
    public IPSAppLocalDE getPSAppLocalDE(String strPSAppLocalDEId) throws Exception {
        return (IPSAppLocalDE)this.psAppDataEntityGlobalModel.FindModelHelper(strPSAppLocalDEId);
    }

    @Override
    public void resetPSAppLocalDE(String strPSAppLocalDEId) {
        this.psAppDataEntityGlobalModel.ResetModel(strPSAppLocalDEId);
    }

    @Override
    public Iterator<? extends IPSAppLocalDE> getAllPSAppLocalDEs() throws Exception {
        return this.psAppDataEntityGlobalModel.getAllModelHelpers();
    }

    @Override
    public boolean isAutoAddAppDEView() {
        return this.bAutoAddAppDEView;
    }

    @Override
    public boolean isGridForceFit() {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().isGridForceFit();
        }
        return this.bGridForceFit;
    }

    @Override
    public boolean isGridEnableCustomized() {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().isGridEnableCustomized();
        }
        return this.bGridEnableCustomized;
    }

    @Override
    public int getGridRowActiveMode() {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getGridRowActiveMode();
        }
        return this.nGridRowActiveMode;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSystem().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u540d\u79f0")
    public String getServiceCodeName() {
        if (StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
            return this.getPKGCodeName();
        }
        return this.strServiceCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7edf\u4e00\u8ba4\u8bc1\u767b\u5f55")
    public boolean isEnableUACLogin() {
        return this.bEnableUACLogin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }

    @Override
    public boolean isPreviewMode() {
        return this.bPreviewMode;
    }

    @Override
    public void markPSAppViewUsage(String strPSAppViewId, int nViewUsage, Object objRef) {
        Integer nUsage = this.psAppViewUsageMap.get(strPSAppViewId);
        if (nUsage == null) {
            nUsage = 0;
        }
        nUsage = nUsage | nViewUsage;
        this.psAppViewUsageMap.put(strPSAppViewId, nUsage);
    }

    @Override
    public int getPSAppViewUsage(String strPSAppViewId) {
        Integer nUsage = this.psAppViewUsageMap.get(strPSAppViewId);
        if (nUsage == null) {
            return 0;
        }
        return nUsage;
    }

    @Override
    public String getWorkshopName() {
        if (this.getPSAppUIStyle() != null) {
            return StringHelper.format((String)"%1$s%2$s", (Object)this.getPKGCodeName(), (Object)this.getPSAppUIStyle().getStyleCode());
        }
        return this.getPKGCodeName();
    }

    @Override
    public IPSPF getDefaultPSPF() {
        return this.defaultPSPF;
    }

    @Override
    public IPSPFStyle getDefaultPSPFStyle() {
        return this.defaultPSPFStyle;
    }

    @Override
    public boolean isEnableDynaSys() {
        return PSApplicationImpl.isDynaModelCodeGenMode() || this.bEnableDynaSys && this.getPSSystem().isEnableDynaSys();
    }

    @Override
    public int getFormItemNoPrivDisplayMode() {
        return this.nFormItemNoPrivDisplayMode;
    }

    @Override
    public int getGridColumnNoPrivDisplayMode() {
        return this.nGridColumnNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u89c6\u56fe\u96c6\u5408", group="\u5e94\u7528\u89c6\u56fe", order=200)
    public Iterator<IPSAppPDTView> getAllPSAppPDTViews() throws Exception {
        return this.psAppPDTViewGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppPDTView getPSAppPDTView(String strPSAppPDTViewId, boolean bTryMode) throws Exception {
        return (IPSAppPDTView)this.psAppPDTViewGlobalModel.FindModelHelper(strPSAppPDTViewId, bTryMode);
    }

    @Override
    public void resetPSAppPDTView(String strPSAppPDTViewId) {
        this.psAppPDTViewGlobalModel.ResetModel(strPSAppPDTViewId);
    }

    @Override
    public boolean isOutputFormItemUpdatePrivTag() {
        return this.bOutputFormItemUpdateTag;
    }

    @Override
    public String getUIStyle() {
        if (this.getPSAppUIStyle() != null) {
            return this.getPSAppUIStyle().getUIStyle();
        }
        return this.strUIStyle;
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity(String strPSAppDataEntityId, boolean bTryMode) throws Exception {
        return (IPSAppDataEntity)this.psAppDataEntityGlobalModel.FindModelHelper(strPSAppDataEntityId, bTryMode);
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntityByDEId(String strPSDEId, boolean bTryMode) throws Exception {
        IPSDataEntity iPSDataEntity = this.getPSSystem().getPSDataEntity(strPSDEId);
        if (iPSDataEntity == null) {
            if (!bTryMode) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)strPSDEId));
            }
            return null;
        }
        return this.getPSAppDataEntity(iPSDataEntity, bTryMode);
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity(IPSDataEntity iPSDataEntity, boolean bTryMode) throws Exception {
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity(KeyValueHelper.genUniqueId((String)this.getId(), (String)iPSDataEntity.getId()), true);
        if (iPSAppDataEntity != null || bTryMode) {
            return iPSAppDataEntity;
        }
        throw new Exception(StringHelper.format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53[%2$s]", (Object)this.getName(), (Object)iPSDataEntity.getName()));
    }

    @Override
    public void resetPSAppDataEntity(String strPSAppDataEntityId) {
        this.psAppDataEntityGlobalModel.ResetModel(strPSAppDataEntityId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u96c6\u5408", dumpref=true, child=true, rtdump=2, ignorert=3, modelreftype="APPLICATION", group="\u6a21\u578b&\u63a5\u53e3", order=170)
    public Iterator<IPSAppDataEntity> getAllPSAppDataEntities() throws Exception {
        return this.psAppDataEntityGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u6a21\u5f0f", dump=false)
    public String getBackendMode() {
        return this.strBackendMode;
    }

    public boolean isEnableFolderKey() {
        return this.bEnableFolderKey;
    }

    @Override
    public String getProjectPath() {
        return this.strProjectPath;
    }

    @Override
    public Iterator<IPSAppFunc> getPSAppFuncsByTag(String strPreFix) throws Exception {
        strPreFix = strPreFix.toUpperCase();
        ArrayList<IPSAppFunc> psAppFuncList = new ArrayList<IPSAppFunc>();
        Iterator<IPSAppFunc> psAppFuncs = this.getAllPSAppFuncs();
        if (psAppFuncs != null) {
            while (psAppFuncs.hasNext()) {
                IPSAppFunc iPSAppFunc = psAppFuncs.next();
                if (StringHelper.isNullOrEmpty((String)iPSAppFunc.getCodeName()) || iPSAppFunc.getCodeName().toUpperCase().indexOf(strPreFix) != 0) continue;
                psAppFuncList.add(iPSAppFunc);
            }
        }
        Collections.sort(psAppFuncList, new Comparator<IPSAppFunc>(){

            @Override
            public int compare(IPSAppFunc o1, IPSAppFunc o2) {
                return o1.getCodeName().compareTo(o2.getCodeName());
            }
        });
        return psAppFuncList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=345)
    public Iterator<IPSAppUILogic> getAllPSAppUILogics() throws Exception {
        return this.psAppUILogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppUILogic getPSAppUILogic(String strPSAppUILogicId) throws Exception {
        return (IPSAppUILogic)this.psAppUILogicGlobalModel.FindModelHelper(strPSAppUILogicId);
    }

    @Override
    public void resetPSAppUILogic(String strPSAppUILogicId) {
        this.psAppUILogicGlobalModel.ResetModel(strPSAppUILogicId);
    }

    @Override
    public String getDefaultControlStyle() {
        try {
            return this.getPFStyleParam(PFSTYLEPARAM_DEFAULTCONTROLSTYLE, "");
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return "";
        }
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u89c6\u56fe\u4f18\u5148\u7ea7", dump=false)
    public Integer getDefaultAppViewPriority() {
        try {
            String value = this.getPFStyleParam(PFSTYLEPARAM_DEFAULTAPPVIEWPRIORITY, "");
            if (StringUtils.hasLength((String)value)) {
                return Integer.parseInt(value);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5e94\u7528\u89c6\u56fe\u754c\u9762\u6837\u5f0f")
    public IPSSysCss getDefaultAppViewPSSysCss() {
        return this.defaultAppViewPSSysCss;
    }

    @Override
    public IPSAppWF getPSAppWF(String strPSAppWFId) throws Exception {
        return (IPSAppWF)this.psAppWFGlobalModel.FindModelHelper(strPSAppWFId);
    }

    @Override
    public IPSAppWF getPSAppWF(String strPSAppWFId, boolean bTryMode) throws Exception {
        return this.psAppWFGlobalModel.FindModelHelper(strPSAppWFId, bTryMode);
    }

    @Override
    public void resetPSAppWF(String strPSAppWFId) {
        this.psAppWFGlobalModel.ResetModel(strPSAppWFId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u96c6\u5408", child=true, group="\u5de5\u4f5c\u6d41", order=425)
    public Iterator<IPSAppWF> getAllPSAppWFs() throws Exception {
        return this.psAppWFGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppWFVer getPSAppWFVer(String strPSAppWFVerId) throws Exception {
        return (IPSAppWFVer)this.psAppWFVerGlobalModel.FindModelHelper(strPSAppWFVerId);
    }

    @Override
    public IPSAppWFVer getPSAppWFVer(String strPSAppWFVerId, boolean bTryMode) throws Exception {
        return (IPSAppWFVer)this.psAppWFVerGlobalModel.FindModelHelper(strPSAppWFVerId, bTryMode);
    }

    @Override
    public void resetPSAppWFVer(String strPSAppWFVerId) {
        this.psAppWFVerGlobalModel.ResetModel(strPSAppWFVerId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c\u96c6\u5408", group="\u5de5\u4f5c\u6d41", order=427)
    public Iterator<IPSAppWFVer> getAllPSAppWFVers() throws Exception {
        return this.psAppWFVerGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3")
    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u8d44\u6e90\u96c6\u5408", child=true)
    public Iterator<IPSAppResource> getAllPSAppResources() throws Exception {
        return this.psAppResourceGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppResource getPSAppResource(String strPSAppResourceId) throws Exception {
        return this.getPSAppResource(strPSAppResourceId, false);
    }

    @Override
    public IPSAppResource getPSAppResource(String strPSAppResourceId, boolean bTryMode) throws Exception {
        return (IPSAppResource)this.psAppResourceGlobalModel.FindModelHelper(strPSAppResourceId, bTryMode);
    }

    @Override
    public void resetPSAppResource(String strPSAppResourceId) {
        this.psAppResourceGlobalModel.ResetModel(strPSAppResourceId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u96c6\u5408", child=true, ignorert=3, group="\u6a21\u578b&\u63a5\u53e3", order=171)
    public Iterator<IPSAppDERS> getAllPSAppDERSs() throws Exception {
        return this.psAppDERSList.iterator();
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId) throws Exception {
        return this.getPSAppDEUIAction(strAppDEUIActionId, false);
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId, boolean bTryMode) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = this.psAppDEUIActionMap.get(strAppDEUIActionId);
        if (iPSAppDEUIAction != null) {
            return iPSAppDEUIAction;
        }
        iPSAppDEUIAction = (IPSAppDEUIAction)this.psSysAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
        if (iPSAppDEUIAction != null && !this.bLoadPSAppDEUIActionGroupNow) {
            this.psAppDEUIActionMap.put(iPSAppDEUIAction.getId(), iPSAppDEUIAction);
            if (iPSAppDEUIAction.getPSAppDataEntity() != null) {
                iPSAppDEUIAction.getPSAppDataEntity().getPSAppDEUIAction(iPSAppDEUIAction.getId(), false);
            }
        }
        return iPSAppDEUIAction;
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction(String strAppDEUIActionId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = this.getPSAppDEUIAction(strAppDEUIActionId, bTryMode);
        PSApplicationImpl.registerRefPSModelObject(iPSAppDEUIAction, refPSModelObject);
        return iPSAppDEUIAction;
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction2(String strAppDEUIActionId, boolean bTryMode) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = (IPSAppDEUIAction)this.psSysAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
        return iPSAppDEUIAction;
    }

    @Override
    public void resetPSAppDEUIAction(String strAppDEUIActionId) {
        this.psSysAppDEUIActionGlobalModel.ResetModel(strAppDEUIActionId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u884c\u4e3a\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=330)
    public Iterator<IPSAppDEUIAction> getAllPSAppDEUIActions() throws Exception {
        this.psSysAppDEUIActionGlobalModel.getAllModelHelpers();
        return PSModelUtil.sort(this.psAppDEUIActionMap, IPSAppDEUIAction.class).iterator();
    }

    @Override
    public IPSAppDEUIAction registerPSAppDEUIAction(PSDEUIAction psDEUIAction) throws Exception {
        IPSAppDEUIAction iPSAppDEUIAction = this.psAppDEUIActionMap.get(psDEUIAction.getPSDEUIACTIONID());
        if (iPSAppDEUIAction == null) {
            iPSAppDEUIAction = new PSDEUIActionImpl();
            iPSAppDEUIAction.init(this.getDAGlobalHelper(), this, null, psDEUIAction);
            this.psAppDEUIActionMap.put(iPSAppDEUIAction.getId(), iPSAppDEUIAction);
        }
        return iPSAppDEUIAction;
    }

    @Override
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String strAppDEUIActionGroupId) throws Exception {
        return this.getPSAppDEUIActionGroup(strAppDEUIActionGroupId, false);
    }

    @Override
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String strAppDEUIActionGroupId, boolean bTryMode) throws Exception {
        IPSAppDEUIActionGroup iPSAppDEUIActionGroup = (IPSAppDEUIActionGroup)this.psSysAppDEUIActionGroupGlobalModel.FindModelHelper(strAppDEUIActionGroupId, bTryMode);
        if (iPSAppDEUIActionGroup != null) {
            this.psAppDEUIActionGroupMap.put(iPSAppDEUIActionGroup.getId(), iPSAppDEUIActionGroup);
        }
        return iPSAppDEUIActionGroup;
    }

    @Override
    public void resetPSAppDEUIActionGroup(String strAppDEUIActionGroupId) {
        this.psSysAppDEUIActionGroupGlobalModel.ResetModel(strAppDEUIActionGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408", child=true, ignorepf=true, group="\u754c\u9762\u903b\u8f91", order=332)
    public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception {
        this.psSysAppDEUIActionGroupGlobalModel.getAllModelHelpers();
        return PSModelUtil.sort(this.psAppDEUIActionGroupMap, IPSAppDEUIActionGroup.class).iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u9879\u76ee\u96c6\u5408", child=true, dumpref=true, ignorepf=true, ignorert=3, dynamodelmode=8, group="\u6d4b\u8bd5", order=545)
    public Iterator<IPSSysTestPrj> getAllPSSysTestPrjs() throws Exception {
        if (this.psSysTestPrjList == null) {
            ArrayList<IPSSysTestPrj> psSysTestPrjList = new ArrayList<IPSSysTestPrj>();
            Iterator<IPSSysTestPrj> psSysTestPrjs = this.getPSSystem().getAllPSSysTestPrjs();
            if (psSysTestPrjs != null) {
                while (psSysTestPrjs.hasNext()) {
                    IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                    if (StringHelper.compare((String)iPSSysTestPrj.getPrjType(), (String)"SYSAPP", (boolean)false) != 0 || StringHelper.compare((String)this.getId(), (String)iPSSysTestPrj.getPSApplication().getId(), (boolean)false) != 0) continue;
                    psSysTestPrjList.add(iPSSysTestPrj);
                }
            }
            if (this.psSysTestPrjList == null) {
                this.psSysTestPrjList = psSysTestPrjList;
            }
        }
        return this.psSysTestPrjList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u670d\u52a1\u63a5\u53e3\u96c6\u5408", group="\u6a21\u578b&\u63a5\u53e3", order=175)
    public Iterator<IPSSysServiceAPI> getAllPSSysServiceAPIs() throws Exception {
        if (this.psSysServiceAPIList == null) {
            ArrayList psSysServiceAPIList = new ArrayList();
            LinkedHashMap<String, IPSSysServiceAPI> psSysServiceAPIMap = new LinkedHashMap<String, IPSSysServiceAPI>();
            Iterator<IPSAppDataEntity> psAppDataEntitys = this.getAllPSAppDataEntities();
            if (psAppDataEntitys != null) {
                while (psAppDataEntitys.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntitys.next();
                    if (iPSAppDataEntity.getPSSysServiceAPI() == null || psSysServiceAPIMap.containsKey(iPSAppDataEntity.getPSSysServiceAPI().getId())) continue;
                    psSysServiceAPIMap.put(iPSAppDataEntity.getPSSysServiceAPI().getId(), iPSAppDataEntity.getPSSysServiceAPI());
                }
                psSysServiceAPIList.addAll(psSysServiceAPIMap.values());
            }
            if (this.psSysServiceAPIList == null) {
                this.psSysServiceAPIList = psSysServiceAPIList;
            }
        }
        return this.psSysServiceAPIList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u96c6\u5408", child=true, dumpref=true, rtdump=2, dynamodelmode=8, ignorepf=true, group="\u5e94\u7528\u903b\u8f91", order=252)
    public Iterator<IPSAppCounter> getAllPSAppCounters() throws Exception {
        return PSModelUtil.sort(this.psAppCounterMap, IPSAppCounter.class).iterator();
    }

    @Override
    public IPSAppCounter getPSAppCounter(String strPSAppCounterId) throws Exception {
        return this.getPSAppCounter(strPSAppCounterId, false);
    }

    @Override
    public IPSAppCounter getPSAppCounter(String strPSAppCounterId, boolean bTryMode) throws Exception {
        IPSAppCounter iPSAppCounter = this.psAppCounterMap.get(strPSAppCounterId);
        if (iPSAppCounter != null) {
            return iPSAppCounter;
        }
        IPSSysCounter iPSSysCounter = this.getPSSystem().getPSSysCounter(strPSAppCounterId, bTryMode);
        if (iPSSysCounter != null) {
            PSAppCounterImpl psAppCounterImpl = new PSAppCounterImpl();
            psAppCounterImpl.init(this.getDAGlobalHelper(), this, iPSSysCounter);
            this.psAppCounterMap.put(psAppCounterImpl.getId(), psAppCounterImpl);
            return psAppCounterImpl;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u96c6\u5408", child=true, ignorert=3, modelreftype="APPLICATION", group="\u6a21\u578b&\u63a5\u53e3", order=172)
    public Iterator<IPSAppCodeList> getAllPSAppCodeLists() throws Exception {
        return this.getAllPSAppCodeLists(false);
    }

    @Override
    public Iterator<IPSAppCodeList> getAllPSAppCodeLists(boolean bRefOnly) throws Exception {
        LinkedHashMap<String, IPSAppCodeList> psAppCodeListMap = new LinkedHashMap<String, IPSAppCodeList>();
        Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
        while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            Iterator<IPSCodeList> psCodeList = iPSAppView.getAllRelatedPSCodeLists();
            if (psCodeList == null) continue;
            while (psCodeList.hasNext()) {
                IPSCodeList iPSCodeList = psCodeList.next();
                IPSAppCodeList iPSAppCodeList = this.getPSAppCodeList(iPSCodeList.getId());
                if (!bRefOnly || !iPSAppView.getRefFlag()) continue;
                psAppCodeListMap.put(iPSAppCodeList.getId(), iPSAppCodeList);
            }
        }
        if (!bRefOnly) {
            psAppCodeListMap.putAll(this.psAppCodeListMap);
        }
        return PSModelUtil.sort(psAppCodeListMap, IPSAppCodeList.class).iterator();
    }

    @Override
    public IPSAppCodeList getPSAppCodeList(String strPSAppCodeListId) throws Exception {
        return this.getPSAppCodeList(strPSAppCodeListId, false);
    }

    @Override
    public IPSAppCodeList getPSAppCodeList(String strPSAppCodeListId, boolean bTryMode) throws Exception {
        IPSAppCodeList iPSAppCodeList = this.psAppCodeListMap.get(strPSAppCodeListId);
        if (iPSAppCodeList != null) {
            return iPSAppCodeList;
        }
        IPSCodeList iPSSysCodeList = this.getPSSystem().getPSCodeList(strPSAppCodeListId, bTryMode);
        if (iPSSysCodeList != null) {
            PSAppCodeListImpl psAppCodeListImpl = new PSAppCodeListImpl();
            psAppCodeListImpl.init(this.getDAGlobalHelper(), this, iPSSysCodeList);
            this.psAppCodeListMap.put(psAppCodeListImpl.getId(), psAppCodeListImpl);
            return psAppCodeListImpl;
        }
        return null;
    }

    @Override
    public IPSAppCodeList getPSAppCodeList(IPSCodeList iPSCodeList, boolean bTryMode) throws Exception {
        if (iPSCodeList == null) {
            return null;
        }
        if (iPSCodeList instanceof IPSAppCodeList) {
            return (IPSAppCodeList)iPSCodeList;
        }
        IPSAppCodeList iPSAppCodeList = this.psAppCodeListMap.get(iPSCodeList.getId());
        if (iPSAppCodeList != null) {
            return iPSAppCodeList;
        }
        PSAppCodeListImpl psAppCodeListImpl = new PSAppCodeListImpl();
        psAppCodeListImpl.init(this.getDAGlobalHelper(), this, iPSCodeList);
        this.psAppCodeListMap.put(psAppCodeListImpl.getId(), psAppCodeListImpl);
        return psAppCodeListImpl;
    }

    @Override
    public IPSCodeList getPSCodeList(IPSCodeList iPSCodeList, boolean bTryMode) throws Exception {
        IPSAppCodeList iPSAppCodeList = this.getPSAppCodeList(iPSCodeList, bTryMode);
        if (iPSAppCodeList == null) {
            return iPSCodeList;
        }
        return iPSAppCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6d88\u606f\u6a21\u677f\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=338)
    public Iterator<IPSAppMsgTempl> getAllPSAppMsgTempls() throws Exception {
        return PSModelUtil.sort(this.psAppMsgTemplMap, IPSAppMsgTempl.class).iterator();
    }

    @Override
    public IPSAppMsgTempl getPSAppMsgTempl(String strPSAppMsgTemplId) throws Exception {
        return this.getPSAppMsgTempl(strPSAppMsgTemplId, false);
    }

    @Override
    public IPSAppMsgTempl getPSAppMsgTempl(String strPSAppMsgTemplId, boolean bTryMode) throws Exception {
        IPSAppMsgTempl iPSAppMsgTempl = this.psAppMsgTemplMap.get(strPSAppMsgTemplId);
        if (iPSAppMsgTempl != null) {
            return iPSAppMsgTempl;
        }
        IPSSysMsgTempl iPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(strPSAppMsgTemplId, bTryMode);
        if (iPSSysMsgTempl != null) {
            PSAppMsgTemplImpl psAppMsgTemplImpl = new PSAppMsgTemplImpl();
            psAppMsgTemplImpl.init(this.getDAGlobalHelper(), this, iPSSysMsgTempl);
            this.psAppMsgTemplMap.put(psAppMsgTemplImpl.getId(), psAppMsgTemplImpl);
            return psAppMsgTemplImpl;
        }
        return null;
    }

    @Override
    public IPSAppMsgTempl getPSAppMsgTempl(IPSSysMsgTempl iPSSysMsgTempl, boolean bTryMode) throws Exception {
        if (iPSSysMsgTempl == null) {
            return null;
        }
        if (iPSSysMsgTempl instanceof IPSAppMsgTempl) {
            return (IPSAppMsgTempl)iPSSysMsgTempl;
        }
        IPSAppMsgTempl iPSAppMsgTempl = this.psAppMsgTemplMap.get(iPSSysMsgTempl.getId());
        if (iPSAppMsgTempl != null) {
            return iPSAppMsgTempl;
        }
        PSAppMsgTemplImpl psAppMsgTemplImpl = new PSAppMsgTemplImpl();
        psAppMsgTemplImpl.init(this.getDAGlobalHelper(), this, iPSSysMsgTempl);
        this.psAppMsgTemplMap.put(psAppMsgTemplImpl.getId(), psAppMsgTemplImpl);
        return psAppMsgTemplImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=335)
    public Iterator<? extends IPSAppViewMsg> getAllPSAppViewMsgs() throws Exception {
        return PSModelUtil.sort(this.psAppViewMsgMap, IPSAppViewMsg.class).iterator();
    }

    @Override
    public IPSAppViewMsg getPSAppViewMsg(String strPSAppViewMsgId) throws Exception {
        return this.getPSAppViewMsg(strPSAppViewMsgId, false);
    }

    @Override
    public IPSAppViewMsg getPSAppViewMsg(String strPSAppViewMsgId, boolean bTryMode) throws Exception {
        IPSAppViewMsg iPSAppViewMsg = this.psAppViewMsgMap.get(strPSAppViewMsgId);
        if (iPSAppViewMsg != null) {
            return iPSAppViewMsg;
        }
        IPSViewMsg iPSSysViewMsg = this.getPSSystem().getPSViewMsg(strPSAppViewMsgId, bTryMode);
        if (iPSSysViewMsg != null) {
            PSAppViewMsgImpl psAppViewMsgImpl = null;
            psAppViewMsgImpl = iPSSysViewMsg instanceof IPSDEDataSetViewMsg ? new PSAppDEDataSetViewMsgImpl() : new PSAppViewMsgImpl();
            psAppViewMsgImpl.init(this.getDAGlobalHelper(), this, iPSSysViewMsg);
            this.psAppViewMsgMap.put(psAppViewMsgImpl.getId(), psAppViewMsgImpl);
            return psAppViewMsgImpl;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=336)
    public Iterator<? extends IPSAppViewMsgGroup> getAllPSAppViewMsgGroups() throws Exception {
        return this.getAllPSAppViewMsgGroups(this.isPubRefViewOnly());
    }

    @Override
    public IPSAppViewMsgGroup getPSAppViewMsgGroup(String strPSAppViewMsgGroupId) throws Exception {
        return this.getPSAppViewMsgGroup(strPSAppViewMsgGroupId, false);
    }

    @Override
    public IPSAppViewMsgGroup getPSAppViewMsgGroup(String strPSAppViewMsgGroupId, boolean bTryMode) throws Exception {
        IPSAppViewMsgGroup iPSAppViewMsgGroup = this.psAppViewMsgGroupMap.get(strPSAppViewMsgGroupId);
        if (iPSAppViewMsgGroup != null) {
            return iPSAppViewMsgGroup;
        }
        IPSViewMsgGroup iPSSysViewMsgGroup = this.getPSSystem().getPSViewMsgGroup(strPSAppViewMsgGroupId, bTryMode);
        if (iPSSysViewMsgGroup != null) {
            PSAppViewMsgGroupImpl psAppViewMsgGroupImpl = new PSAppViewMsgGroupImpl();
            psAppViewMsgGroupImpl.init(this.getDAGlobalHelper(), this, iPSSysViewMsgGroup);
            this.psAppViewMsgGroupMap.put(psAppViewMsgGroupImpl.getId(), psAppViewMsgGroupImpl);
            return psAppViewMsgGroupImpl;
        }
        return null;
    }

    @Override
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId) throws Exception {
        return this.getPSAppDEUILogicGroup(strAppDEUILogicGroupId, true);
    }

    @Override
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId, boolean bTryMode) throws Exception {
        IPSAppDEUILogicGroup iPSAppDEUILogicGroup = (IPSAppDEUILogicGroup)this.psSysAppDEUILogicGroupGlobalModel.FindModelHelper(strAppDEUILogicGroupId, bTryMode);
        return iPSAppDEUILogicGroup;
    }

    @Override
    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
        IPSAppDEUILogicGroup iPSAppDEUILogicGroup = this.getPSAppDEUILogicGroup(strAppDEUILogicGroupId, bTryMode);
        PSApplicationImpl.registerRefPSModelObject(iPSAppDEUILogicGroup, refPSModelObject);
        return iPSAppDEUILogicGroup;
    }

    @Override
    public void resetPSAppDEUILogicGroup(String strAppDEUILogicGroupId) {
        this.psSysAppDEUILogicGroupGlobalModel.ResetModel(strAppDEUILogicGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91\u7ec4\u96c6\u5408", group="\u754c\u9762\u903b\u8f91", order=340)
    public Iterator<IPSAppDEUILogicGroup> getAllPSAppDEUILogicGroups() throws Exception {
        return this.psSysAppDEUILogicGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u7ec4\u4ef6\u96c6\u5408", child=true, group="\u5e94\u7528\u903b\u8f91", order=300)
    public Iterator<IPSAppUtil> getAllPSAppUtils() throws Exception {
        return this.psAppUtilGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppUtil getPSAppUtil(String strPSAppUtilId) throws Exception {
        return this.getPSAppUtil(strPSAppUtilId, false);
    }

    @Override
    public IPSAppUtil getPSAppUtil(String strPSAppUtilId, boolean bTryMode) throws Exception {
        return (IPSAppUtil)this.psAppUtilGlobalModel.FindModelHelper(strPSAppUtilId, bTryMode);
    }

    @Override
    public void resetPSAppUtil(String strPSAppUtilId) {
        this.psAppUtilGlobalModel.ResetModel(strPSAppUtilId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u7c7b\u578b", group="\u57fa\u672c", order=124)
    public String getAppType() {
        return this.strAppType;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5f0f", codelist="AppMode", group="\u57fa\u672c", order=125)
    public String getAppMode() {
        return this.strAppMode;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22\u6761\u4ef6\u5b58\u50a8")
    public boolean isEnableFilterStorage() {
        return this.getPSAppFilterStorageUtil() != null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6570\u636e\u770b\u677f")
    public boolean isEnableDynaDashboard() {
        return this.getPSAppDynaDashboardUtil() != null;
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u6761\u4ef6\u5b58\u50a8\u5e94\u7528\u7ec4\u4ef6")
    public IPSAppFilterStorageUtil getPSAppFilterStorageUtil() {
        try {
            IPSAppUtil iPSAppUtil = this.getPSAppUtil("FILTERSTORAGE", true);
            if (iPSAppUtil instanceof IPSAppFilterStorageUtil) {
                return (IPSAppFilterStorageUtil)iPSAppUtil;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5e94\u7528\u770b\u677f\u5e94\u7528\u7ec4\u4ef6")
    public IPSAppDynaDashboardUtil getPSAppDynaDashboardUtil() {
        try {
            IPSAppUtil iPSAppUtil = this.getPSAppUtil("DYNADASHBOARD", true);
            if (iPSAppUtil instanceof IPSAppDynaDashboardUtil) {
                return (IPSAppDynaDashboardUtil)iPSAppUtil;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=349)
    public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception {
        if (this.psAppPortletList != null && this.psAppPortletList.size() > 0) {
            return this.psAppPortletList.iterator();
        }
        return this.psAppPortletGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppPortlet getPSAppPortlet(String strPSAppPortletId) throws Exception {
        return this.getPSAppPortlet(strPSAppPortletId, false);
    }

    @Override
    public IPSAppPortlet getPSAppPortlet(String strPSAppPortletId, boolean bTryMode) throws Exception {
        return (IPSAppPortlet)this.psAppPortletGlobalModel.FindModelHelper(strPSAppPortletId, bTryMode);
    }

    @Override
    public void resetPSAppPortlet(String strPSAppPortletId) {
        this.psAppPortletGlobalModel.ResetModel(strPSAppPortletId);
    }

    @Override
    public Iterator<IPSControlContainerView> getPSControlContainerViews() {
        if (this.containerPSAppViewList == null || this.containerPSAppViewList.size() == 0) {
            return null;
        }
        return this.containerPSAppViewList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u96c6\u5408", child=true, group="\u754c\u9762\u903b\u8f91", order=348)
    public Iterator<IPSAppPortletCat> getAllPSAppPortletCats() throws Exception {
        ArrayList<IPSAppPortletCat> list = new ArrayList<IPSAppPortletCat>();
        list.addAll(this.psAppPortletCatMap.values());
        Collections.sort(list, new Comparator<IPSAppPortletCat>(){

            @Override
            public int compare(IPSAppPortletCat o1, IPSAppPortletCat o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list.iterator();
    }

    @Override
    public IPSAppPortletCat getPSAppPortletCat(String strPSAppPortletCatId) throws Exception {
        return this.getPSAppPortletCat(strPSAppPortletCatId, false);
    }

    @Override
    public IPSAppPortletCat getPSAppPortletCat(String strPSAppPortletCatId, boolean bTryMode) throws Exception {
        IPSAppPortletCat iPSAppPortletCat = this.psAppPortletCatMap.get(strPSAppPortletCatId);
        if (iPSAppPortletCat != null) {
            return iPSAppPortletCat;
        }
        IPSSysPortletCat iPSSysPortletCat = this.getPSSystem().getPSSysPortletCat(strPSAppPortletCatId, bTryMode);
        if (iPSSysPortletCat != null) {
            PSAppPortletCatImpl psAppPortletCatImpl = new PSAppPortletCatImpl();
            psAppPortletCatImpl.init(this.getDAGlobalHelper(), this, iPSSysPortletCat);
            this.psAppPortletCatMap.put(psAppPortletCatImpl.getId(), psAppPortletCatImpl);
            return psAppPortletCatImpl;
        }
        return null;
    }

    @Override
    public IPSAppPortletCat getUngroupPSAppPortletCat() throws Exception {
        String strPSAppPortletCatId = "UNGROUP";
        IPSAppPortletCat iPSAppPortletCat = this.psAppPortletCatMap.get(strPSAppPortletCatId);
        if (iPSAppPortletCat != null) {
            return iPSAppPortletCat;
        }
        PSAppPortletCatImpl psAppPortletCatImpl = new PSAppPortletCatImpl();
        psAppPortletCatImpl.init(this.getDAGlobalHelper(), this, null);
        this.psAppPortletCatMap.put(psAppPortletCatImpl.getId(), psAppPortletCatImpl);
        return psAppPortletCatImpl;
    }

    @Override
    public Iterator<IPSAppDataEntity> getPSAppDataEntitiesByDEId(String strPSDEId) throws Exception {
        ArrayList<IPSAppDataEntity> psAppDataEntityList = new ArrayList<IPSAppDataEntity>();
        Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
        if (psAppDataEntities != null) {
            while (psAppDataEntities.hasNext()) {
                IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                if (StringHelper.compare((String)iPSAppDataEntity.getPSDataEntity().getId(), (String)strPSDEId, (boolean)false) != 0) continue;
                if (iPSAppDataEntity.isDefaultMode()) {
                    psAppDataEntityList.add(0, iPSAppDataEntity);
                    continue;
                }
                psAppDataEntityList.add(iPSAppDataEntity);
            }
        }
        if (psAppDataEntityList.size() == 0) {
            return null;
        }
        return psAppDataEntityList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5168\u5c40\u95e8\u6237\u90e8\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppPortlet> getAppPSAppPortlets() throws Exception {
        if (this.appPSAppPortletList == null || this.appPSAppPortletList.size() == 0) {
            return null;
        }
        return this.appPSAppPortletList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5168\u5c40\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppPortletCat> getAppPSAppPortletCats() throws Exception {
        if (this.appPSAppPortletCatList == null) {
            ArrayList<IPSAppPortletCat> appPSAppPortletCatList = new ArrayList<IPSAppPortletCat>();
            Iterator<IPSAppPortlet> psAppPortlets = this.getAppPSAppPortlets();
            if (psAppPortlets != null) {
                LinkedHashMap<String, IPSAppPortletCat> psAppPortletCatMap = new LinkedHashMap<String, IPSAppPortletCat>();
                while (psAppPortlets.hasNext()) {
                    IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                    if (iPSAppPortlet.getPSAppPortletCat() == null || psAppPortletCatMap.containsKey(iPSAppPortlet.getPSAppPortletCat().getId())) continue;
                    psAppPortletCatMap.put(iPSAppPortlet.getPSAppPortletCat().getId(), iPSAppPortlet.getPSAppPortletCat());
                    appPSAppPortletCatList.add(iPSAppPortlet.getPSAppPortletCat());
                }
                Collections.sort(appPSAppPortletCatList, new Comparator<IPSAppPortletCat>(){

                    @Override
                    public int compare(IPSAppPortletCat o1, IPSAppPortletCat o2) {
                        if (o1.isUngroup()) {
                            return 1;
                        }
                        return StringHelper.compare((String)o1.getName(), (String)o2.getName(), (boolean)false);
                    }
                });
            }
            if (this.appPSAppPortletCatList == null) {
                this.appPSAppPortletCatList = appPSAppPortletCatList;
            }
        }
        if (this.appPSAppPortletCatList == null || this.appPSAppPortletCatList.size() == 0) {
            return null;
        }
        return this.appPSAppPortletCatList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        String strRootDeployId = this.getPSSystem().getDeployId();
        String strOrgId = this.getPSSystemUtil().getDeploySysOrgId();
        String strOrgSectorId = this.getPSSystemUtil().getDeploySysOrgSectorId();
        return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)strOrgId, (String)strOrgSectorId, (String)this.getPKGCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5e94\u7528\u6a21\u5f0f")
    public boolean isWFAppMode() {
        return this.bWFAppMode;
    }

    @Override
    public int getGridColumnEnableLink() {
        return this.nGridColumnEnableLink;
    }

    @Override
    public int getGridColumnEnableFilter() {
        return this.nGridColumnEnableFilter;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u503c\u89c4\u5219\u96c6\u5408", group="\u5e94\u7528\u903b\u8f91", order=220)
    public Iterator<IPSAppValueRule> getAllPSAppValueRules() throws Exception {
        return PSModelUtil.sort(this.psAppValueRuleMap, IPSAppValueRule.class).iterator();
    }

    @Override
    public IPSAppValueRule getPSAppValueRule(String strPSAppValueRuleId) throws Exception {
        return this.getPSAppValueRule(strPSAppValueRuleId, false);
    }

    @Override
    public IPSAppValueRule getPSAppValueRule(String strPSAppValueRuleId, boolean bTryMode) throws Exception {
        IPSAppValueRule iPSAppValueRule = this.psAppValueRuleMap.get(strPSAppValueRuleId);
        if (iPSAppValueRule != null) {
            return iPSAppValueRule;
        }
        IPSSysValueRule iPSSysValueRule = this.getPSSystem().getPSSysValueRule(strPSAppValueRuleId, bTryMode);
        if (iPSSysValueRule != null) {
            PSAppValueRuleImpl psAppValueRuleImpl = new PSAppValueRuleImpl();
            psAppValueRuleImpl.init(this.getDAGlobalHelper(), this, iPSSysValueRule);
            this.psAppValueRuleMap.put(psAppValueRuleImpl.getId(), psAppValueRuleImpl);
            return psAppValueRuleImpl;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7aef\u53e3", dump=false)
    public int getHttpPort() {
        return this.nHttpPort;
    }

    @Override
    @PSModelRTMeta(name="[H]\u524d\u7aef\u6a21\u677f\u53d1\u5e03\u5e2e\u52a9", hideempty=true)
    public IPSPFPubHelp getPSPFPubHelp() {
        block4: {
            try {
                if (!PSTemplHelper.isBusy()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.iPSPFPubHelp != null) {
            return this.iPSPFPubHelp;
        }
        HashMap<String, IPSCodePublisherParam> publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        this.fillPSPFCodePublisherParams(publisherParamMap);
        this.iPSPFPubHelp = PSPFPubHelpImpl.createPSPFPubHelp(this.getPSPFPubObjTarget(), this, this, publisherParamMap);
        return this.iPSPFPubHelp;
    }

    protected void fillPSPFCodePublisherParams(Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected String getPSPFPubObjTarget() {
        return this.getModelType();
    }

    @Override
    public String getMDCtrlEmptyText() {
        return this.strMDCtrlEmptyText;
    }

    @Override
    public IPSLanguageRes getMDCtrlEmptyTextPSLanguageRes() {
        return this.mdCtrlEmptyTextPSLanguageRes;
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin(String strPSSysPFPluginId, String strRefMode, String strTag, String strTag2) throws Exception {
        String strKey = KeyValueHelper.genUniqueId((String)strPSSysPFPluginId, (String)strRefMode, (String)strTag, (String)strTag2);
        IPSAppPFPluginRef iPSAppPFPluginRef = this.psAppPFPluginRefMap.get(strKey);
        if (iPSAppPFPluginRef == null) {
            IPSSysPFPlugin iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(strPSSysPFPluginId);
            PSAppPFPluginRefImpl psAppPFPluginRefImpl = new PSAppPFPluginRefImpl();
            psAppPFPluginRefImpl.init(this.getDAGlobalHelper(), this, iPSSysPFPlugin, strRefMode, strTag, strTag2);
            this.psAppPFPluginRefMap.put(strKey, psAppPFPluginRefImpl);
            iPSAppPFPluginRef = psAppPFPluginRefImpl;
        }
        return iPSAppPFPluginRef.getPSSysPFPlugin();
    }

    @Override
    public IPSSubViewType getPSSubViewType(String strPSSubViewTypeId, String strViewType) throws Exception {
        return this.getPSSubViewType(strPSSubViewTypeId, strViewType, null);
    }

    @Override
    public IPSSubViewType getPSSubViewType(String strPSSubViewTypeId, String strViewType, String strTag) throws Exception {
        String strKey = KeyValueHelper.genUniqueId((String)strPSSubViewTypeId, (String)strViewType, (String)strTag);
        IPSAppSubViewTypeRef iPSAppSubViewTypeRef = this.psAppSubViewTypeRefMap.get(strKey);
        if (iPSAppSubViewTypeRef == null) {
            IPSSubViewType iPSSubViewType = this.getPSSystem().getPSSubViewType(strPSSubViewTypeId);
            PSAppSubViewTypeRefImpl psAppSubViewTypeRefImpl = new PSAppSubViewTypeRefImpl();
            psAppSubViewTypeRefImpl.init(this.getDAGlobalHelper(), this, iPSSubViewType, strViewType, strTag);
            this.psAppSubViewTypeRefMap.put(strKey, psAppSubViewTypeRefImpl);
            iPSAppSubViewTypeRef = psAppSubViewTypeRefImpl;
        }
        return iPSAppSubViewTypeRef.getPSSubViewType();
    }

    @Override
    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String strPSEditorTypeId, String strContainerType) throws Exception {
        IPSSysEditorStyle iPSSysEditorStyle = this.getPSSystem().getDefaultPSSysEditorStyle(strPSEditorTypeId, strContainerType);
        if (iPSSysEditorStyle == null) {
            return null;
        }
        String strKey = KeyValueHelper.genUniqueId((String)iPSSysEditorStyle.getId(), (String)strContainerType, null);
        IPSAppEditorStyleRef iPSAppEditorStyleRef = this.psAppEditorStyleRefMap.get(strKey);
        if (iPSAppEditorStyleRef == null) {
            PSAppEditorStyleRefImpl psAppEditorStyleRefImpl = new PSAppEditorStyleRefImpl();
            psAppEditorStyleRefImpl.init(this.getDAGlobalHelper(), this, iPSSysEditorStyle, strContainerType, null);
            this.psAppEditorStyleRefMap.put(strKey, psAppEditorStyleRefImpl);
        }
        return iPSSysEditorStyle;
    }

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle(String strPSSysEditorStyleId, String strContainerType) throws Exception {
        return this.getPSSysEditorStyle(strPSSysEditorStyleId, strContainerType, null);
    }

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle(String strPSSysEditorStyleId, String strContainerType, String strTag) throws Exception {
        String strKey = KeyValueHelper.genUniqueId((String)strPSSysEditorStyleId, (String)strContainerType, (String)strTag);
        IPSAppEditorStyleRef iPSAppEditorStyleRef = this.psAppEditorStyleRefMap.get(strKey);
        if (iPSAppEditorStyleRef == null) {
            IPSSysEditorStyle iPSSysEditorStyle = this.getPSSystem().getPSSysEditorStyle(strPSSysEditorStyleId);
            PSAppEditorStyleRefImpl psAppEditorStyleRefImpl = new PSAppEditorStyleRefImpl();
            psAppEditorStyleRefImpl.init(this.getDAGlobalHelper(), this, iPSSysEditorStyle, strContainerType, strTag);
            this.psAppEditorStyleRefMap.put(strKey, psAppEditorStyleRefImpl);
            iPSAppEditorStyleRef = psAppEditorStyleRefImpl;
        }
        return iPSAppEditorStyleRef.getPSSysEditorStyle();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5f15\u7528\u96c6\u5408", child=true, dynamodelmode=4, group="\u6a21\u677f\u6269\u5c55", order=605)
    public Iterator<IPSAppPFPluginRef> getAllPSAppPFPluginRefs() {
        return PSModelUtil.sort(this.psAppPFPluginRefMap, IPSAppPFPluginRef.class).iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u7f16\u8f91\u5668\u6837\u5f0f\u5f15\u7528\u96c6\u5408", child=true, ignorepf=true, dynamodelmode=8, group="\u6a21\u677f\u6269\u5c55", order=607)
    public Iterator<IPSAppEditorStyleRef> getAllPSAppEditorStyleRefs() {
        return PSModelUtil.sort(this.psAppEditorStyleRefMap, IPSAppEditorStyleRef.class).iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u5b50\u7c7b\u578b\u5f15\u7528\u96c6\u5408", child=true, group="\u6a21\u677f\u6269\u5c55", order=609)
    public Iterator<IPSAppSubViewTypeRef> getAllPSAppSubViewTypeRefs() {
        return PSModelUtil.sort(this.psAppSubViewTypeRefMap, IPSAppSubViewTypeRef.class).iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u62ac\u5934")
    public String getTitle() {
        return this.psSystemApplication.getTITLE();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6807\u9898")
    public String getCaption() {
        return this.psSystemApplication.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b50\u6807\u9898")
    public String getSubCaption() {
        return this.psSystemApplication.getSUBCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5934\u90e8\u4fe1\u606f")
    public String getHeaderInfo() {
        return this.psSystemApplication.getHEADERINFO();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4e0b\u65b9\u4fe1\u606f")
    public String getBottomInfo() {
        return this.psSystemApplication.getBOTTOMINFO();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9ed8\u8ba4\u56fe\u6807")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    protected int onGetDynaInstMode() {
        if (this.isEnableDynaSys()) {
            return 1;
        }
        return 0;
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return this.isEnableDynaSys();
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getCodeName();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        ArrayNode arrayNode;
        ObjectNode childNode;
        ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList;
        if ("HUBSUBAPP".equals(strModelType)) {
            Iterator<IPSAppPortlet> psAppPortlets;
            Iterator<IPSAppPFPluginRef> psAppPFPluginRefs;
            ArrayNode arrayNode2;
            Iterator<IPSAppView> psAppViews;
            ObjectNode node;
            objectNode.put("name", this.getName());
            Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
            if (psAppDataEntities != null) {
                ArrayNode arrayNode3 = objectNode.putArray("getAllPSAppDEUIActionGroups");
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups = iPSAppDataEntity.getAllPSAppDEUIActionGroups();
                    if (psAppDEUIActionGroups == null) continue;
                    while (psAppDEUIActionGroups.hasNext()) {
                        IPSAppDEUIActionGroup iPSAppDEUIActionGroup = psAppDEUIActionGroups.next();
                        if (StringHelper.isNullOrEmpty((String)iPSAppDEUIActionGroup.getUniqueTag()) || (node = iPSAppDEUIActionGroup.getModel()) == null) continue;
                        arrayNode3.add((JsonNode)node);
                    }
                }
            }
            if ((psAppViews = this.getAllPSAppViews()) != null) {
                TreeMap<String, IPSControl> psControlMap = new TreeMap<String, IPSControl>();
                ArrayList allList = new ArrayList();
                try {
                    PSDEViewPanelImpl.setEmbeddedPSAppDEViewMustLink(true);
                    arrayNode2 = objectNode.putArray("getAllPSDEDRControls");
                    ArrayNode arrayNode22 = objectNode.putArray("getAllPSControls");
                    ArrayNode arrayNode3 = objectNode.putArray("getAllPSAppViewRefs");
                    while (psAppViews.hasNext()) {
                        ObjectNode node2;
                        IPSAppView iPSAppView = psAppViews.next();
                        if (iPSAppView.getPriority() != 100) continue;
                        Iterator<IPSAppViewRef> psAppViewRefs = null;
                        psAppViewRefs = iPSAppView.isRedirectView() && iPSAppView instanceof IPSAppRedirectView ? ((IPSAppRedirectView)iPSAppView).getRedirectPSAppViewRefs() : iPSAppView.getPSAppViewRefs();
                        if (psAppViewRefs != null) {
                            while (psAppViewRefs.hasNext()) {
                                IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
                                node2 = iPSAppViewRef.getModel();
                                if (node2 == null) continue;
                                node2.put("ownerTag", iPSAppView.getName());
                                arrayNode3.add((JsonNode)node2);
                            }
                        }
                        allList.clear();
                        ArrayList list = iPSAppView.getAllPSControls();
                        if (list != null) {
                            allList.addAll(list);
                        }
                        if (iPSAppView.getPSSysViewLayoutPanel() != null && (list = iPSAppView.getPSSysViewLayoutPanel().getAllPSControls()) != null) {
                            allList.addAll(list);
                        }
                        if (allList == null) continue;
                        for (IPSControl iPSControl : allList) {
                            ObjectNode node3;
                            if (iPSControl instanceof IPSDEDRCtrl) {
                                IPSDEDRCtrl iPSDEDRCtrl = (IPSDEDRCtrl)iPSControl;
                                if (StringHelper.isNullOrEmpty((String)iPSDEDRCtrl.getUniqueTag()) || psControlMap.containsKey(iPSDEDRCtrl.getUniqueTag()) || (node3 = iPSDEDRCtrl.getModel()) == null) continue;
                                arrayNode2.add((JsonNode)node3);
                                psControlMap.put(iPSDEDRCtrl.getUniqueTag(), iPSDEDRCtrl);
                                continue;
                            }
                            if (iPSControl instanceof IPSTabExpPanel) {
                                IPSTabExpPanel iPSTabExpPanel = (IPSTabExpPanel)iPSControl;
                                if (StringHelper.isNullOrEmpty((String)iPSTabExpPanel.getUniqueTag()) || psControlMap.containsKey(iPSTabExpPanel.getUniqueTag()) || (node3 = iPSTabExpPanel.getModel()) == null) continue;
                                arrayNode2.add((JsonNode)node3);
                                psControlMap.put(iPSTabExpPanel.getUniqueTag(), iPSTabExpPanel);
                                continue;
                            }
                            if (!(iPSControl instanceof IPSDETree) && !(iPSControl instanceof IPSDEEditForm) || StringHelper.isNullOrEmpty((String)iPSControl.getDynaModelFilePath()) || psControlMap.containsKey(iPSControl.getDynaModelFilePath()) || (node2 = iPSControl.toModel("SINGLE")) == null) continue;
                            arrayNode22.add((JsonNode)node2);
                            psControlMap.put(iPSControl.getDynaModelFilePath(), iPSControl);
                        }
                    }
                }
                finally {
                    PSDEViewPanelImpl.setEmbeddedPSAppDEViewMustLink(false);
                }
            }
            if ((psAppPFPluginRefs = this.getAllPSAppPFPluginRefs()) != null) {
                ArrayNode arrayNode4 = null;
                while (psAppPFPluginRefs.hasNext()) {
                    IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
                    node = iPSAppPFPluginRef.getModel();
                    if (node == null) continue;
                    if (arrayNode4 == null) {
                        arrayNode4 = objectNode.putArray("getAllPSAppPFPluginRefs");
                    }
                    arrayNode4.add((JsonNode)node);
                }
            }
            if ((psAppPortlets = this.getAllPSAppPortlets()) != null) {
                arrayNode2 = null;
                while (psAppPortlets.hasNext()) {
                    IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                    ObjectNode node4 = iPSAppPortlet.getModel();
                    if (node4 == null) continue;
                    node4.remove("getPSControl");
                    node4.remove("portletParams");
                    node4.remove("dynaModelFilePath");
                    if (arrayNode2 == null) {
                        arrayNode2 = objectNode.putArray("getAllPSAppPortlets");
                    }
                    arrayNode2.add((JsonNode)node4);
                }
            }
            return;
        }
        if ("SIMPLEAPP".equals(strModelType)) {
            Iterator<IPSAppDEUIAction> psAppDEUIActions;
            Iterator<IPSAppPFPluginRef> psAppPFPluginRefs;
            objectNode.put("name", this.getName());
            objectNode.put("simple", "true");
            if (!StringHelper.isNullOrEmpty((String)this.getTitle())) {
                objectNode.put("title", this.getTitle());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getCaption())) {
                objectNode.put("caption", this.getCaption());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getSubCaption())) {
                objectNode.put("subCaption", this.getSubCaption());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getHeaderInfo())) {
                objectNode.put("headerInfo", this.getHeaderInfo());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getBottomInfo())) {
                objectNode.put("bottomInfo", this.getBottomInfo());
            }
            if (this.getPSSysImage() != null) {
                objectNode.put("getPSSysImage", (JsonNode)this.getPSSysImage().getModel());
            }
            if ((psAppPFPluginRefs = this.getAllPSAppPFPluginRefs()) != null) {
                ArrayNode arrayNode5 = null;
                while (psAppPFPluginRefs.hasNext()) {
                    IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
                    ObjectNode node = iPSAppPFPluginRef.getModel();
                    if (node == null) continue;
                    if (arrayNode5 == null) {
                        arrayNode5 = objectNode.putArray("getAllPSAppPFPluginRefs");
                    }
                    arrayNode5.add((JsonNode)node);
                }
            }
            if ((psAppDEUIActions = this.getAllPSAppDEUIActions()) != null) {
                ArrayNode arrayNode6 = null;
                while (psAppDEUIActions.hasNext()) {
                    ObjectNode node;
                    IPSAppDEUIAction iPSAppDEUIAction = psAppDEUIActions.next();
                    if (iPSAppDEUIAction.getPSAppDataEntity() != null || (node = iPSAppDEUIAction.getModel()) == null) continue;
                    if (arrayNode6 == null) {
                        arrayNode6 = objectNode.putArray("getAllPSAppDEUIActions");
                    }
                    arrayNode6.add((JsonNode)node);
                }
            }
            LinkedHashMap<String, IPSAppView> cachePSAppViewMap = new LinkedHashMap<String, IPSAppView>();
            Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppUtilView iPSAppUtilView;
                IPSAppView iPSAppView = psAppViews.next();
                if ((iPSAppView.getAccUserMode() & 1) == 1) {
                    cachePSAppViewMap.put(iPSAppView.getId(), iPSAppView);
                }
                if (!(iPSAppView instanceof IPSAppUtilView) || StringHelper.compare((String)"APPLOGINVIEW", (String)(iPSAppUtilView = (IPSAppUtilView)iPSAppView).getViewType(), (boolean)false) != 0 && StringHelper.compare((String)"APPERRORVIEW", (String)iPSAppUtilView.getViewType(), (boolean)false) != 0 && StringHelper.compare((String)"APPSTARTVIEW", (String)iPSAppUtilView.getViewType(), (boolean)false) != 0 && StringHelper.compare((String)"APPWELCOMEVIEW", (String)iPSAppUtilView.getViewType(), (boolean)false) != 0 && StringHelper.compare((String)"APPLOGOUTVIEW", (String)iPSAppUtilView.getViewType(), (boolean)false) != 0) continue;
                cachePSAppViewMap.put(iPSAppView.getId(), iPSAppView);
            }
            ObjectNode cacheNode = JsonNodeHelper.createObjectNode();
            if (cachePSAppViewMap != null) {
                ArrayNode arrayNode7 = cacheNode.putArray("getPSAppViews");
                for (IPSAppView iPSAppView : cachePSAppViewMap.values()) {
                    arrayNode7.add((JsonNode)iPSAppView.getModel());
                }
            }
            objectNode.put("cache", (JsonNode)cacheNode);
            return;
        }
        if (this.getPSSystemRuntime() != null && this.getPSSystemRuntime().getDynaInstMode() == 2) {
            Iterator<IPSAppView> psAppViews;
            Iterator<IPSAppDataEntity> psAppDataEntities;
            Iterator<IPSAppCodeList> psAppCodeLists;
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getPSDynaInstId())) {
                objectNode.put("getPSDynaInstId", this.getPSSystemRuntime().getPSDynaInstId());
            }
            objectNode.put("dynaInstMode", this.getPSSystemRuntime().getDynaInstMode());
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getDynaInstTag())) {
                objectNode.put("dynaInstTag", this.getPSSystemRuntime().getDynaInstTag());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getDynaInstTag2())) {
                objectNode.put("dynaInstTag2", this.getPSSystemRuntime().getDynaInstTag2());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getPPSDynaInstId())) {
                objectNode.put("getPPSDynaInstId", this.getPSSystemRuntime().getPPSDynaInstId());
            }
            if ((psAppCodeLists = this.getAllPSAppCodeLists()) != null) {
                ArrayNode arrayNode8 = objectNode.putArray("getAllPSAppCodeLists");
                while (psAppCodeLists.hasNext()) {
                    IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
                    if (iPSAppCodeList.getDynaInstMode() != 2 || StringHelper.compare((String)this.getPSSystemRuntime().getDynaInstTag(), (String)iPSAppCodeList.getDynaInstTag(), (boolean)false) != 0) continue;
                    arrayNode8.add((JsonNode)iPSAppCodeList.getModel());
                }
            }
            if ((psAppDataEntities = this.getAllPSAppDataEntities()) != null) {
                ArrayNode arrayNode9 = objectNode.putArray("getAllPSAppDataEntities");
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    if (iPSAppDataEntity.getDynaInstMode() != 2 || StringHelper.compare((String)this.getPSSystemRuntime().getDynaInstTag(), (String)iPSAppDataEntity.getDynaInstTag(), (boolean)false) != 0) continue;
                    arrayNode9.add((JsonNode)iPSAppDataEntity.getModelRef());
                }
            }
            if ((psAppViews = this.getAllPSAppViews()) != null) {
                ArrayNode arrayNode10 = objectNode.putArray("getAllPSAppViews");
                while (psAppViews.hasNext()) {
                    IPSAppView iPSAppView = psAppViews.next();
                    if (iPSAppView.getDynaInstMode() != 2 || StringHelper.compare((String)this.getPSSystemRuntime().getDynaInstTag(), (String)iPSAppView.getDynaInstTag(), (boolean)false) != 0) continue;
                    arrayNode10.add((JsonNode)iPSAppView.toModelRef("APPLICATION"));
                }
            }
            return;
        }
        super.onFillModelNode(objectNode, strModelType);
        if (objectNode.has("getAllPSAppDEUIActionGroups")) {
            objectNode.remove("getAllPSAppDEUIActionGroups");
        }
        if (!objectNode.has("getAllPSAppDEUIActionGroups")) {
            ArrayNode arrayNode11 = objectNode.putArray("getAllPSAppDEUIActionGroups");
            Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups = this.getAllPSAppDEUIActionGroups();
            if (psAppDEUIActionGroups != null) {
                while (psAppDEUIActionGroups.hasNext()) {
                    arrayNode11.add((JsonNode)psAppDEUIActionGroups.next().toModel("APPLICATION"));
                }
            }
            if (arrayNode11.size() == 0) {
                objectNode.remove("getAllPSAppDEUIActionGroups");
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getPSDynaInstId())) {
            objectNode.put("getPSDynaInstId", this.getPSSystemRuntime().getPSDynaInstId());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSSystemRuntime().getPPSDynaInstId())) {
            objectNode.put("getPPSDynaInstId", this.getPSSystemRuntime().getPPSDynaInstId());
        }
        if ((psDevSlnSysDynaInstList = ((IPSSystemRuntime)((Object)this.iPSSystem)).getPSDevSlnSysDynaInstList()) != null && psDevSlnSysDynaInstList.size() > 0) {
            ArrayNode arrayNode12 = objectNode.putArray("getPSDynaInsts");
            for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
                ObjectNode instNode = JsonNodeHelper.createObjectNode();
                instNode.put("id", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
                instNode.put("name", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME());
                if (!StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getLOGICNAME())) {
                    instNode.put("logicName", psDevSlnSysDynaInst.getLOGICNAME());
                }
                if (!StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTYPE())) {
                    instNode.put("instType", psDevSlnSysDynaInst.getINSTTYPE());
                }
                if (!StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTAG())) {
                    instNode.put("instTag", psDevSlnSysDynaInst.getINSTTAG());
                }
                if (!StringHelper.isNullOrEmpty((String)psDevSlnSysDynaInst.getINSTTAG2())) {
                    instNode.put("instTag2", psDevSlnSysDynaInst.getINSTTAG2());
                }
                arrayNode12.add((JsonNode)instNode);
            }
        }
        if (this.getPSSysSFPlugin() != null) {
            childNode = this.getPSSysSFPlugin().toModelRef("");
            PSApplicationImpl.putJsonProperty(objectNode, "getPSSysSFPlugin", childNode);
        }
        if (this.getPSSysResource() != null) {
            childNode = this.getPSSysResource().toModelRef("");
            PSApplicationImpl.putJsonProperty(objectNode, "getPSSysResource", childNode);
        }
        if ((PSObjectImpl.getDynaModelPubMode() & 8) != 8) {
            Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs;
            if (objectNode.has("getAllPSAppSubViewTypeRefs")) {
                objectNode.remove("getAllPSAppSubViewTypeRefs");
            }
            if (this.isEnableUIModelEx() && (psAppSubViewTypeRefs = this.getAllPSAppSubViewTypeRefs()) != null) {
                ArrayNode arrayNode13 = null;
                while (psAppSubViewTypeRefs.hasNext()) {
                    IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
                    if (!iPSAppSubViewTypeRef.isReplaceDefault()) continue;
                    ObjectNode childNode2 = iPSAppSubViewTypeRef.toModel("");
                    if (arrayNode13 == null) {
                        arrayNode13 = objectNode.putArray("getAllPSAppSubViewTypeRefs");
                    }
                    arrayNode13.add((JsonNode)childNode2);
                }
            }
        }
        LinkedHashMap<String, IPSAppView> cachePSAppViewMap = new LinkedHashMap<String, IPSAppView>();
        LinkedHashMap<String, IPSAppDataEntity> cachePSDataEntityMap = new LinkedHashMap<String, IPSAppDataEntity>();
        IPSAppIndexView iPSAppIndexView = this.getDefaultPSAppIndexView();
        if (this.getDefaultPSAppIndexView() != null) {
            iPSAppIndexView = this.getDefaultPSAppIndexView();
        } else {
            Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                if (!(iPSAppView instanceof IPSAppIndexView)) continue;
                iPSAppIndexView = (IPSAppIndexView)iPSAppView;
                break;
            }
        }
        if (iPSAppIndexView != null) {
            Iterator<IPSAppMenuItem> psAppMenuItems;
            cachePSAppViewMap.put(iPSAppIndexView.getId(), iPSAppIndexView);
            if (iPSAppIndexView.getPSAppMenu() != null && (psAppMenuItems = iPSAppIndexView.getPSAppMenu().getPSAppMenuItems()) != null) {
                while (psAppMenuItems.hasNext()) {
                    IPSAppFunc iPSAppFunc = psAppMenuItems.next().getPSAppFunc();
                    if (iPSAppFunc == null || iPSAppFunc.getPSAppView() == null) continue;
                    cachePSAppViewMap.put(iPSAppFunc.getPSAppView().getId(), iPSAppFunc.getPSAppView());
                }
            }
        }
        for (IPSAppView iPSAppView : cachePSAppViewMap.values()) {
            IPSAppDataEntity iPSAppDataEntity = iPSAppView.getPSAppDataEntity();
            if (iPSAppDataEntity == null) continue;
            cachePSDataEntityMap.put(iPSAppDataEntity.getId(), iPSAppDataEntity);
        }
        ObjectNode cacheNode = JsonNodeHelper.createObjectNode();
        if (cachePSAppViewMap != null) {
            arrayNode = cacheNode.putArray("getPSAppViews");
            for (IPSAppView iPSAppView : cachePSAppViewMap.values()) {
                arrayNode.add((JsonNode)iPSAppView.getModel());
            }
        }
        if (cachePSDataEntityMap != null) {
            arrayNode = cacheNode.putArray("getPSAppDataEntities");
            for (IPSAppDataEntity iPSAppDataEntity : cachePSDataEntityMap.values()) {
                arrayNode.add((JsonNode)iPSAppDataEntity.getModel());
            }
        }
        objectNode.put("cache", (JsonNode)cacheNode);
    }

    @Override
    public IPSAppModule getDefaultPSAppModule() {
        return this.psAppModuleGlobalModel.getDefaultPSAppModule();
    }

    @Override
    public IPSLanguageRes getPSLanguageRes(String strLanguageResId) throws Exception {
        IPSLanguageRes iPSLanguageRes = this.psLanguageResMap.get(strLanguageResId);
        if (iPSLanguageRes == null) {
            iPSLanguageRes = this.getPSSystem().getPSLanguageRes(strLanguageResId);
            this.psLanguageResMap.put(strLanguageResId, iPSLanguageRes);
        }
        return iPSLanguageRes;
    }

    @Override
    public Iterator<IPSLanguageRes> getAllPSLanguageReses() {
        return PSModelUtil.sort(this.psLanguageResMap, IPSLanguageRes.class).iterator();
    }

    /*
     * Unable to fully structure code
     */
    protected void registerPSApplicationLogics() throws Exception {
        map = new LinkedHashMap<String, IPSAppDEUILogicGroupDetail>();
        psAppLogics = this.getAllPSAppLogics();
        if (psAppLogics != null) {
            while (psAppLogics.hasNext()) {
                iPSAppDEUILogicGroupDetail = psAppLogics.next();
                strName = iPSAppDEUILogicGroupDetail.getName();
                if (StringHelper.isNullOrEmpty((String)strName) || map.containsKey(strName = strName.toLowerCase())) continue;
                map.put(strName, iPSAppDEUILogicGroupDetail);
                if (!"APPEVENT".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) && !"TIMER".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) && !"CUSTOM".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) continue;
                psApplicationLogicImpl = new PSApplicationLogicImpl(this, iPSAppDEUILogicGroupDetail);
                this.registerPSApplicationLogic(psApplicationLogicImpl);
            }
        }
        if (StringHelper.isNullOrEmpty((String)(strPPSDEUILogicGroupId = this.psSystemApplication.getPSCTRLLOGICGROUPID()))) {
            return;
        }
        list = new ArrayList<IPSAppDEUILogicGroup>();
        while (!StringHelper.isNullOrEmpty((String)strPPSDEUILogicGroupId)) {
            parent = this.getPSAppDEUILogicGroup(strPPSDEUILogicGroupId);
            if (list.contains(parent)) {
                throw new Exception(String.format("\u754c\u9762\u903b\u8f91\u7ec4[%1$s]\u51fa\u73b0\u9012\u5f52\u5f15\u7528", new Object[]{parent.getFullName()}));
            }
            list.add(parent);
            strPPSDEUILogicGroupId = parent.getParentPSDEUILogicGroupId();
        }
        for (IPSAppDEUILogicGroup item : list) {
            psAppDEUILogicGroupDetails = item.getPSAppDEUILogicGroupDetails();
            if (psAppDEUILogicGroupDetails != null) ** GOTO lbl37
            continue;
lbl-1000:
            // 1 sources

            {
                iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                strName = iPSAppDEUILogicGroupDetail.getName();
                if (StringHelper.isNullOrEmpty((String)strName) || map.containsKey(strName = strName.toLowerCase())) continue;
                map.put(strName, iPSAppDEUILogicGroupDetail);
                if (!"APPEVENT".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) && !"TIMER".equals(iPSAppDEUILogicGroupDetail.getTriggerType()) && !"CUSTOM".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) continue;
                psApplicationLogicImpl = new PSApplicationLogicImpl(this, iPSAppDEUILogicGroupDetail);
                this.registerPSApplicationLogic(psApplicationLogicImpl);
lbl37:
                // 4 sources

                ** while (psAppDEUILogicGroupDetails.hasNext())
            }
lbl38:
            // 1 sources

        }
    }

    protected void registerPSApplicationLogic(IPSApplicationLogic iPSApplicationLogic) throws Exception {
        if (this.psApplicationLogicList == null) {
            this.psApplicationLogicList = new ArrayList<IPSApplicationLogic>();
        }
        this.psApplicationLogicList.add(iPSApplicationLogic);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u8f7d\u903b\u8f91\u96c6\u5408", hideempty2=true, child=true, group="\u5e94\u7528\u903b\u8f91", order=302)
    public Iterator<? extends IPSApplicationLogic> getPSApplicationLogics() {
        if (this.psApplicationLogicList == null || this.psApplicationLogicList.size() == 0) {
            return null;
        }
        return this.psApplicationLogicList.iterator();
    }

    @Override
    public String getFormItemEmptyText() {
        return this.psSystemApplication.getFIEMPTYTEXT();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        String strDynaModelPath = this.getDynaModelFolder();
        if (StringHelper.isNullOrEmpty((String)strDynaModelPath)) {
            return null;
        }
        return String.format("%1$s/%2$s.json", this.getDynaModelFolder(), this.getDumpModelType());
    }

    @Override
    protected boolean isEnableExportModel() {
        if (!this.isEnableDynaSys()) {
            return false;
        }
        return super.isEnableExportModel();
    }

    @Override
    protected boolean isEnableExportModelRef() {
        if (!this.isEnableDynaSys()) {
            return false;
        }
        return super.isEnableExportModelRef();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u670d\u52a1\u63a5\u53e3DTO", ignoredumpvalues="false")
    public boolean isEnableServiceAPIDTO() {
        return this.bEnableServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u8d44\u6e90\u6807\u8bc6\u96c6\u5408", child=true, group="\u8bbf\u95ee\u63a7\u5236", order=515)
    public Iterator<String> getAllAccessKeys() {
        if (this.accessKeyMap == null || this.accessKeyMap.size() == 0) {
            return null;
        }
        return this.accessKeyMap.keySet().iterator();
    }

    protected void fillPSAppMenuItemAccessKey(IPSAppMenuItem iPSAppMenuItem) {
        Iterator<IPSAppMenuItem> psAppMenuItems;
        if (!StringHelper.isNullOrEmpty((String)iPSAppMenuItem.getAccessKey())) {
            this.accessKeyMap.put(iPSAppMenuItem.getAccessKey(), null);
        }
        if ((psAppMenuItems = iPSAppMenuItem.getPSAppMenuItems()) != null) {
            while (psAppMenuItems.hasNext()) {
                this.fillPSAppMenuItemAccessKey(psAppMenuItems.next());
            }
        }
    }

    @Override
    public int getACMinChars() {
        return this.nACMinChars;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", ignorepf=true, hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    public String getDEPSSysSFPluginId() {
        return this.psSystemApplication.getDEPSSYSSFPLUGINID();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<? extends IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception {
        return this.getPSSystem().getAllPSDEOPPrivs();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6807\u8bb0", hideempty2=true)
    public String getAppTag() {
        return this.psSystemApplication.getAPPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6807\u8bb02", hideempty2=true)
    public String getAppTag2() {
        return this.psSystemApplication.getAPPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6807\u8bb03", hideempty2=true)
    public String getAppTag3() {
        return this.psSystemApplication.getAPPTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6807\u8bb04", hideempty2=true)
    public String getAppTag4() {
        return this.psSystemApplication.getAPPTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4ee3\u7801\u6807\u8bc6", hideempty2=true)
    public String getSysCodeName() {
        return this.getPSSystem().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5f15\u64ce\u7248\u672c")
    public int getEngineVer() {
        return this.getPSSystem().getEngineVer();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u8d44\u6e90\u5bf9\u8c61", ignorepf=true, hideempty=true, dumpref=true)
    public IPSSysResource getPSSysResource() {
        block4: {
            if (this.iPSSysResource == null) {
                try {
                    Iterator<IPSSysResource> psSysResources = this.getPSSystem().getAllPSSysResources();
                    if (psSysResources == null) break block4;
                    while (psSysResources.hasNext()) {
                        IPSSysResource item = psSysResources.next();
                        if (StringHelper.isNullOrEmpty((String)item.getResTag())) continue;
                        String strResTag = String.format("PSSYSAPP__%1$s", this.getCodeName()).toUpperCase();
                        if (StringHelper.compare((String)item.getResTag(), (String)strResTag, (boolean)true) != 0) continue;
                        this.iPSSysResource = item;
                        break;
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        }
        return this.iPSSysResource;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u65b9\u6cd5DTO\u96c6\u5408", child=true, group="\u5e94\u7528\u903b\u8f91", order=236)
    public Iterator<IPSAppMethodDTO> getAllPSAppMethodDTOs() throws Exception {
        if (this.psAppMethodDTOMap == null || this.psAppMethodDTOMap.size() == 0) {
            return null;
        }
        return this.psAppMethodDTOMap.values().iterator();
    }

    @Override
    public IPSAppMethodDTO getPSAppMethodDTO(IPSSysMethodDTO iPSSysMethodDTO) throws Exception {
        for (Map.Entry<String, IPSAppMethodDTO> entry : this.psAppMethodDTOMap.entrySet()) {
            if (StringHelper.compare((String)entry.getValue().getType(), (String)"DEFAULT", (boolean)true) != 0 || entry.getValue().getPSSysMethodDTO() == null || StringHelper.compare((String)entry.getValue().getPSSysMethodDTO().getId(), (String)iPSSysMethodDTO.getId(), (boolean)false) != 0) continue;
            return entry.getValue();
        }
        PSAppMethodDTOImpl psAppMethodDTOImpl = new PSAppMethodDTOImpl();
        psAppMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSSysMethodDTO);
        if (this.psAppMethodDTOMap.containsKey(psAppMethodDTOImpl.getCodeName())) {
            throw new Exception(String.format("\u5e94\u7528\u4e2d\u5df2\u5b58\u5728\u4ee3\u7801\u6807\u8bc6\u4e3a[%1$s]\u7684\u65b9\u6cd5DTO\u5bf9\u8c61", psAppMethodDTOImpl.getCodeName()));
        }
        this.psAppMethodDTOMap.put(psAppMethodDTOImpl.getCodeName(), psAppMethodDTOImpl);
        return psAppMethodDTOImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u4f53\u7cfb\u96c6\u5408", child=true, dumpref=true)
    public Iterator<IPSAppBIScheme> getAllPSAppBISchemes() throws Exception {
        if (this.psAppBISchemeMap == null || this.psAppBISchemeMap.size() == 0) {
            return null;
        }
        return this.psAppBISchemeMap.values().iterator();
    }

    @Override
    public IPSAppBIScheme getPSAppBIScheme(IPSSysBIScheme iPSSysBIScheme) throws Exception {
        IPSAppBIScheme iPSAppBIScheme = this.psAppBISchemeMap.get(iPSSysBIScheme.getUniqueTag());
        if (iPSAppBIScheme != null) {
            return iPSAppBIScheme;
        }
        PSAppBISchemeImpl psAppBISchemeImpl = new PSAppBISchemeImpl();
        psAppBISchemeImpl.init(this.getDAGlobalHelper(), this, iPSSysBIScheme);
        this.psAppBISchemeMap.put(psAppBISchemeImpl.getUniqueTag(), psAppBISchemeImpl);
        return psAppBISchemeImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<IPSAppLogic> getAllPSAppLogics() throws Exception {
        return this.psAppLogicGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppLogic getPSAppLogic(String strPSAppLogicId) throws Exception {
        return (IPSAppLogic)this.psAppLogicGlobalModel.FindModelHelper(strPSAppLogicId);
    }

    @Override
    public void resetPSAppLogic(String strPSAppLogicId) {
        this.psAppLogicGlobalModel.ResetModel(strPSAppLogicId);
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIActionByPredefinedType(String strType, boolean bTryMode) throws Exception {
        Iterator<IPSDEUIAction> globalPSDEActions = this.getPSSystem().getAllPSDEUIActions();
        if (globalPSDEActions != null) {
            while (globalPSDEActions.hasNext()) {
                IPSDEUIAction iPSDEUIAction = globalPSDEActions.next();
                String strPredefinedType = iPSDEUIAction.getPredefinedType();
                if (StringHelper.isNullOrEmpty((String)strPredefinedType) || StringHelper.compare((String)strType, (String)strPredefinedType, (boolean)false) != 0) continue;
                return this.getPSAppDEUIAction(iPSDEUIAction.getId());
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u5c40\u9884\u7f6e\u754c\u9762\u884c\u4e3a[%1$s]", strType));
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u754c\u9762\u6a21\u578b\u589e\u5f3a", ignoredumpvalues="false")
    public boolean isEnableUIModelEx() {
        try {
            String strEnableUIModelEx = this.getPFStyleParam(PFSTYLEPARAM_ENABLEUIMODELEX, "");
            if (!StringHelper.isNullOrEmpty((String)strEnableUIModelEx)) {
                return StringHelper.compare((String)strEnableUIModelEx, (String)"TRUE", (boolean)true) == 0;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return this.getPSSystemSetting().isEnableUIModelEx();
    }

    @PSModelRTMeta(description="\u542f\u7528BI\u6a21\u578b", dump=false, ignoredumpvalues="false")
    public boolean isEnableBIScheme() {
        try {
            String strEnableBIScheme = this.getPFStyleParam(PFSTYLEPARAM_ENABLEBISCHEME, "");
            if (!StringHelper.isNullOrEmpty((String)strEnableBIScheme)) {
                return StringHelper.compare((String)strEnableBIScheme, (String)"TRUE", (boolean)true) == 0;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DynaSysMode", ignoredumpvalues="0", fields={"ENABLEDYNASYS"})
    public int getDynaSysMode() {
        return this.nDynaSysMode;
    }

    @Override
    public IPSSysUniRes getPSSysUniRes(String strSysUniResId) throws Exception {
        return this.getPSSysUniRes(strSysUniResId, false);
    }

    @Override
    public IPSSysUniRes getPSSysUniRes(String strSysUniResId, boolean bTryMode) throws Exception {
        IPSSysUniRes iPSSysUniRes = this.getPSSystem().getPSSysUniRes(strSysUniResId, bTryMode);
        if (iPSSysUniRes != null) {
            this.accessKeyMap.put(iPSSysUniRes.getResCode(), null);
        }
        return iPSSysUniRes;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bf9\u8c61\u5b58\u50a8\u5206\u7c7b")
    public String getDefaultOSSCat() {
        try {
            return this.getPFStyleParam(PFSTYLEPARAM_DEFAULTOSSCAT, "");
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", fields={"CODENAMEMODE"})
    public String getViewCodeNameMode() {
        if (StringHelper.isNullOrEmpty((String)this.psSystemApplication.getCODENAMEMODE())) {
            try {
                return this.getPFStyleParam(PFSTYLEPARAM_CODENAMEMODE, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.psSystemApplication.getCODENAMEMODE();
    }

    @Override
    public String getViewCodeName(String strPrefix, String strCodeName, String strSuffix) {
        return PSModelCodeNameUtils.to(this.getViewCodeNameMode(), strPrefix, strCodeName, strSuffix);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u96c6\u5408", child=true, modelreftype="APPLICATION", group="\u6a21\u578b&\u63a5\u53e3", order=172)
    public Iterator<IPSAppDEFInputTipSet> getAllPSAppDEFInputTipSets() throws Exception {
        return PSModelUtil.sort(this.psAppDEFInputTipSetMap, IPSAppDEFInputTipSet.class).iterator();
    }

    @Override
    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet(String strPSAppDEFInputTipSetId) throws Exception {
        return this.getPSAppDEFInputTipSet(strPSAppDEFInputTipSetId, false);
    }

    @Override
    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet(String strPSAppDEFInputTipSetId, boolean bTryMode) throws Exception {
        IPSAppDEFInputTipSet iPSAppDEFInputTipSet = this.psAppDEFInputTipSetMap.get(strPSAppDEFInputTipSetId);
        if (iPSAppDEFInputTipSet != null) {
            return iPSAppDEFInputTipSet;
        }
        IPSDEFInputTipSet iPSSysDEFInputTipSet = this.getPSSystem().getPSDEFInputTipSet(strPSAppDEFInputTipSetId, bTryMode);
        if (iPSSysDEFInputTipSet != null) {
            PSAppDEFInputTipSetImpl psAppDEFInputTipSetImpl = new PSAppDEFInputTipSetImpl();
            psAppDEFInputTipSetImpl.init(this.getDAGlobalHelper(), this, iPSSysDEFInputTipSet);
            this.psAppDEFInputTipSetMap.put(psAppDEFInputTipSetImpl.getId(), psAppDEFInputTipSetImpl);
            return psAppDEFInputTipSetImpl;
        }
        return null;
    }

    @Override
    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet(IPSDEFInputTipSet iPSDEFInputTipSet, boolean bTryMode) throws Exception {
        if (iPSDEFInputTipSet == null) {
            return null;
        }
        if (iPSDEFInputTipSet instanceof IPSAppDEFInputTipSet) {
            return (IPSAppDEFInputTipSet)iPSDEFInputTipSet;
        }
        IPSAppDEFInputTipSet iPSAppDEFInputTipSet = this.psAppDEFInputTipSetMap.get(iPSDEFInputTipSet.getId());
        if (iPSAppDEFInputTipSet != null) {
            return iPSAppDEFInputTipSet;
        }
        PSAppDEFInputTipSetImpl psAppDEFInputTipSetImpl = new PSAppDEFInputTipSetImpl();
        psAppDEFInputTipSetImpl.init(this.getDAGlobalHelper(), this, iPSDEFInputTipSet);
        this.psAppDEFInputTipSetMap.put(psAppDEFInputTipSetImpl.getId(), psAppDEFInputTipSetImpl);
        return psAppDEFInputTipSetImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u5e94\u7528\u8bbf\u95ee\u6807\u8bc6")
    public String getSubAppAccessKey() {
        try {
            return this.getPFStyleParam(PFSTYLEPARAM_SUBAPPACCESSKEY, "");
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    public int getOrderValue() {
        if (!this.psSystemApplication.isORDERVALUENull() && this.psSystemApplication.getORDERVALUE() >= 0) {
            return this.psSystemApplication.getORDERVALUE();
        }
        return 99999;
    }
}

