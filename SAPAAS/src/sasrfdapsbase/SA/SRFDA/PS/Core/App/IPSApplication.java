/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IApplication
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.Control.IPSControlContainerView;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSAppLogic;
import SA.SRFDA.PS.Core.App.IPSAppMethodDTO;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSAppPDTView;
import SA.SRFDA.PS.Core.App.IPSAppPkg;
import SA.SRFDA.PS.Core.App.IPSAppResource;
import SA.SRFDA.PS.Core.App.IPSAppUIStyle;
import SA.SRFDA.PS.Core.App.IPSAppUtilPage;
import SA.SRFDA.PS.Core.App.IPSApplicationLogic;
import SA.SRFDA.PS.Core.App.IPSApplicationUI;
import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Mob.IPSAppLocalDE;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppIcon;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackCert;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppStartPage;
import SA.SRFDA.PS.Core.App.Msg.IPSAppMsgTempl;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
import SA.SRFDA.PS.Core.App.Res.IPSAppDEFInputTipSet;
import SA.SRFDA.PS.Core.App.Res.IPSAppEditorStyleRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.App.Res.IPSAppSubViewTypeRef;
import SA.SRFDA.PS.Core.App.Theme.IPSAppUITheme;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.App.Util.IPSAppDynaDashboardUtil;
import SA.SRFDA.PS.Core.App.Util.IPSAppFilterStorageUtil;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewStyle;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Data.PSSystemApplication;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IApplication;

