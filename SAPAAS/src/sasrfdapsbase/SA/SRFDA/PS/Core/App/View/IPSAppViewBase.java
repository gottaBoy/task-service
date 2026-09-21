/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IViewWizardGroup
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavContext;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewType;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.view.IViewWizardGroup;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true, model="PSAppView")
@PSModelRTIgnoreMeta
public interface IPSAppViewBase
extends IPSApplicationObject {
    public Iterator<IPSSysPFPlugin> getPSSysPFPlugins();

    public IPSSysPFPlugin getPSSysPFPlugin();

    @Override
    public String getCodeName();

    public String getFullCodeName();

    public IPSControl getPSControl(String var1) throws Exception;

    public boolean hasPSControl(String var1);

    public Iterator<IPSControl> getPSControls();

    public Iterator<IPSAjaxControl> getPSAjaxControls();

    public IPSAppModule getPSAppModule() throws Exception;

    public IPSViewType getPSViewType();

    public boolean isEnableDP();

    public int getWidth();

    public int getHeight();

    public IPSAppView getRefPSAppView(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppView> getRefPSAppViews(String var1) throws Exception;

    public IPSAppViewRef getPSAppViewRef(String var1, boolean var2) throws Exception;

    public Iterator<IPSUIAction> getPSUIActions();

    public JSONObject getPSUIActionParamJO(IPSUIAction var1) throws Exception;

    public IPSSysCss getPSSysCss();

    public Iterator<IPSSysCss> getPSSysCsses();

    public Iterator<IPSSysImage> getPSSysImages();

    public Iterator<IPSLanguageRes> getPSLanguageReses();

    public Iterator<IPSAppViewLogic> getPSAppViewLogics();

    public String getLanguage();

    public String getBackendUrl();

    public Iterator<String> getAppViewRefModes();

    public Iterator<IPSAppViewRef> getPSAppViewRefs();

    public String getViewIcon();

    public String getTitle();

    public String getCaption();

    public String getSubCaption();

    public String getOpenMode();

    public boolean isEnableViewModel();

    public String getViewModelUrl();

    public boolean isEnableWF();

    public boolean isUserRefMode();

    public ArrayList<IPSControl> getAllPSControls();

    public ArrayList<IPSAjaxControl> getAllPSAjaxControls();

    public boolean isEnableHelp();

    public Iterator<IPSCodeList> getRelatedPSCodeLists(boolean var1) throws Exception;

    public Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception;

    public Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception;

    public ArrayList<IPSControl> getPSControls(String var1, int var2);

    public String getPageUrl();

    public Iterator<IPSSysCounterRef> getPSSysCounterRefs();

    public Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception;

    public String getAppViewParam(String var1) throws Exception;

    public IPSAppViewParam getPSAppViewParam(String var1) throws Exception;

    public IPSSubViewType getPSSubViewType();

    public int getAccUserMode();

    public String getAccessKey();

    public boolean isRedirectView();

    public boolean isPSDEView();

    public String getLastModifyTimeStr();

    public boolean isMobileView();

    public boolean isPickupView();

    public boolean getRefFlag();

    public IPSPFStyle getPSPFStyle();

    public IViewWizardGroup getViewWizardGroup();

    public IPSViewMsgGroup getPSViewMsgGroup();

    public IPSAppViewMsgGroup getPSAppViewMsgGroup();

    public String getMainMenuAlign();

    public IPSLanguageRes getTitlePSLanguageRes();

    public String getTitleLanResTag();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public IPSLanguageRes getSubCapPSLanguageRes();

    public String getSubCapLanResTag();

    public String getPSHelpModuleId();

    public boolean isShowCaptionBar();

    public boolean getSysRefFlag();

    public IPSSysImage getPSSysImage();

    public boolean isCustomViewStyle();

    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception;

    public Iterator<IPSAppFunc> getPSAppFuncs();

    public int getButtonNoPrivDisplayMode();

    public boolean isDynamicView();

    public IPSTitleBar getPSTitleBar();

    public boolean isEmbeddedView();

    public IPSAjaxHandler getPSAjaxHandler();

    public int getViewUsage();

    public IPSSysViewLayoutPanel getPSSysViewLayoutPanel();

    public boolean isPickupMode();

    public String getUIStyle();

    public IPSAppViewLogic getPSAppViewLogic(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppViewRef> getPSAppViewRefs(String var1) throws Exception;

    public String getViewType();

    public IPSAppDataEntity getPSAppDataEntity();

    public int getPSAppDERSPathCount() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int var1) throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception;

    public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception;

    public IPSSystem getPSSystem();

    public Iterator<IPSAppViewNavParam> getPSAppViewNavParams() throws Exception;

    public Iterator<IPSAppViewNavContext> getPSAppViewNavContexts() throws Exception;

    public int getPriority();
}

