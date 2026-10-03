package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
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
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBContainerPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.ViewPanel.PSDEViewPanelImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionImpl;
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
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.db.SqlParamList;
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
   public static final String MODELGROUP_MODEL = "模型&接口";
   public static final String MODELGROUP_UI = "应用视图";
   public static final String MODELGROUP_LOGIC = "应用逻辑";
   public static final String MODELGROUP_UILOGIC = "界面逻辑";
   public static final String MODELGROUP_MOB = "移动端";
   public static final String MODELGROUP_WF = "工作流";
   public static final String MODELGROUP_ADVUTIL = "高级组件";
   public static final String MODELGROUP_MSG = "消息";
   public static final String MODELGROUP_ACCCTRL = "访问控制";
   public static final String MODELGROUP_TEST = "测试";
   public static final String MODELGROUP_ADVMODEL = "模型高级";
   public static final String MODELGROUP_PFSF = "模板扩展";
   public static final String[] MODELGROUPS = new String[]{
      "基本", "模型&接口", "应用视图", "应用逻辑", "界面逻辑", "移动端", "工作流", "高级组件", "消息", "访问控制", "测试", "模型高级", "模板扩展", "用户扩展", "其它"
   };
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
   private static final Map<String, String> GlobaDEUIActionMap = new HashMap<>();
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
   private Map<String, IPSPFStyle> psPFStyleMap = new LinkedHashMap<>();
   private String strAppFolder = null;
   private String strMainMenuAlign = "";
   protected ArrayList<IPSPFPkgVer> psPFPkgVerList = new ArrayList<>();
   private IPSPFCDN iPSPFCDN = null;
   private String strUpdatePSAppViewSysRefFlagSql = "UPDATE T_SRFPSAPPVIEW SET SYSREFFLAG = ? WHERE PSAPPVIEWID=?";
   private String strResetPSAppViewSysRefFlagSql = "UPDATE T_SRFPSAPPVIEW SET SYSREFFLAG = 0 WHERE PSSYSAPPID=? AND SYSREFFLAG IS NULL";
   private boolean bPubSysRefViewOnly = false;
   private ArrayList<IPSLogItem> psLogItemList = new ArrayList<>();
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
   private Map<String, Integer> psAppViewUsageMap = new LinkedHashMap<>();
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
   private ArrayList<IPSAppDERS> psAppDERSList = new ArrayList<>();
   private Map<String, IPSAppCounter> psAppCounterMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppCodeList> psAppCodeListMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppMsgTempl> psAppMsgTemplMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppValueRule> psAppValueRuleMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppViewMsg> psAppViewMsgMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppViewMsgGroup> psAppViewMsgGroupMap = new ConcurrentHashMap<>();
   private String strAppMode = "DEFAULT";
   private boolean bWFAppMode = false;
   private ArrayList<IPSControlContainerView> containerPSAppViewList = new ArrayList<>();
   private Map<String, IPSAppPortletCat> psAppPortletCatMap = new ConcurrentHashMap<>();
   private List<IPSAppPortlet> psAppPortletList = null;
   private List<IPSAppPortlet> appPSAppPortletList = null;
   private List<IPSAppPortletCat> appPSAppPortletCatList = null;
   private Map<String, IPSAppDEUIAction> psAppDEUIActionMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppDEUIActionGroup> psAppDEUIActionGroupMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppPFPluginRef> psAppPFPluginRefMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppEditorStyleRef> psAppEditorStyleRefMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppSubViewTypeRef> psAppSubViewTypeRefMap = new ConcurrentHashMap<>();
   private Map<String, IPSAppDEFInputTipSet> psAppDEFInputTipSetMap = new ConcurrentHashMap<>();
   private int nGridColumnEnableLink = 2;
   private int nGridColumnEnableFilter = 2;
   private int nHttpPort = 0;
   private IPSPFPubHelp iPSPFPubHelp = null;
   private String strMDCtrlEmptyText = null;
   private IPSLanguageRes mdCtrlEmptyTextPSLanguageRes = null;
   private static Random RANDOM = new Random();
   private Map<String, IPSLanguageRes> psLanguageResMap = new ConcurrentHashMap<>();
   private List<IPSApplicationLogic> psApplicationLogicList = null;
   private Map<String, IPSAppPDTView> replacePSAppPDTViewMap = null;
   private boolean bEnableServiceAPIDTO = false;
   private Map<String, Object> accessKeyMap = new LinkedHashMap<>();
   private int nACMinChars = 0;
   private boolean bLoadPSAppDEUIActionGroupNow = false;
   private IPSSysSFPlugin iPSSysSFPlugin = null;
   private IPSSFXCodeObject iPSSFXCodeObject = null;
   private IPSSysImage iPSSysImage = null;
   private IPSSysResource iPSSysResource = null;
   private static List<IPSSubAppRef> EmptyPSSubAppRefList = new ArrayList<>();
   private Map<String, IPSAppMethodDTO> psAppMethodDTOMap = new TreeMap<>();
   private int nDynaSysMode = 0;
   private boolean bDynaSysModeDefined = false;
   private Map<String, IPSAppBIScheme> psAppBISchemeMap = new TreeMap<>();
   private Integer nDefaultAppViewCssId = null;
   private String strAppType = null;

   static {
      GlobaDEUIActionMap.put("DATA_CREATEOBJECT", "建立数据");
      GlobaDEUIActionMap.put("DATA_SAVECHANGES", "保存变更");
      GlobaDEUIActionMap.put("DATA_CANCELCHANGES", "取消变更");
      GlobaDEUIActionMap.put("DATA_REMOVEOBJECT", "删除数据");
      GlobaDEUIActionMap.put("DATA_SYNCHRONIZE", "同步数据");
      GlobaDEUIActionMap.put("VIEW_OKACTION", "确定（视图）");
      GlobaDEUIActionMap.put("VIEW_CANCELACTION", "取消（视图）");
      GlobaDEUIActionMap.put("VIEW_YESACTION", "是（视图）");
      GlobaDEUIActionMap.put("VIEW_NOACTION", "否（视图）");
      GlobaDEUIActionMap.put("UTIL_ADDSELECTION", "添加选中数据（数据选择）");
      GlobaDEUIActionMap.put("UTIL_REMOVESELECTION", "移除选中数据（数据选择）");
      GlobaDEUIActionMap.put("UTIL_ADDALL", "添加全部数据（数据选择）");
      GlobaDEUIActionMap.put("UTIL_REMOVEALL", "移除全部数据（数据选择）");
      GlobaDEUIActionMap.put("UTIL_PREVSTEP", "上一步（向导）");
      GlobaDEUIActionMap.put("UTIL_NEXTSTEP", "下一步（向导）");
      GlobaDEUIActionMap.put("UTIL_FINISH", "完成（向导）");
      GlobaDEUIActionMap.put("UTIL_SEARCH", "搜索（搜索栏）");
      GlobaDEUIActionMap.put("UTIL_RESET", "重置（搜索栏）");
      GlobaDEUIActionMap.put("APP_LOGIN", "登录操作");
      GlobaDEUIActionMap.put("APP_LOGOUT", "登出操作");
   }

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemApplication psSystemApplication) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSSystem(iPSSystem);
         this.psSystemApplication = psSystemApplication;
         this.setId(this.psSystemApplication.getPSSYSAPPID());
         this.setName(this.psSystemApplication.getPSSYSAPPNAME());
         ArrayList<PSDevSlnTempl> psDevSlnTemplList = ((IPSSystemRuntime)iPSSystem).getPSDevSlnTemplList();
         if (psDevSlnTemplList != null && psDevSlnTemplList.size() > 0) {
            String strPSDevSlnSysAppId = KeyValueHelper.genUniqueId(iPSSystem.getPSDevSlnSysId(), this.psSystemApplication.getPSSYSAPPID());

            for (PSDevSlnTempl psDevSlnTempl : psDevSlnTemplList) {
               if (!StringHelper.isNullOrEmpty(psDevSlnTempl.getPSDEVSLNSYSAPPID())
                  && StringHelper.compare(psDevSlnTempl.getPSDEVSLNSYSAPPID(), strPSDevSlnSysAppId, true) == 0) {
                  psSystemApplication.setPSPFID(psDevSlnTempl.getPSPFID());
                  psSystemApplication.setPSPFSTYLEID(psDevSlnTempl.getPSPFSTYLEID());
                  psSystemApplication.setPSPFSTYLENAME(psDevSlnTempl.getPSDEVSLNTEMPLNAME());
               }
            }
         }

         this.setPSObjectData(this.psSystemApplication);
         if (!StringHelper.isNullOrEmpty(this.getId())) {
            this.bEnableFolderKey = this.getId().indexOf("S") == 0;
         }

         this.strAppType = this.psSystemApplication.getPSAPPTYPEID();
         if (!this.psSystemApplication.isDEFAULTPUBNull()) {
            this.bDefaultFlag = this.psSystemApplication.getDEFAULTPUB();
         }

         if (StringHelper.isNullOrEmpty(this.psSystemApplication.getPSSYSSFPUBID())) {
            this.iPSSysSFPub = this.getPSSystem().getDefaultPSSysSFPub();
         } else {
            this.iPSSysSFPub = this.getPSSystem().getPSSysSFPub(this.psSystemApplication.getPSSYSSFPUBID());
         }

         if (this.getPSSysSFPub() != null && this.getPSSysSFPub().getPSSFStyle() instanceof IPSSFStyle2) {
            this.strBackendMode = "SERVICE";
            this.strProjectPath = this.getPSSysSFPub().getPSSFStyle().getStyleParam("%APP_PRJ%", null);
         }

         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getAPPMODE())) {
            this.strAppMode = this.psSystemApplication.getAPPMODE();
         }

         if (StringHelper.compare(this.getAppMode(), "WFAPP", false) == 0) {
            this.bWFAppMode = true;
         }

         if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().isPreviewMode()) {
            this.bPreviewMode = true;
         }

         this.strAppFolder = this.psSystemApplication.getAPPFOLDER();
         if (StringHelper.isNullOrEmpty(this.strAppFolder)) {
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
         } else if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getPSDynaInstId())) {
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
         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getMDCTRLEMPTYTEXTPSLANRESID())) {
            this.mdCtrlEmptyTextPSLanguageRes = this.getPSLanguageRes(this.psSystemApplication.getMDCTRLEMPTYTEXTPSLANRESID());
         }

         this.psApplicationUIProxy = new PSApplicationUIProxy(this);
         this.iPSPF = this.getPSModelStorage().getPSPF(this.psSystemApplication.getPSPFID());
         this.iPSPFStyle = this.getPSSystemUtil()
            .getPSPFStyle(this.psSystemApplication.getPSPFID(), this.psSystemApplication.getPSPFSTYLEID(), this.getCodeName());
         this.defaultPSPF = this.iPSPF;
         this.defaultPSPFStyle = this.iPSPFStyle;
         PSAppUIStyleImpl psAppUIStyleImpl = null;
         if (PSJITWebContext.getInstance() != null && PSJITWebContext.getInstance().isPreviewMode()) {
            PSAppUIStyle psAppUIStyle = new PSAppUIStyle();
            psAppUIStyle.setPSAPPUISTYLEID("PREVIEW");
            psAppUIStyle.setPSAPPUISTYLENAME("应用预览模式");
            psAppUIStyle.setUISTYLE("PREVIEW");
            if (this.iPSPF.getPSAppType() != null) {
               if (StringHelper.compare("WEBAPP_HTML5", this.iPSPF.getPSAppType().getId(), true) == 0) {
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
         if (!this.bPreviewMode && !StringHelper.isNullOrEmpty(this.psSystemApplication.getUISTYLE())) {
            this.psAppUIStyleGlobalModel.getAllModelHelpers();
            this.iPSAppUIStyle = this.psAppUIStyleGlobalModel.FindModelHelper(this.psSystemApplication.getUISTYLE(), true);
         }

         if (psAppUIStyleImpl != null) {
            this.iPSAppUIStyle = psAppUIStyleImpl;
         }

         if (this.iPSAppUIStyle != null) {
            this.iPSPF = this.iPSAppUIStyle.getPSPF();
            this.iPSPFStyle = this.iPSAppUIStyle.getPSPFStyle();
            this.strUIStyle = this.iPSAppUIStyle.getUIStyle();
         } else if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getUISTYLE())) {
            this.strUIStyle = this.psSystemApplication.getUISTYLE();
         }

         if (this.iPSPF.getPSAppType() != null) {
            this.bUseServiceApi = this.iPSPF.getPSAppType().isUseServiceApi();
            this.bMobileApp = this.iPSPF.getPSAppType().isMobileApp();
         }

         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psSystemApplication.getPSSYSIMAGEID());
         }

         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getPSPFCDNID())) {
            this.iPSPFCDN = this.getPSModelStorage().getPSPFCDN(this.psSystemApplication.getPSPFCDNID());
         }

         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getPSSYSSERVICEAPIID())) {
            this.iPSSysServiceAPI = this.getPSSystem().getPSSysServiceAPI(this.psSystemApplication.getPSSYSSERVICEAPIID());
         }

         if (this.getPSSysServiceAPI() != null) {
            this.bUseServiceApi = true;
         } else {
            this.bUseServiceApi = false;
         }

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

         String strPFStyleParams = this.iPSPFStyle.getPFStyleParams();
         if (!StringHelper.isNullOrEmpty(strPFStyleParams)) {
            strPFStyleParams = strPFStyleParams + "\r\n";
         }

         strPFStyleParams = strPFStyleParams + this.psSystemApplication.getPFSTYLEPARAM();
         this.pfStyleParams = PropertiesHelper.Load(strPFStyleParams);
         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSystemApplication.getPSSYSRESOURCEID());
         }

         if (!StringHelper.isNullOrEmpty(this.psSystemApplication.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSystemApplication.getPSSYSSFPLUGINID());
         }

         if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId(this.getPSSysSFPlugin().getId(), this.getPSSystem().getPSSFId());
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
      } catch (Exception ex) {
         String strLogName = StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
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
      String strDefaultAppViewCssId = this.getPFStyleParam("DEFAULTAPPVIEWCSS", "");
      if (!StringHelper.isNullOrEmpty(strDefaultAppViewCssId)) {
         this.defaultAppViewPSSysCss = this.getPSSystem().getPSSysCss(strDefaultAppViewCssId);
      }
   }

   protected void preparePSPFPkgVers() throws Exception {
      HashMap<String, IPSPFPkgVer> psPFPkgVerMap = new LinkedHashMap<>();
      Iterator<IPSPFPkgVer> psPFPkgVers = this.getPSPFStyle().getPSPFPkgVers();

      while (psPFPkgVers.hasNext()) {
         IPSPFPkgVer iPSPFPkgVer = psPFPkgVers.next();
         if (this.getPSPFCDN() != null) {
            IPSPFPkgVerCDN iPSPFPkgVerCDN = this.getPSPF()
               .getPSPFPkgVerCDN(iPSPFPkgVer.getId(), this.getPSPFCDN().getId(), this.getPSSystem().getPSDevCenterId(), true);
            if (iPSPFPkgVerCDN != null) {
               iPSPFPkgVer = new PSPFPkgVerProxy(iPSPFPkgVerCDN, iPSPFPkgVer.getOrderValue());
            }
         }

         psPFPkgVerMap.put(iPSPFPkgVer.getPSPFPkg().getId(), iPSPFPkgVer);
      }

      Iterator<IPSAppPkg> psAppPkgs = this.getPSAppPkgs();

      while (psAppPkgs.hasNext()) {
         IPSAppPkg iPSAppPkg = psAppPkgs.next();
         if (iPSAppPkg.getPSPFPkg() != null) {
            psPFPkgVerMap.put(iPSAppPkg.getPSPFPkg().getId(), iPSAppPkg);
         } else {
            this.psPFPkgVerList.add(iPSAppPkg);
         }
      }

      this.psPFPkgVerList.addAll(psPFPkgVerMap.values());
      Collections.sort(this.psPFPkgVerList, new Comparator<IPSPFPkgVer>() {
         public int compare(IPSPFPkgVer arg0, IPSPFPkgVer arg1) {
            int nValue = arg0.getOrderValue() - arg1.getOrderValue();
            return nValue == 0 ? 0 : nValue;
         }
      });
   }

   protected void preparePSAppDERSs() throws Exception {
      this.psAppDERSList.clear();
      Vector<PSAppDERS> list = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getAllPSAppDERSs(this.getId(), list);
      if (callResult.isError()) {
         throw new Exception(StringHelper.format("查询应用全部应用实体关系发生错误, %1$s", callResult.getErrorInfo()));
      }

      Iterator<IPSAppDataEntity> psDataEntities = this.getAllPSAppDataEntities();
      if (psDataEntities != null) {
         Map<String, IPSAppDERS> psAppDERSMap = new LinkedHashMap<>();
         if (!this.isEnableUIModelEx()) {
            for (PSAppDERS psAppDERS : list) {
               PSAppDERSImpl psAppDERSImpl = new PSAppDERSImpl();
               psAppDERSImpl.init(this.getDAGlobalHelper(), this, psAppDERS);
               String strTag = StringHelper.format("%1$s-%2$s", psAppDERSImpl.getPPSAppDataEntityId(), psAppDERSImpl.getCPSAppDataEntityId());
               if (!psAppDERSMap.containsKey(strTag)) {
                  psAppDERSMap.put(strTag, psAppDERSImpl);
                  this.psAppDERSList.add(psAppDERSImpl);
               }
            }
         } else {
            Iterator<IPSAppDataEntity> psDataEntitiesx = this.getAllPSAppDataEntities();

            while (psDataEntitiesx.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psDataEntitiesx.next();
               if (iPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_DTOONLY
                  || iPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_LOCALONLY
                  || iPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_LOCALANDREMOTE
                  || iPSAppDataEntity.getPSDEServiceAPI() != null && iPSAppDataEntity.getPSDEServiceAPI().getAPIMode() == 9) {
                  Iterator<IPSDERBase> psDERBases = iPSAppDataEntity.getPSDataEntity().getMinorPSDERs();
                  if (psDERBases != null) {
                     while (psDERBases.hasNext()) {
                        IPSDERBase iPSDERBase = psDERBases.next();
                        String strDERType = iPSDERBase.getDERType();
                        if ("DERCUSTOM".equals(strDERType)) {
                           strDERType = ((IPSDERCustom)iPSDERBase).getDERSubType();
                        }

                        if ("DER11".equals(strDERType) || "DER1N".equals(strDERType)) {
                           IPSAppDataEntity majorPSAppDataEntity = this.getPSAppDataEntity(iPSDERBase.getMajorPSDataEntity(), true);
                           if (majorPSAppDataEntity != null) {
                              boolean bNested = false;
                              if (iPSDERBase instanceof IPSDER1N) {
                                 IPSDER1N iPSDER1N = (IPSDER1N)iPSDERBase;
                                 bNested = iPSDER1N.isNestedRS() || iPSDER1N.getTempDataOrder() >= 0;
                              } else if (iPSDERBase instanceof IPSDERCustom) {
                                 IPSDERCustom iPSDERCustom = (IPSDERCustom)iPSDERBase;
                                 bNested = (iPSDERCustom.getMasterRS() & 8) == 8;
                              }

                              if (bNested
                                 || majorPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_DTOONLY
                                 || majorPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_LOCALONLY
                                 || majorPSAppDataEntity.getStorageMode() == IPSAppDataEntity.STORAGEMODE_LOCALANDREMOTE
                                 || majorPSAppDataEntity.getPSDEServiceAPI() != null && majorPSAppDataEntity.getPSDEServiceAPI().getAPIMode() == 9) {
                                 PSAppDERSImpl3 psAppDERSImpl3 = new PSAppDERSImpl3();
                                 psAppDERSImpl3.init(this.getDAGlobalHelper(), this, iPSDERBase, majorPSAppDataEntity, iPSAppDataEntity);
                                 this.psAppDERSList.add(psAppDERSImpl3);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         Iterator<IPSSysServiceAPI> psSysServiceAPIs = this.getAllPSSysServiceAPIs();
         if (psSysServiceAPIs != null) {
            Map<String, IPSAppDataEntity> psDataEntitityMap = new LinkedHashMap<>();
            Iterator<IPSAppDataEntity> psDataEntitiesx = this.getAllPSAppDataEntities();

            while (psDataEntitiesx.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psDataEntitiesx.next();
               if (iPSAppDataEntity.getPSDEServiceAPI() != null
                  && (!psDataEntitityMap.containsKey(iPSAppDataEntity.getPSDEServiceAPI().getId()) || iPSAppDataEntity.isMajor())) {
                  psDataEntitityMap.put(iPSAppDataEntity.getPSDEServiceAPI().getId(), iPSAppDataEntity);
               }
            }

            while (psSysServiceAPIs.hasNext()) {
               IPSSysServiceAPI iPSSysServiceAPI = psSysServiceAPIs.next();
               Iterator<IPSDEServiceAPIRS> psDEServiceAPIRSs = iPSSysServiceAPI.getPSDEServiceAPIRSs();
               if (psDEServiceAPIRSs != null) {
                  while (psDEServiceAPIRSs.hasNext()) {
                     IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                     IPSDEServiceAPI majorPSDEServiceAPI = iPSDEServiceAPIRS.getMajorPSDEServiceAPI();
                     IPSDEServiceAPI minorPSDEServiceAPI = iPSDEServiceAPIRS.getMinorPSDEServiceAPI();
                     if (majorPSDEServiceAPI == null || minorPSDEServiceAPI == null) {
                        throw new Exception(StringHelper.format("实体服务接口关系[%1$s]逻辑有误，没有主接口或是从接口对象", iPSDEServiceAPIRS.getName()));
                     }

                     IPSAppDataEntity majorPSAppDataEntity = psDataEntitityMap.get(majorPSDEServiceAPI.getId());
                     IPSAppDataEntity minorPSAppDataEntity = psDataEntitityMap.get(minorPSDEServiceAPI.getId());
                     if (majorPSAppDataEntity != null && minorPSAppDataEntity != null) {
                        String strTag = StringHelper.format("%1$s-%2$s", majorPSAppDataEntity.getId(), minorPSAppDataEntity.getId());
                        if (!psAppDERSMap.containsKey(strTag)) {
                           PSAppDERSImpl2 psAppDERSImpl2 = new PSAppDERSImpl2();
                           psAppDERSImpl2.init(this.getDAGlobalHelper(), this, iPSDEServiceAPIRS, majorPSAppDataEntity, minorPSAppDataEntity);
                           this.psAppDERSList.add(psAppDERSImpl2);
                           psAppDERSMap.put(strTag, psAppDERSImpl2);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @PSModelRTMeta(description = "默认应用", fields = "DEFAULTPUB", ignorert = 3)
   @Override
   public boolean getDefaultFlag() {
      return this.bDefaultFlag;
   }

   @PSModelRTMeta(description = "前端模板", dynamodelmode = 12, fields = "PSPFID")
   @Override
   public String getPFType() {
      return this.iPSPF != null ? this.iPSPF.getId() : this.psSystemApplication.getPSPFID();
   }

   @PSModelRTMeta(description = "前端模板样式", dynamodelmode = 12, fields = "PSPFSTYLEID")
   @Override
   public String getPFStyle() {
      return this.iPSPFStyle != null && !StringHelper.isNullOrEmpty(this.iPSPFStyle.getId())
         ? this.iPSPFStyle.getId()
         : this.psSystemApplication.getPSPFSTYLEID();
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

      IPSAppView iPSAppView = this.psApplicationViewGlobalModel.FindModelHelper(strPSApplicationViewId, true);
      if (iPSAppView == null && !bTryMode) {
         if (!StringHelper.isNullOrEmpty(strOriginViewId)) {
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            CallResult callResult = this.getPSModelHelper().getPSDEViewBase(strOriginViewId, psDEViewBase);
            if (callResult.isOk()) {
               throw PSApplicationException.create(this, 40012, strPSApplicationViewId, strOriginViewId);
            }
         }

         throw PSApplicationException.create(this, 40012, strPSApplicationViewId, strOriginViewId);
      } else {
         return iPSAppView;
      }
   }

   @Override
   public IPSAppView getPSAppView(String strPSApplicationViewId, boolean bTryMode) throws Exception {
      if (this.replacePSAppPDTViewMap != null) {
         IPSAppPDTView iPSAppPDTView = this.replacePSAppPDTViewMap.get(strPSApplicationViewId);
         if (iPSAppPDTView != null) {
            return iPSAppPDTView.getPSAppView();
         }
      }

      IPSAppView iPSAppView = this.psApplicationViewGlobalModel.FindModelHelper(strPSApplicationViewId, bTryMode);
      return iPSAppView;
   }

   @Override
   public void resetPSAppView(String strPSApplicationViewId) {
      this.psApplicationViewGlobalModel.ResetModel(strPSApplicationViewId);
   }

   @PSModelRTMeta(description = "应用模块集合", child = true, dumpref = true, rtdump = 2, ignorepf = true, dynamodelmode = 8, group = "基本", order = 240)
   @Override
   public Iterator<IPSAppModule> getAllPSAppModules() throws Exception {
      return this.psAppModuleGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppModule getPSAppModule(String strPSAppModuleId) throws Exception {
      return this.psAppModuleGlobalModel.FindModelHelper(strPSAppModuleId);
   }

   @Override
   public void resetPSAppModule(String strPSAppModuleId) {
      this.psAppModuleGlobalModel.ResetModel(strPSAppModuleId);
   }

   @Override
   public IPSSubAppRef getPSSubAppRef(String strPSSubAppRefId) throws Exception {
      return this.psSubAppRefGlobalModel.FindModelHelper(strPSSubAppRefId);
   }

   @Override
   public void resetPSSubAppRef(String strPSSubAppRefId) {
      this.psSubAppRefGlobalModel.ResetModel(strPSSubAppRefId);
   }

   @PSModelRTMeta(description = "代码包名称", fields = "APPPKGNAME")
   @Override
   public String getPKGCodeName() {
      return PSJITWebContext.getInstance() != null ? PSJITWebContext.getInstance().getPSAppName() : this.psSystemApplication.getAPPPKGNAME();
   }

   @PSModelRTMeta(description = "代码标识", fields = "APPPKGNAME")
   @Override
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
      return this.psAppViewStyleGlobalModel.FindModelHelper(strPSAppViewStyleId);
   }

   @Override
   public void resetPSAppViewStyle(String strPSAppViewStyleId) {
      this.psAppViewStyleGlobalModel.ResetModel(strPSAppViewStyleId);
   }

   @Override
   public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType iPSEditorType, String strContainerType, IPSPFPubCode iPSPFPubCode, String strStyle) throws Exception {
      try {
         String strPSAppEditorTemplId = Helper.GenUniqueId(this.getId(), iPSEditorType.getId(), strStyle, strContainerType, iPSPFPubCode.getId());
         IPSAppEditorTempl iPSAppEditorTempl = this.psAppEditorTemplGlobalModel.FindModelHelper(strPSAppEditorTemplId, true);
         if (iPSAppEditorTempl != null) {
            return iPSAppEditorTempl;
         }

         if (StringHelper.compare(iPSEditorType.getStandardPSEditorType(), iPSEditorType.getId(), false) != 0) {
            strPSAppEditorTemplId = Helper.GenUniqueId(this.getId(), iPSEditorType.getStandardPSEditorType(), strStyle, strContainerType, iPSPFPubCode.getId());
            iPSAppEditorTempl = this.psAppEditorTemplGlobalModel.FindModelHelper(strPSAppEditorTemplId, true);
            if (iPSAppEditorTempl != null) {
               return iPSAppEditorTempl;
            }
         }

         return this.getPSPFStyle().getPSPFEditorTempl(iPSEditorType, strContainerType, iPSPFPubCode);
      } catch (Exception ex) {
         log.error(StringHelper.format("获取编辑器模板[%1$s/%2$s/%3$s/%4$s]发生错误", iPSEditorType.getId(), strContainerType, iPSPFPubCode.getName(), strStyle));
         throw ex;
      }
   }

   @Override
   public IPSAppFunc getPSAppFunc(String strPSAppFuncId) throws Exception {
      return this.psAppFuncGlobalModel.FindModelHelper(strPSAppFuncId);
   }

   @Override
   public IPSAppFunc getPSAppFunc(String strPSAppFuncId, boolean bTryMode) throws Exception {
      return this.psAppFuncGlobalModel.FindModelHelper(strPSAppFuncId, bTryMode);
   }

   @Override
   public IPSAppFunc getPSAppFunc(String strPSAppFuncId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
      IPSAppFunc iPSAppFunc = this.getPSAppFunc(strPSAppFuncId, bTryMode);
      if (iPSAppFunc != null) {
         registerRefPSModelObject(iPSAppFunc, refPSModelObject);
      }

      return iPSAppFunc;
   }

   @Override
   public void resetPSAppFunc(String strPSAppFuncId) {
      this.psAppFuncGlobalModel.ResetModel(strPSAppFuncId);
   }

   @PSModelRTMeta(description = "应用功能集合", child = true, group = "应用逻辑", order = 220)
   @Override
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

   @PSModelRTMeta(description = "应用视图集合", child = true, dumpref = true, rtdump = 2, ignorert = 3, modelreftype = "APPLICATION", group = "应用视图", order = 190)
   @Override
   public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
      return this.psApplicationViewGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "应用视图集合（被引用）")
   @Override
   public Iterator<IPSAppView> getAllRefPSAppViews() throws Exception {
      if (this.refPSAppViewList != null) {
         return this.refPSAppViewList.iterator();
      }

      synchronized (this) {
         ArrayList<IPSAppView> psAppViewList = new ArrayList<>();
         Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

         while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            if (iPSAppView.getRefFlag()) {
               psAppViewList.add(iPSAppView);
            }
         }

         if (this.refPSAppViewList == null) {
            this.refPSAppViewList = psAppViewList;
         }
      }

      return this.refPSAppViewList.iterator();
   }

   @Override
   public IPSAppViewCode getPSAppViewCode(String strPSAppViewCodeId, boolean bTryMode) throws Exception {
      return this.psAppViewCodeGlobalModel.FindModelHelper(strPSAppViewCodeId, bTryMode);
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
         if (nLoadLevel > this.nLoadedLevel) {
            if (this.isLoading()) {
               throw new Exception("正在加载中，无法重复加载");
            }

            if (!this.getPSSystem().isDynaInstMode()) {
               PSAppDEViewRefService psAppDEViewRefService = (PSAppDEViewRefService)ServiceGlobal.getService(
                  PSAppDEViewRefService.class, PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId())
               );
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
            Vector<PSAppPFPlugin> pfAppPFPluginList = new Vector<>();
            CallResult callResult = this.getPSModelHelper().getAllPSAppPFPlugins(this.getId(), pfAppPFPluginList);
            if (callResult.isError()) {
               throw new Exception(String.format("获取应用前端插件发生异常，%1$s", callResult.getErrorInfo()));
            }

            for (PSAppPFPlugin psAppPFPlugin : pfAppPFPluginList) {
               this.getPSSysPFPlugin(psAppPFPlugin.getPSSYSPFPLUGINID(), "APP", psAppPFPlugin.getCODENAME(), null);
            }

            Iterator<IPSAppPDTView> psAppPDTViews = this.getAllPSAppPDTViews();
            if (psAppPDTViews != null) {
               while (psAppPDTViews.hasNext()) {
                  IPSAppPDTView iPSAppPDTView = psAppPDTViews.next();
                  if (iPSAppPDTView.getPSSysPDTView() != null && iPSAppPDTView.getPSSysPDTView().isFromDEViewToPDTView()) {
                     String strPSDEViewBaseId = iPSAppPDTView.getPSSysPDTView().getPSDEViewBaseId();
                     if (!StringHelper.isNullOrEmpty(strPSDEViewBaseId)) {
                        if (this.replacePSAppPDTViewMap == null) {
                           this.replacePSAppPDTViewMap = new LinkedHashMap<>();
                        }

                        this.replacePSAppPDTViewMap.put(strPSDEViewBaseId, iPSAppPDTView);
                        this.replacePSAppPDTViewMap.put(KeyValueHelper.genUniqueId(this.getId(), strPSDEViewBaseId), iPSAppPDTView);
                     }
                  }
               }
            }

            Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs = this.getAllPSAppSubViewTypeRefs();
            if (psAppSubViewTypeRefs != null) {
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

               String strLoadDEUAGroups = this.getUserParam("SRFLOADDEUAGROUPS", null);
               if (!StringHelper.isNullOrEmpty(strLoadDEUAGroups)) {
                  strLoadDEUAGroups = strLoadDEUAGroups.trim();
                  if (!StringHelper.isNullOrEmpty(strLoadDEUAGroups)) {
                     String[] uagroups = strLoadDEUAGroups.split("[;]");
                     String[] iPSSysTestPrj = uagroups;
                     int psSysTestPrjs = uagroups.length;

                     for (int psAppWFVers = 0; psAppWFVers < psSysTestPrjs; psAppWFVers++) {
                        String strUAGroup = iPSSysTestPrj[psAppWFVers];
                        if (!StringHelper.isNullOrEmpty(strUAGroup)) {
                           Iterator<IPSAppDataEntity> var22 = this.getAllPSAppDataEntities();

                           while (var22.hasNext()) {
                              IPSAppDataEntity iPSAppDataEntity = (IPSAppDataEntity)var22.next();
                              iPSAppDataEntity.getPSAppDEUIActionGroup(strUAGroup, true);
                           }
                        }
                     }
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
                  if (!StringHelper.isNullOrEmpty(strPredefinedType) && GlobaDEUIActionMap.containsKey(strPredefinedType)) {
                     this.getPSAppDEUIAction(iPSDEUIAction.getId());
                  }
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
                  if (!StringHelper.isNullOrEmpty(iPSAppFunc.getAccessKey())) {
                     this.accessKeyMap.put(iPSAppFunc.getAccessKey(), null);
                  }
               }
            }

            this.getAllPSAppUserModes();
            this.getAllPSAppLocalDEs();
            Iterator<IPSAppMenuModel> psAppMenuModels = this.getAllPSAppMenuModels();
            if (psAppMenuModels != null) {
               while (psAppMenuModels.hasNext()) {
                  IPSAppMenuModel iPSAppMenuModel = psAppMenuModels.next();
                  Iterator<IPSAppMenuItem> psAppMenuItems = iPSAppMenuModel.getPSAppMenuItems();
                  if (psAppMenuItems != null) {
                     while (psAppMenuItems.hasNext()) {
                        this.fillPSAppMenuItemAccessKey(psAppMenuItems.next());
                     }
                  }
               }
            }

            Iterator<IPSAppDataEntity> psAppDataEntitiesx = this.getAllPSAppDataEntities();

            while (psAppDataEntitiesx.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psAppDataEntitiesx.next();
               Iterator<IPSAppDEUIAction> psAppDEUIActions = iPSAppDataEntity.getAllPSAppDEUIActions();
               if (psAppDEUIActions != null) {
                  while (psAppDEUIActions.hasNext()) {
                     IPSAppDEUIAction iPSAppDEUIAction = psAppDEUIActions.next();
                     IPSUIAction nextPSUIAction = iPSAppDEUIAction.getNextPSUIAction();
                     if (nextPSUIAction instanceof IPSAppDEUIAction) {
                        IPSAppDEUIAction nextPSAppDEUIAction = (IPSAppDEUIAction)nextPSUIAction;
                        if (nextPSAppDEUIAction.getPSAppDataEntity() != null) {
                           nextPSAppDEUIAction.getPSAppDataEntity().getPSAppDEUIAction(nextPSAppDEUIAction.getId(), false);
                        }
                     }
                  }
               }
            }

            int nLastTotal = -1;

            while (true) {
               List<IPSAppDEUILogic> list = new ArrayList<>();
               List<IPSAppDEUIAction> list2 = new ArrayList<>();
               List<IPSAppDEACMode> list3 = new ArrayList<>();
               psAppDataEntitiesx = this.getAllPSAppDataEntities();

               while (psAppDataEntitiesx.hasNext()) {
                  IPSAppDataEntity iPSAppDataEntity = psAppDataEntitiesx.next();
                  Iterator<IPSAppDEUILogic> psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics();
                  if (psAppDEUILogics != null) {
                     while (psAppDEUILogics.hasNext()) {
                        list.add(psAppDEUILogics.next());
                     }
                  }

                  Iterator<? extends IPSAppDEUIAction> psAppDEUIActions = iPSAppDataEntity.getAllPSAppDEUIActions();
                  if (psAppDEUIActions != null) {
                     while (psAppDEUIActions.hasNext()) {
                        list2.add(psAppDEUIActions.next());
                     }
                  }

                  Iterator<? extends IPSAppDEACMode> psAppDEACModes = iPSAppDataEntity.getAllPSAppDEACModes();
                  if (psAppDEACModes != null) {
                     while (psAppDEACModes.hasNext()) {
                        list3.add(psAppDEACModes.next());
                     }
                  }
               }

               if (nLastTotal == -1) {
                  nLastTotal = list.size() + list2.size() + list3.size();
               } else {
                  int nTotal = list.size() + list2.size() + list3.size();
                  if (nTotal == 0 || nLastTotal == nTotal) {
                     psAppDataEntitiesx = this.getAllPSAppDataEntities();

                     while (psAppDataEntitiesx.hasNext()) {
                        IPSAppDataEntity iPSAppDataEntity = psAppDataEntitiesx.next();
                        Iterator<IPSAppDEUIAction> psAppDEUIActions = iPSAppDataEntity.getAllPSAppDEUIActions();
                        if (psAppDEUIActions != null) {
                           while (psAppDEUIActions.hasNext()) {
                              IPSAppDEUIAction iPSAppDEUIAction = psAppDEUIActions.next();
                              IPSDEOPPriv iPSDEOPPriv = iPSAppDEUIAction.getPSDEOPPriv();
                              if (iPSDEOPPriv != null && iPSDEOPPriv.isMapSysUniRes() && !StringHelper.isNullOrEmpty(iPSDEOPPriv.getMapSysUniResCode())) {
                                 this.accessKeyMap.put(iPSDEOPPriv.getMapSysUniResCode(), null);
                              }
                           }
                        }

                        Iterator<IPSDEOPPriv> psDEOPPrivs = iPSAppDataEntity.getPSDataEntity().getAllPSDEOPPrivs();
                        if (psDEOPPrivs != null) {
                           while (psDEOPPrivs.hasNext()) {
                              IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                              if (iPSDEOPPriv.isMapSysUniRes() && !StringHelper.isNullOrEmpty(iPSDEOPPriv.getMapSysUniResCode())) {
                                 this.accessKeyMap.put(iPSDEOPPriv.getMapSysUniResCode(), null);
                              }
                           }
                        }

                        Iterator<IPSAppDEReport> psAppDEReports = iPSAppDataEntity.getAllPSAppDEReports();
                        if (psAppDEReports != null) {
                           while (psAppDEReports.hasNext()) {
                              IPSAppDEReport iPSAppDEReport = psAppDEReports.next();
                              if (!StringHelper.isNullOrEmpty(iPSAppDEReport.getSysUniResCode())) {
                                 this.accessKeyMap.put(iPSAppDEReport.getSysUniResCode(), null);
                              }
                           }
                        }
                     }

                     Iterator<IPSAppDEUIAction> psAppDEUIActions = this.getAllPSAppDEUIActions();
                     if (psAppDEUIActions != null) {
                        while (psAppDEUIActions.hasNext()) {
                           IPSAppDEUIAction iPSAppDEUIAction = psAppDEUIActions.next();
                           IPSDEOPPriv iPSDEOPPriv = iPSAppDEUIAction.getPSDEOPPriv();
                           if (iPSDEOPPriv != null && iPSDEOPPriv.isMapSysUniRes() && !StringHelper.isNullOrEmpty(iPSDEOPPriv.getMapSysUniResCode())) {
                              this.accessKeyMap.put(iPSDEOPPriv.getMapSysUniResCode(), null);
                           }
                        }
                     }

                     Map<String, IPSAppMethodDTO> psAppMethodDTOMap = new HashMap<>();

                     boolean bLoop;
                     do {
                        List<IPSAppMethodDTO> methodDTOs = new ArrayList<>();
                        Iterator<IPSAppMethodDTO> psAppMethodDTOs = this.getAllPSAppMethodDTOs();
                        if (psAppMethodDTOs != null) {
                           while (psAppMethodDTOs.hasNext()) {
                              IPSAppMethodDTO iPSAppMethodDTO = psAppMethodDTOs.next();
                              methodDTOs.add(iPSAppMethodDTO);
                           }
                        }

                        bLoop = false;

                        for (IPSAppMethodDTO iPSAppMethodDTO : methodDTOs) {
                           if (!psAppMethodDTOMap.containsKey(iPSAppMethodDTO.getCodeName())) {
                              iPSAppMethodDTO.check();
                              psAppMethodDTOMap.put(iPSAppMethodDTO.getCodeName(), iPSAppMethodDTO);
                              bLoop = true;
                           }
                        }
                     } while (bLoop);

                     this.getAllPSMobAppStartPages();
                     this.getAllPSMobAppIcons();
                     this.getAllPSAppPortlets();
                     this.registerPSApplicationLogics();
                     Map<String, Object> psViewTypeMap = new HashMap<>();
                     Iterator<IPSAppView> viewCheckIterator = this.getAllPSAppViews();

                     while (viewCheckIterator.hasNext()) {
                        IPSAppView iPSAppView = viewCheckIterator.next();
                        iPSAppView.checkViewEnv();
                        if (!StringHelper.isNullOrEmpty(iPSAppView.getAccessKey())) {
                           this.accessKeyMap.put(iPSAppView.getAccessKey(), null);
                        }

                        psViewTypeMap.put(iPSAppView.getViewType(), "");
                        if (!this.bDynaSysModeDefined && this.nDynaSysMode == 0 && iPSAppView.getDynaSysMode() != 0) {
                           this.nDynaSysMode = iPSAppView.getDynaSysMode();
                        }
                     }

                     if (this.isEnableUIModelEx()) {
                        Iterator<IPSSubViewType> psSubViewTypes = this.getPSSystem().getAllPSSubViewTypes();
                        if (psSubViewTypes != null) {
                           while (psSubViewTypes.hasNext()) {
                              IPSSubViewType iPSSubViewType = psSubViewTypes.next();
                              if (iPSSubViewType.isReplaceDefault() && psViewTypeMap.containsKey(iPSSubViewType.getViewType())) {
                                 this.getPSSubViewType(iPSSubViewType.getId(), iPSSubViewType.getViewType());
                              }
                           }
                        }
                     }

                     Iterator<IPSAppWF> psAppWFs = this.getAllPSAppWFs();
                     if (psAppWFs != null) {
                        while (psAppWFs.hasNext()) {
                           IPSAppWF iPSAppWF = psAppWFs.next();
                           if (iPSAppWF != null) {
                              iPSAppWF.check();
                           }
                        }
                     }

                     Iterator<IPSAppWFVer> psAppWFVers = this.getAllPSAppWFVers();
                     if (psAppWFVers != null) {
                        while (psAppWFVers.hasNext()) {
                           IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
                           if (iPSAppWFVer != null) {
                              iPSAppWFVer.check();
                           }
                        }
                     }

                     if (this.isEnableUIModelEx() && this.isEnableBIScheme()) {
                        Iterator<? extends IPSSysBIScheme> psSysBISchemes = this.getPSSystem().getAllPSSysBISchemes();
                        if (psSysBISchemes != null) {
                           while (psSysBISchemes.hasNext()) {
                              IPSSysBIScheme iPSSysBIScheme = psSysBISchemes.next();
                              Iterator<? extends IPSSysBICube> psSysBICubes = iPSSysBIScheme.getAllPSSysBICubes();
                              if (psSysBICubes != null) {
                                 while (psSysBICubes.hasNext()) {
                                    IPSSysBICube iPSSysBICube = psSysBICubes.next();
                                    if (iPSSysBICube.getPSDataEntity() != null) {
                                       IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity(iPSSysBICube.getPSDataEntity(), true);
                                       if (iPSAppDataEntity != null) {
                                          IPSAppBICube iPSAppBICube = this.getPSAppBIScheme(iPSSysBIScheme).getPSAppBICube(iPSSysBICube, false);
                                          if (!StringHelper.isNullOrEmpty(iPSAppBICube.getAccessKey())) {
                                             this.accessKeyMap.put(iPSAppBICube.getAccessKey(), null);
                                          }
                                       }
                                    }
                                 }
                              }

                              Iterator<? extends IPSSysBIReport> psSysBIReports = iPSSysBIScheme.getAllPSSysBIReports();
                              if (psSysBIReports != null) {
                                 while (psSysBIReports.hasNext()) {
                                    IPSSysBIReport iPSSysBIReport = psSysBIReports.next();
                                    if (iPSSysBIReport.getPSSysBICube() != null) {
                                       IPSAppBICube iPSAppBICube = this.getPSAppBIScheme(iPSSysBIScheme).getPSAppBICube(iPSSysBIReport.getPSSysBICube(), true);
                                       if (iPSAppBICube != null) {
                                          IPSAppBIReport iPSAppBIReport = this.getPSAppBIScheme(iPSSysBIScheme).getPSAppBIReport(iPSSysBIReport, false);
                                          if (!StringHelper.isNullOrEmpty(iPSAppBIReport.getAccessKey())) {
                                             this.accessKeyMap.put(iPSAppBIReport.getAccessKey(), null);
                                          }
                                       }
                                    }
                                 }
                              }

                              iPSSysBIScheme.check();
                           }
                        }
                     }

                     if (this.isEnableDynaDashboard()) {
                        this.preparePSAppPortlets();
                     }

                     Iterator<IPSSysTestPrj> psSysTestPrjs = this.getAllPSSysTestPrjs();
                     if (psSysTestPrjs != null) {
                        while (psSysTestPrjs.hasNext()) {
                           IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                           iPSSysTestPrj.check();
                        }
                     }

                     this.logPSModelLoadLog(0, null, null);
                     this.nLoadedLevel = nLoadLevel;
                     this.bLoading = false;
                     return;
                  }

                  nLastTotal = nTotal;
               }

               for (IPSAppDEUILogic iPSAppDEUILogic : list) {
                  iPSAppDEUILogic.check();
               }

               for (IPSAppDEUIAction iPSAppDEUIAction : list2) {
                  iPSAppDEUIAction.check();
               }

               for (IPSAppDEACMode iPSAppDEACMode : list3) {
                  iPSAppDEACMode.check();
               }
            }
         }
      } catch (Exception ex) {
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

      this.psAppPortletList = new ArrayList<>();
      this.appPSAppPortletList = new ArrayList<>();
      Map<String, IPSSysPortlet> psSysPortletMap = new LinkedHashMap<>();
      Iterator<IPSAppPortlet> psAppPortlets = this.psAppPortletGlobalModel.getAllModelHelpers();
      if (psAppPortlets != null) {
         while (psAppPortlets.hasNext()) {
            IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
            if (iPSAppPortlet.getPSControl() != null) {
               this.psAppPortletList.add(iPSAppPortlet);
               if (iPSAppPortlet.getPSSysPortlet() != null) {
                  psSysPortletMap.put(iPSAppPortlet.getPSSysPortlet().getId(), iPSAppPortlet.getPSSysPortlet());
               }
            }
         }
      }

      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         ArrayList<IPSControl> psControlList = iPSAppView.getAllPSControls();
         if (psControlList != null) {
            for (IPSControl iPSControl : psControlList) {
               if (iPSControl instanceof IPSDashboard) {
                  IPSDashboard iPSDashboard = (IPSDashboard)iPSControl;
                  Iterator<IPSDBPortletPart> psDBPortletParts = iPSDashboard.getAllPSPortlets();
                  if (psDBPortletParts != null) {
                     while (psDBPortletParts.hasNext()) {
                        IPSDBPortletPart iPSDBPortletPart = psDBPortletParts.next();
                        if (!(iPSDBPortletPart instanceof IPSDBContainerPortletPart)) {
                           if (iPSDBPortletPart instanceof IPSDBSysPortletPart) {
                              IPSDBSysPortletPart iPSDBSysPortletPart = (IPSDBSysPortletPart)iPSDBPortletPart;
                              if (iPSDBSysPortletPart.getPSSysPortlet() != null && psSysPortletMap.containsKey(iPSDBSysPortletPart.getPSSysPortlet().getId())) {
                                 continue;
                              }
                           }

                           PSAppPortletImpl psAppPortletImpl = new PSAppPortletImpl();
                           psAppPortletImpl.init(this.getDAGlobalHelper(), this, iPSDBPortletPart);
                           this.psAppPortletList.add(psAppPortletImpl);
                           if (psAppPortletImpl.getPSSysPortlet() != null) {
                              psSysPortletMap.put(psAppPortletImpl.getPSSysPortlet().getId(), psAppPortletImpl.getPSSysPortlet());
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      for (IPSAppPortlet iPSAppPortlet : this.psAppPortletList) {
         if (iPSAppPortlet.isEnableAppDashboard()) {
            this.appPSAppPortletList.add(iPSAppPortlet);
         }
      }

      Collections.sort(this.appPSAppPortletList, new Comparator<IPSAppPortlet>() {
         public int compare(IPSAppPortlet o1, IPSAppPortlet o2) {
            return StringHelper.compare(o1.getName(), o2.getName(), false);
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

   @PSModelRTMeta(description = "子应用引用集合", child = true)
   @Override
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

   @PSModelRTMeta(description = "应用功能页面集合", child = true, group = "应用视图", order = 195)
   @Override
   public Iterator<IPSAppUtilPage> getAllPSAppUtilPages() throws Exception {
      return this.psAppUtilPageGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId) throws Exception {
      return this.getPSAppUtilPage(strPSAppUtilPageId, false);
   }

   @Override
   public IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId, boolean bTryMode) throws Exception {
      if (StringHelper.length(strPSAppUtilPageId) <= 20) {
         String strKey = KeyValueHelper.genUniqueId(this.getId(), strPSAppUtilPageId);
         IPSAppUtilPage iPSAppUtilPage = this.psAppUtilPageGlobalModel.FindModelHelper(strKey, true);
         if (iPSAppUtilPage != null) {
            return iPSAppUtilPage;
         }
      }

      return this.psAppUtilPageGlobalModel.FindModelHelper(strPSAppUtilPageId, bTryMode);
   }

   @Override
   public void resetPSAppUtilPage(String strPSAppUtilPageId) {
      this.psAppUtilPageGlobalModel.ResetModel(strPSAppUtilPageId);
   }

   @PSModelRTMeta(description = "应用界面模式集合", child = true, dynamodelmode = 8, group = "应用视图", order = 206)
   @Override
   public Iterator<IPSAppUIStyle> getAllPSAppUIStyles() throws Exception {
      return this.psAppUIStyleGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppUIStyle getPSAppUIStyle(String strPSAppUIStyleId) throws Exception {
      return this.psAppUIStyleGlobalModel.FindModelHelper(strPSAppUIStyleId);
   }

   @Override
   public void resetPSAppUIStyle(String strPSAppUIStyleId) {
      this.psAppUIStyleGlobalModel.ResetModel(strPSAppUIStyleId);
   }

   @PSModelRTMeta(description = "应用界面主题集合", child = true, group = "应用视图", order = 205)
   @Override
   public Iterator<IPSAppUITheme> getAllPSAppUIThemes() throws Exception {
      return this.psAppUIThemeGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppUITheme getPSAppUITheme(String strPSAppUIThemeId) throws Exception {
      return this.psAppUIThemeGlobalModel.FindModelHelper(strPSAppUIThemeId);
   }

   @Override
   public void resetPSAppUITheme(String strPSAppUIThemeId) {
      this.psAppUIThemeGlobalModel.ResetModel(strPSAppUIThemeId);
   }

   @Override
   public Object getPFStyleParam(String strKey) throws Exception {
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().getPFStyleParam(strKey) : PropertiesHelper.GetProperty(this.pfStyleParams, strKey);
   }

   @Override
   public boolean getPFStyleParam(String strKey, boolean bDefault) throws Exception {
      return this.getPSAppUIStyle() != null
         ? this.getPSAppUIStyle().getPFStyleParam(strKey, bDefault)
         : PropertiesHelper.GetProperty(this.pfStyleParams, strKey, bDefault);
   }

   @Override
   public String getPFStyleParam(String strKey, String strDefault) throws Exception {
      return this.getPSAppUIStyle() != null
         ? this.getPSAppUIStyle().getPFStyleParam(strKey, strDefault)
         : PropertiesHelper.GetProperty(this.pfStyleParams, strKey, strDefault);
   }

   @Override
   public int getPFStyleParam(String strKey, int nDefault) throws Exception {
      return this.getPSAppUIStyle() != null
         ? this.getPSAppUIStyle().getPFStyleParam(strKey, nDefault)
         : PropertiesHelper.GetProperty(this.pfStyleParams, strKey, nDefault);
   }

   @Override
   public double getPFStyleParam(String strKey, double fDefault) throws Exception {
      return this.getPSAppUIStyle() != null
         ? this.getPSAppUIStyle().getPFStyleParam(strKey, (double)fDefault)
         : PropertiesHelper.GetProperty(this.pfStyleParams, strKey, fDefault);
   }

   @PSModelRTMeta(description = "使用服务接口")
   @Override
   public boolean isUseServiceApi() {
      return this.bUseServiceApi;
   }

   @PSModelRTMeta(description = "移动端应用")
   @Override
   public boolean isMobileApp() {
      return this.bMobileApp;
   }

   @Override
   public IPSPFStyle getPSPFStyle() {
      return this.iPSPFStyle;
   }

   @Override
   public IPSAppView getPSAppViewByDEViewId(String strPSDEViewId, boolean bTryMode) throws Exception {
      if (this.replacePSAppPDTViewMap != null) {
         IPSAppPDTView iPSAppPDTView = this.replacePSAppPDTViewMap.get(strPSDEViewId);
         if (iPSAppPDTView != null) {
            return iPSAppPDTView.getPSAppView();
         }
      }

      String strPSApplicationViewId = KeyValueHelper.genUniqueId(this.getId(), strPSDEViewId);
      IPSAppView iPSAppView = this.psApplicationViewGlobalModel.FindModelHelper(strPSApplicationViewId, true);
      if (iPSAppView == null && !bTryMode) {
         PSDEViewBase psDEViewBase = new PSDEViewBase();
         CallResult callResult = this.getPSModelHelper().getPSDEViewBase(strPSDEViewId, psDEViewBase);
         if (!callResult.isOk()) {
            String strInfo = StringHelper.format("无法获取指定应用视图，标识为[%1$s]，指定了无法识别的实体视图[%2$s]", strPSApplicationViewId, strPSDEViewId);
            throw new PSApplicationException(this, 40012, strInfo, strPSApplicationViewId, null);
         }

         if (this.getPSSystem().isDynaInstMode()) {
            PSAppView psAppView = new PSAppView();
            psAppView.setPSDEVIEWBASEID(psDEViewBase.getPSDEVIEWBASEID());
            psAppView.setPSDEVIEWBASENAME(psDEViewBase.getPSDEVIEWBASENAME());
            String strPSAppDEViewId = KeyValueHelper.genUniqueId(this.getId(), psDEViewBase.getPSDEVIEWBASEID());
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
         } else {
            String strInfo = StringHelper.format(
               "无法获取指定应用视图，标识为[%1$s]，请确认实体视图[%2$s][%3$s]已经添加到应用[%4$s]中",
               strPSApplicationViewId,
               psDEViewBase.getPSDENAME(),
               psDEViewBase.getPSDEVIEWBASENAME(),
               this.getName()
            );
            throw new PSApplicationException(this, 40012, strInfo, strPSApplicationViewId, strPSDEViewId);
         }
      } else {
         return iPSAppView;
      }
   }

   @Override
   public IPSAppUserMode getPSAppUserMode(String strPSAppUserModeId) throws Exception {
      return this.psAppUserModeGlobalModel.FindModelHelper(strPSAppUserModeId);
   }

   @Override
   public void resetPSAppUserMode(String strPSAppUserModeId) {
      this.psAppUserModeGlobalModel.ResetModel(strPSAppUserModeId);
   }

   @PSModelRTMeta(description = "应用用户模式集合", child = true, dynamodelmode = 8, group = "访问控制", order = 520)
   @Override
   public Iterator<IPSAppUserMode> getAllPSAppUserModes() throws Exception {
      return this.psAppUserModeGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppMenuModel getPSAppMenuModel(String strPSAppMenuModelId) throws Exception {
      return this.psAppMenuModelGlobalModel.FindModelHelper(strPSAppMenuModelId);
   }

   @Override
   public void resetPSAppMenuModel(String strPSAppMenuModelId) {
      this.psAppMenuModelGlobalModel.ResetModel(strPSAppMenuModelId);
   }

   @PSModelRTMeta(description = "应用菜单模型集合", child = true, dumpref = true, ignorert = 3, group = "界面逻辑", order = 322)
   @Override
   public Iterator<IPSAppMenuModel> getAllPSAppMenuModels() throws Exception {
      return this.psAppMenuModelGlobalModel.getAllModelHelpers();
   }

   @Override
   public String getModelType() {
      return "PSSYSAPP";
   }

   @PSModelRTMeta(description = "应用版本")
   @Override
   public String getAppVersion() {
      return "1.0.0.0";
   }

   @Override
   public IPSPFStyle getPSPFStyle(String strPSPFStyleId) throws Exception {
      IPSPFStyle iPSPFStyle = this.getPSPFStyle();
      if (StringHelper.compare(iPSPFStyle.getId(), strPSPFStyleId, false) == 0) {
         return iPSPFStyle;
      }

      if (this.getPSPFStyle() instanceof IPSPFStyle2) {
         throw new Exception("应用不支持多样式模式");
      }

      synchronized (this.psPFStyleMap) {
         iPSPFStyle = this.psPFStyleMap.get(strPSPFStyleId);
      }

      if (iPSPFStyle != null) {
         return iPSPFStyle;
      }

      iPSPFStyle = this.getPSPF().getPSPFStyle(strPSPFStyleId);
      synchronized (this.psPFStyleMap) {
         this.psPFStyleMap.put(strPSPFStyleId, iPSPFStyle);
         return iPSPFStyle;
      }
   }

   @PSModelRTMeta(description = "应用目录名称")
   @Override
   public String getAppFolder() {
      if (PSJITWebContext.getInstance() != null) {
         return PSJITWebContext.getInstance().getPSAppName();
      } else {
         return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().getAppFolder() : this.strAppFolder;
      }
   }

   @PSModelRTMeta(description = "应用语言集合", child = true, dumpref = true, ignorert = 3)
   @Override
   public Iterator<IPSAppLan> getAllPSAppLans() throws Exception {
      return this.psAppLanGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppLan getPSAppLan(String strPSAppLanId) throws Exception {
      return this.psAppLanGlobalModel.FindModelHelper(strPSAppLanId);
   }

   @Override
   public void resetPSAppLan(String strPSAppLanId) {
      this.psAppLanGlobalModel.ResetModel(strPSAppLanId);
   }

   @Override
   public String getMainMenuAlign() {
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().getMainMenuAlign() : this.strMainMenuAlign;
   }

   @Override
   public Iterator<IPSAppPkg> getPSAppPkgs() throws Exception {
      return this.psAppPkgGlobalModel.getAllModelHelpers();
   }

   @Override
   public Iterator<IPSPFPkgVer> getPSPFPkgVers() throws Exception {
      return this.psPFPkgVerList.iterator();
   }

   @PSModelRTMeta(description = "应用组件包集合", child = true, ignorepf = true, dynamodelmode = 8, group = "模板扩展", order = 616)
   @Override
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

   @PSModelRTMeta(description = "应用CDN")
   @Override
   public IPSPFCDN getPSPFCDN() {
      return this.iPSPFCDN;
   }

   @Override
   public int check() throws Exception {
      if (this.getLoadedLevel() <= IPSSystem.LOADLEVEL_NONE) {
         throw new Exception("应用还未加载");
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

      Iterator<IPSAppMethodDTO> psAppMethodDTOs = this.getAllPSAppMethodDTOs();
      if (psAppMethodDTOs != null) {
         while (psAppMethodDTOs.hasNext()) {
            IPSAppMethodDTO iPSAppMethodDTO = psAppMethodDTOs.next();
            iPSAppMethodDTO.check();
         }
      }

      Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs = this.getAllPSAppSubViewTypeRefs();
      if (psAppSubViewTypeRefs != null) {
         while (psAppSubViewTypeRefs.hasNext()) {
            IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
            iPSAppSubViewTypeRef.check();
         }
      }

      return -1;
   }

   protected void calcRelatedPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> relatedPSAppViewMap) throws Exception {
      if (!relatedPSAppViewMap.containsKey(iPSAppView.getId())) {
         relatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
         ArrayList<IPSAppView> relatedPSAppViewList = new ArrayList<>();
         iPSAppView.fillRelatedPSAppViews(relatedPSAppViewList);

         for (IPSAppView relatedPSAppView : relatedPSAppViewList) {
            this.calcRelatedPSAppViews(relatedPSAppView, relatedPSAppViewMap);
         }
      }
   }

   @Override
   public void calcPSAppViewSysRefFlag() throws Exception {
      log.debug(StringHelper.format("计算应用[%1$s]系统引用视图", this.getName()));
      HashMap<String, IPSAppView> relatedPSAppViewMap = new HashMap<>();
      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if (iPSAppView.isUserRefMode()) {
            this.calcRelatedPSAppViews(iPSAppView, relatedPSAppViewMap);
         }
      }

      ArrayList<IPSAppView> relatedList = new ArrayList<>();
      Iterator<IPSAppUserMode> psAppUserModes = this.getAllPSAppUserModes();
      if (psAppUserModes != null) {
         while (psAppUserModes.hasNext()) {
            IPSAppUserMode iPSAppUserMode = psAppUserModes.next();
            if (iPSAppUserMode.getPSAppMenuModel() != null) {
               IPSAppMenuModel iPSAppMenuModel = iPSAppUserMode.getPSAppMenuModel();
               Iterator<IPSAppFunc> psAppFuncs = iPSAppMenuModel.getPSAppFuncs();
               if (psAppFuncs != null) {
                  while (psAppFuncs.hasNext()) {
                     IPSAppFunc iPSAppFunc = psAppFuncs.next();
                     iPSAppFunc.fillRelatedPSAppViews(relatedList);
                  }
               }
            }
         }
      }

      Iterator<IPSAppPortlet> psAppPortlets = this.getAllPSAppPortlets();
      if (psAppPortlets != null) {
         while (psAppPortlets.hasNext()) {
            IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
            if (iPSAppPortlet.getPSControl() != null) {
               iPSAppPortlet.getPSControl().fillRelatedPSAppViews(relatedList);
            }
         }
      }

      Iterator<IPSAppWF> psAppWFs = this.getAllPSAppWFs();
      if (psAppWFs != null) {
         while (psAppWFs.hasNext()) {
            IPSAppWF iPSAppWF = psAppWFs.next();
            Iterator<IPSAppView> psAppViews2 = iPSAppWF.getAllPSAppViews();
            if (psAppViews2 != null) {
               while (psAppViews2.hasNext()) {
                  relatedList.add(psAppViews2.next());
               }
            }
         }
      }

      Iterator<IPSAppWFVer> psAppWFVers = this.getAllPSAppWFVers();
      if (psAppWFVers != null) {
         while (psAppWFVers.hasNext()) {
            IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
            Iterator<IPSAppView> psAppViews2 = iPSAppWFVer.getAllPSAppViews();
            if (psAppViews2 != null) {
               while (psAppViews2.hasNext()) {
                  relatedList.add(psAppViews2.next());
               }
            }
         }
      }

      for (IPSAppView iPSAppView : relatedList) {
         this.calcRelatedPSAppViews(iPSAppView, relatedPSAppViewMap);
      }

      SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.iPSSystem.getPSSysModelInstId());
      IService psAppViewService = ServiceGlobal.getService(PSAppViewService.class, sessionFactory);
      this.resetAllPSAppViewSysRefFlag(psAppViewService);
      int nTotal = 0;
      int nUsed = 0;
      psAppViews = this.getAllPSAppViews();
      boolean bChanged = false;

      while (psAppViews.hasNext()) {
         nTotal++;
         IPSAppView iPSAppView = psAppViews.next();
         if (relatedPSAppViewMap.containsKey(iPSAppView.getId())) {
            nUsed++;
            if (!iPSAppView.getSysRefFlag()) {
               this.updatePSAppViewSysRefFlag(psAppViewService, iPSAppView, true);
               ((IPSAppViewRuntime)iPSAppView).updateSysRefFlag(true);
               bChanged = true;
            }
         } else if (iPSAppView.getSysRefFlag()) {
            this.updatePSAppViewSysRefFlag(psAppViewService, iPSAppView, false);
            ((IPSAppViewRuntime)iPSAppView).updateSysRefFlag(false);
            bChanged = true;
         }
      }

      if (bChanged) {
         PSSysModelLogService psSysModelLogService = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, sessionFactory);
         PSSysModelLog psSysModelLog = new PSSysModelLog();
         psSysModelLog.setPSSystemId(this.getPSSystem().getId());
         psSysModelLog.setPSSystemName("(N/A)");
         psSysModelLog.setPSSysModelLogName("PSAPPVIEW");
         psSysModelLogService.save(psSysModelLog, false);
         log.debug(StringHelper.format("系统引用视图有变化，更新缓存标记"));
      }

      log.debug(StringHelper.format("计算系统引用视图完成，总共[%1$s]，引用[%2$s]", nTotal, nUsed));
   }

   protected void updatePSAppViewSysRefFlag(IService psAppViewService, IPSAppView iPSAppView, boolean bSysRefFlag) throws Exception {
      SqlParamList sqlParamList = new SqlParamList();
      sqlParamList.add(bSysRefFlag ? 1 : 0, 9);
      sqlParamList.add(iPSAppView.getId(), 25);
      psAppViewService.executeRaw(this.strUpdatePSAppViewSysRefFlagSql, sqlParamList);
   }

   protected void resetAllPSAppViewSysRefFlag(IService psAppViewService) throws Exception {
      SqlParamList sqlParamList = new SqlParamList();
      sqlParamList.add(this.getId(), 25);
      psAppViewService.executeRaw(this.strResetPSAppViewSysRefFlagSql, sqlParamList);
   }

   @PSModelRTMeta(description = "只发布引用视图", dump = false)
   @Override
   public boolean isPubRefViewOnly() {
      return this.bPubSysRefViewOnly;
   }

   @Override
   public IPSMobAppStartPage getPSMobAppStartPage(String strPSMobAppStartPageId, boolean bTryMode) throws Exception {
      return this.psMobAppStartPageGlobalModel.FindModelHelper(strPSMobAppStartPageId, bTryMode);
   }

   @Override
   public void resetPSMobAppStartPage(String strPSMobAppStartPageId) {
      this.psMobAppStartPageGlobalModel.ResetModel(strPSMobAppStartPageId);
   }

   @PSModelRTMeta(description = "移动端起始页集合", group = "移动端", order = 370)
   @Override
   public Iterator<IPSMobAppStartPage> getAllPSMobAppStartPages() throws Exception {
      return this.psMobAppStartPageGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSMobAppPack getPSMobAppPack(String strPSMobAppPackId) throws Exception {
      return this.psMobAppPackGlobalModel.FindModelHelper(strPSMobAppPackId);
   }

   @Override
   public void resetPSMobAppPack(String strPSMobAppPackId) {
      this.psMobAppPackGlobalModel.ResetModel(strPSMobAppPackId);
   }

   @Override
   public IPSMobAppIcon getPSMobAppIcon(String strPSMobAppIconId, boolean bTryMode) throws Exception {
      return this.psMobAppIconGlobalModel.FindModelHelper(strPSMobAppIconId, bTryMode);
   }

   @Override
   public void resetPSMobAppIcon(String strPSMobAppIconId) {
      this.psMobAppIconGlobalModel.ResetModel(strPSMobAppIconId);
   }

   @PSModelRTMeta(description = "移动端图标集合", group = "移动端", order = 375)
   @Override
   public Iterator<IPSMobAppIcon> getAllPSMobAppIcons() throws Exception {
      return this.psMobAppIconGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSMobAppPackCert getPSMobAppPackCert(String strPSMobAppPackCertId) throws Exception {
      return this.psMobAppPackCertGlobalModel.FindModelHelper(strPSMobAppPackCertId);
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
            sb.append("%1$s\r\n", PSLogItemImpl.toString(iPSLogItem));
            if (iPSLogItem.getLogLevel() > nLogLevel) {
               nLogLevel = iPSLogItem.getLogLevel();
            }
         }

         final int nLogLevel2 = nLogLevel;
         final StringBuilderEx sb2 = new StringBuilderEx();
         if (!StringHelper.isNullOrEmpty(strInfo)) {
            sb2.append("%1$s\r\n", strInfo);
         }

         if (exception != null) {
            sb2.append("模型加载发生异常：");
            exception.printStackTrace(new PrintWriter(sb2.getWriter()));
         }

         ServiceWorkHelper.getInstance()
            .execute(
               new IServiceWork() {
                  @Override
                  public void execute(ITransaction iTransaction) throws Exception {
                     PSSysModelLoadLog psSysModelLoadLog = new PSSysModelLoadLog();
                     PSSysModelLoadLogService psSysModelLoadLogService = (PSSysModelLoadLogService)ServiceGlobal.getService(
                        PSSysModelLoadLogService.class, PSSysModelInstGlobal.getSessionFactory(PSApplicationImpl.this.getRuntimePSSysModelInstId())
                     );
                     psSysModelLoadLog.setPSObjType("PSSYSAPP");
                     psSysModelLoadLog.setPSSystemId(PSApplicationImpl.this.getPSSystem().getId());
                     psSysModelLoadLog.setPSSystemName(PSApplicationImpl.this.getPSSystem().getName());
                     psSysModelLoadLog.setPSObjId(PSApplicationImpl.this.getId());
                     psSysModelLoadLog.setPSObjName(PSApplicationImpl.this.getName());
                     psSysModelLoadLog.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                     psSysModelLoadLog.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
                     switch (nLogLevel2) {
                        case 0:
                           psSysModelLoadLog.setLogLevel("OK");
                           break;
                        case 1:
                           psSysModelLoadLog.setLogLevel("ERROR");
                        case 2:
                        case 3:
                        default:
                           break;
                        case 4:
                           psSysModelLoadLog.setLogLevel("WARN");
                     }

                     psSysModelLoadLog.setPSSysModelLoadLogName(StringHelper.format("[%1$s]加载日志", PSApplicationImpl.this.getName()));
                     psSysModelLoadLog.setLogInfo(sb.toString());
                     psSysModelLoadLog.setExceptionInfo(sb2.toString());
                     psSysModelLoadLogService.save(psSysModelLoadLog);
                  }
               }
            );
      } catch (Exception ex) {
         log.error(ex);
      }
   }

   @Override
   public int getButtonNoPrivDisplayMode() {
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().getButtonNoPrivDisplayMode() : this.nButtonNoPrivDisplayMode;
   }

   @PSModelRTMeta(description = "应用界面设置")
   @Override
   public IPSApplicationUI getPSApplicationUI() {
      return this.psApplicationUIProxy;
   }

   @PSModelRTMeta(description = "应用界面模式")
   @Override
   public IPSAppUIStyle getPSAppUIStyle() {
      return this.iPSAppUIStyle;
   }

   @Override
   public Iterator<IPSSysCss> getAllPSSysCsses(boolean bRefOnly) throws Exception {
      Map<String, IPSSysCss> psSysCssMap = new LinkedHashMap<>();
      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if (!bRefOnly || iPSAppView.getRefFlag()) {
            Iterator<IPSSysCss> psSysCsses = iPSAppView.getPSSysCsses();
            if (psSysCsses != null) {
               while (psSysCsses.hasNext()) {
                  IPSSysCss iPSSysCss = psSysCsses.next();
                  psSysCssMap.put(iPSSysCss.getId(), iPSSysCss);
               }
            }
         }
      }

      return psSysCssMap.values().iterator();
   }

   @Override
   public Iterator<IPSSysImage> getAllPSSysImages(boolean bRefOnly) throws Exception {
      Map<String, IPSSysImage> psSysImageMap = new LinkedHashMap<>();
      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if (!bRefOnly || iPSAppView.getRefFlag()) {
            Iterator<IPSSysImage> psSysImages = iPSAppView.getPSSysImages();
            if (psSysImages != null) {
               while (psSysImages.hasNext()) {
                  IPSSysImage iPSSysImage = psSysImages.next();
                  psSysImageMap.put(iPSSysImage.getId(), iPSSysImage);
               }
            }
         }
      }

      return psSysImageMap.values().iterator();
   }

   @Override
   public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins(boolean bRefOnly) throws Exception {
      Map<String, IPSSysPFPlugin> psPFPluginMap = new LinkedHashMap<>();
      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if (!bRefOnly || iPSAppView.getRefFlag()) {
            Iterator<IPSSysPFPlugin> psPFPlugines = iPSAppView.getPSSysPFPlugins();
            if (psPFPlugines != null) {
               while (psPFPlugines.hasNext()) {
                  IPSSysPFPlugin iPSPFPlugin = psPFPlugines.next();
                  psPFPluginMap.put(iPSPFPlugin.getId(), iPSPFPlugin);
               }
            }
         }
      }

      return psPFPluginMap.values().iterator();
   }

   @Override
   public Iterator<? extends IPSAppViewMsgGroup> getAllPSAppViewMsgGroups(boolean bRefOnly) throws Exception {
      if (!bRefOnly) {
         return PSModelUtil.sort(this.psAppViewMsgGroupMap, IPSAppViewMsgGroup.class).iterator();
      }

      Map<String, IPSAppViewMsgGroup> psViewMsgGroupMap = new LinkedHashMap<>();
      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if ((!bRefOnly || iPSAppView.getRefFlag()) && iPSAppView.getPSViewMsgGroup() != null && iPSAppView.getPSViewMsgGroup() instanceof IPSAppViewMsgGroup) {
            psViewMsgGroupMap.put(iPSAppView.getPSViewMsgGroup().getId(), (IPSAppViewMsgGroup)iPSAppView.getPSViewMsgGroup());
         }
      }

      return psViewMsgGroupMap.values().iterator();
   }

   @Deprecated
   @Override
   public Iterator<? extends IPSViewMsgGroup> getAllPSViewMsgGroups(boolean bRefOnly) throws Exception {
      return this.getAllPSAppViewMsgGroups(bRefOnly);
   }

   @PSModelRTMeta(description = "应用引用系统样式表集合", outputdoc = "false")
   @Override
   public Iterator<IPSSysCss> getAllPSSysCsses() throws Exception {
      return this.getAllPSSysCsses(this.isPubRefViewOnly());
   }

   @PSModelRTMeta(description = "应用引用系统图片集合", outputdoc = "false")
   @Override
   public Iterator<IPSSysImage> getAllPSSysImages() throws Exception {
      return this.getAllPSSysImages(this.isPubRefViewOnly());
   }

   @PSModelRTMeta(description = "应用前端插件集合", outputdoc = "false")
   @Override
   public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins() throws Exception {
      return this.getAllPSSysPFPlugins(this.isPubRefViewOnly());
   }

   @Override
   public Iterator<? extends IPSAppViewMsgGroup> getAllPSViewMsgGroups() throws Exception {
      return this.getAllPSAppViewMsgGroups(this.isPubRefViewOnly());
   }

   @PSModelRTMeta(description = "启动视图", group = "应用视图", order = 182)
   @Override
   public IPSAppView getDefaultPSAppView() throws Exception {
      if (this.getPSAppUIStyle() != null && this.getPSAppUIStyle().getDefaultPSAppView() != null) {
         return this.getPSAppUIStyle().getDefaultPSAppView();
      }

      if (this.defaultPSAppView != null) {
         return this.defaultPSAppView;
      }

      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if (iPSAppView instanceof IPSAppIndexView && ((IPSAppIndexView)iPSAppView).isDefaultPage()) {
            this.defaultPSAppView = iPSAppView;
            return this.defaultPSAppView;
         }
      }

      psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         if (iPSAppView instanceof IPSAppPortalView && ((IPSAppPortalView)iPSAppView).isDefaultPage()) {
            this.defaultPSAppView = iPSAppView;
            return this.defaultPSAppView;
         }
      }

      return null;
   }

   @Override
   public boolean isEnableCol12ToCol24() {
      return this.bEnableCol12ToCol24;
   }

   @PSModelRTMeta(description = "启动首页视图", dumpref = true, outputdoc = "false", doc = "计算默认的应用首页视图", ignorert = 3)
   @Override
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
         if (iPSAppView instanceof IPSAppIndexView && ((IPSAppIndexView)iPSAppView).isDefaultPage()) {
            this.defaultPSAppIndexView = (IPSAppIndexView)iPSAppView;
            return this.defaultPSAppIndexView;
         }
      }

      return null;
   }

   @Override
   public IPSAppLocalDE getPSAppLocalDE(String strPSAppLocalDEId) throws Exception {
      return this.psAppDataEntityGlobalModel.FindModelHelper(strPSAppLocalDEId);
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
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().isGridForceFit() : this.bGridForceFit;
   }

   @Override
   public boolean isGridEnableCustomized() {
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().isGridEnableCustomized() : this.bGridEnableCustomized;
   }

   @Override
   public int getGridRowActiveMode() {
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().getGridRowActiveMode() : this.nGridRowActiveMode;
   }

   @Override
   public String getFullModelName() {
      return StringHelper.format("%1$s|%2$s", this.getPSSystem().getFullModelName(), this.getModelName());
   }

   @PSModelRTMeta(description = "服务代码名称")
   @Override
   public String getServiceCodeName() {
      return StringHelper.isNullOrEmpty(this.strServiceCodeName) ? this.getPKGCodeName() : this.strServiceCodeName;
   }

   @PSModelRTMeta(description = "启用统一认证登录")
   @Override
   public boolean isEnableUACLogin() {
      return this.bEnableUACLogin;
   }

   @PSModelRTMeta(description = "后台服务发布对象", hideempty = true)
   @Override
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
      return nUsage == null ? 0 : nUsage;
   }

   @Override
   public String getWorkshopName() {
      return this.getPSAppUIStyle() != null
         ? StringHelper.format("%1$s%2$s", this.getPKGCodeName(), this.getPSAppUIStyle().getStyleCode())
         : this.getPKGCodeName();
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
      return isDynaModelCodeGenMode() || this.bEnableDynaSys && this.getPSSystem().isEnableDynaSys();
   }

   @Override
   public int getFormItemNoPrivDisplayMode() {
      return this.nFormItemNoPrivDisplayMode;
   }

   @Override
   public int getGridColumnNoPrivDisplayMode() {
      return this.nGridColumnNoPrivDisplayMode;
   }

   @PSModelRTMeta(description = "应用预置视图集合", group = "应用视图", order = 200)
   @Override
   public Iterator<IPSAppPDTView> getAllPSAppPDTViews() throws Exception {
      return this.psAppPDTViewGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppPDTView getPSAppPDTView(String strPSAppPDTViewId, boolean bTryMode) throws Exception {
      return this.psAppPDTViewGlobalModel.FindModelHelper(strPSAppPDTViewId, bTryMode);
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
      return this.getPSAppUIStyle() != null ? this.getPSAppUIStyle().getUIStyle() : this.strUIStyle;
   }

   @Override
   public IPSAppDataEntity getPSAppDataEntity(String strPSAppDataEntityId, boolean bTryMode) throws Exception {
      return this.psAppDataEntityGlobalModel.FindModelHelper(strPSAppDataEntityId, bTryMode);
   }

   @Override
   public IPSAppDataEntity getPSAppDataEntityByDEId(String strPSDEId, boolean bTryMode) throws Exception {
      IPSDataEntity iPSDataEntity = this.getPSSystem().getPSDataEntity(strPSDEId);
      if (iPSDataEntity == null) {
         if (!bTryMode) {
            throw new Exception(StringHelper.format("无法获取指定实体[%1$s]", strPSDEId));
         } else {
            return null;
         }
      } else {
         return this.getPSAppDataEntity(iPSDataEntity, bTryMode);
      }
   }

   @Override
   public IPSAppDataEntity getPSAppDataEntity(IPSDataEntity iPSDataEntity, boolean bTryMode) throws Exception {
      IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity(KeyValueHelper.genUniqueId(this.getId(), iPSDataEntity.getId()), true);
      if (iPSAppDataEntity == null && !bTryMode) {
         throw new Exception(StringHelper.format("应用[%1$s]不存在指定应用实体[%2$s]", this.getName(), iPSDataEntity.getName()));
      } else {
         return iPSAppDataEntity;
      }
   }

   @Override
   public void resetPSAppDataEntity(String strPSAppDataEntityId) {
      this.psAppDataEntityGlobalModel.ResetModel(strPSAppDataEntityId);
   }

   @PSModelRTMeta(description = "应用实体集合", dumpref = true, child = true, rtdump = 2, ignorert = 3, modelreftype = "APPLICATION", group = "模型&接口", order = 170)
   @Override
   public Iterator<IPSAppDataEntity> getAllPSAppDataEntities() throws Exception {
      return this.psAppDataEntityGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "后台服务模式", dump = false)
   @Override
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
      ArrayList<IPSAppFunc> psAppFuncList = new ArrayList<>();
      Iterator<IPSAppFunc> psAppFuncs = this.getAllPSAppFuncs();
      if (psAppFuncs != null) {
         while (psAppFuncs.hasNext()) {
            IPSAppFunc iPSAppFunc = psAppFuncs.next();
            if (!StringHelper.isNullOrEmpty(iPSAppFunc.getCodeName()) && iPSAppFunc.getCodeName().toUpperCase().indexOf(strPreFix) == 0) {
               psAppFuncList.add(iPSAppFunc);
            }
         }
      }

      Collections.sort(psAppFuncList, new Comparator<IPSAppFunc>() {
         public int compare(IPSAppFunc o1, IPSAppFunc o2) {
            return o1.getCodeName().compareTo(o2.getCodeName());
         }
      });
      return psAppFuncList.iterator();
   }

   @PSModelRTMeta(description = "应用预置界面逻辑集合", child = true, group = "界面逻辑", order = 345)
   @Override
   public Iterator<IPSAppUILogic> getAllPSAppUILogics() throws Exception {
      return this.psAppUILogicGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppUILogic getPSAppUILogic(String strPSAppUILogicId) throws Exception {
      return this.psAppUILogicGlobalModel.FindModelHelper(strPSAppUILogicId);
   }

   @Override
   public void resetPSAppUILogic(String strPSAppUILogicId) {
      this.psAppUILogicGlobalModel.ResetModel(strPSAppUILogicId);
   }

   @Override
   public String getDefaultControlStyle() {
      try {
         return this.getPFStyleParam("DEFAULTCONTROLSTYLE", "");
      } catch (Exception ex) {
         log.error(ex);
         return "";
      }
   }

   @PSModelRTMeta(description = "默认视图优先级", dump = false)
   @Override
   public Integer getDefaultAppViewPriority() {
      try {
         String value = this.getPFStyleParam("DEFAULTAPPVIEWPRIORITY", "");
         if (StringUtils.hasLength(value)) {
            return Integer.parseInt(value);
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return null;
   }

   @PSModelRTMeta(description = "默认应用视图界面样式")
   @Override
   public IPSSysCss getDefaultAppViewPSSysCss() {
      return this.defaultAppViewPSSysCss;
   }

   @Override
   public IPSAppWF getPSAppWF(String strPSAppWFId) throws Exception {
      return this.psAppWFGlobalModel.FindModelHelper(strPSAppWFId);
   }

   @Override
   public IPSAppWF getPSAppWF(String strPSAppWFId, boolean bTryMode) throws Exception {
      return this.psAppWFGlobalModel.FindModelHelper(strPSAppWFId, bTryMode);
   }

   @Override
   public void resetPSAppWF(String strPSAppWFId) {
      this.psAppWFGlobalModel.ResetModel(strPSAppWFId);
   }

   @PSModelRTMeta(description = "应用工作流集合", child = true, group = "工作流", order = 425)
   @Override
   public Iterator<IPSAppWF> getAllPSAppWFs() throws Exception {
      return this.psAppWFGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppWFVer getPSAppWFVer(String strPSAppWFVerId) throws Exception {
      return this.psAppWFVerGlobalModel.FindModelHelper(strPSAppWFVerId);
   }

   @Override
   public IPSAppWFVer getPSAppWFVer(String strPSAppWFVerId, boolean bTryMode) throws Exception {
      return this.psAppWFVerGlobalModel.FindModelHelper(strPSAppWFVerId, bTryMode);
   }

   @Override
   public void resetPSAppWFVer(String strPSAppWFVerId) {
      this.psAppWFVerGlobalModel.ResetModel(strPSAppWFVerId);
   }

   @PSModelRTMeta(description = "应用工作流版本集合", group = "工作流", order = 427)
   @Override
   public Iterator<IPSAppWFVer> getAllPSAppWFVers() throws Exception {
      return this.psAppWFVerGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "默认系统服务接口")
   @Override
   public IPSSysServiceAPI getPSSysServiceAPI() {
      return this.iPSSysServiceAPI;
   }

   @PSModelRTMeta(description = "应用预置资源集合", child = true)
   @Override
   public Iterator<IPSAppResource> getAllPSAppResources() throws Exception {
      return this.psAppResourceGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppResource getPSAppResource(String strPSAppResourceId) throws Exception {
      return this.getPSAppResource(strPSAppResourceId, false);
   }

   @Override
   public IPSAppResource getPSAppResource(String strPSAppResourceId, boolean bTryMode) throws Exception {
      return this.psAppResourceGlobalModel.FindModelHelper(strPSAppResourceId, bTryMode);
   }

   @Override
   public void resetPSAppResource(String strPSAppResourceId) {
      this.psAppResourceGlobalModel.ResetModel(strPSAppResourceId);
   }

   @PSModelRTMeta(description = "应用实体关系集合", child = true, ignorert = 3, group = "模型&接口", order = 171)
   @Override
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

      iPSAppDEUIAction = this.psSysAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
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
      registerRefPSModelObject(iPSAppDEUIAction, refPSModelObject);
      return iPSAppDEUIAction;
   }

   @Override
   public IPSAppDEUIAction getPSAppDEUIAction2(String strAppDEUIActionId, boolean bTryMode) throws Exception {
      return this.psSysAppDEUIActionGlobalModel.FindModelHelper(strAppDEUIActionId, bTryMode);
   }

   @Override
   public void resetPSAppDEUIAction(String strAppDEUIActionId) {
      this.psSysAppDEUIActionGlobalModel.ResetModel(strAppDEUIActionId);
   }

   @PSModelRTMeta(description = "应用界面行为集合", child = true, group = "界面逻辑", order = 330)
   @Override
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
      IPSAppDEUIActionGroup iPSAppDEUIActionGroup = this.psSysAppDEUIActionGroupGlobalModel.FindModelHelper(strAppDEUIActionGroupId, bTryMode);
      if (iPSAppDEUIActionGroup != null) {
         this.psAppDEUIActionGroupMap.put(iPSAppDEUIActionGroup.getId(), iPSAppDEUIActionGroup);
      }

      return iPSAppDEUIActionGroup;
   }

   @Override
   public void resetPSAppDEUIActionGroup(String strAppDEUIActionGroupId) {
      this.psSysAppDEUIActionGroupGlobalModel.ResetModel(strAppDEUIActionGroupId);
   }

   @PSModelRTMeta(description = "应用界面行为组集合", child = true, ignorepf = true, group = "界面逻辑", order = 332)
   @Override
   public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception {
      this.psSysAppDEUIActionGroupGlobalModel.getAllModelHelpers();
      return PSModelUtil.sort(this.psAppDEUIActionGroupMap, IPSAppDEUIActionGroup.class).iterator();
   }

   @PSModelRTMeta(description = "测试项目集合", child = true, dumpref = true, ignorepf = true, ignorert = 3, dynamodelmode = 8, group = "测试", order = 545)
   @Override
   public Iterator<IPSSysTestPrj> getAllPSSysTestPrjs() throws Exception {
      if (this.psSysTestPrjList == null) {
         ArrayList<IPSSysTestPrj> psSysTestPrjList = new ArrayList<>();
         Iterator<IPSSysTestPrj> psSysTestPrjs = this.getPSSystem().getAllPSSysTestPrjs();
         if (psSysTestPrjs != null) {
            while (psSysTestPrjs.hasNext()) {
               IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
               if (StringHelper.compare(iPSSysTestPrj.getPrjType(), "SYSAPP", false) == 0
                  && StringHelper.compare(this.getId(), iPSSysTestPrj.getPSApplication().getId(), false) == 0) {
                  psSysTestPrjList.add(iPSSysTestPrj);
               }
            }
         }

         if (this.psSysTestPrjList == null) {
            this.psSysTestPrjList = psSysTestPrjList;
         }
      }

      return this.psSysTestPrjList.iterator();
   }

   @PSModelRTMeta(description = "相关服务接口集合", group = "模型&接口", order = 175)
   @Override
   public Iterator<IPSSysServiceAPI> getAllPSSysServiceAPIs() throws Exception {
      if (this.psSysServiceAPIList == null) {
         ArrayList<IPSSysServiceAPI> psSysServiceAPIList = new ArrayList<>();
         Map<String, IPSSysServiceAPI> psSysServiceAPIMap = new LinkedHashMap<>();
         Iterator<IPSAppDataEntity> psAppDataEntitys = this.getAllPSAppDataEntities();
         if (psAppDataEntitys != null) {
            while (psAppDataEntitys.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psAppDataEntitys.next();
               if (iPSAppDataEntity.getPSSysServiceAPI() != null && !psSysServiceAPIMap.containsKey(iPSAppDataEntity.getPSSysServiceAPI().getId())) {
                  psSysServiceAPIMap.put(iPSAppDataEntity.getPSSysServiceAPI().getId(), iPSAppDataEntity.getPSSysServiceAPI());
               }
            }

            psSysServiceAPIList.addAll(psSysServiceAPIMap.values());
         }

         if (this.psSysServiceAPIList == null) {
            this.psSysServiceAPIList = psSysServiceAPIList;
         }
      }

      return this.psSysServiceAPIList.iterator();
   }

   @PSModelRTMeta(description = "应用计数器集合", child = true, dumpref = true, rtdump = 2, dynamodelmode = 8, ignorepf = true, group = "应用逻辑", order = 252)
   @Override
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
      } else {
         IPSSysCounter iPSSysCounter = this.getPSSystem().getPSSysCounter(strPSAppCounterId, bTryMode);
         if (iPSSysCounter != null) {
            PSAppCounterImpl psAppCounterImpl = new PSAppCounterImpl();
            psAppCounterImpl.init(this.getDAGlobalHelper(), this, iPSSysCounter);
            this.psAppCounterMap.put(psAppCounterImpl.getId(), psAppCounterImpl);
            return psAppCounterImpl;
         } else {
            return null;
         }
      }
   }

   @PSModelRTMeta(description = "应用代码表集合", child = true, ignorert = 3, modelreftype = "APPLICATION", group = "模型&接口", order = 172)
   @Override
   public Iterator<IPSAppCodeList> getAllPSAppCodeLists() throws Exception {
      return this.getAllPSAppCodeLists(false);
   }

   @Override
   public Iterator<IPSAppCodeList> getAllPSAppCodeLists(boolean bRefOnly) throws Exception {
      Map<String, IPSAppCodeList> psAppCodeListMap = new LinkedHashMap<>();
      Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

      while (psAppViews.hasNext()) {
         IPSAppView iPSAppView = psAppViews.next();
         Iterator<IPSCodeList> psCodeList = iPSAppView.getAllRelatedPSCodeLists();
         if (psCodeList != null) {
            while (psCodeList.hasNext()) {
               IPSCodeList iPSCodeList = psCodeList.next();
               IPSAppCodeList iPSAppCodeList = this.getPSAppCodeList(iPSCodeList.getId());
               if (bRefOnly && iPSAppView.getRefFlag()) {
                  psAppCodeListMap.put(iPSAppCodeList.getId(), iPSAppCodeList);
               }
            }
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
      } else {
         IPSCodeList iPSSysCodeList = this.getPSSystem().getPSCodeList(strPSAppCodeListId, bTryMode);
         if (iPSSysCodeList != null) {
            PSAppCodeListImpl psAppCodeListImpl = new PSAppCodeListImpl();
            psAppCodeListImpl.init(this.getDAGlobalHelper(), this, iPSSysCodeList);
            this.psAppCodeListMap.put(psAppCodeListImpl.getId(), psAppCodeListImpl);
            return psAppCodeListImpl;
         } else {
            return null;
         }
      }
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
      return iPSAppCodeList == null ? iPSCodeList : iPSAppCodeList;
   }

   @PSModelRTMeta(description = "应用消息模板集合", child = true, group = "界面逻辑", order = 338)
   @Override
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
      } else {
         IPSSysMsgTempl iPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(strPSAppMsgTemplId, bTryMode);
         if (iPSSysMsgTempl != null) {
            PSAppMsgTemplImpl psAppMsgTemplImpl = new PSAppMsgTemplImpl();
            psAppMsgTemplImpl.init(this.getDAGlobalHelper(), this, iPSSysMsgTempl);
            this.psAppMsgTemplMap.put(psAppMsgTemplImpl.getId(), psAppMsgTemplImpl);
            return psAppMsgTemplImpl;
         } else {
            return null;
         }
      }
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

   @PSModelRTMeta(description = "应用视图消息集合", child = true, group = "界面逻辑", order = 335)
   @Override
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
         if (iPSSysViewMsg instanceof IPSDEDataSetViewMsg) {
            psAppViewMsgImpl = new PSAppDEDataSetViewMsgImpl();
         } else {
            psAppViewMsgImpl = new PSAppViewMsgImpl();
         }

         psAppViewMsgImpl.init(this.getDAGlobalHelper(), this, iPSSysViewMsg);
         this.psAppViewMsgMap.put(psAppViewMsgImpl.getId(), psAppViewMsgImpl);
         return psAppViewMsgImpl;
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "应用视图消息组集合", child = true, group = "界面逻辑", order = 336)
   @Override
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
      } else {
         IPSViewMsgGroup iPSSysViewMsgGroup = this.getPSSystem().getPSViewMsgGroup(strPSAppViewMsgGroupId, bTryMode);
         if (iPSSysViewMsgGroup != null) {
            PSAppViewMsgGroupImpl psAppViewMsgGroupImpl = new PSAppViewMsgGroupImpl();
            psAppViewMsgGroupImpl.init(this.getDAGlobalHelper(), this, iPSSysViewMsgGroup);
            this.psAppViewMsgGroupMap.put(psAppViewMsgGroupImpl.getId(), psAppViewMsgGroupImpl);
            return psAppViewMsgGroupImpl;
         } else {
            return null;
         }
      }
   }

   @Override
   public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId) throws Exception {
      return this.getPSAppDEUILogicGroup(strAppDEUILogicGroupId, true);
   }

   @Override
   public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId, boolean bTryMode) throws Exception {
      return this.psSysAppDEUILogicGroupGlobalModel.FindModelHelper(strAppDEUILogicGroupId, bTryMode);
   }

   @Override
   public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String strAppDEUILogicGroupId, boolean bTryMode, IPSModelObject refPSModelObject) throws Exception {
      IPSAppDEUILogicGroup iPSAppDEUILogicGroup = this.getPSAppDEUILogicGroup(strAppDEUILogicGroupId, bTryMode);
      registerRefPSModelObject(iPSAppDEUILogicGroup, refPSModelObject);
      return iPSAppDEUILogicGroup;
   }

   @Override
   public void resetPSAppDEUILogicGroup(String strAppDEUILogicGroupId) {
      this.psSysAppDEUILogicGroupGlobalModel.ResetModel(strAppDEUILogicGroupId);
   }

   @PSModelRTMeta(description = "应用预置界面逻辑组集合", group = "界面逻辑", order = 340)
   @Override
   public Iterator<IPSAppDEUILogicGroup> getAllPSAppDEUILogicGroups() throws Exception {
      return this.psSysAppDEUILogicGroupGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "应用功能组件集合", child = true, group = "应用逻辑", order = 300)
   @Override
   public Iterator<IPSAppUtil> getAllPSAppUtils() throws Exception {
      return this.psAppUtilGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppUtil getPSAppUtil(String strPSAppUtilId) throws Exception {
      return this.getPSAppUtil(strPSAppUtilId, false);
   }

   @Override
   public IPSAppUtil getPSAppUtil(String strPSAppUtilId, boolean bTryMode) throws Exception {
      return this.psAppUtilGlobalModel.FindModelHelper(strPSAppUtilId, bTryMode);
   }

   @Override
   public void resetPSAppUtil(String strPSAppUtilId) {
      this.psAppUtilGlobalModel.ResetModel(strPSAppUtilId);
   }

   @PSModelRTMeta(description = "应用类型", group = "基本", order = 124)
   @Override
   public String getAppType() {
      return this.strAppType;
   }

   @PSModelRTMeta(description = "应用模式", codelist = "AppMode", group = "基本", order = 125)
   @Override
   public String getAppMode() {
      return this.strAppMode;
   }

   @PSModelRTMeta(description = "支持搜索条件存储")
   @Override
   public boolean isEnableFilterStorage() {
      return this.getPSAppFilterStorageUtil() != null;
   }

   @PSModelRTMeta(description = "支持动态数据看板")
   @Override
   public boolean isEnableDynaDashboard() {
      return this.getPSAppDynaDashboardUtil() != null;
   }

   @PSModelRTMeta(description = "查询条件存储应用组件")
   @Override
   public IPSAppFilterStorageUtil getPSAppFilterStorageUtil() {
      try {
         IPSAppUtil iPSAppUtil = this.getPSAppUtil("FILTERSTORAGE", true);
         if (iPSAppUtil instanceof IPSAppFilterStorageUtil) {
            return (IPSAppFilterStorageUtil)iPSAppUtil;
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return null;
   }

   @PSModelRTMeta(description = "动态应用看板应用组件")
   @Override
   public IPSAppDynaDashboardUtil getPSAppDynaDashboardUtil() {
      try {
         IPSAppUtil iPSAppUtil = this.getPSAppUtil("DYNADASHBOARD", true);
         if (iPSAppUtil instanceof IPSAppDynaDashboardUtil) {
            return (IPSAppDynaDashboardUtil)iPSAppUtil;
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return null;
   }

   @PSModelRTMeta(description = "应用门户部件集合", child = true, group = "界面逻辑", order = 349)
   @Override
   public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception {
      return this.psAppPortletList != null && this.psAppPortletList.size() > 0
         ? this.psAppPortletList.iterator()
         : this.psAppPortletGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppPortlet getPSAppPortlet(String strPSAppPortletId) throws Exception {
      return this.getPSAppPortlet(strPSAppPortletId, false);
   }

   @Override
   public IPSAppPortlet getPSAppPortlet(String strPSAppPortletId, boolean bTryMode) throws Exception {
      return this.psAppPortletGlobalModel.FindModelHelper(strPSAppPortletId, bTryMode);
   }

   @Override
   public void resetPSAppPortlet(String strPSAppPortletId) {
      this.psAppPortletGlobalModel.ResetModel(strPSAppPortletId);
   }

   @Override
   public Iterator<IPSControlContainerView> getPSControlContainerViews() {
      return this.containerPSAppViewList != null && this.containerPSAppViewList.size() != 0 ? this.containerPSAppViewList.iterator() : null;
   }

   @PSModelRTMeta(description = "应用门户部件分类集合", child = true, group = "界面逻辑", order = 348)
   @Override
   public Iterator<IPSAppPortletCat> getAllPSAppPortletCats() throws Exception {
      ArrayList<IPSAppPortletCat> list = new ArrayList<>();
      list.addAll(this.psAppPortletCatMap.values());
      Collections.sort(list, new Comparator<IPSAppPortletCat>() {
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
      } else {
         IPSSysPortletCat iPSSysPortletCat = this.getPSSystem().getPSSysPortletCat(strPSAppPortletCatId, bTryMode);
         if (iPSSysPortletCat != null) {
            PSAppPortletCatImpl psAppPortletCatImpl = new PSAppPortletCatImpl();
            psAppPortletCatImpl.init(this.getDAGlobalHelper(), this, iPSSysPortletCat);
            this.psAppPortletCatMap.put(psAppPortletCatImpl.getId(), psAppPortletCatImpl);
            return psAppPortletCatImpl;
         } else {
            return null;
         }
      }
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
      List<IPSAppDataEntity> psAppDataEntityList = new ArrayList<>();
      Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
      if (psAppDataEntities != null) {
         while (psAppDataEntities.hasNext()) {
            IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
            if (StringHelper.compare(iPSAppDataEntity.getPSDataEntity().getId(), strPSDEId, false) == 0) {
               if (iPSAppDataEntity.isDefaultMode()) {
                  psAppDataEntityList.add(0, iPSAppDataEntity);
               } else {
                  psAppDataEntityList.add(iPSAppDataEntity);
               }
            }
         }
      }

      return psAppDataEntityList.size() == 0 ? null : psAppDataEntityList.iterator();
   }

   @PSModelRTMeta(description = "应用全局门户部件集合", outputdoc = "false")
   @Override
   public Iterator<IPSAppPortlet> getAppPSAppPortlets() throws Exception {
      return this.appPSAppPortletList != null && this.appPSAppPortletList.size() != 0 ? this.appPSAppPortletList.iterator() : null;
   }

   @PSModelRTMeta(description = "应用全局门户部件分类集合", outputdoc = "false")
   @Override
   public Iterator<IPSAppPortletCat> getAppPSAppPortletCats() throws Exception {
      if (this.appPSAppPortletCatList == null) {
         List<IPSAppPortletCat> appPSAppPortletCatList = new ArrayList<>();
         Iterator<IPSAppPortlet> psAppPortlets = this.getAppPSAppPortlets();
         if (psAppPortlets != null) {
            Map<String, IPSAppPortletCat> psAppPortletCatMap = new LinkedHashMap<>();

            while (psAppPortlets.hasNext()) {
               IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
               if (iPSAppPortlet.getPSAppPortletCat() != null && !psAppPortletCatMap.containsKey(iPSAppPortlet.getPSAppPortletCat().getId())) {
                  psAppPortletCatMap.put(iPSAppPortlet.getPSAppPortletCat().getId(), iPSAppPortlet.getPSAppPortletCat());
                  appPSAppPortletCatList.add(iPSAppPortlet.getPSAppPortletCat());
               }
            }

            Collections.sort(appPSAppPortletCatList, new Comparator<IPSAppPortletCat>() {
               public int compare(IPSAppPortletCat o1, IPSAppPortletCat o2) {
                  return o1.isUngroup() ? 1 : StringHelper.compare(o1.getName(), o2.getName(), false);
               }
            });
         }

         if (this.appPSAppPortletCatList == null) {
            this.appPSAppPortletCatList = appPSAppPortletCatList;
         }
      }

      return this.appPSAppPortletCatList != null && this.appPSAppPortletCatList.size() != 0 ? this.appPSAppPortletCatList.iterator() : null;
   }

   @PSModelRTMeta(description = "部署数据标识", dump = false)
   @Override
   public String getDeployId() {
      String strRootDeployId = this.getPSSystem().getDeployId();
      String strOrgId = this.getPSSystemUtil().getDeploySysOrgId();
      String strOrgSectorId = this.getPSSystemUtil().getDeploySysOrgSectorId();
      return KeyValueHelper.genUniqueId(strRootDeployId, strOrgId, strOrgSectorId, this.getPKGCodeName());
   }

   @PSModelRTMeta(description = "流程应用模式")
   @Override
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

   @PSModelRTMeta(description = "应用值规则集合", group = "应用逻辑", order = 220)
   @Override
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
      } else {
         IPSSysValueRule iPSSysValueRule = this.getPSSystem().getPSSysValueRule(strPSAppValueRuleId, bTryMode);
         if (iPSSysValueRule != null) {
            PSAppValueRuleImpl psAppValueRuleImpl = new PSAppValueRuleImpl();
            psAppValueRuleImpl.init(this.getDAGlobalHelper(), this, iPSSysValueRule);
            this.psAppValueRuleMap.put(psAppValueRuleImpl.getId(), psAppValueRuleImpl);
            return psAppValueRuleImpl;
         } else {
            return null;
         }
      }
   }

   @PSModelRTMeta(description = "默认端口", dump = false)
   @Override
   public int getHttpPort() {
      return this.nHttpPort;
   }

   @PSModelRTMeta(name = "[H]前端模板发布帮助", hideempty = true)
   @Override
   public IPSPFPubHelp getPSPFPubHelp() {
      try {
         if (PSTemplHelper.isBusy()) {
            return null;
         }

         if (this.iPSPFPubHelp != null) {
            return this.iPSPFPubHelp;
         }

         Map<String, IPSCodePublisherParam> publisherParamMap = new HashMap<>();
         this.fillPSPFCodePublisherParams(publisherParamMap);
         this.iPSPFPubHelp = PSPFPubHelpImpl.createPSPFPubHelp(this.getPSPFPubObjTarget(), this, this, publisherParamMap);
         return this.iPSPFPubHelp;
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
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
      String strKey = KeyValueHelper.genUniqueId(strPSSysPFPluginId, strRefMode, strTag, strTag2);
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
      String strKey = KeyValueHelper.genUniqueId(strPSSubViewTypeId, strViewType, strTag);
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

      String strKey = KeyValueHelper.genUniqueId(iPSSysEditorStyle.getId(), strContainerType, null);
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
      String strKey = KeyValueHelper.genUniqueId(strPSSysEditorStyleId, strContainerType, strTag);
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

   @PSModelRTMeta(description = "应用前端模板插件引用集合", child = true, dynamodelmode = 4, group = "模板扩展", order = 605)
   @Override
   public Iterator<IPSAppPFPluginRef> getAllPSAppPFPluginRefs() {
      return PSModelUtil.sort(this.psAppPFPluginRefMap, IPSAppPFPluginRef.class).iterator();
   }

   @PSModelRTMeta(description = "应用编辑器样式引用集合", child = true, ignorepf = true, dynamodelmode = 8, group = "模板扩展", order = 607)
   @Override
   public Iterator<IPSAppEditorStyleRef> getAllPSAppEditorStyleRefs() {
      return PSModelUtil.sort(this.psAppEditorStyleRefMap, IPSAppEditorStyleRef.class).iterator();
   }

   @PSModelRTMeta(description = "应用视图子类型引用集合", child = true, group = "模板扩展", order = 609)
   @Override
   public Iterator<IPSAppSubViewTypeRef> getAllPSAppSubViewTypeRefs() {
      return PSModelUtil.sort(this.psAppSubViewTypeRefMap, IPSAppSubViewTypeRef.class).iterator();
   }

   @PSModelRTMeta(description = "应用抬头")
   @Override
   public String getTitle() {
      return this.psSystemApplication.getTITLE();
   }

   @PSModelRTMeta(description = "应用标题")
   @Override
   public String getCaption() {
      return this.psSystemApplication.getCAPTION();
   }

   @PSModelRTMeta(description = "应用子标题")
   @Override
   public String getSubCaption() {
      return this.psSystemApplication.getSUBCAPTION();
   }

   @PSModelRTMeta(description = "应用头部信息")
   @Override
   public String getHeaderInfo() {
      return this.psSystemApplication.getHEADERINFO();
   }

   @PSModelRTMeta(description = "应用下方信息")
   @Override
   public String getBottomInfo() {
      return this.psSystemApplication.getBOTTOMINFO();
   }

   @PSModelRTMeta(description = "应用默认图标")
   @Override
   public IPSSysImage getPSSysImage() {
      return this.iPSSysImage;
   }

   @Override
   protected int onGetDynaInstMode() {
      return this.isEnableDynaSys() ? 1 : 0;
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
      if ("HUBSUBAPP".equals(strModelType)) {
         objectNode.put("name", this.getName());
         Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
         if (psAppDataEntities != null) {
            ArrayNode arrayNode = objectNode.putArray("getAllPSAppDEUIActionGroups");

            while (psAppDataEntities.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
               Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups = iPSAppDataEntity.getAllPSAppDEUIActionGroups();
               if (psAppDEUIActionGroups != null) {
                  while (psAppDEUIActionGroups.hasNext()) {
                     IPSAppDEUIActionGroup iPSAppDEUIActionGroup = psAppDEUIActionGroups.next();
                     if (!StringHelper.isNullOrEmpty(iPSAppDEUIActionGroup.getUniqueTag())) {
                        ObjectNode node = iPSAppDEUIActionGroup.getModel();
                        if (node != null) {
                           arrayNode.add(node);
                        }
                     }
                  }
               }
            }
         }

         Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
         if (psAppViews != null) {
            Map<String, IPSControl> psControlMap = new TreeMap<>();
            ArrayList<IPSControl> allList = new ArrayList<>();

            try {
               PSDEViewPanelImpl.setEmbeddedPSAppDEViewMustLink(true);
               ArrayNode arrayNode = objectNode.putArray("getAllPSDEDRControls");
               ArrayNode arrayNode2 = objectNode.putArray("getAllPSControls");
               ArrayNode arrayNode3 = objectNode.putArray("getAllPSAppViewRefs");

               while (psAppViews.hasNext()) {
                  IPSAppView iPSAppView = psAppViews.next();
                  if (iPSAppView.getPriority() == 100) {
                     Iterator<IPSAppViewRef> psAppViewRefs = null;
                     if (iPSAppView.isRedirectView() && iPSAppView instanceof IPSAppRedirectView) {
                        psAppViewRefs = ((IPSAppRedirectView)iPSAppView).getRedirectPSAppViewRefs();
                     } else {
                        psAppViewRefs = iPSAppView.getPSAppViewRefs();
                     }

                     if (psAppViewRefs != null) {
                        while (psAppViewRefs.hasNext()) {
                           IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
                           ObjectNode node = iPSAppViewRef.getModel();
                           if (node != null) {
                              node.put("ownerTag", iPSAppView.getName());
                              arrayNode3.add(node);
                           }
                        }
                     }

                     allList.clear();
                     ArrayList<IPSControl> list = iPSAppView.getAllPSControls();
                     if (list != null) {
                        allList.addAll(list);
                     }

                     if (iPSAppView.getPSSysViewLayoutPanel() != null) {
                        ArrayList<IPSControl> listx = iPSAppView.getPSSysViewLayoutPanel().getAllPSControls();
                        if (listx != null) {
                           allList.addAll(listx);
                        }
                     }

                     if (allList != null) {
                        for (IPSControl iPSControl : allList) {
                           if (iPSControl instanceof IPSDEDRCtrl) {
                              IPSDEDRCtrl iPSDEDRCtrl = (IPSDEDRCtrl)iPSControl;
                              if (!StringHelper.isNullOrEmpty(iPSDEDRCtrl.getUniqueTag()) && !psControlMap.containsKey(iPSDEDRCtrl.getUniqueTag())) {
                                 ObjectNode node = iPSDEDRCtrl.getModel();
                                 if (node != null) {
                                    arrayNode.add(node);
                                    psControlMap.put(iPSDEDRCtrl.getUniqueTag(), iPSDEDRCtrl);
                                 }
                              }
                           } else if (iPSControl instanceof IPSTabExpPanel) {
                              IPSTabExpPanel iPSTabExpPanel = (IPSTabExpPanel)iPSControl;
                              if (!StringHelper.isNullOrEmpty(iPSTabExpPanel.getUniqueTag()) && !psControlMap.containsKey(iPSTabExpPanel.getUniqueTag())) {
                                 ObjectNode node = iPSTabExpPanel.getModel();
                                 if (node != null) {
                                    arrayNode.add(node);
                                    psControlMap.put(iPSTabExpPanel.getUniqueTag(), iPSTabExpPanel);
                                 }
                              }
                           } else if ((iPSControl instanceof IPSDETree || iPSControl instanceof IPSDEEditForm)
                              && !StringHelper.isNullOrEmpty(iPSControl.getDynaModelFilePath())
                              && !psControlMap.containsKey(iPSControl.getDynaModelFilePath())) {
                              ObjectNode node = iPSControl.toModel("SINGLE");
                              if (node != null) {
                                 arrayNode2.add(node);
                                 psControlMap.put(iPSControl.getDynaModelFilePath(), iPSControl);
                              }
                           }
                        }
                     }
                  }
               }
            } finally {
               PSDEViewPanelImpl.setEmbeddedPSAppDEViewMustLink(false);
            }
         }

         Iterator<IPSAppPFPluginRef> psAppPFPluginRefs = this.getAllPSAppPFPluginRefs();
         if (psAppPFPluginRefs != null) {
            ArrayNode arrayNode = null;

            while (psAppPFPluginRefs.hasNext()) {
               IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
               ObjectNode node = iPSAppPFPluginRef.getModel();
               if (node != null) {
                  if (arrayNode == null) {
                     arrayNode = objectNode.putArray("getAllPSAppPFPluginRefs");
                  }

                  arrayNode.add(node);
               }
            }
         }

         Iterator<IPSAppPortlet> psAppPortlets = this.getAllPSAppPortlets();
         if (psAppPortlets != null) {
            ArrayNode arrayNode = null;

            while (psAppPortlets.hasNext()) {
               IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
               ObjectNode node = iPSAppPortlet.getModel();
               if (node != null) {
                  node.remove("getPSControl");
                  node.remove("portletParams");
                  node.remove("dynaModelFilePath");
                  if (arrayNode == null) {
                     arrayNode = objectNode.putArray("getAllPSAppPortlets");
                  }

                  arrayNode.add(node);
               }
            }
         }
      } else if ("SIMPLEAPP".equals(strModelType)) {
         objectNode.put("name", this.getName());
         objectNode.put("simple", "true");
         if (!StringHelper.isNullOrEmpty(this.getTitle())) {
            objectNode.put("title", this.getTitle());
         }

         if (!StringHelper.isNullOrEmpty(this.getCaption())) {
            objectNode.put("caption", this.getCaption());
         }

         if (!StringHelper.isNullOrEmpty(this.getSubCaption())) {
            objectNode.put("subCaption", this.getSubCaption());
         }

         if (!StringHelper.isNullOrEmpty(this.getHeaderInfo())) {
            objectNode.put("headerInfo", this.getHeaderInfo());
         }

         if (!StringHelper.isNullOrEmpty(this.getBottomInfo())) {
            objectNode.put("bottomInfo", this.getBottomInfo());
         }

         if (this.getPSSysImage() != null) {
            objectNode.put("getPSSysImage", this.getPSSysImage().getModel());
         }

         Iterator<IPSAppPFPluginRef> psAppPFPluginRefs = this.getAllPSAppPFPluginRefs();
         if (psAppPFPluginRefs != null) {
            ArrayNode arrayNode = null;

            while (psAppPFPluginRefs.hasNext()) {
               IPSAppPFPluginRef iPSAppPFPluginRef = psAppPFPluginRefs.next();
               ObjectNode node = iPSAppPFPluginRef.getModel();
               if (node != null) {
                  if (arrayNode == null) {
                     arrayNode = objectNode.putArray("getAllPSAppPFPluginRefs");
                  }

                  arrayNode.add(node);
               }
            }
         }

         Iterator<IPSAppDEUIAction> psAppDEUIActions = this.getAllPSAppDEUIActions();
         if (psAppDEUIActions != null) {
            ArrayNode arrayNode = null;

            while (psAppDEUIActions.hasNext()) {
               IPSAppDEUIAction iPSAppDEUIAction = psAppDEUIActions.next();
               if (iPSAppDEUIAction.getPSAppDataEntity() == null) {
                  ObjectNode node = iPSAppDEUIAction.getModel();
                  if (node != null) {
                     if (arrayNode == null) {
                        arrayNode = objectNode.putArray("getAllPSAppDEUIActions");
                     }

                     arrayNode.add(node);
                  }
               }
            }
         }

         Map<String, IPSAppView> cachePSAppViewMap = new LinkedHashMap<>();
         Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

         while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            if ((iPSAppView.getAccUserMode() & 1) == 1) {
               cachePSAppViewMap.put(iPSAppView.getId(), iPSAppView);
            }

            if (iPSAppView instanceof IPSAppUtilView) {
               IPSAppUtilView iPSAppUtilView = (IPSAppUtilView)iPSAppView;
               if (StringHelper.compare("APPLOGINVIEW", iPSAppUtilView.getViewType(), false) == 0
                  || StringHelper.compare("APPERRORVIEW", iPSAppUtilView.getViewType(), false) == 0
                  || StringHelper.compare("APPSTARTVIEW", iPSAppUtilView.getViewType(), false) == 0
                  || StringHelper.compare("APPWELCOMEVIEW", iPSAppUtilView.getViewType(), false) == 0
                  || StringHelper.compare("APPLOGOUTVIEW", iPSAppUtilView.getViewType(), false) == 0) {
                  cachePSAppViewMap.put(iPSAppView.getId(), iPSAppView);
               }
            }
         }

         ObjectNode cacheNode = JsonNodeHelper.createObjectNode();
         if (cachePSAppViewMap != null) {
            ArrayNode arrayNode = cacheNode.putArray("getPSAppViews");

            for (IPSAppView iPSAppView : cachePSAppViewMap.values()) {
               arrayNode.add(iPSAppView.getModel());
            }
         }

         objectNode.put("cache", cacheNode);
      } else if (this.getPSSystemRuntime() != null && this.getPSSystemRuntime().getDynaInstMode() == 2) {
         if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getPSDynaInstId())) {
            objectNode.put("getPSDynaInstId", this.getPSSystemRuntime().getPSDynaInstId());
         }

         objectNode.put("dynaInstMode", this.getPSSystemRuntime().getDynaInstMode());
         if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getDynaInstTag())) {
            objectNode.put("dynaInstTag", this.getPSSystemRuntime().getDynaInstTag());
         }

         if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getDynaInstTag2())) {
            objectNode.put("dynaInstTag2", this.getPSSystemRuntime().getDynaInstTag2());
         }

         if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getPPSDynaInstId())) {
            objectNode.put("getPPSDynaInstId", this.getPSSystemRuntime().getPPSDynaInstId());
         }

         Iterator<IPSAppCodeList> psAppCodeLists = this.getAllPSAppCodeLists();
         if (psAppCodeLists != null) {
            ArrayNode arrayNode = objectNode.putArray("getAllPSAppCodeLists");

            while (psAppCodeLists.hasNext()) {
               IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
               if (iPSAppCodeList.getDynaInstMode() == 2
                  && StringHelper.compare(this.getPSSystemRuntime().getDynaInstTag(), iPSAppCodeList.getDynaInstTag(), false) == 0) {
                  arrayNode.add(iPSAppCodeList.getModel());
               }
            }
         }

         Iterator<IPSAppDataEntity> psAppDataEntities = this.getAllPSAppDataEntities();
         if (psAppDataEntities != null) {
            ArrayNode arrayNode = objectNode.putArray("getAllPSAppDataEntities");

            while (psAppDataEntities.hasNext()) {
               IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
               if (iPSAppDataEntity.getDynaInstMode() == 2
                  && StringHelper.compare(this.getPSSystemRuntime().getDynaInstTag(), iPSAppDataEntity.getDynaInstTag(), false) == 0) {
                  arrayNode.add(iPSAppDataEntity.getModelRef());
               }
            }
         }

         Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();
         if (psAppViews != null) {
            ArrayNode arrayNode = objectNode.putArray("getAllPSAppViews");

            while (psAppViews.hasNext()) {
               IPSAppView iPSAppView = psAppViews.next();
               if (iPSAppView.getDynaInstMode() == 2
                  && StringHelper.compare(this.getPSSystemRuntime().getDynaInstTag(), iPSAppView.getDynaInstTag(), false) == 0) {
                  arrayNode.add(iPSAppView.toModelRef("APPLICATION"));
               }
            }
         }
      } else {
         super.onFillModelNode(objectNode, strModelType);
         if (objectNode.has("getAllPSAppDEUIActionGroups")) {
            objectNode.remove("getAllPSAppDEUIActionGroups");
         }

         if (!objectNode.has("getAllPSAppDEUIActionGroups")) {
            ArrayNode arrayNode = objectNode.putArray("getAllPSAppDEUIActionGroups");
            Iterator<IPSAppDEUIActionGroup> psAppDEUIActionGroups = this.getAllPSAppDEUIActionGroups();
            if (psAppDEUIActionGroups != null) {
               while (psAppDEUIActionGroups.hasNext()) {
                  arrayNode.add(psAppDEUIActionGroups.next().toModel("APPLICATION"));
               }
            }

            if (arrayNode.size() == 0) {
               objectNode.remove("getAllPSAppDEUIActionGroups");
            }
         }

         if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getPSDynaInstId())) {
            objectNode.put("getPSDynaInstId", this.getPSSystemRuntime().getPSDynaInstId());
         }

         if (!StringHelper.isNullOrEmpty(this.getPSSystemRuntime().getPPSDynaInstId())) {
            objectNode.put("getPPSDynaInstId", this.getPSSystemRuntime().getPPSDynaInstId());
         }

         ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList = ((IPSSystemRuntime)this.iPSSystem).getPSDevSlnSysDynaInstList();
         if (psDevSlnSysDynaInstList != null && psDevSlnSysDynaInstList.size() > 0) {
            ArrayNode arrayNode = objectNode.putArray("getPSDynaInsts");

            for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
               ObjectNode instNode = JsonNodeHelper.createObjectNode();
               instNode.put("id", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
               instNode.put("name", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME());
               if (!StringHelper.isNullOrEmpty(psDevSlnSysDynaInst.getLOGICNAME())) {
                  instNode.put("logicName", psDevSlnSysDynaInst.getLOGICNAME());
               }

               if (!StringHelper.isNullOrEmpty(psDevSlnSysDynaInst.getINSTTYPE())) {
                  instNode.put("instType", psDevSlnSysDynaInst.getINSTTYPE());
               }

               if (!StringHelper.isNullOrEmpty(psDevSlnSysDynaInst.getINSTTAG())) {
                  instNode.put("instTag", psDevSlnSysDynaInst.getINSTTAG());
               }

               if (!StringHelper.isNullOrEmpty(psDevSlnSysDynaInst.getINSTTAG2())) {
                  instNode.put("instTag2", psDevSlnSysDynaInst.getINSTTAG2());
               }

               arrayNode.add(instNode);
            }
         }

         if (this.getPSSysSFPlugin() != null) {
            ObjectNode childNode = this.getPSSysSFPlugin().toModelRef("");
            putJsonProperty(objectNode, "getPSSysSFPlugin", childNode);
         }

         if (this.getPSSysResource() != null) {
            ObjectNode childNode = this.getPSSysResource().toModelRef("");
            putJsonProperty(objectNode, "getPSSysResource", childNode);
         }

         if ((PSObjectImpl.getDynaModelPubMode() & 8) != 8) {
            if (objectNode.has("getAllPSAppSubViewTypeRefs")) {
               objectNode.remove("getAllPSAppSubViewTypeRefs");
            }

            if (this.isEnableUIModelEx()) {
               Iterator<IPSAppSubViewTypeRef> psAppSubViewTypeRefs = this.getAllPSAppSubViewTypeRefs();
               if (psAppSubViewTypeRefs != null) {
                  ArrayNode arrayNode = null;

                  while (psAppSubViewTypeRefs.hasNext()) {
                     IPSAppSubViewTypeRef iPSAppSubViewTypeRef = psAppSubViewTypeRefs.next();
                     if (iPSAppSubViewTypeRef.isReplaceDefault()) {
                        ObjectNode childNode = iPSAppSubViewTypeRef.toModel("");
                        if (arrayNode == null) {
                           arrayNode = objectNode.putArray("getAllPSAppSubViewTypeRefs");
                        }

                        arrayNode.add(childNode);
                     }
                  }
               }
            }
         }

         Map<String, IPSAppView> cachePSAppViewMap = new LinkedHashMap<>();
         Map<String, IPSAppDataEntity> cachePSDataEntityMap = new LinkedHashMap<>();
         IPSAppIndexView iPSAppIndexView = this.getDefaultPSAppIndexView();
         if (this.getDefaultPSAppIndexView() != null) {
            iPSAppIndexView = this.getDefaultPSAppIndexView();
         } else {
            Iterator<IPSAppView> psAppViews = this.getAllPSAppViews();

            while (psAppViews.hasNext()) {
               IPSAppView iPSAppView = psAppViews.next();
               if (iPSAppView instanceof IPSAppIndexView) {
                  iPSAppIndexView = (IPSAppIndexView)iPSAppView;
                  break;
               }
            }
         }

         if (iPSAppIndexView != null) {
            cachePSAppViewMap.put(iPSAppIndexView.getId(), iPSAppIndexView);
            if (iPSAppIndexView.getPSAppMenu() != null) {
               Iterator<IPSAppMenuItem> psAppMenuItems = iPSAppIndexView.getPSAppMenu().getPSAppMenuItems();
               if (psAppMenuItems != null) {
                  while (psAppMenuItems.hasNext()) {
                     IPSAppFunc iPSAppFunc = psAppMenuItems.next().getPSAppFunc();
                     if (iPSAppFunc != null && iPSAppFunc.getPSAppView() != null) {
                        cachePSAppViewMap.put(iPSAppFunc.getPSAppView().getId(), iPSAppFunc.getPSAppView());
                     }
                  }
               }
            }
         }

         for (IPSAppView iPSAppView : cachePSAppViewMap.values()) {
            IPSAppDataEntity iPSAppDataEntity = iPSAppView.getPSAppDataEntity();
            if (iPSAppDataEntity != null) {
               cachePSDataEntityMap.put(iPSAppDataEntity.getId(), iPSAppDataEntity);
            }
         }

         ObjectNode cacheNode = JsonNodeHelper.createObjectNode();
         if (cachePSAppViewMap != null) {
            ArrayNode arrayNode = cacheNode.putArray("getPSAppViews");

            for (IPSAppView iPSAppView : cachePSAppViewMap.values()) {
               arrayNode.add(iPSAppView.getModel());
            }
         }

         if (cachePSDataEntityMap != null) {
            ArrayNode arrayNode = cacheNode.putArray("getPSAppDataEntities");

            for (IPSAppDataEntity iPSAppDataEntity : cachePSDataEntityMap.values()) {
               arrayNode.add(iPSAppDataEntity.getModel());
            }
         }

         objectNode.put("cache", cacheNode);
      }
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

   protected void registerPSApplicationLogics() throws Exception {
      Map<String, IPSAppDEUILogicGroupDetail> map = new LinkedHashMap<>();
      Iterator<IPSAppLogic> psAppLogics = this.getAllPSAppLogics();
      if (psAppLogics != null) {
         while (psAppLogics.hasNext()) {
            IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = psAppLogics.next();
            String strName = iPSAppDEUILogicGroupDetail.getName();
            if (!StringHelper.isNullOrEmpty(strName)) {
               strName = strName.toLowerCase();
               if (!map.containsKey(strName)) {
                  map.put(strName, iPSAppDEUILogicGroupDetail);
                  if ("APPEVENT".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
                     || "TIMER".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
                     || "CUSTOM".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
                     PSApplicationLogicImpl psApplicationLogicImpl = new PSApplicationLogicImpl(this, iPSAppDEUILogicGroupDetail);
                     this.registerPSApplicationLogic(psApplicationLogicImpl);
                  }
               }
            }
         }
      }

      String strPPSDEUILogicGroupId = this.psSystemApplication.getPSCTRLLOGICGROUPID();
      if (!StringHelper.isNullOrEmpty(strPPSDEUILogicGroupId)) {
         List<IPSAppDEUILogicGroup> list = new ArrayList<>();

         while (!StringHelper.isNullOrEmpty(strPPSDEUILogicGroupId)) {
            IPSAppDEUILogicGroup parent = this.getPSAppDEUILogicGroup(strPPSDEUILogicGroupId);
            if (list.contains(parent)) {
               throw new Exception(String.format("界面逻辑组[%1$s]出现递归引用", parent.getFullName()));
            }

            list.add(parent);
            strPPSDEUILogicGroupId = parent.getParentPSDEUILogicGroupId();
         }

         for (IPSAppDEUILogicGroup item : list) {
            Iterator<? extends IPSAppDEUILogicGroupDetail> psAppDEUILogicGroupDetails = item.getPSAppDEUILogicGroupDetails();
            if (psAppDEUILogicGroupDetails != null) {
               while (psAppDEUILogicGroupDetails.hasNext()) {
                  IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                  String strName = iPSAppDEUILogicGroupDetail.getName();
                  if (!StringHelper.isNullOrEmpty(strName)) {
                     strName = strName.toLowerCase();
                     if (!map.containsKey(strName)) {
                        map.put(strName, iPSAppDEUILogicGroupDetail);
                        if ("APPEVENT".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
                           || "TIMER".equals(iPSAppDEUILogicGroupDetail.getTriggerType())
                           || "CUSTOM".equals(iPSAppDEUILogicGroupDetail.getTriggerType())) {
                           PSApplicationLogicImpl psApplicationLogicImpl = new PSApplicationLogicImpl(this, iPSAppDEUILogicGroupDetail);
                           this.registerPSApplicationLogic(psApplicationLogicImpl);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   protected void registerPSApplicationLogic(IPSApplicationLogic iPSApplicationLogic) throws Exception {
      if (this.psApplicationLogicList == null) {
         this.psApplicationLogicList = new ArrayList<>();
      }

      this.psApplicationLogicList.add(iPSApplicationLogic);
   }

   @PSModelRTMeta(description = "应用预载逻辑集合", hideempty2 = true, child = true, group = "应用逻辑", order = 302)
   @Override
   public Iterator<? extends IPSApplicationLogic> getPSApplicationLogics() {
      return this.psApplicationLogicList != null && this.psApplicationLogicList.size() != 0 ? this.psApplicationLogicList.iterator() : null;
   }

   @Override
   public String getFormItemEmptyText() {
      return this.psSystemApplication.getFIEMPTYTEXT();
   }

   @PSModelRTMeta(description = "动态模型文件路径", hideempty = true)
   @Override
   public String getDynaModelFilePath() {
      if (!this.isEnableDynaModel()) {
         return null;
      }

      String strDynaModelPath = this.getDynaModelFolder();
      return StringHelper.isNullOrEmpty(strDynaModelPath) ? null : String.format("%1$s/%2$s.json", this.getDynaModelFolder(), this.getDumpModelType());
   }

   @Override
   protected boolean isEnableExportModel() {
      return !this.isEnableDynaSys() ? false : super.isEnableExportModel();
   }

   @Override
   protected boolean isEnableExportModelRef() {
      return !this.isEnableDynaSys() ? false : super.isEnableExportModelRef();
   }

   @PSModelRTMeta(description = "启用服务接口DTO", ignoredumpvalues = "false")
   @Override
   public boolean isEnableServiceAPIDTO() {
      return this.bEnableServiceAPIDTO;
   }

   @PSModelRTMeta(description = "全部资源标识集合", child = true, group = "访问控制", order = 515)
   @Override
   public Iterator<String> getAllAccessKeys() {
      return this.accessKeyMap != null && this.accessKeyMap.size() != 0 ? this.accessKeyMap.keySet().iterator() : null;
   }

   protected void fillPSAppMenuItemAccessKey(IPSAppMenuItem iPSAppMenuItem) {
      if (!StringHelper.isNullOrEmpty(iPSAppMenuItem.getAccessKey())) {
         this.accessKeyMap.put(iPSAppMenuItem.getAccessKey(), null);
      }

      Iterator<IPSAppMenuItem> psAppMenuItems = iPSAppMenuItem.getPSAppMenuItems();
      if (psAppMenuItems != null) {
         while (psAppMenuItems.hasNext()) {
            this.fillPSAppMenuItemAccessKey(psAppMenuItems.next());
         }
      }
   }

   @Override
   public int getACMinChars() {
      return this.nACMinChars;
   }

   @PSModelRTMeta(description = "后端扩展插件", ignorepf = true, hideempty = true)
   @Override
   public IPSSysSFPlugin getPSSysSFPlugin() {
      return this.iPSSysSFPlugin;
   }

   @PSModelRTMeta(description = "绘制器", hideempty = true)
   @Override
   public IPSSFXCodeObject getRender() {
      return this.iPSSFXCodeObject;
   }

   @Override
   public String getDEPSSysSFPluginId() {
      return this.psSystemApplication.getDEPSSYSSFPLUGINID();
   }

   @PSModelRTMeta(description = "全局实体操作标识集合", child = true, outputdoc = "false")
   @Override
   public Iterator<? extends IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception {
      return this.getPSSystem().getAllPSDEOPPrivs();
   }

   @PSModelRTMeta(description = "应用标记", hideempty2 = true)
   @Override
   public String getAppTag() {
      return this.psSystemApplication.getAPPTAG();
   }

   @PSModelRTMeta(description = "应用标记2", hideempty2 = true)
   @Override
   public String getAppTag2() {
      return this.psSystemApplication.getAPPTAG2();
   }

   @PSModelRTMeta(description = "应用标记3", hideempty2 = true)
   @Override
   public String getAppTag3() {
      return this.psSystemApplication.getAPPTAG3();
   }

   @PSModelRTMeta(description = "应用标记4", hideempty2 = true)
   @Override
   public String getAppTag4() {
      return this.psSystemApplication.getAPPTAG4();
   }

   @PSModelRTMeta(description = "系统代码标识", hideempty2 = true)
   @Override
   public String getSysCodeName() {
      return this.getPSSystem().getCodeName();
   }

   @PSModelRTMeta(description = "模型引擎版本")
   @Override
   public int getEngineVer() {
      return this.getPSSystem().getEngineVer();
   }

   @PSModelRTMeta(description = "预置资源对象", ignorepf = true, hideempty = true, dumpref = true)
   @Override
   public IPSSysResource getPSSysResource() {
      if (this.iPSSysResource == null) {
         try {
            Iterator<IPSSysResource> psSysResources = this.getPSSystem().getAllPSSysResources();
            if (psSysResources != null) {
               while (psSysResources.hasNext()) {
                  IPSSysResource item = psSysResources.next();
                  if (!StringHelper.isNullOrEmpty(item.getResTag())) {
                     String strResTag = String.format("PSSYSAPP__%1$s", this.getCodeName()).toUpperCase();
                     if (StringHelper.compare(item.getResTag(), strResTag, true) == 0) {
                        this.iPSSysResource = item;
                        break;
                     }
                  }
               }
            }
         } catch (Exception ex) {
            log.error(ex);
         }
      }

      return this.iPSSysResource;
   }

   @PSModelRTMeta(description = "应用方法DTO集合", child = true, group = "应用逻辑", order = 236)
   @Override
   public Iterator<IPSAppMethodDTO> getAllPSAppMethodDTOs() throws Exception {
      return this.psAppMethodDTOMap != null && this.psAppMethodDTOMap.size() != 0 ? this.psAppMethodDTOMap.values().iterator() : null;
   }

   @Override
   public IPSAppMethodDTO getPSAppMethodDTO(IPSSysMethodDTO iPSSysMethodDTO) throws Exception {
      for (Entry<String, IPSAppMethodDTO> entry : this.psAppMethodDTOMap.entrySet()) {
         if (StringHelper.compare(entry.getValue().getType(), "DEFAULT", true) == 0
            && entry.getValue().getPSSysMethodDTO() != null
            && StringHelper.compare(entry.getValue().getPSSysMethodDTO().getId(), iPSSysMethodDTO.getId(), false) == 0) {
            return entry.getValue();
         }
      }

      PSAppMethodDTOImpl psAppMethodDTOImpl = new PSAppMethodDTOImpl();
      psAppMethodDTOImpl.init(this.getDAGlobalHelper(), this, iPSSysMethodDTO);
      if (this.psAppMethodDTOMap.containsKey(psAppMethodDTOImpl.getCodeName())) {
         throw new Exception(String.format("应用中已存在代码标识为[%1$s]的方法DTO对象", psAppMethodDTOImpl.getCodeName()));
      }

      this.psAppMethodDTOMap.put(psAppMethodDTOImpl.getCodeName(), psAppMethodDTOImpl);
      return psAppMethodDTOImpl;
   }

   @PSModelRTMeta(description = "应用智能报表体系集合", child = true, dumpref = true)
   @Override
   public Iterator<IPSAppBIScheme> getAllPSAppBISchemes() throws Exception {
      return this.psAppBISchemeMap != null && this.psAppBISchemeMap.size() != 0 ? this.psAppBISchemeMap.values().iterator() : null;
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

   @PSModelRTMeta(description = "应用逻辑集合", child = true)
   @Override
   public Iterator<IPSAppLogic> getAllPSAppLogics() throws Exception {
      return this.psAppLogicGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSAppLogic getPSAppLogic(String strPSAppLogicId) throws Exception {
      return this.psAppLogicGlobalModel.FindModelHelper(strPSAppLogicId);
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
            if (!StringHelper.isNullOrEmpty(strPredefinedType) && StringHelper.compare(strType, strPredefinedType, false) == 0) {
               return this.getPSAppDEUIAction(iPSDEUIAction.getId());
            }
         }
      }

      if (bTryMode) {
         return null;
      } else {
         throw new Exception(String.format("无法获取指定全局预置界面行为[%1$s]", strType));
      }
   }

   @PSModelRTMeta(description = "启用界面模型增强", ignoredumpvalues = "false")
   @Override
   public boolean isEnableUIModelEx() {
      try {
         String strEnableUIModelEx = this.getPFStyleParam("ENABLEUIMODELEX", "");
         if (!StringHelper.isNullOrEmpty(strEnableUIModelEx)) {
            if (StringHelper.compare(strEnableUIModelEx, "TRUE", true) == 0) {
               return true;
            }

            return false;
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return this.getPSSystemSetting().isEnableUIModelEx();
   }

   @PSModelRTMeta(description = "启用BI模型", dump = false, ignoredumpvalues = "false")
   public boolean isEnableBIScheme() {
      try {
         String strEnableBIScheme = this.getPFStyleParam("ENABLEBISCHEME", "");
         if (!StringHelper.isNullOrEmpty(strEnableBIScheme)) {
            if (StringHelper.compare(strEnableBIScheme, "TRUE", true) == 0) {
               return true;
            }

            return false;
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      return true;
   }

   @PSModelRTMeta(description = "动态系统模式", codelist = "DynaSysMode", ignoredumpvalues = "0", fields = "ENABLEDYNASYS")
   @Override
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

   @PSModelRTMeta(description = "默认对象存储分类")
   @Override
   public String getDefaultOSSCat() {
      try {
         return this.getPFStyleParam("DEFAULTOSSCAT", "");
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "视图代码标识模式", codelist = "CodeNameMode", fields = "CODENAMEMODE")
   @Override
   public String getViewCodeNameMode() {
      if (StringHelper.isNullOrEmpty(this.psSystemApplication.getCODENAMEMODE())) {
         try {
            return this.getPFStyleParam("CODENAMEMODE", null);
         } catch (Exception ex) {
            log.error(ex);
         }
      }

      return this.psSystemApplication.getCODENAMEMODE();
   }

   @Override
   public String getViewCodeName(String strPrefix, String strCodeName, String strSuffix) {
      return PSModelCodeNameUtils.to(this.getViewCodeNameMode(), strPrefix, strCodeName, strSuffix);
   }

   @PSModelRTMeta(description = "应用实体属性输入提示集合集合", child = true, modelreftype = "APPLICATION", group = "模型&接口", order = 172)
   @Override
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
      } else {
         IPSDEFInputTipSet iPSSysDEFInputTipSet = this.getPSSystem().getPSDEFInputTipSet(strPSAppDEFInputTipSetId, bTryMode);
         if (iPSSysDEFInputTipSet != null) {
            PSAppDEFInputTipSetImpl psAppDEFInputTipSetImpl = new PSAppDEFInputTipSetImpl();
            psAppDEFInputTipSetImpl.init(this.getDAGlobalHelper(), this, iPSSysDEFInputTipSet);
            this.psAppDEFInputTipSetMap.put(psAppDEFInputTipSetImpl.getId(), psAppDEFInputTipSetImpl);
            return psAppDEFInputTipSetImpl;
         } else {
            return null;
         }
      }
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

   @PSModelRTMeta(description = "子应用访问标识")
   @Override
   public String getSubAppAccessKey() {
      try {
         return this.getPFStyleParam("SUBAPPACCESSKEY", "");
      } catch (Exception ex) {
         log.error(ex);
         return null;
      }
   }

   @Override
   public int getOrderValue() {
      return !this.psSystemApplication.isORDERVALUENull() && this.psSystemApplication.getORDERVALUE() >= 0 ? this.psSystemApplication.getORDERVALUE() : 99999;
   }
}
