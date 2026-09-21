/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IViewWizardGroup
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogicRefView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEViewBase;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavContext;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizardGroup;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUILogicRefViewImpl
extends PSObjectImpl
implements IPSAppUILogicRefView {
    private static final Log log = LogFactory.getLog(PSAppUILogicRefViewImpl.class);
    private IPSAppViewRef iPSAppViewRef = null;
    private IPSAppUILogic iPSAppViewLogic = null;
    private String strRefCat = null;
    private String strRefMode = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSAppView refPSAppView = null;
    private IPSDER1N iPSDER1N = null;

    public PSAppUILogicRefViewImpl() {
    }

    public PSAppUILogicRefViewImpl(IPSAppUILogic iPSAppViewLogic, IPSAppViewRef iPSAppViewRef, String strRefCat, String strRefMode) throws Exception {
        this.init(iPSAppViewLogic, iPSAppViewRef, strRefCat, strRefMode);
    }

    public void init(IPSAppUILogic iPSAppViewLogic, IPSAppViewRef iPSAppViewRef, String strRefCat, String strRefMode) throws Exception {
        try {
            this.iPSAppViewRef = iPSAppViewRef;
            this.strRefCat = strRefCat;
            this.strRefMode = strRefMode;
            if (this.iPSAppViewRef == null || this.iPSAppViewRef.getRefPSAppView() == null) {
                throw new Exception("\u5f15\u7528\u89c6\u56fe\u65e0\u6548");
            }
            this.refPSAppView = this.iPSAppViewRef.getRefPSAppView();
            this.iPSAppViewLogic = iPSAppViewLogic;
            if (this.getRefPSAppView() instanceof IPSAppDEView) {
                this.iPSDataEntity = ((IPSAppDEView)this.getRefPSAppView()).getPSDataEntity();
                this.iPSDER1N = ((IPSAppDEView)this.getRefPSAppView()).getPSDER1N();
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
    public String getRefCat() {
        return this.strRefCat;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f", hideempty2=true)
    public String getRefMode() {
        return this.strRefMode;
    }

    @Override
    public String getRefModeDesc() {
        return this.iPSAppViewRef.getRefModeDesc();
    }

    @Override
    public Iterator<IPSSysPFPlugin> getPSSysPFPlugins() {
        return this.getRefPSAppView().getPSSysPFPlugins();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.getRefPSAppView().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getRefPSAppView().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6574\u4ee3\u7801\u6807\u8bc6")
    public String getFullCodeName() {
        return this.getRefPSAppView().getFullCodeName();
    }

    @Override
    public IPSControl getPSControl(String strControlName) throws Exception {
        return this.getRefPSAppView().getPSControl(strControlName);
    }

    @Override
    public boolean hasPSControl(String strControlName) {
        return this.getRefPSAppView().hasPSControl(strControlName);
    }

    @Override
    @PSModelRTMeta(description="\u6839\u90e8\u4ef6\u96c6\u5408", child=true)
    public Iterator<IPSControl> getPSControls() {
        return this.getRefPSAppView().getPSControls();
    }

    @Override
    public Iterator<IPSAjaxControl> getPSAjaxControls() {
        return this.getRefPSAppView().getPSAjaxControls();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5757")
    public IPSAppModule getPSAppModule() throws Exception {
        return this.getRefPSAppView().getPSAppModule();
    }

    @Override
    public IPSViewType getPSViewType() {
        return this.getRefPSAppView().getPSViewType();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return this.getRefPSAppView().isEnableDP();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bbd\u5ea6", ignoredumpvalues="0;-1", outputdoc="(%1$s.getWidth() gt 0)")
    public int getWidth() {
        return this.getRefPSAppView().getWidth(this.iPSAppViewRef);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u9ad8\u5ea6", ignoredumpvalues="0;-1", outputdoc="(%1$s.getHeight() gt 0)")
    public int getHeight() {
        return this.getRefPSAppView().getHeight(this.iPSAppViewRef);
    }

    @Override
    public IPSAppView getRefPSAppView(String strRefMode, boolean bTry) throws Exception {
        return this.getRefPSAppView().getRefPSAppView(strRefMode, bTry);
    }

    @Override
    public Iterator<IPSAppView> getRefPSAppViews(String strRefModePrefix) throws Exception {
        return this.getRefPSAppView().getRefPSAppViews(strRefModePrefix);
    }

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        return this.getRefPSAppView().getPSAppViewRef(strRefMode, bTry);
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSUIAction> getPSUIActions() {
        return this.getRefPSAppView().getPSUIActions();
    }

    @Override
    public JSONObject getPSUIActionParamJO(IPSUIAction iPSUIAction) throws Exception {
        return this.getRefPSAppView().getPSUIActionParamJO(iPSUIAction);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u6837\u5f0f\u5bf9\u8c61")
    public IPSSysCss getPSSysCss() {
        return this.getRefPSAppView().getPSSysCss();
    }

    @Override
    public Iterator<IPSSysCss> getPSSysCsses() {
        return this.getRefPSAppView().getPSSysCsses();
    }

    @Override
    public Iterator<IPSSysImage> getPSSysImages() {
        return this.getRefPSAppView().getPSSysImages();
    }

    @Override
    public Iterator<IPSLanguageRes> getPSLanguageReses() {
        return this.getRefPSAppView().getPSLanguageReses();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u96c6\u5408", child=true, hideempty2=true)
    public Iterator<IPSAppViewLogic> getPSAppViewLogics() {
        return this.getRefPSAppView().getPSAppViewLogics();
    }

    @Override
    public String getLanguage() {
        return this.getRefPSAppView().getLanguage();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u8def\u5f84", dump=false)
    public String getBackendUrl() {
        return this.getRefPSAppView().getBackendUrl();
    }

    @Override
    public Iterator<String> getAppViewRefModes() {
        return this.getRefPSAppView().getAppViewRefModes();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528", child=true)
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        return this.getRefPSAppView().getPSAppViewRefs();
    }

    @Override
    public String getViewIcon() {
        return this.getRefPSAppView().getViewIcon();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u62ac\u5934")
    public String getTitle() {
        return this.getRefPSAppView().getTitle(this.iPSAppViewRef);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898")
    public String getCaption() {
        return this.getRefPSAppView().getCaption(this.iPSAppViewRef);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898")
    public String getSubCaption() {
        return this.getRefPSAppView().getSubCaption();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6253\u5f00\u6a21\u5f0f")
    public String getOpenMode() {
        return this.getRefPSAppView().getOpenMode(this.iPSAppViewRef);
    }

    @Override
    public boolean isEnableViewModel() {
        return this.getRefPSAppView().isEnableViewModel();
    }

    @Override
    public String getViewModelUrl() {
        return this.getRefPSAppView().getViewModelUrl();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5de5\u4f5c\u6d41")
    public boolean isEnableWF() {
        return this.getRefPSAppView().isEnableWF();
    }

    @Override
    public boolean isUserRefMode() {
        return this.getRefPSAppView().isUserRefMode();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u90e8\u4ef6\u96c6\u5408")
    public ArrayList<IPSControl> getAllPSControls() {
        return this.getRefPSAppView().getAllPSControls();
    }

    @Override
    public ArrayList<IPSAjaxControl> getAllPSAjaxControls() {
        return this.getRefPSAppView().getAllPSAjaxControls();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u89c6\u56fe\u5e2e\u52a9", dump=false)
    public boolean isEnableHelp() {
        return this.getRefPSAppView().isEnableHelp();
    }

    @Override
    public Iterator<IPSCodeList> getRelatedPSCodeLists(boolean bIncludeEmbed) throws Exception {
        return this.getRefPSAppView().getRelatedPSCodeList(bIncludeEmbed);
    }

    @Override
    public Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception {
        return this.getRefPSAppView().getAllRelatedPSCodeLists();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u4ee3\u7801\u8868\u96c6\u5408")
    public Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception {
        return this.getRefPSAppView().getRelatedPSCodeLists();
    }

    @Override
    public ArrayList<IPSControl> getPSControls(String strControlName, int nCount) {
        return this.getRefPSAppView().getPSControls(strControlName, nCount);
    }

    @Override
    public String getPageUrl() {
        return this.getRefPSAppView().getPageUrl();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528\u96c6\u5408")
    public Iterator<IPSSysCounterRef> getPSSysCounterRefs() {
        return this.getRefPSAppView().getPSSysCounterRefs();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception {
        return this.getRefPSAppView().getPSAppViewParams();
    }

    @Override
    public IPSSubViewType getPSSubViewType() {
        return this.getRefPSAppView().getPSSubViewType();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers")
    public int getAccUserMode() {
        return this.getRefPSAppView().getAccUserMode();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        return this.getRefPSAppView().getAccessKey();
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe", ignoredumpvalues="false")
    public boolean isRedirectView() {
        return this.getRefPSAppView().isRedirectView();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", dump=false)
    public boolean isPSDEView() {
        return this.getRefPSAppView().isPSDEView();
    }

    @Override
    public String getLastModifyTimeStr() {
        return this.getRefPSAppView().getLastModifyTimeStr();
    }

    @Override
    public boolean isMobileView() {
        return this.getRefPSAppView().isMobileView();
    }

    @Override
    public boolean isPickupView() {
        return this.getRefPSAppView().isPickupView();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u88ab\u5f15\u7528", ignoredumpvalues="true", dynamodelmode=8)
    public boolean getRefFlag() {
        return this.getRefPSAppView().getRefFlag();
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.getRefPSAppView().getPSPFStyle();
    }

    @Override
    public IViewWizardGroup getViewWizardGroup() {
        return this.getRefPSAppView().getViewWizardGroup();
    }

    @Override
    public IPSViewMsgGroup getPSViewMsgGroup() {
        return this.getRefPSAppView().getPSViewMsgGroup();
    }

    @Override
    public IPSAppViewMsgGroup getPSAppViewMsgGroup() {
        return this.getRefPSAppView().getPSAppViewMsgGroup();
    }

    @Override
    public String getMainMenuAlign() {
        return this.getRefPSAppView().getMainMenuAlign();
    }

    @Override
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.getRefPSAppView().getTitlePSLanguageRes(this.iPSAppViewRef);
    }

    @Override
    public String getTitleLanResTag() {
        return this.getRefPSAppView().getTitleLanResTag(this.iPSAppViewRef);
    }

    @Override
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.getRefPSAppView().getCapPSLanguageRes();
    }

    @Override
    public String getCapLanResTag() {
        return this.getRefPSAppView().getCapLanResTag();
    }

    @Override
    public IPSLanguageRes getSubCapPSLanguageRes() {
        return this.getRefPSAppView().getSubCapPSLanguageRes();
    }

    @Override
    public String getSubCapLanResTag() {
        return this.getRefPSAppView().getSubCapLanResTag();
    }

    @Override
    public String getPSHelpModuleId() {
        return this.getRefPSAppView().getPSHelpModuleId();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f", ignoredumpvalues="true")
    public boolean isShowCaptionBar() {
        return this.getRefPSAppView().isShowCaptionBar();
    }

    @Override
    public boolean getSysRefFlag() {
        return this.getRefPSAppView().getSysRefFlag();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.getRefPSAppView().getPSSysImage();
    }

    @Override
    public boolean isCustomViewStyle() {
        return this.getRefPSAppView().isCustomViewStyle();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5173\u8054\u89c6\u56fe", hideempty2=true)
    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception {
        return this.getRefPSAppView().getAllRelatedPSAppViews();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u5e94\u7528\u529f\u80fd\u96c6\u5408")
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        return this.getRefPSAppView().getPSAppFuncs();
    }

    @Override
    public int getButtonNoPrivDisplayMode() {
        return this.getRefPSAppView().getButtonNoPrivDisplayMode();
    }

    @Override
    public boolean isDynamicView() {
        return this.getRefPSAppView().isDynamicView();
    }

    @Override
    public IPSTitleBar getPSTitleBar() {
        return this.getRefPSAppView().getPSTitleBar();
    }

    @Override
    public boolean isEmbeddedView() {
        return this.getRefPSAppView().isEmbeddedView();
    }

    @Override
    public IPSAjaxHandler getPSAjaxHandler() {
        return this.getRefPSAppView().getPSAjaxHandler();
    }

    @Override
    public int getViewUsage() {
        return this.getRefPSAppView().getViewUsage();
    }

    @Override
    public IPSSysViewLayoutPanel getPSSysViewLayoutPanel() {
        return this.getRefPSAppView().getPSSysViewLayoutPanel();
    }

    @Override
    public boolean isPickupMode() {
        return this.getRefPSAppView().isPickupMode();
    }

    @Override
    public String getUIStyle() {
        return this.getRefPSAppView().getUIStyle();
    }

    @Override
    public IPSAppViewLogic getPSAppViewLogic(String strLogicTag, boolean bTry) throws Exception {
        return this.getRefPSAppView().getPSAppViewLogic(strLogicTag, bTry);
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefModePrefix) throws Exception {
        return this.getRefPSAppView().getPSAppViewRefs(strRefModePrefix);
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.getRefPSAppView().getPSApplication();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getRefPSAppView().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u7c7b\u578b", codelist="DEViewType")
    public String getViewType() {
        return this.getRefPSAppView().getViewType();
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u5f15\u7528\u89c6\u56fe", hideempty2=true, dumpref=true)
    public IPSAppView getRefPSAppView() {
        return this.refPSAppView;
    }

    @Override
    public IPSAppViewRef getPSAppViewRef() {
        return this.iPSAppViewRef;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getRefPSAppView().getPSSysModelInstId();
    }

    @Override
    public String getId() {
        return this.getRefPSAppView().getId();
    }

    @Override
    public String getName() {
        return this.getRefPSAppView().getName();
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWLOGICREFVIEW";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s#%3$s", (Object)this.iPSAppViewLogic.getModelId(), (Object)this.getRefCat(), (Object)this.getName());
    }

    @Override
    public String getPSDEViewId() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSDEViewId();
        }
        return "";
    }

    @Override
    public String getPSDEViewName() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSDEViewName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", ignoredumpvalues="0")
    public int getTempMode() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getTempMode();
        }
        return 0;
    }

    @Override
    public IPSDEActionWizardGroup getPSDEActionWizardGroup() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSDEActionWizardGroup();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u89c6\u56fe\u4ee3\u7801\u540d\u79f0", hideempty2=true)
    public String getPSDEViewCodeName() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSDEViewCodeName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u63a7\u5236\u5173\u7cfb", hideempty=true)
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5e94\u7528\u5b9e\u4f53", ignorert=3)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.getRefPSAppView().getPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84\u6570\u91cf", dump=false)
    public int getPSAppDERSPathCount() throws Exception {
        return this.getRefPSAppView().getPSAppDERSPathCount();
    }

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int nPathIndex) throws Exception {
        return this.getRefPSAppView().getPSAppDERSPath(nPathIndex);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[0]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception {
        return this.getRefPSAppView().getPSAppDERSPath0();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[1]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception {
        return this.getRefPSAppView().getPSAppDERSPath1();
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[2]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception {
        return this.getRefPSAppView().getPSAppDERSPath2();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[3]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception {
        return this.getRefPSAppView().getPSAppDERSPath3();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84[4]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception {
        return this.getRefPSAppView().getPSAppDERSPath4();
    }

    @Override
    public String getAppViewParam(String strKey) throws Exception {
        return this.getRefPSAppView().getAppViewParam(strKey);
    }

    @Override
    public IPSAppViewParam getPSAppViewParam(String strKey) throws Exception {
        return this.getRefPSAppView().getPSAppViewParam(strKey);
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u89c6\u56fe\u6a21\u5f0f", codelist="PredefinedViewType", hideempty2=true)
    public String getFuncViewMode() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getFuncViewMode();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u89c6\u56fe\u53c2\u6570", hideempty2=true)
    public String getFuncViewParam() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getFuncViewParam();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSAppViewNavParam> getPSAppViewNavParams() throws Exception {
        return this.getRefPSAppView().getPSAppViewNavParams();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true)
    public Iterator<IPSAppViewNavContext> getPSAppViewNavContexts() throws Exception {
        return this.getRefPSAppView().getPSAppViewNavContexts();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668", hideempty=true)
    public IPSSysCounter getPSSysCounter() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSSysCounter();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSSysCounterRef();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getPSAppCounterRef();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u4f18\u5148\u7ea7", ignoredumpvalues="-1")
    public int getPriority() {
        return this.getRefPSAppView().getPriority();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        return this.iPSAppViewRef.getPSNavigateParams();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        return this.iPSAppViewRef.getPSNavigateContexts();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5e94\u7528\u5b9e\u4f53", dumpref=true, ignorert=3)
    public IPSAppDataEntity getParentPSAppDataEntity() throws Exception {
        if (this.getRefPSAppView() instanceof IPSAppDEViewBase) {
            return ((IPSAppDEViewBase)((Object)this.getRefPSAppView())).getParentPSAppDataEntity();
        }
        return null;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getRefPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        return this.getRefPSAppView().isEnableDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", dump=false, codelist="DynaInstMode3")
    public int getDynaInstMode() {
        return this.getRefPSAppView().getDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", dump=false)
    public String getDynaInstTag() {
        return this.getRefPSAppView().getDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02", dump=false)
    public String getDynaInstTag2() {
        return this.getRefPSAppView().getDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u76ee\u5f55", hideempty=true, dump=false)
    public String getDynaModelFolder() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected boolean isExportModelCodeName() {
        return false;
    }
}

