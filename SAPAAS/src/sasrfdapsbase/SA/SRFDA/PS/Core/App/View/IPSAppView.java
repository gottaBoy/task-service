/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.view.IView
 *  net.ibizsys.paas.view.IViewWizardGroup
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppViewBase;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavContext;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.CaptionBar.IPSCaptionBar;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSUpdatePanel;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.view.IView;
import net.ibizsys.paas.view.IViewWizardGroup;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="viewType", extend="IPSAppDEView", model="PSAppView")
public interface IPSAppView
extends IPSAppViewBase,
IPSControlContainer,
IView {
    public static final String CONTROL_CAPTIONBAR = "captionbar";
    public static final String APPVIEWTYPE_APPDEVIEW = "APPDEVIEW";
    public static final String APPVIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String APPVIEWTYPE_APPDYNADEVIEW = "APPDYNADEVIEW";
    public static final String APPVIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String APPVIEWTYPE_APPUTILVIEW = "APPUTILVIEW";
    public static final String APPVIEWTYPE_APPPANELVIEW = "APPPANELVIEW";
    public static final String VIEWPARAM_UI_CTRL = "UI.CTRL";
    public static final String VIEWPARAM_UI_SHOWCAPTIONBAR = "UI.SHOWCAPTIONBAR";
    public static final int VIEWUSAGE_DEFAULT = 1;
    public static final int VIEWUSAGE_MODAL = 2;
    public static final int VIEWUSAGE_EMBEDED = 4;
    public static final int PRIORITY_PLUGINCONTAINERVIEW = 100;

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppView var3) throws Exception;

    public boolean isInited();

    public void setPSViewType(IPSViewType var1);

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    @Override
    public void registerPSUIAction(IPSUIAction var1) throws Exception;

    @Override
    public void registerPSUIAction(IPSUIAction var1, JSONObject var2) throws Exception;

    public void registerPSSysPFPlugin(IPSSysPFPlugin var1) throws Exception;

    @Override
    public Iterator<IPSSysPFPlugin> getPSSysPFPlugins();

    public String generateCtrlUniId();

    public String generateViewUniId();

    @Override
    public void registerPSSysCss(IPSSysCss var1) throws Exception;

    @Override
    public void registerPSSysImage(IPSSysImage var1) throws Exception;

    public void registerPSLanguageRes(IPSLanguageRes var1) throws Exception;

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin();

    @Override
    public String getCodeName();

    @Override
    public String getFullCodeName();

    @Override
    public IPSControl getPSControl(String var1) throws Exception;

    @Override
    public boolean hasPSControl(String var1);

    @Override
    public Iterator<IPSControl> getPSControls();

    @Override
    public Iterator<IPSAjaxControl> getPSAjaxControls();

    @Override
    public IPSAppModule getPSAppModule() throws Exception;

    @Override
    public IPSViewType getPSViewType();

    @Override
    public boolean isEnableDP();

    @Override
    public int getWidth();

    @Override
    public int getHeight();

    @Override
    public IPSAppView getRefPSAppView(String var1, boolean var2) throws Exception;

    @Override
    public Iterator<IPSAppView> getRefPSAppViews(String var1) throws Exception;

    @Override
    public IPSAppViewRef getPSAppViewRef(String var1, boolean var2) throws Exception;

    @Override
    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef var1) throws Exception;

    @Override
    public Iterator<IPSUIAction> getPSUIActions();

    @Override
    public JSONObject getPSUIActionParamJO(IPSUIAction var1) throws Exception;

    @Override
    public IPSSysCss getPSSysCss();

    @Override
    public Iterator<IPSSysCss> getPSSysCsses();

    @Override
    public Iterator<IPSSysImage> getPSSysImages();

    @Override
    public Iterator<IPSLanguageRes> getPSLanguageReses();

    @Override
    public Iterator<IPSAppViewLogic> getPSAppViewLogics();

    @Override
    public String getLanguage();

    @Override
    public String getBackendUrl();

    @Override
    public Iterator<String> getAppViewRefModes();

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs();

    @Override
    public String getViewType();

    @Override
    public String getViewIcon();

    public String getTitle(IPSAppViewRef var1);

    public String getCaption(IPSAppViewRef var1);

    public String getOpenMode(IPSAppViewRef var1);

    public int getWidth(IPSAppViewRef var1);

    public int getHeight(IPSAppViewRef var1);

    @Override
    public String getTitle();

    @Override
    public String getCaption();

    @Override
    public String getSubCaption();

    @Override
    public String getOpenMode();

    @Override
    public boolean isEnableViewModel();

    @Override
    public String getViewModelUrl();

    @Override
    public boolean isEnableWF();

    @Override
    public boolean isUserRefMode();

    @Override
    public ArrayList<IPSControl> getAllPSControls();

    @Override
    public ArrayList<IPSAjaxControl> getAllPSAjaxControls();

    @Override
    public boolean isEnableHelp();

    public Iterator<IPSAppViewRef> getEmbeddedPSAppViewRefs(String var1) throws Exception;

    public Iterator<IPSCodeList> getRelatedPSCodeList(boolean var1) throws Exception;

    @Override
    public Iterator<IPSCodeList> getRelatedPSCodeLists(boolean var1) throws Exception;

    @Override
    public Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception;

    @Override
    public Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception;

    @Override
    public ArrayList<IPSControl> getPSControls(String var1, int var2);

    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> var1) throws Exception;

    @Deprecated
    public String getSubAppFolderName();

    @Override
    public String getPageUrl();

    public IPSSysCounterRef registerPSSysCounter(IPSSysCounter var1, JSONObject var2) throws Exception;

    @Override
    public Iterator<IPSSysCounterRef> getPSSysCounterRefs();

    public IPSAppViewParam registerPSAppViewParam(String var1, String var2, String var3) throws Exception;

    @Override
    public Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception;

    @Override
    public IPSSubViewType getPSSubViewType();

    @Override
    public int getAccUserMode();

    @Override
    public String getAccessKey();

    public void checkViewEnv() throws Exception;

    @Override
    public boolean isRedirectView();

    @Override
    public boolean isPSDEView();

    @Override
    public String getLastModifyTimeStr();

    @Override
    public boolean isMobileView();

    @Override
    public boolean isPickupView();

    @Override
    public boolean getRefFlag();

    public Iterator<IPSUpdatePanel> getPSUpdatePanels();

    @Override
    public IPSPFStyle getPSPFStyle();

    @Override
    public IViewWizardGroup getViewWizardGroup();

    @Override
    public IPSViewMsgGroup getPSViewMsgGroup();

    @Override
    public IPSAppViewMsgGroup getPSAppViewMsgGroup();

    @Override
    public String getMainMenuAlign();

    @Override
    public IPSLanguageRes getTitlePSLanguageRes();

    public IPSLanguageRes getTitlePSLanguageRes(IPSAppViewRef var1);

    @Override
    public String getTitleLanResTag();

    public String getTitleLanResTag(IPSAppViewRef var1);

    @Override
    public IPSLanguageRes getCapPSLanguageRes();

    @Override
    public String getCapLanResTag();

    @Override
    public IPSLanguageRes getSubCapPSLanguageRes();

    @Override
    public String getSubCapLanResTag();

    @Override
    public String getPSHelpModuleId();

    @Override
    public boolean isShowCaptionBar();

    @Override
    public boolean getSysRefFlag();

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public boolean isCustomViewStyle();

    @Override
    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception;

    public void registerPSAppFunc(IPSAppFunc var1) throws Exception;

    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs();

    @Override
    public void registerPSAppViewLogic(String var1, IPSAppViewLogic var2) throws Exception;

    @Override
    public void registerPSAppViewLogic(IPSAppViewLogic var1) throws Exception;

    @Override
    public int getButtonNoPrivDisplayMode();

    @Override
    public boolean isDynamicView();

    @Override
    public IPSTitleBar getPSTitleBar();

    @Override
    public boolean isEmbeddedView();

    @Override
    public IPSAjaxHandler getPSAjaxHandler();

    public void markViewUsage(int var1, Object var2);

    public boolean testViewUsage(int var1);

    @Override
    public int getViewUsage();

    @Override
    public IPSSysViewLayoutPanel getPSSysViewLayoutPanel();

    public IPSViewLayoutPanel getPSViewLayoutPanel();

    @Override
    public boolean isPickupMode();

    public String getViewUrl(String var1) throws Exception;

    @Override
    public String getUIStyle();

    @Override
    public IPSAppViewLogic getPSAppViewLogic(String var1, boolean var2) throws Exception;

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String var1) throws Exception;

    @Override
    public void registerPSAppViewEngine(String var1, IPSAppViewEngine var2) throws Exception;

    @Override
    public void registerPSAppViewEngine(IPSAppViewEngine var1) throws Exception;

    @Override
    public IPSAppViewEngine getPSAppViewEngine(String var1, boolean var2) throws Exception;

    @Override
    public Iterator<IPSAppViewEngine> getPSAppViewEngines();

    public String getViewStyle();

    @Override
    public Iterator<IPSAppViewUIAction> getPSAppViewUIActions();

    @Override
    public void registerPSAppViewUIAction(IPSAppViewUIAction var1) throws Exception;

    public Iterator<IPSAppView> getAllRelatedPSAppViewsEx() throws Exception;

    public Iterator<IPSAppView> getAllEmbeddedPSAppViews() throws Exception;

    @Override
    public String getAppViewParam(String var1) throws Exception;

    @Override
    public IPSAppViewParam getPSAppViewParam(String var1) throws Exception;

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    @Override
    public int getPSAppDERSPathCount() throws Exception;

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int var1) throws Exception;

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception;

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception;

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception;

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception;

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception;

    @Override
    public Iterator<IPSAppViewNavParam> getPSAppViewNavParams() throws Exception;

    @Override
    public Iterator<IPSAppViewNavContext> getPSAppViewNavContexts() throws Exception;

    @Override
    public int getPriority();

    public IPSCaptionBar getPSCaptionBar();

    public boolean isEnableUIModelEx();

    public int getDynaSysMode();
}