@PSModelInterfaceMeta(title="\u5e94\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysApp")
public interface IPSApplication
extends IPSSystemObject,
IApplication,
IPSSysSFPubObject {
    public static final String CONTEXT_WFIATAG = "srfwfiatag";
    public static final String CONTEXT_WFSTEP = "srfwfstep";
    public static final String CONTEXT_USERID = "srfuserid";
    public static final String CONTEXT_USERNAME = "srfusername";
    public static final String CONTEXT_USERICONPATH = "srfusericonpath";
    public static final String CONTEXT_USERMODE = "srfusermode";
    public static final String CONTEXT_LOGINNAME = "srfloginname";
    public static final String CONTEXT_LOCALE = "srflocale";
    public static final String CONTEXT_TIMEZONE = "srftimezone";
    public static final String CONTEXT_ORGID = "srforgid";
    public static final String CONTEXT_ORGNAME = "srforgname";
    public static final String CONTEXT_ORGSECTORID = "srforgsectorid";
    public static final String CONTEXT_ORGSECTORNAME = "srforgsectorname";
    public static final String CONTEXT_ORGSECTORBC = "srfsectorbc";
    public static final String CONTEXT_WFMODE = "srfwfmode";
    public static final String CONTEXT_PARENTDENAME = "srfparentdename";
    public static final String CONTEXT_PARENTKEY = "srfparentkey";
    public static final String CONTEXT_DYNAINSTID = "srfdynainstid";
    public static final String BACKENDMODE_VIEW = "VIEW";
    public static final String BACKENDMODE_SERVICE = "SERVICE";
    public static final String APPMODE_DEFAULT = "DEFAULT";
    public static final String APPMODE_WFAPP = "WFAPP";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSystemApplication var3) throws Exception;

    public IPSPFStyle getPSPFStyle(String var1) throws Exception;

    public boolean getDefaultFlag();

    public String getPFType();

    public String getPFStyle();

    public IPSPF getPSPF();

    public IPSPFStyle getPSPFStyle();

    public IPSAppView getPSAppView(String var1, boolean var2) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2, IPSAppView var3) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2, boolean var3) throws Exception;

    public IPSAppView getPSAppView(String var1, String var2, boolean var3, IPSAppView var4) throws Exception;

    public void resetPSAppView(String var1);

    public Iterator<IPSAppView> getAllPSAppViews() throws Exception;

    public Iterator<IPSAppView> getAllRefPSAppViews() throws Exception;

    public Iterator<IPSAppModule> getAllPSAppModules() throws Exception;

    public IPSAppModule getPSAppModule(String var1) throws Exception;

    public void resetPSAppModule(String var1);

    public String getPKGCodeName();

    @Override
    public String getCodeName();

    public String getCodeFolder();

    public IPSAppViewStyle getPSAppViewStyle(String var1) throws Exception;

    public void resetPSAppViewStyle(String var1);

    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType var1, String var2, IPSPFPubCode var3, String var4) throws Exception;

    public IPSAppFunc getPSAppFunc(String var1) throws Exception;

    public IPSAppFunc getPSAppFunc(String var1, boolean var2) throws Exception;

    public IPSAppFunc getPSAppFunc(String var1, boolean var2, IPSModelObject var3) throws Exception;

    public void resetPSAppFunc(String var1);

    public Iterator<IPSAppFunc> getAllPSAppFuncs() throws Exception;

    public IPSAppViewCode getPSAppViewCode(String var1, boolean var2) throws Exception;

    public void resetPSAppViewCode(String var1);

    public Iterator<IPSAppViewCode> getAllPSAppViewCodes() throws Exception;

    public void load(int var1) throws Exception;

    public int getLoadingLevel();

    public int getLoadedLevel();

    public boolean isLoading();

    public Iterator<IPSSubAppRef> getAllPSSubAppRefs() throws Exception;

    public IPSSubAppRef getPSSubAppRef(String var1) throws Exception;

    public void resetPSSubAppRef(String var1);

    public IPSSubAppRef getPSSubAppRefBySubApp(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppUtilPage> getAllPSAppUtilPages() throws Exception;

    public IPSAppUtilPage getPSAppUtilPage(String var1) throws Exception;

    public IPSAppUtilPage getPSAppUtilPage(String var1, boolean var2) throws Exception;

    public void resetPSAppUtilPage(String var1);

    public Object getPFStyleParam(String var1) throws Exception;

    public boolean getPFStyleParam(String var1, boolean var2) throws Exception;

    public String getPFStyleParam(String var1, String var2) throws Exception;

    public int getPFStyleParam(String var1, int var2) throws Exception;

    public double getPFStyleParam(String var1, double var2) throws Exception;

    public boolean isUseServiceApi();

    public boolean isMobileApp();

    public IPSAppView getPSAppViewByDEViewId(String var1, boolean var2) throws Exception;

    public IPSAppUserMode getPSAppUserMode(String var1) throws Exception;

    public void resetPSAppUserMode(String var1);

    public Iterator<IPSAppUserMode> getAllPSAppUserModes() throws Exception;

    public IPSAppMenuModel getPSAppMenuModel(String var1) throws Exception;

    public void resetPSAppMenuModel(String var1);

    public Iterator<IPSAppMenuModel> getAllPSAppMenuModels() throws Exception;

    public String getAppVersion();

    public String getAppFolder();

    public Iterator<IPSAppLan> getAllPSAppLans() throws Exception;

    public IPSAppLan getPSAppLan(String var1) throws Exception;

    public void resetPSAppLan(String var1);

    public String getMainMenuAlign();

    public Iterator<IPSAppPkg> getAllPSAppPkgs() throws Exception;

    public Iterator<IPSPFPkgVer> getAllPSPFPkgVers() throws Exception;

    public Iterator<IPSAppPkg> getPSAppPkgs() throws Exception;

    public Iterator<IPSPFPkgVer> getPSPFPkgVers() throws Exception;

    public boolean isEnableMultiLan();

    public IPSPFCDN getPSPFCDN();

    public boolean isPubRefViewOnly();

    public IPSMobAppStartPage getPSMobAppStartPage(String var1, boolean var2) throws Exception;

    public void resetPSMobAppStartPage(String var1);

    public Iterator<IPSMobAppStartPage> getAllPSMobAppStartPages() throws Exception;

    public IPSMobAppIcon getPSMobAppIcon(String var1, boolean var2) throws Exception;

    public void resetPSMobAppIcon(String var1);

    public Iterator<IPSMobAppIcon> getAllPSMobAppIcons() throws Exception;

    public IPSMobAppPack getPSMobAppPack(String var1) throws Exception;

    public void resetPSMobAppPack(String var1);

    public IPSMobAppPackCert getPSMobAppPackCert(String var1) throws Exception;

    public void resetPSMobAppPackCert(String var1);

    public IPSApplicationUI getPSApplicationUI();

    public IPSAppUIStyle getPSAppUIStyle();

    public Iterator<IPSSysCss> getAllPSSysCsses(boolean var1) throws Exception;

    public Iterator<IPSSysImage> getAllPSSysImages(boolean var1) throws Exception;

    public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins(boolean var1) throws Exception;

    public Iterator<? extends IPSViewMsgGroup> getAllPSViewMsgGroups(boolean var1) throws Exception;

    public Iterator<? extends IPSAppViewMsgGroup> getAllPSAppViewMsgGroups(boolean var1) throws Exception;

    public Iterator<IPSSysCss> getAllPSSysCsses() throws Exception;

    public Iterator<IPSSysImage> getAllPSSysImages() throws Exception;

    public Iterator<IPSSysPFPlugin> getAllPSSysPFPlugins() throws Exception;

    public Iterator<? extends IPSAppViewMsgGroup> getAllPSViewMsgGroups() throws Exception;

    public IPSAppView getDefaultPSAppView() throws Exception;

    public IPSAppIndexView getDefaultPSAppIndexView() throws Exception;

    public IPSAppLocalDE getPSAppLocalDE(String var1) throws Exception;

    public void resetPSAppLocalDE(String var1);

    public Iterator<? extends IPSAppLocalDE> getAllPSAppLocalDEs() throws Exception;

    public boolean isAutoAddAppDEView();

    public String getServiceCodeName();

    public boolean isEnableUACLogin();

    public boolean isPreviewMode();

    public void markPSAppViewUsage(String var1, int var2, Object var3);

    public int getPSAppViewUsage(String var1);

    public Iterator<IPSAppUIStyle> getAllPSAppUIStyles() throws Exception;

    public IPSAppUIStyle getPSAppUIStyle(String var1) throws Exception;

    public void resetPSAppUIStyle(String var1);

    public Iterator<IPSAppUITheme> getAllPSAppUIThemes() throws Exception;

    public IPSAppUITheme getPSAppUITheme(String var1) throws Exception;

    public void resetPSAppUITheme(String var1);

    public String getWorkshopName();

    public IPSPF getDefaultPSPF();

    public IPSPFStyle getDefaultPSPFStyle();

    public boolean isEnableDynaSys();

    public Iterator<IPSAppPDTView> getAllPSAppPDTViews() throws Exception;

    public IPSAppPDTView getPSAppPDTView(String var1, boolean var2) throws Exception;

    public void resetPSAppPDTView(String var1);

    public IPSAppDataEntity getPSAppDataEntity(String var1, boolean var2) throws Exception;

    public IPSAppDataEntity getPSAppDataEntityByDEId(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppDataEntity> getPSAppDataEntitiesByDEId(String var1) throws Exception;

    public IPSAppDataEntity getPSAppDataEntity(IPSDataEntity var1, boolean var2) throws Exception;

    public void resetPSAppDataEntity(String var1);

    public Iterator<IPSAppDataEntity> getAllPSAppDataEntities() throws Exception;

    public String getBackendMode();

    public String getProjectPath();

    public Iterator<IPSAppFunc> getPSAppFuncsByTag(String var1) throws Exception;

    public Iterator<IPSAppUILogic> getAllPSAppUILogics() throws Exception;

    public IPSAppUILogic getPSAppUILogic(String var1) throws Exception;

    public void resetPSAppUILogic(String var1);

    public IPSAppWF getPSAppWF(String var1) throws Exception;

    public IPSAppWF getPSAppWF(String var1, boolean var2) throws Exception;

    public void resetPSAppWF(String var1);

    public Iterator<IPSAppWF> getAllPSAppWFs() throws Exception;

    public IPSAppWFVer getPSAppWFVer(String var1) throws Exception;

    public IPSAppWFVer getPSAppWFVer(String var1, boolean var2) throws Exception;

    public void resetPSAppWFVer(String var1);

    public Iterator<IPSAppWFVer> getAllPSAppWFVers() throws Exception;

    public IPSSysServiceAPI getPSSysServiceAPI();

    public Iterator<IPSSysServiceAPI> getAllPSSysServiceAPIs() throws Exception;

    public Iterator<IPSAppResource> getAllPSAppResources() throws Exception;

    public IPSAppResource getPSAppResource(String var1) throws Exception;

    public IPSAppResource getPSAppResource(String var1, boolean var2) throws Exception;

    public void resetPSAppResource(String var1);

    public Iterator<IPSAppDERS> getAllPSAppDERSs() throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction(String var1) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction(String var1, boolean var2) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIActionByPredefinedType(String var1, boolean var2) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction(String var1, boolean var2, IPSModelObject var3) throws Exception;

    public IPSAppDEUIAction getPSAppDEUIAction2(String var1, boolean var2) throws Exception;

    public void resetPSAppDEUIAction(String var1);

    public Iterator<IPSAppDEUIAction> getAllPSAppDEUIActions() throws Exception;

    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String var1) throws Exception;

    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSAppDEUIActionGroup(String var1);

    public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception;

    public Iterator<IPSSysTestPrj> getAllPSSysTestPrjs() throws Exception;

    public Iterator<IPSAppCounter> getAllPSAppCounters() throws Exception;

    public IPSAppCounter getPSAppCounter(String var1) throws Exception;

    public IPSAppCounter getPSAppCounter(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppCodeList> getAllPSAppCodeLists() throws Exception;

    public Iterator<IPSAppCodeList> getAllPSAppCodeLists(boolean var1) throws Exception;

    public IPSAppCodeList getPSAppCodeList(String var1) throws Exception;

    public IPSAppCodeList getPSAppCodeList(String var1, boolean var2) throws Exception;

    public IPSAppCodeList getPSAppCodeList(IPSCodeList var1, boolean var2) throws Exception;

    public IPSCodeList getPSCodeList(IPSCodeList var1, boolean var2) throws Exception;

    public Iterator<? extends IPSAppViewMsgGroup> getAllPSAppViewMsgGroups() throws Exception;

    public IPSAppViewMsgGroup getPSAppViewMsgGroup(String var1) throws Exception;

    public IPSAppViewMsgGroup getPSAppViewMsgGroup(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSAppViewMsg> getAllPSAppViewMsgs() throws Exception;

    public IPSAppViewMsg getPSAppViewMsg(String var1) throws Exception;

    public IPSAppViewMsg getPSAppViewMsg(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppDEUILogicGroup> getAllPSAppDEUILogicGroups() throws Exception;

    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String var1) throws Exception;

    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String var1, boolean var2) throws Exception;

    public IPSAppDEUILogicGroup getPSAppDEUILogicGroup(String var1, boolean var2, IPSModelObject var3) throws Exception;

    public void resetPSAppDEUILogicGroup(String var1);

    public String getAppType();

    public String getAppMode();

    public Iterator<IPSAppUtil> getAllPSAppUtils() throws Exception;

    public IPSAppUtil getPSAppUtil(String var1) throws Exception;

    public IPSAppUtil getPSAppUtil(String var1, boolean var2) throws Exception;

    public void resetPSAppUtil(String var1);

    public IPSAppFilterStorageUtil getPSAppFilterStorageUtil();

    public IPSAppDynaDashboardUtil getPSAppDynaDashboardUtil();

    public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception;

    public IPSAppPortlet getPSAppPortlet(String var1) throws Exception;

    public IPSAppPortlet getPSAppPortlet(String var1, boolean var2) throws Exception;

    public void resetPSAppPortlet(String var1);

    public Iterator<IPSControlContainerView> getPSControlContainerViews();

    public Iterator<IPSAppPortletCat> getAllPSAppPortletCats() throws Exception;

    public IPSAppPortletCat getPSAppPortletCat(String var1) throws Exception;

    public IPSAppPortletCat getPSAppPortletCat(String var1, boolean var2) throws Exception;

    public IPSAppPortletCat getUngroupPSAppPortletCat() throws Exception;

    public Iterator<IPSAppPortlet> getAppPSAppPortlets() throws Exception;

    public Iterator<IPSAppPortletCat> getAppPSAppPortletCats() throws Exception;

    public boolean isWFAppMode();

    public Iterator<IPSAppValueRule> getAllPSAppValueRules() throws Exception;

    public IPSAppValueRule getPSAppValueRule(String var1) throws Exception;

    public IPSAppValueRule getPSAppValueRule(String var1, boolean var2) throws Exception;

    public int getHttpPort();

    public IPSSysPFPlugin getPSSysPFPlugin(String var1, String var2, String var3, String var4) throws Exception;

    public IPSSubViewType getPSSubViewType(String var1, String var2) throws Exception;

    public IPSSubViewType getPSSubViewType(String var1, String var2, String var3) throws Exception;

    public IPSSysEditorStyle getPSSysEditorStyle(String var1, String var2) throws Exception;

    public IPSSysEditorStyle getPSSysEditorStyle(String var1, String var2, String var3) throws Exception;

    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String var1, String var2) throws Exception;

    public Iterator<IPSAppPFPluginRef> getAllPSAppPFPluginRefs();

    public Iterator<IPSAppEditorStyleRef> getAllPSAppEditorStyleRefs();

    public Iterator<IPSAppSubViewTypeRef> getAllPSAppSubViewTypeRefs();

    public IPSAppModule getDefaultPSAppModule();

    public String getTitle();

    public String getCaption();

    public String getSubCaption();

    public String getHeaderInfo();

    public String getBottomInfo();

    public IPSLanguageRes getPSLanguageRes(String var1) throws Exception;

    public Iterator<IPSLanguageRes> getAllPSLanguageReses();

    public Iterator<IPSAppMsgTempl> getAllPSAppMsgTempls() throws Exception;

    public IPSAppMsgTempl getPSAppMsgTempl(String var1) throws Exception;

    public IPSAppMsgTempl getPSAppMsgTempl(String var1, boolean var2) throws Exception;

    public IPSAppMsgTempl getPSAppMsgTempl(IPSSysMsgTempl var1, boolean var2) throws Exception;

    public Iterator<? extends IPSApplicationLogic> getPSApplicationLogics();

    public boolean isEnableServiceAPIDTO();

    public Iterator<String> getAllAccessKeys();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getDEPSSysSFPluginId();

    public Iterator<? extends IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception;

    public String getAppTag();

    public String getAppTag2();

    public String getAppTag3();

    public String getAppTag4();

    public String getSysCodeName();

    public IPSSysImage getPSSysImage();

    public int getEngineVer();

    public IPSSysResource getPSSysResource();

    public Iterator<IPSAppMethodDTO> getAllPSAppMethodDTOs() throws Exception;

    public IPSAppMethodDTO getPSAppMethodDTO(IPSSysMethodDTO var1) throws Exception;

    public Iterator<IPSAppLogic> getAllPSAppLogics() throws Exception;

    public IPSAppLogic getPSAppLogic(String var1) throws Exception;

    public void resetPSAppLogic(String var1);

    public boolean isEnableUIModelEx();

    public int getDynaSysMode();

    public IPSSysUniRes getPSSysUniRes(String var1) throws Exception;

    public IPSSysUniRes getPSSysUniRes(String var1, boolean var2) throws Exception;

    public String getDefaultOSSCat();

    public String getViewCodeNameMode();

    public String getViewCodeName(String var1, String var2, String var3);

    public Iterator<IPSAppBIScheme> getAllPSAppBISchemes() throws Exception;

    public IPSAppBIScheme getPSAppBIScheme(IPSSysBIScheme var1) throws Exception;

    public String getSubAppAccessKey();

    public Iterator<IPSAppDEFInputTipSet> getAllPSAppDEFInputTipSets() throws Exception;

    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet(String var1) throws Exception;

    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet(String var1, boolean var2) throws Exception;

    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet(IPSDEFInputTipSet var1, boolean var2) throws Exception;
}

