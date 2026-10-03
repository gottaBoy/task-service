/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.control.IControl
 *  net.ibizsys.paas.core.IApplication
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IViewWizardGroup
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IAjaxActionContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.Control.PSAppCounterRefImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSAppModuleImpl;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppRedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavContext;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPlugin;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPreview;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIActionRuntime;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewNavContextImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewNavParamImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewParamImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.App.View.PSViewAjaxHandlerImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.CaptionBar.IPSCaptionBar;
import SA.SRFDA.PS.Core.Control.CaptionBar.PSCaptionBarParamImpl;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.PSSysCounterRefImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.Control.TitleBar.PSTitleBarParamImpl;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSUpdatePanel;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.PSPFViewPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.ObjectHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizardGroup;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewImpl
extends PSApplicationObjectImpl
implements IPSAppView,
IPSAppViewRuntime,
IPSAppViewPreview {
    private static final Log log = LogFactory.getLog(PSAppViewImpl.class);
    public static final String MODELGROUP_UI = "\u754c\u9762&\u90e8\u4ef6";
    public static final String MODELGROUP_UILOGIC = "\u89c6\u56fe\u903b\u8f91";
    public static final String[] MODELGROUPS = new String[]{"\u57fa\u672c", "\u754c\u9762&\u90e8\u4ef6", "\u89c6\u56fe\u903b\u8f91", "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    public static final int MODELORDER_UI = 150;
    public static final int MODELORDER_UILOGIC = 200;
    private static final ThreadLocal<Boolean> designMode = new ThreadLocal();
    private static final HashMap<String, IPSAppCounterRef> emptyPSAppCounterRefMap = new HashMap();
    private static final HashMap<String, IPSSysCounterRef> emptyPSSysCounterRefMap = new HashMap();
    private static final ArrayList<IPSUIAction> emptyPSUIActionList = new ArrayList();
    private static final ArrayList<IPSAppViewUIAction> emptyPSAppViewUIActionList = new ArrayList();
    private static final HashMap<String, IPSUpdatePanel> emptyPSUpdatePanelMap = new HashMap();
    private static final HashMap<String, IPSSysImage> emptyPSSysImageMap = new HashMap();
    private static final HashMap<String, IPSSysCss> emptyPSSysCssMap = new HashMap();
    private static final HashMap<String, IPSLanguageRes> emptyPSLanguageResMap = new HashMap();
    private static final HashMap<String, IPSAppFunc> emptyPSAppFuncMap = new HashMap();
    private static final ArrayList<IPSAppViewLogic> emptyPSAppViewLogicList = new ArrayList();
    private static final ArrayList<IPSAppViewEngine> emptyPSAppViewEngineList = new ArrayList();
    private static final HashMap<String, IPSSysPFPlugin> emptyPSPFPluginMap = new HashMap();
    private static final HashMap<String, IPSAppViewRef> emptyPSAppViewRefMap = new HashMap();
    private static final HashMap<String, IPSLayoutPanel> emptyPSLayoutPanelMap = new HashMap();
    protected PSAppView psApplicationView = null;
    private Map<String, IPSControl> psControlMap = new LinkedHashMap<String, IPSControl>();
    private Map<String, IPSAjaxControl> psControlMap2 = new LinkedHashMap<String, IPSAjaxControl>();
    private Map<String, IPSUpdatePanel> psUpdatePanelMap = null;
    protected IPSViewType iPSViewType = null;
    private Map<String, IPSAppViewRef> psAppViewRefMap = null;
    private Map<String, IPSSysCounterRef> psSysCounterRefMap = null;
    private Map<String, IPSAppCounterRef> psAppCounterRefMap = null;
    private ArrayList<IPSUIAction> psUIActionList = null;
    private Map<String, IPSUIAction> psUIActionMap = null;
    private Map<String, JSONObject> psUIActionParamMap = null;
    private Map<String, IPSSysImage> psSysImageMap = null;
    private Map<String, IPSSysCss> psSysCssMap = null;
    private Map<String, IPSLanguageRes> psLanguageResMap = null;
    private Map<String, IPSAppFunc> psAppFuncMap = null;
    private ArrayList<IPSAppViewLogic> psAppViewLogicList = null;
    private Map<String, IPSAppViewLogic> psAppViewLogicMap = null;
    protected Map<String, IPSAppViewParam> psAppViewParamMap = null;
    protected Map<String, IPSAppViewNavContext> psAppViewNavContextMap = null;
    protected Map<String, IPSAppViewNavParam> psAppViewNavParamMap = null;
    private Map<String, IPSSysPFPlugin> psPFPluginMap = null;
    private ArrayList<IPSAppViewEngine> psAppViewEngineList = null;
    private Map<String, IPSAppViewEngine> psAppViewEngineMap = null;
    private ArrayList<IPSAppViewUIAction> psAppViewUIActionList = null;
    private Map<String, IPSLayoutPanel> psLayoutPanelMap = null;
    private String strCodeName = "";
    private String strFullCodeName = "";
    private String strBackendUrl = "";
    private boolean bUserRefMode = false;
    private String strCaption = null;
    private String strTitle = null;
    private String strSubCaption = null;
    private Integer nChildControlIndex = 0;
    private Integer nChildViewIndex = 0;
    private String strSubAppFolderName = null;
    private String strPageUrl = null;
    private boolean bInited = false;
    private IPSSubViewType iPSSubViewType = null;
    private int nAccUserMode = AccessUserModes.UNKNOWN;
    private IPSSysUniRes iPSSysUniRes = null;
    private String strLastModifyTime = "";
    private IPSPFStyle iPSPFStyle = null;
    private String strMainMenuAlign = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSLanguageRes titlePSLanguageRes = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes subCapPSLanguageRes = null;
    private IPSViewMsgGroup iPSViewMsgGroup = null;
    private String strPSHelpModuleId = null;
    private Boolean bShowCaptionBar = null;
    private Boolean bSysRefFlag = null;
    private boolean bEnableViewModelDefault = false;
    private IPSSysImage iPSSysImage = null;
    private boolean bCustomViewStyle = false;
    private IPSAppViewPlugin iPSAppViewPlugin = null;
    private Boolean bDynamicView = null;
    private IPSTitleBar iPSTitleBar = null;
    private IPSSysCss iPSSysCss = null;
    private IPSAjaxHandler iPSAjaxHandler = null;
    private IPSSysViewLayoutPanel iPSViewLayoutPanel = null;
    public static final String TITLEBARNAME = "titlebar";
    private int nViewUsage = 0;
    private String strUIStyle = "";
    private String strAppUIStyle = "";
    private int nPreviewVersion = 0;
    private IPSAppModule iPSAppModule = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private boolean bShowCaptionBarDefault = true;
    private IPSPFPubHelp iPSPFPubHelp = null;
    private Integer nPriority;
    private IPSCaptionBar iPSCaptionBar = null;

    @Override
    public synchronized void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        if (this.bInited) {
            return;
        }
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psApplicationView = psApplicationView;
            this.setId(this.psApplicationView.getPSAPPVIEWID());
            this.setName(this.psApplicationView.getPSAPPVIEWNAME());
            this.setPSObjectData(this.psApplicationView);
            this.strCodeName = this.psApplicationView.getPSAPPVIEWNAME();
            this.strFullCodeName = String.valueOf(this.getPSAppModule().getCodeName()) + "." + this.strCodeName;
            this.strBackendUrl = iPSApplication.getPSPF().getPSAppViewBackendUrl(this);
            this.strPageUrl = iPSApplication.getPSPF().getPSAppViewPageUrl(this);
            this.bUserRefMode = !this.psApplicationView.isUSERREFFLAGNull() ? this.psApplicationView.getUSERREFFLAG() : this.isUserRefModeDefault();
            if (!this.psApplicationView.isSYSREFFLAGNull()) {
                this.bSysRefFlag = this.psApplicationView.getSYSREFFLAG();
            }
            this.strCaption = psApplicationView.getCAPTION();
            this.strTitle = psApplicationView.getTITLE();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psApplicationView.getSUBCAPTION())) {
                this.strSubCaption = this.psApplicationView.getSUBCAPTION();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSSUBVIEWTYPEID())) {
                this.iPSSubViewType = this.getPSApplication().getPSSubViewType(this.psApplicationView.getPSSUBVIEWTYPEID(), this.getViewType());
                if (this.iPSSubViewType.getPSSysPFPlugin() != null) {
                    this.setPSSysPFPlugin(this.getPSApplication().getPSSysPFPlugin(this.iPSSubViewType.getPSSysPFPlugin().getId(), "APPVIEW", this.getViewType(), null));
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSAPPLOCALDEID())) {
                this.setPSAppDataEntity(this.getPSApplication().getPSAppDataEntity(this.psApplicationView.getPSAPPLOCALDEID(), false));
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getACCUSERMODE())) {
                this.nAccUserMode = Integer.parseInt(this.psApplicationView.getACCUSERMODE());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSApplication().getPSSystem().getPSSysUniRes(this.psApplicationView.getPSSYSUNIRESID());
            }
            if (!psApplicationView.isUPDATEDATENull()) {
                this.strLastModifyTime = DateHelper.toDateTimeString((Date)psApplicationView.getUPDATEDATE());
            }
            if (this.getPSPFStyle() == null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psApplicationView.getPSPFSTYLEID())) {
                    if (this.getPSApplication().getPSPFStyle() instanceof IPSPFStyle2) {
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)psApplicationView.getPSPFSTYLEID(), (String)this.getPSApplication().getPSPFStyle().getId(), (boolean)false) != 0) {
                            this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u5f53\u524d\u5e94\u7528\u4e0d\u652f\u6301\u591a\u524d\u7aef\u6837\u5f0f\uff0c\u5ffd\u7565\u6307\u5b9a\u6837\u5f0f"));
                        }
                        this.iPSPFStyle = this.getPSApplication().getPSPFStyle();
                    } else {
                        this.iPSPFStyle = this.getPSApplication().getPSPFStyle(psApplicationView.getPSPFSTYLEID());
                    }
                } else {
                    this.iPSPFStyle = this.getPSApplication().getPSPFStyle();
                }
            }
            this.strMainMenuAlign = this.getPSAppModule().getMainMenuAlign();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSVIEWMSGGROUPID())) {
                this.iPSViewMsgGroup = this.getPSApplication().getPSAppViewMsgGroup(this.psApplicationView.getPSVIEWMSGGROUPID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getTITLEPSLANRESID())) {
                this.titlePSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psApplicationView.getTITLEPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psApplicationView.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getSUBCAPPSLANRESID())) {
                this.subCapPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psApplicationView.getSUBCAPPSLANRESID());
            }
            this.strPSHelpModuleId = this.psApplicationView.getPSHELPMODULEID();
            if (!this.psApplicationView.isSHOWCAPTIONBARNull()) {
                this.bShowCaptionBar = this.psApplicationView.getSHOWCAPTIONBAR();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getSUBCAPPSLANRESID())) {
                this.subCapPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psApplicationView.getSUBCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psApplicationView.getPSSYSIMAGEID());
            } else if (this.getPSAppDataEntity() != null) {
                this.iPSSysImage = this.getPSAppDataEntity().getPSSysImage();
            }
            if (this.iPSSysImage != null) {
                this.registerPSSysImage(this.iPSSysImage);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psApplicationView.getPSSYSCSSID());
                this.registerPSSysCss(this.iPSSysCss);
            }
            if (!this.psApplicationView.isENABLEVIEWSTYLENull()) {
                this.bCustomViewStyle = this.psApplicationView.getENABLEVIEWSTYLE();
            }
            if (!this.psApplicationView.isDYNCMODENull() && this.psApplicationView.getDYNCMODE() >= 10) {
                this.nPriority = this.psApplicationView.getDYNCMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSACHANDLERID())) {
                this.iPSAjaxHandler = this.createPSAjaxHandler(this.psApplicationView.getPSACHANDLERID());
            }
            this.strUIStyle = this.psApplicationView.getUISTYLE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIStyle)) {
                this.strAppUIStyle = this.getPSApplication().getPSApplicationUI().getUIStyle();
            }
            this.iPSAppViewPlugin = this.createPSAppViewPlugin();
            this.bInited = true;
            this.onInit();
            if (this.getPSSysPFPlugin() != null) {
                this.registerPSSysPFPlugin(this.getPSSysPFPlugin());
            }
            if (this.isPrepareDefaultPSAppViewLogics()) {
                IPSAppViewEngine defaultPSAppViewEngine = this.getPSAppViewEngine("engine", true);
                if (defaultPSAppViewEngine == null && (defaultPSAppViewEngine = this.createDefaultPSAppViewEngine()) != null) {
                    this.registerPSAppViewEngine("engine", defaultPSAppViewEngine);
                }
                this.bShowCaptionBarDefault = this.isShowCaptionBarDefault();
            }
            if (this.isEnableUIModelEx()) {
                this.onPreparePSCaptionBar();
            }
        }
        catch (Exception ex) {
            this.bInited = false;
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex, true);
        }
    }

    @Override
    public synchronized boolean isInited() {
        return this.bInited;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.nViewUsage = this.isPickupView() ? 2 : (this.isEmbeddedView() ? 4 : 1);
        this.onPreparePSTitleBar();
        this.onPreparePSViewLayoutPanel();
        IPSAppViewPlugin iPSAppViewPlugin = this.getPSAppViewPlugin();
        if (iPSAppViewPlugin == null || !iPSAppViewPlugin.preparePSAppViewRefs(this)) {
            this.onPreparePSAppViewRefs();
        }
        if (iPSAppViewPlugin == null || !iPSAppViewPlugin.preparePSAppViewLogics(this)) {
            this.onPreparePSAppViewLogics();
        }
        this.onPreparePSAppViewEngines();
    }

    @Override
    protected int onCheck() throws Exception {
        int nRet = 0;
        Iterator<IPSControl> psControls = this.getPSControls();
        if (psControls != null) {
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                nRet += iPSControl.check();
            }
        }
        if (this.getPSViewLayoutPanel() != null) {
            nRet += this.getPSViewLayoutPanel().check();
        }
        return nRet += super.onCheck();
    }

    protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSystem().getPSAjaxControlHandlerData(strPSAjaxHandlerId, false);
        PSViewAjaxHandlerImpl iPSAjaxHandler = new PSViewAjaxHandlerImpl();
        iPSAjaxHandler.init(this.getDAGlobalHelper(), this, psACHandler);
        return iPSAjaxHandler;
    }

    protected void onPreparePSAppViewRefs() throws Exception {
        Vector<PSAppViewRef> psAppViewRefList = new Vector<PSAppViewRef>();
        CallResult callResult = this.getPSModelHelper().getPSAppViewRefs(this.getId(), psAppViewRefList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psAppViewRefList.size() > 0) {
            if (this.psAppViewRefMap == null) {
                this.psAppViewRefMap = new TreeMap<String, IPSAppViewRef>();
            }
            for (PSAppViewRef psAppViewRef : psAppViewRefList) {
                PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
                iPSAppViewRef.init(this.getDAGlobalHelper(), this, psAppViewRef);
                this.psAppViewRefMap.put(iPSAppViewRef.getName().toUpperCase(), iPSAppViewRef);
            }
        }
    }

    protected void onPreparePSAppViewLogics() throws Exception {
        Vector<PSAppViewLogic> psAppViewLogicList = new Vector<PSAppViewLogic>();
        CallResult callResult = this.getPSModelHelper().getPSAppViewLogics(this.getId(), psAppViewLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u5173\u8054\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void onPreparePSAppViewEngines() throws Exception {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final String generateCtrlUniId() {
        boolean bHex = true;
        String curId = "";
        if (SA.SRFramework.Utility.StringHelper.Length((String)curId) == 0) {
            curId = "M";
        } else {
            char ch = curId.charAt(curId.length() - 1);
            if (ch < 'g' || ch > 'z') {
                bHex = false;
            }
        }
        Integer n = this.nChildControlIndex;
        synchronized (n) {
            this.nChildControlIndex = this.nChildControlIndex + 1;
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s", (Object)curId, (Object)(bHex ? Integer.toHexString(this.nChildControlIndex) : PSAppViewImpl.getUniId(this.nChildControlIndex)));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final String generateViewUniId() {
        boolean bHex = true;
        String curId = "";
        if (SA.SRFramework.Utility.StringHelper.Length((String)curId) == 0) {
            curId = "C";
        } else {
            char ch = curId.charAt(curId.length() - 1);
            if (ch < 'g' || ch > 'z') {
                bHex = false;
            }
        }
        Integer n = this.nChildViewIndex;
        synchronized (n) {
            this.nChildViewIndex = this.nChildViewIndex + 1;
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s", (Object)curId, (Object)(bHex ? Integer.toHexString(this.nChildViewIndex) : PSAppViewImpl.getUniId(this.nChildViewIndex)));
        }
    }

    public static String getControlUniId(String strParentId, int nIndex) {
        boolean bHex = true;
        if (SA.SRFramework.Utility.StringHelper.Length((String)strParentId) == 0) {
            strParentId = "M";
        } else {
            char ch = strParentId.charAt(strParentId.length() - 1);
            if (ch < 'g' || ch > 'z') {
                bHex = false;
            }
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s", (Object)strParentId, (Object)(bHex ? Integer.toHexString(nIndex) : PSAppViewImpl.getUniId(nIndex)));
    }

    private static String getUniId(int nValue) {
        String strRet = "";
        do {
            int nTemp = nValue % 16;
            char nC = (char)(103 + nTemp);
            strRet = String.valueOf(nC) + strRet;
        } while ((nValue /= 16) != 0);
        return strRet;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u7c7b\u578b", codelist="AllViewType", group="\u57fa\u672c", order=125, fields={"PSAPPVIEWTYPE"})
    public String getViewType() {
        return this.onGetViewType();
    }

    protected String onGetViewType() {
        if (this.getPSViewType() != null) {
            return this.getPSViewType().getId();
        }
        return "UNKNOWN";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"PSAPPVIEWNAME"})
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6574\u4ee3\u7801\u540d\u79f0", dump=false, outputdoc="false")
    public String getFullCodeName() {
        return this.strFullCodeName;
    }

    @Override
    public IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception {
        IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(strPSCtrlType);
        IPSControl iPSControl = iPSControlType.createPSControl(iPSControlParam);
        this.registerPSControl(strKey, iPSControl);
        iPSControl.init(this.getDAGlobalHelper(), this, strKey, iPSControlParam);
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerPSControl(String strKey, IPSControl iPSControl) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strKey)) {
            strKey = strKey.toLowerCase();
        }
        Map<String, IPSControl> map = this.psControlMap;
        synchronized (map) {
            this.psControlMap.put(strKey, iPSControl);
            if (iPSControl instanceof IPSAjaxControl && ((IPSAjaxControl)iPSControl).isAjaxCtrl()) {
                this.psControlMap2.put(strKey, (IPSAjaxControl)iPSControl);
            }
            if (iPSControl instanceof IPSUpdatePanel) {
                if (this.psUpdatePanelMap == null) {
                    this.psUpdatePanelMap = new LinkedHashMap<String, IPSUpdatePanel>();
                }
                this.psUpdatePanelMap.put(strKey, (IPSUpdatePanel)iPSControl);
            }
        }
    }

    public IControl getControl(String strControlName) throws Exception {
        return this.getPSControl(strControlName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ArrayList<IPSControl> getPSControls(String strControlName, int nCount) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strControlName)) {
            strControlName = strControlName.toLowerCase();
        }
        ArrayList<IPSControl> list = new ArrayList<IPSControl>();
        int i = 0;
        while (i < nCount) {
            String strNewName = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s", (Object)strControlName, (Object)(i == 0 ? "" : Integer.valueOf(i)));
            Map<String, IPSControl> map = this.psControlMap;
            synchronized (map) {
                IPSControl iPSControl = this.psControlMap.get(strNewName);
                if (iPSControl != null) {
                    list.add(iPSControl);
                }
            }
            ++i;
        }
        return list;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSControl getPSControl(String strControlName) throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strControlName)) {
            strControlName = strControlName.toLowerCase();
        }
        IPSControl iPSControl = null;
        Map<String, IPSControl> map = this.psControlMap;
        synchronized (map) {
            iPSControl = this.psControlMap.get(strControlName);
        }
        if (iPSControl == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%2$s]", (Object)this.getFullCodeName(), (Object)strControlName));
        }
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasPSControl(String strControlName) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strControlName)) {
            strControlName = strControlName.toLowerCase();
        }
        Map<String, IPSControl> map = this.psControlMap;
        synchronized (map) {
            return this.psControlMap.containsKey(strControlName);
        }
    }

    @Override
    @PSModelRTMeta(description="\u6839\u90e8\u4ef6\u96c6\u5408", child=true, modelreftype="IGNOREDESIGN", outputdoc="false")
    public Iterator<IPSControl> getPSControls() {
        if (this.psControlMap.size() <= 1) {
            return this.psControlMap.values().iterator();
        }
        ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
        psControlList.addAll(this.psControlMap.values());
        Collections.sort(psControlList, new Comparator<IPSControl>(){

            @Override
            public int compare(IPSControl arg0, IPSControl arg1) {
                return Integer.valueOf(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
            }
        });
        return psControlList.iterator();
    }

    @Override
    public Iterator<IPSAjaxControl> getPSAjaxControls() {
        return this.psControlMap2.values().iterator();
    }

    @Override
    public void registerPSAppViewLogic(IPSAppViewLogic iPSAppViewLogic) throws Exception {
        this.registerPSAppViewLogic(null, iPSAppViewLogic);
    }

    @Override
    public void registerPSAppViewLogic(String strKey, IPSAppViewLogic iPSAppViewLogic) throws Exception {
        IPSAppViewLogic last;
        if (this.isEnableUIModelEx()) {
            if ("APPVIEWUIACTION".equals(iPSAppViewLogic.getLogicType())) {
                return;
            }
            if (!("VIEWEVENT".equals(iPSAppViewLogic.getLogicTrigger()) || "CTRLEVENT".equals(iPSAppViewLogic.getLogicTrigger()) || "TIMER".equals(iPSAppViewLogic.getLogicTrigger()) || "CUSTOM".equals(iPSAppViewLogic.getLogicTrigger()))) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSAppViewLogic.getPSViewCtrlName())) {
                    if (this.hasPSControl(iPSAppViewLogic.getPSViewCtrlName())) {
                        IPSControl iPSControl = this.getPSControl(iPSAppViewLogic.getPSViewCtrlName());
                        iPSControl.registerPSControlLogic(iPSAppViewLogic);
                    } else {
                        log.warn((Object)String.format("\u65e0\u6cd5\u83b7\u53d6\u89c6\u56fe\u90e8\u4ef6[%1$s]\uff0c\u5ffd\u7565\u6ce8\u518c\u5e94\u7528\u89c6\u56fe\u903b\u8f91[%2$s][%3$s]", iPSAppViewLogic.getPSViewCtrlName(), iPSAppViewLogic.getName(), iPSAppViewLogic.getLogicTrigger()));
                    }
                    return;
                }
                return;
            }
        }
        if (this.psAppViewLogicList == null) {
            this.psAppViewLogicList = new ArrayList();
        }
        if (this.psAppViewLogicMap == null) {
            this.psAppViewLogicMap = new LinkedHashMap<String, IPSAppViewLogic>();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strKey)) {
            strKey = iPSAppViewLogic.getName().toLowerCase();
        }
        if (this.psAppViewLogicMap.containsKey(strKey) && (last = this.psAppViewLogicMap.remove(strKey)) != null) {
            this.psAppViewLogicList.remove(last);
        }
        this.psAppViewLogicMap.put(strKey, iPSAppViewLogic);
        this.psAppViewLogicList.add(iPSAppViewLogic);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5757", ignorepf=true, dumpref=true, dynamodelmode=8, from="IPSApplication", fields={"PSAPPMODULEID"})
    public IPSAppModule getPSAppModule() throws Exception {
        if (this.iPSAppModule == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSAPPMODULEID())) {
            this.iPSAppModule = this.getPSApplication().getPSAppModule(this.psApplicationView.getPSAPPMODULEID());
        }
        return this.iPSAppModule;
    }

    @Override
    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }

    @Override
    public void setPSViewType(IPSViewType iPSViewType) {
        this.iPSViewType = iPSViewType;
    }

    public AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception {
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8bf7\u6c42"));
    }

    public IDataEntity getDataEntity() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5173\u8054\u89c6\u56fe", hideempty2=true, outputdoc="false")
    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception {
        ArrayList<IPSAppView> relatedPSAppViewList = new ArrayList<IPSAppView>();
        this.fillRelatedPSAppViews(relatedPSAppViewList);
        LinkedHashMap<String, IPSAppView> relatedPSAppViewMap = new LinkedHashMap<String, IPSAppView>();
        for (IPSAppView iPSAppView : relatedPSAppViewList) {
            if (iPSAppView == null) continue;
            relatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
        }
        return relatedPSAppViewMap.values().iterator();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        IPSAppViewPlugin iPSAppViewPlugin = this.getPSAppViewPlugin();
        if (iPSAppViewPlugin != null && iPSAppViewPlugin.fillRelatedPSAppViews(this, relatedAppViewList)) {
            return;
        }
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        ArrayList<IPSAppView> relatedAppViewList2 = new ArrayList<IPSAppView>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            try {
                iPSControl.fillRelatedPSAppViews(relatedAppViewList2);
            }
            catch (Exception ex) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u586b\u5145\u5173\u8054\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getName(), (Object)iPSControl.getName(), (Object)ex.getMessage()), ex);
            }
        }
        if (this.psAppViewRefMap != null) {
            for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                try {
                    if (iPSAppViewRef.getRefPSAppView() == null) continue;
                    relatedAppViewList2.add(iPSAppViewRef.getRefPSAppView());
                }
                catch (Exception ex) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u89c6\u56fe\u5f15\u7528[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getName(), (Object)iPSAppViewRef.getName(), (Object)ex.getMessage()), ex);
                }
            }
        }
        if (this.psUIActionList != null) {
            for (IPSUIAction iPSUIAction : this.psUIActionList) {
                IPSAppView refPSAppView = iPSUIAction.getFrontPSAppView(this);
                if (refPSAppView == null) continue;
                relatedAppViewList2.add(refPSAppView);
            }
        }
        for (IPSAppView iPSAppView : relatedAppViewList2) {
            IPSAppRedirectView iPSAppRedirectView;
            Iterator<IPSAppView> redirectPSAppViews;
            relatedAppViewList.add(iPSAppView);
            if (!(iPSAppView instanceof IPSAppRedirectView) || (redirectPSAppViews = (iPSAppRedirectView = (IPSAppRedirectView)iPSAppView).getRedirectPSAppViews()) == null) continue;
            while (redirectPSAppViews.hasNext()) {
                relatedAppViewList.add(redirectPSAppViews.next());
            }
        }
    }

    public IApplication getApplication() {
        return this.getPSApplication();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bbd\u5ea6", ignoredumpvalues="0", outputdoc="(%1$s.getWidth() gt 0)")
    public int getWidth() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u9ad8\u5ea6", ignoredumpvalues="0", outputdoc="(%1$s.getHeight() gt 0)")
    public int getHeight() {
        return 0;
    }

    @Override
    public IPSAppView getRefPSAppView(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = null;
        if (this.psAppViewRefMap != null) {
            iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        }
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef.getRefPSAppView();
    }

    @Override
    public Iterator<IPSAppView> getRefPSAppViews(String strRefMode) throws Exception {
        strRefMode = strRefMode.toUpperCase();
        ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
        if (this.psAppViewRefMap != null) {
            for (String strKey : this.psAppViewRefMap.keySet()) {
                if (strKey.indexOf(strRefMode) != 0) continue;
                IPSAppViewRef iPSAppViewRef = this.psAppViewRefMap.get(strKey);
                if (iPSAppViewRef == null) {
                    iPSAppViewRef = null;
                }
                if (iPSAppViewRef.getRefPSAppView() == null) continue;
                psAppViewList.add(iPSAppViewRef.getRefPSAppView());
            }
        }
        if (psAppViewList.size() == 0) {
            return null;
        }
        return psAppViewList.iterator();
    }

    @Override
    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef psAppViewRef) throws Exception {
        if (this.psAppViewRefMap == null) {
            this.psAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
        }
        PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
        iPSAppViewRef.init(this.getDAGlobalHelper(), this, psAppViewRef);
        this.psAppViewRefMap.put(psAppViewRef.getPSAPPVIEWREFNAME().toUpperCase(), iPSAppViewRef);
        return iPSAppViewRef;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408", outputdoc="false")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList != null) {
            return this.psUIActionList.iterator();
        }
        return emptyPSUIActionList.iterator();
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction, JSONObject actionParam) throws Exception {
        if (this.psUIActionList == null) {
            this.psUIActionList = new ArrayList();
        }
        if (this.psUIActionMap == null) {
            this.psUIActionMap = new LinkedHashMap<String, IPSUIAction>();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSUIAction.getId())) {
            if (this.psUIActionMap.containsKey(iPSUIAction.getId())) {
                return;
            }
            this.psUIActionMap.put(iPSUIAction.getId(), iPSUIAction);
            if (actionParam != null) {
                if (this.psUIActionParamMap == null) {
                    this.psUIActionParamMap = new LinkedHashMap<String, JSONObject>();
                }
                this.psUIActionParamMap.put(iPSUIAction.getId(), actionParam);
            }
        }
        this.psUIActionList.add(iPSUIAction);
        IPSAppView refPSAppView = iPSUIAction.getFrontPSAppView(this);
        if (refPSAppView != null) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"WFBACKEND", (boolean)true) == 0) {
                this.getPSApplication().markPSAppViewUsage(refPSAppView.getId(), 2, this);
            } else if ((SA.SRFramework.Utility.StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSUIAction.getUIActionMode(), (String)"WFFRONT", (boolean)true) == 0) && SA.SRFramework.Utility.StringHelper.Compare((String)iPSUIAction.getFrontProcessType(), (String)"WIZARD", (boolean)true) == 0) {
                this.getPSApplication().markPSAppViewUsage(refPSAppView.getId(), 2, this);
            } else {
                this.getPSApplication().markPSAppViewUsage(refPSAppView.getId(), 1, this);
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSUIAction.getViewLogicAttachMode()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSUIAction.getPSSysViewLogicId()) && this.getPSPFStyle().getPFEngineVer() < 20) {
            IPSDEUIAction iPSDEUIAction;
            PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
            psAppViewLogic.setPSAPPVIEWID(this.getId());
            psAppViewLogic.setPSAPPVIEWNAME(this.getName());
            psAppViewLogic.setPSAPPVIEWLOGICID(iPSUIAction.getId());
            psAppViewLogic.setPSAPPVIEWLOGICNAME(String.valueOf(iPSUIAction.getUIActionTag()) + "_VL");
            psAppViewLogic.setINITLOGICMODE(false);
            psAppViewLogic.setParamValue("DSTLOGICTYPE", iPSUIAction.getViewLogicType());
            psAppViewLogic.setParamValue("PSDELOGICID", iPSUIAction.getPSDEUILogicId());
            psAppViewLogic.setParamValue("PSSYSVIEWLOGICID", iPSUIAction.getPSSysViewLogicId());
            if (iPSUIAction instanceof IPSDEUIAction && (iPSDEUIAction = (IPSDEUIAction)iPSUIAction).getPSDataEntity() != null) {
                psAppViewLogic.setParamValue("PSDEID", iPSDEUIAction.getPSDataEntity().getId());
            }
            PSAppViewLogicImpl psAppViewLogicImpl = new PSAppViewLogicImpl();
            psAppViewLogicImpl.init(this.getDAGlobalHelper(), this, psAppViewLogic);
            this.registerPSAppViewLogic(String.valueOf(iPSUIAction.getUIActionTag()) + "_VL", psAppViewLogicImpl);
        }
        if (iPSUIAction.getNextPSUIAction() != null) {
            this.registerPSUIAction(iPSUIAction.getNextPSUIAction());
        }
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction) throws Exception {
        this.registerPSUIAction(iPSUIAction, null);
    }

    @Override
    public JSONObject getPSUIActionParamJO(IPSUIAction iPSUIAction) throws Exception {
        if (this.psUIActionParamMap == null) {
            return null;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSUIAction.getId())) {
            return this.psUIActionParamMap.get(iPSUIAction.getId());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u96c6\u5408", hideempty2=true, child=true, group="\u89c6\u56fe\u903b\u8f91", order=220, outputdoc="false")
    public Iterator<IPSAppViewLogic> getPSAppViewLogics() {
        if (this.psAppViewLogicList != null) {
            return this.psAppViewLogicList.iterator();
        }
        return emptyPSAppViewLogicList.iterator();
    }

    @Override
    public String getLanguage() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u8def\u5f84", dump=false, outputdoc="false")
    public String getBackendUrl() {
        try {
            if (PSJITWebContext.getInstance() != null) {
                return this.getPSApplication().getPSPF().getPSAppViewBackendUrl(this);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return this.strBackendUrl;
    }

    @Override
    public Iterator<String> getAppViewRefModes() {
        if (this.psAppViewRefMap != null) {
            return this.psAppViewRefMap.keySet().iterator();
        }
        return emptyPSAppViewRefMap.keySet().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u62ac\u5934", fields={"TITLE"})
    public String getTitle() {
        return this.strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898", group="\u57fa\u672c", order=120, fields={"CAPTION"})
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898", fields={"SUBCAPTION"})
    public String getSubCaption() {
        return this.strSubCaption;
    }

    @Override
    public String getViewIcon() {
        return "";
    }

    @Override
    public String getOpenMode() {
        return "";
    }

    @Override
    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = null;
        if (this.psAppViewRefMap != null) {
            iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        }
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef;
    }

    @Override
    public String getTitle(IPSAppViewRef iPSAppViewRef) {
        return this.getTitle();
    }

    @Override
    public String getCaption(IPSAppViewRef iPSAppViewRef) {
        return this.getCaption();
    }

    @Override
    public String getOpenMode(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSAppViewRef.getOpenMode())) {
            return iPSAppViewRef.getOpenMode();
        }
        return this.getOpenMode();
    }

    @Override
    public int getWidth(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef.getWidth() > 0) {
            return iPSAppViewRef.getWidth();
        }
        return this.getWidth();
    }

    @Override
    public int getHeight(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef.getHeight() > 0) {
            return iPSAppViewRef.getHeight();
        }
        return this.getHeight();
    }

    @Override
    public boolean isEnableViewModel() {
        return this.isEnableViewModelDefault();
    }

    protected boolean isEnableViewModelDefault() {
        return this.bEnableViewModelDefault;
    }

    protected void setEnableViewModelDefault(boolean bEnableViewModelDefault) {
        this.bEnableViewModelDefault = bEnableViewModelDefault;
    }

    @Override
    public String getViewModelUrl() {
        return "";
    }

    @Override
    public boolean isUserRefMode() {
        return this.bUserRefMode;
    }

    @Override
    public IPSAppView getPSAppView() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u90e8\u4ef6\u96c6\u5408", group="\u754c\u9762&\u90e8\u4ef6", order=165)
    public ArrayList<IPSControl> getAllPSControls() {
        ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            psControlList.add(iPSControl);
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerControls((IPSControlContainer)((Object)iPSControl), psControlList);
        }
        Collections.sort(psControlList, new Comparator<IPSControl>(){

            @Override
            public int compare(IPSControl arg0, IPSControl arg1) {
                return Integer.valueOf(arg0.getOrderValue()).compareTo(arg1.getOrderValue());
            }
        });
        return psControlList;
    }

    protected void fillContainerControls(IPSControlContainer iPSControlContainer, ArrayList<IPSControl> psControlList) {
        if (this.isEnableUIModelEx() || this.getPSSystem().isEnableModelRT()) {
            ArrayList<IPSControl> psControls = iPSControlContainer.getAllPSControls();
            if (psControls != null) {
                psControlList.addAll(psControls);
            }
        } else {
            Iterator<IPSControl> psControls = iPSControlContainer.getPSControls();
            if (psControls != null) {
                while (psControls.hasNext()) {
                    IPSControl iPSControl = psControls.next();
                    psControlList.add(iPSControl);
                    if (!(iPSControl instanceof IPSControlContainer)) continue;
                    this.fillContainerControls((IPSControlContainer)((Object)iPSControl), psControlList);
                }
            }
        }
    }

    @Override
    public ArrayList<IPSAjaxControl> getAllPSAjaxControls() {
        ArrayList<IPSAjaxControl> psAjaxControlList = new ArrayList<IPSAjaxControl>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            if (iPSControl instanceof IPSAjaxControl && ((IPSAjaxControl)iPSControl).isAjaxCtrl()) {
                psAjaxControlList.add((IPSAjaxControl)iPSControl);
            }
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerAjaxControls((IPSControlContainer)((Object)iPSControl), psAjaxControlList);
        }
        Collections.sort(psAjaxControlList, new Comparator<IPSControl>(){

            @Override
            public int compare(IPSControl arg0, IPSControl arg1) {
                int nRet = arg0.getOrderValue() - arg1.getOrderValue();
                if (nRet == 0) {
                    return 0;
                }
                if (nRet > 0) {
                    return 1;
                }
                return -1;
            }
        });
        return psAjaxControlList;
    }

    protected void fillContainerAjaxControls(IPSControlContainer iPSControlContainer, ArrayList<IPSAjaxControl> psAjaxControlList) {
        Iterator<IPSControl> psControls = iPSControlContainer.getPSControls();
        while (psControls.hasNext()) {
            IPSControl iPSControl = psControls.next();
            if (iPSControl instanceof IPSAjaxControl && ((IPSAjaxControl)iPSControl).isAjaxCtrl()) {
                psAjaxControlList.add((IPSAjaxControl)iPSControl);
            }
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerAjaxControls((IPSControlContainer)((Object)iPSControl), psAjaxControlList);
        }
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u89c6\u56fe\u5e2e\u52a9", dump=false)
    public boolean isEnableHelp() {
        return true;
    }

    @Override
    public Iterator<IPSAppViewRef> getEmbeddedPSAppViewRefs(String strContainerId) throws Exception {
        boolean bOpenActionSession;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        boolean bl = bOpenActionSession = actionSession == null;
        if (bOpenActionSession) {
            actionSession = ActionSessionManager.openSession();
        }
        try {
            ArrayList<IPSAppViewRef> embeddedPSAppViewRefList = new ArrayList<IPSAppViewRef>();
            if (!actionSession.registerRecursion(this.getId(), (Object)"")) {
                if (bOpenActionSession) {
                    ActionSessionManager.closeSession();
                }
                return embeddedPSAppViewRefList.iterator();
            }
            if (this.psAppViewRefMap != null) {
                for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSAppViewRef.getEmbedId())) continue;
                    PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
                    PSAppViewRef psAppViewRef = new PSAppViewRef();
                    psAppViewRef.setMINORPSAPPVIEWID(iPSAppViewRef.getRefPSAppView().getId());
                    psAppViewRef.setREFMODETEXT(iPSAppViewRef.getRefModeDesc());
                    psAppViewRefImpl.init(this.getDAGlobalHelper(), this, psAppViewRef);
                    psAppViewRefImpl.setRefPSAppView(iPSAppViewRef.getRefPSAppView());
                    String strFullViewId = "";
                    strFullViewId = SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strContainerId) ? iPSAppViewRef.getEmbedId() : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)iPSAppViewRef.getEmbedId());
                    psAppViewRefImpl.setEmbedId(strFullViewId);
                    embeddedPSAppViewRefList.add(iPSAppViewRef);
                    Iterator<IPSAppViewRef> subEmbeddedPSAppViewRefs = iPSAppViewRef.getRefPSAppView().getEmbeddedPSAppViewRefs(strFullViewId);
                    if (subEmbeddedPSAppViewRefs == null) continue;
                    while (subEmbeddedPSAppViewRefs.hasNext()) {
                        embeddedPSAppViewRefList.add(subEmbeddedPSAppViewRefs.next());
                    }
                }
            }
            for (IPSControl iPSControl : this.psControlMap.values()) {
                iPSControl.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
            }
            LinkedHashMap<String, IPSAppViewRef> embeddedPSAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
            for (IPSAppViewRef iPSAppViewRef : embeddedPSAppViewRefList) {
                if (embeddedPSAppViewRefMap.containsKey(iPSAppViewRef.getEmbedId())) continue;
                embeddedPSAppViewRefMap.put(iPSAppViewRef.getEmbedId(), iPSAppViewRef);
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            return embeddedPSAppViewRefMap.values().iterator();
        }
        catch (Exception ex) {
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    @Override
    public Iterator<IPSCodeList> getRelatedPSCodeList(boolean bIncludeEmbed) throws Exception {
        ArrayList<IPSCodeList> relatedPSCodeListList = new ArrayList<IPSCodeList>();
        this.fillRelatedPSCodeLists(relatedPSCodeListList);
        if (bIncludeEmbed && this.psAppViewRefMap != null) {
            for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSAppViewRef.getEmbedId()) || iPSAppViewRef.getRefPSAppView() == null) continue;
                iPSAppViewRef.getRefPSAppView().fillRelatedPSCodeLists(relatedPSCodeListList);
            }
        }
        LinkedHashMap<String, IPSCodeList> relatedPSCodeListMap = new LinkedHashMap<String, IPSCodeList>();
        for (IPSCodeList iPSCodeList : relatedPSCodeListList) {
            if (relatedPSCodeListMap.containsKey(iPSCodeList.getId())) continue;
            relatedPSCodeListMap.put(iPSCodeList.getId(), iPSCodeList);
        }
        return relatedPSCodeListMap.values().iterator();
    }

    @Override
    public Iterator<IPSCodeList> getRelatedPSCodeLists(boolean bIncludeEmbed) throws Exception {
        return this.getRelatedPSCodeList(bIncludeEmbed);
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5173\u8054\u4ee3\u7801\u8868", hideempty2=true, outputdoc="false")
    public Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception {
        return this.getRelatedPSCodeList(true);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u4ee3\u7801\u8868\u96c6\u5408", outputdoc="false")
    public Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception {
        return this.getRelatedPSCodeList(false);
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSControl iPSControl : this.psControlMap.values()) {
            iPSControl.fillRelatedPSCodeLists(relatedPSCodeListList);
        }
    }

    @Override
    public String getSubAppFolderName() {
        return this.strSubAppFolderName;
    }

    @Override
    public String getPageUrl() {
        return this.strPageUrl;
    }

    protected void setPageUrl(String strPageUrl) {
        this.strPageUrl = strPageUrl;
    }

    @Override
    public IPSSysCounterRef registerPSSysCounter(IPSSysCounter iPSSysCounter, JSONObject jsonRefMode) throws Exception {
        String strId;
        IPSSysCounterRef iPSSysCounterRef;
        if (this.psSysCounterRefMap == null) {
            this.psSysCounterRefMap = new LinkedHashMap<String, IPSSysCounterRef>();
        }
        if (jsonRefMode == null) {
            jsonRefMode = new JSONObject();
        }
        if ((iPSSysCounterRef = this.psSysCounterRefMap.get(strId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)iPSSysCounter.getId(), (Object)jsonRefMode.toString()))) == null) {
            if (iPSSysCounter instanceof IPSAppCounter) {
                PSAppCounterRefImpl psAppCounterRefImpl = new PSAppCounterRefImpl();
                psAppCounterRefImpl.init(this.getDAGlobalHelper(), (IPSAppCounter)iPSSysCounter, jsonRefMode);
                iPSSysCounterRef = psAppCounterRefImpl;
            } else {
                iPSSysCounterRef = new PSSysCounterRefImpl();
                iPSSysCounterRef.init(this.getDAGlobalHelper(), iPSSysCounter, jsonRefMode);
            }
            this.psSysCounterRefMap.put(strId, iPSSysCounterRef);
        }
        return iPSSysCounterRef;
    }

    @Override
    public Iterator<IPSSysCounterRef> getPSSysCounterRefs() {
        if (this.psSysCounterRefMap != null) {
            return this.psSysCounterRefMap.values().iterator();
        }
        return emptyPSSysCounterRefMap.values().iterator();
    }

    @Override
    public IPSAppCounterRef registerPSAppCounter(IPSAppCounter iPSAppCounter, JSONObject jsonRefMode) throws Exception {
        String strId;
        IPSAppCounterRef iPSAppCounterRef;
        this.registerPSSysCounter(iPSAppCounter, jsonRefMode);
        if (this.psAppCounterRefMap == null) {
            this.psAppCounterRefMap = new LinkedHashMap<String, IPSAppCounterRef>();
        }
        if (jsonRefMode == null) {
            jsonRefMode = new JSONObject();
        }
        if ((iPSAppCounterRef = this.psAppCounterRefMap.get(strId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)iPSAppCounter.getId(), (Object)jsonRefMode.toString()))) == null) {
            if (iPSAppCounter instanceof IPSAppCounter) {
                PSAppCounterRefImpl psAppCounterRefImpl = new PSAppCounterRefImpl();
                psAppCounterRefImpl.init(this.getDAGlobalHelper(), iPSAppCounter, jsonRefMode);
                iPSAppCounterRef = psAppCounterRefImpl;
            } else {
                iPSAppCounterRef = new PSAppCounterRefImpl();
                iPSAppCounterRef.init(this.getDAGlobalHelper(), iPSAppCounter, jsonRefMode);
            }
            this.psAppCounterRefMap.put(strId, iPSAppCounterRef);
        }
        return iPSAppCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u5f15\u7528\u96c6\u5408", child=true, group="\u89c6\u56fe\u903b\u8f91", order=228, outputdoc="%1$s.getPSAppCounterRefs()?? && (srflist(%1$s.getPSAppCounterRefs())?size gt 0)")
    public Iterator<IPSAppCounterRef> getPSAppCounterRefs() {
        if (this.psAppCounterRefMap != null) {
            return this.psAppCounterRefMap.values().iterator();
        }
        return emptyPSAppCounterRefMap.values().iterator();
    }

    @Override
    public synchronized IPSAppViewParam registerPSAppViewParam(String strKey, String strValue, String strDesc) throws Exception {
        if (this.psAppViewParamMap == null) {
            return null;
        }
        String strTag = strKey.toUpperCase();
        if (strTag.indexOf("SRFNAVCTX.") == 0) {
            boolean bRawValue = true;
            strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                strValue = strValue.replace("%", "");
                bRawValue = false;
            }
            PSAppViewNavContextImpl PSAppViewNavContextImpl2 = new PSAppViewNavContextImpl();
            PSAppViewNavContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, strDesc, bRawValue);
            if (this.psAppViewNavContextMap == null) {
                this.psAppViewNavContextMap = new LinkedHashMap<String, IPSAppViewNavContext>();
            }
            this.psAppViewNavContextMap.put(strTag, PSAppViewNavContextImpl2);
            return PSAppViewNavContextImpl2;
        }
        if (strTag.indexOf("SRFNAVPARAM.") == 0) {
            boolean bRawValue = true;
            strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                strValue = strValue.replace("%", "");
                bRawValue = false;
            }
            PSAppViewNavParamImpl PSAppViewNavParamImpl2 = new PSAppViewNavParamImpl();
            PSAppViewNavParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, strDesc, bRawValue);
            if (this.psAppViewNavParamMap == null) {
                this.psAppViewNavParamMap = new LinkedHashMap<String, IPSAppViewNavParam>();
            }
            this.psAppViewNavParamMap.put(strTag, PSAppViewNavParamImpl2);
            return PSAppViewNavParamImpl2;
        }
        PSAppViewParamImpl psAppViewParamImpl = new PSAppViewParamImpl();
        psAppViewParamImpl.init(this.getDAGlobalHelper(), this, strTag, strValue, strDesc);
        this.psAppViewParamMap.put(strTag, psAppViewParamImpl);
        return psAppViewParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u53c2\u6570\u96c6\u5408", child=true, group="\u89c6\u56fe\u903b\u8f91", order=232)
    public synchronized Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception {
        if (this.psAppViewParamMap == null) {
            this.psAppViewParamMap = new LinkedHashMap<String, IPSAppViewParam>();
            this.onPreparePSAppViewParams();
        }
        return this.psAppViewParamMap.values().iterator();
    }

    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic()) {
            for (String strCtrlName : this.psControlMap.keySet()) {
                String strParam = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s.%2$s", (Object)"UI.CTRL", (Object)strCtrlName);
                this.registerPSAppViewParam(strParam.toUpperCase(), "TRUE", "");
            }
            if (!this.isShowCaptionBar()) {
                this.registerPSAppViewParam("UI.SHOWCAPTIONBAR", "FALSE", "\u4e0d\u663e\u793a\u6807\u9898\u680f");
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        if (this.iPSSysPFPlugin == null && this.getPSSubViewType() != null) {
            return this.getPSSubViewType().getPSSysPFPlugin();
        }
        return this.iPSSysPFPlugin;
    }

    protected void setPSSysPFPlugin(IPSSysPFPlugin iPSSysPFPlugin) {
        this.iPSSysPFPlugin = iPSSysPFPlugin;
    }

    protected void setPSSubViewType(IPSSubViewType iPSSubViewType) {
        this.iPSSubViewType = iPSSubViewType;
    }

    @Override
    public IPSSubViewType getPSSubViewType() {
        return this.iPSSubViewType;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers", fields={"ACCUSERMODE"})
    public int getAccUserMode() {
        return this.nAccUserMode;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6", fields={"PSSYSUNIRESID"}, doc="\u89c6\u56fe\u8bbf\u95ee\u6807\u8bc6\u6765\u81ea\u7edf\u4e00\u8d44\u6e90\u7684\u8d44\u6e90\u4ee3\u7801{@link net.ibizsys.model.security.IPSSysUniRes#getResCode}")
    public String getAccessKey() {
        if (this.getPSSysUniRes() != null) {
            return this.getPSSysUniRes().getResCode();
        }
        return this.getDefaultAccessKey();
    }

    protected IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    protected String getDefaultAccessKey() {
        if ((this.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0) {
            return this.getId();
        }
        return null;
    }

    @Override
    public void checkViewEnv() throws Exception {
        this.onCheckViewEnv();
    }

    protected void onCheckViewEnv() throws Exception {
        try {
            if (this.psUIActionList != null) {
                for (IPSUIAction iPSUIAction : this.psUIActionList) {
                    IPSUIAction iPSDEUIAction;
                    if (iPSUIAction instanceof IPSDEUIAction) {
                        iPSDEUIAction = (IPSDEUIAction)iPSUIAction;
                        iPSDEUIAction.getFrontPSAppView(this);
                        continue;
                    }
                    if (!(iPSUIAction instanceof IPSWFUIAction)) continue;
                    iPSDEUIAction = (IPSWFUIAction)iPSUIAction;
                    iPSDEUIAction.getFrontPSAppView(this);
                }
            }
            if (this.psAppViewRefMap != null) {
                for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                    iPSAppViewRef.getRefPSAppView();
                }
            }
        }
        catch (Exception ex) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u68c0\u67e5\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe", ignoredumpvalues="false")
    public boolean isRedirectView() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", dump=false)
    public boolean isPSDEView() {
        return false;
    }

    @Override
    public String getLastModifyTimeStr() {
        return this.strLastModifyTime;
    }

    protected void setLastModifyTimeStr(String strLastModifyTime) {
        this.strLastModifyTime = strLastModifyTime;
    }

    @Override
    public boolean isMobileView() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528", child=true, outputdoc="false")
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        if (this.psAppViewRefMap != null) {
            return this.psAppViewRefMap.values().iterator();
        }
        return emptyPSAppViewRefMap.values().iterator();
    }

    @Override
    public boolean isPickupView() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u88ab\u5f15\u7528", ignoredumpvalues="true", dynamodelmode=8)
    public boolean getRefFlag() {
        return this.isUserRefMode() || this.getSysRefFlag();
    }

    @Override
    public Iterator<IPSUpdatePanel> getPSUpdatePanels() {
        if (this.psUpdatePanelMap != null) {
            return this.psUpdatePanelMap.values().iterator();
        }
        return emptyPSUpdatePanelMap.values().iterator();
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public IViewWizardGroup getViewWizardGroup() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u7ec4", hideempty=true)
    public IPSViewMsgGroup getPSViewMsgGroup() {
        return this.iPSViewMsgGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4", hideempty=true, dumpref=true, from="IPSApplication", fields={"PSVIEWMSGGROUPID"})
    public IPSAppViewMsgGroup getPSAppViewMsgGroup() {
        IPSViewMsgGroup iPSViewMsgGroup = this.getPSViewMsgGroup();
        if (iPSViewMsgGroup instanceof IPSAppViewMsgGroup) {
            return (IPSAppViewMsgGroup)iPSViewMsgGroup;
        }
        return null;
    }

    @Override
    public String getMainMenuAlign() {
        return this.strMainMenuAlign;
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    public IPSLanguageRes getTitlePSLanguageRes(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef.getTitlePSLanguageRes() != null) {
            return iPSAppViewRef.getTitlePSLanguageRes();
        }
        return this.getTitlePSLanguageRes();
    }

    @Override
    public String getTitleLanResTag() {
        if (this.getTitlePSLanguageRes() != null) {
            return this.getTitlePSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public String getTitleLanResTag(IPSAppViewRef iPSAppViewRef) {
        if (this.getTitlePSLanguageRes(iPSAppViewRef) != null) {
            return this.getTitlePSLanguageRes(iPSAppViewRef).getLanResTag();
        }
        return this.getTitleLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"SUBCAPPSLANRESID"})
    public IPSLanguageRes getSubCapPSLanguageRes() {
        return this.subCapPSLanguageRes;
    }

    @Override
    public String getSubCapLanResTag() {
        if (this.getSubCapPSLanguageRes() != null) {
            return this.getSubCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public String getPSHelpModuleId() {
        return this.strPSHelpModuleId;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f", ignoredumpvalues="true")
    public boolean isShowCaptionBar() {
        if (this.bShowCaptionBar == null) {
            return this.bShowCaptionBarDefault;
        }
        return this.bShowCaptionBar;
    }

    protected boolean isShowCaptionBarDefault() {
        return !this.isPickupView();
    }

    @Override
    public boolean getSysRefFlag() {
        if (this.bSysRefFlag == null) {
            return false;
        }
        return this.bSysRefFlag;
    }

    @Override
    public void logPSControlIssue(IPSControl iPSControl, PSSysIssue psSysIssueV3) throws Exception {
    }

    protected boolean isUserRefModeDefault() {
        return false;
    }

    @Override
    public void updateSysRefFlag(boolean bSysRefFlag) throws Exception {
        this.bSysRefFlag = bSysRefFlag;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        if (this.iPSSysCss == null) {
            return this.getPSApplication().getPSApplicationUI().getDefaultAppViewPSSysCss();
        }
        return this.iPSSysCss;
    }

    @Override
    public boolean isCustomViewStyle() {
        return this.bCustomViewStyle;
    }

    @Override
    public void registerPSAppFunc(IPSAppFunc iPSAppFunc) throws Exception {
        if (this.psAppFuncMap == null) {
            this.psAppFuncMap = new LinkedHashMap<String, IPSAppFunc>();
        }
        this.psAppFuncMap.put(iPSAppFunc.getId(), iPSAppFunc);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u5e94\u7528\u529f\u80fd\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        if (this.psAppFuncMap != null) {
            return this.psAppFuncMap.values().iterator();
        }
        return emptyPSAppFuncMap.values().iterator();
    }

    @Override
    public int getButtonNoPrivDisplayMode() {
        return this.getPSApplication().getPSApplicationUI().getButtonNoPrivDisplayMode();
    }

    protected IPSAppViewPlugin getPSAppViewPlugin() {
        return this.iPSAppViewPlugin;
    }

    protected IPSAppViewPlugin createPSAppViewPlugin() throws Exception {
        IPSViewEngine iPSViewEngine;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSVIEWENGINEID()) && SA.SRFramework.Utility.StringHelper.Compare((String)(iPSViewEngine = this.getPSModelStorage().getPSViewEngine(this.psApplicationView.getPSVIEWENGINEID())).getEngineType(), (String)"PLUGIN", (boolean)false) == 0) {
            IPSAppViewPlugin iPSAppViewPlugin = (IPSAppViewPlugin)ObjectHelper.Create((String)iPSViewEngine.getEngineObj());
            return iPSAppViewPlugin;
        }
        return null;
    }

    @Override
    public void registerPSSysCss(IPSSysCss iPSSysCss) throws Exception {
        if (iPSSysCss == null) {
            return;
        }
        if (this.psSysCssMap == null) {
            this.psSysCssMap = new LinkedHashMap<String, IPSSysCss>();
        }
        this.psSysCssMap.put(iPSSysCss.getId(), iPSSysCss);
    }

    @Override
    public void registerPSSysImage(IPSSysImage iPSSysImage) throws Exception {
        if (iPSSysImage == null) {
            return;
        }
        if (this.psSysImageMap == null) {
            this.psSysImageMap = new LinkedHashMap<String, IPSSysImage>();
        }
        this.psSysImageMap.put(iPSSysImage.getId(), iPSSysImage);
    }

    @Override
    public void registerPSLanguageRes(IPSLanguageRes iPSLanguageRes) throws Exception {
        if (iPSLanguageRes == null) {
            return;
        }
        if (this.psLanguageResMap == null) {
            this.psLanguageResMap = new LinkedHashMap<String, IPSLanguageRes>();
        }
        this.psLanguageResMap.put(iPSLanguageRes.getId(), iPSLanguageRes);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u6837\u5f0f\u8d44\u6e90\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysCss> getPSSysCsses() {
        if (this.psSysCssMap != null) {
            return this.psSysCssMap.values().iterator();
        }
        return emptyPSSysCssMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u56fe\u7247\u8d44\u6e90\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysImage> getPSSysImages() {
        if (this.psSysImageMap != null) {
            return this.psSysImageMap.values().iterator();
        }
        return emptyPSSysImageMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u8bed\u8a00\u8d44\u6e90\u96c6\u5408", outputdoc="false")
    public Iterator<IPSLanguageRes> getPSLanguageReses() {
        if (this.psLanguageResMap != null) {
            return this.psLanguageResMap.values().iterator();
        }
        return emptyPSLanguageResMap.values().iterator();
    }

    @Override
    public void registerPSSysPFPlugin(IPSSysPFPlugin iPSPFPlugin) throws Exception {
        if (this.psPFPluginMap == null) {
            this.psPFPluginMap = new LinkedHashMap<String, IPSSysPFPlugin>();
        }
        this.psPFPluginMap.put(iPSPFPlugin.getId(), iPSPFPlugin);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u524d\u7aef\u5e94\u7528\u63d2\u4ef6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSSysPFPlugin> getPSSysPFPlugins() {
        if (this.psPFPluginMap != null) {
            return this.psPFPluginMap.values().iterator();
        }
        return emptyPSPFPluginMap.values().iterator();
    }

    @Override
    public boolean isDynamicView() {
        if (this.getDynamicView() == null) {
            return false;
        }
        return this.getDynamicView();
    }

    protected Boolean getDynamicView() {
        return this.bDynamicView;
    }

    @Override
    public IPSAjaxHandler getPSAjaxHandler() {
        return this.iPSAjaxHandler;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898\u680f", hideempty=true)
    public IPSTitleBar getPSTitleBar() {
        return this.iPSTitleBar;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe", dump=false)
    public boolean isEmbeddedView() {
        if (this.getPSViewType() != null) {
            return this.getPSViewType().isEmbeddedView();
        }
        return false;
    }

    @Override
    public void markViewUsage(int nViewUsage, Object objRef) {
        this.nViewUsage |= nViewUsage;
    }

    @Override
    public boolean testViewUsage(int nViewUsage) {
        return (this.getViewUsage() & nViewUsage) == nViewUsage;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u4f7f\u7528\u573a\u666f", dump=false)
    public int getViewUsage() {
        return this.nViewUsage | this.getPSApplication().getPSAppViewUsage(this.getId());
    }

    protected void onPreparePSTitleBar() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psApplicationView.getPSAPPTITLEBARID())) {
            PSTitleBarParamImpl psTitleBarParamImpl = new PSTitleBarParamImpl();
            psTitleBarParamImpl.setTitleBarType("APPTITLEBAR");
            psTitleBarParamImpl.setPSTitleBarId(this.psApplicationView.getPSAPPTITLEBARID());
            this.iPSTitleBar = (IPSTitleBar)this.registerPSControl(TITLEBARNAME, "TITLEBAR", psTitleBarParamImpl);
        }
    }

    protected void onPreparePSCaptionBar() throws Exception {
        if (this.getPSCaptionBar() != null) {
            return;
        }
        if (!this.hasPSControl("captionbar")) {
            PSCaptionBarParamImpl psCaptionBarParamImpl = new PSCaptionBarParamImpl();
            this.iPSCaptionBar = (IPSCaptionBar)this.registerPSControl("captionbar", "CAPTIONBAR", psCaptionBarParamImpl);
        } else {
            IPSControl iPSControl = this.getPSControl("captionbar");
            if (iPSControl instanceof IPSCaptionBar) {
                this.iPSCaptionBar = (IPSCaptionBar)iPSControl;
            }
        }
    }

    protected void onPreparePSViewLayoutPanel() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysViewLayoutPanelId())) {
            PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
            psSysPanelParamImpl.setPSSysPanelId(this.getPSSysViewLayoutPanelId());
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWLAYOUTPANEL");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this, "layoutpanel", psSysPanelParamImpl);
            this.iPSViewLayoutPanel = (IPSSysViewLayoutPanel)iPSControl;
        } else if (this.isPrepareDefaultPSViewLayoutPanel()) {
            PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
            psSysPanelParamImpl.setPSSysPanelId("");
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWLAYOUTPANEL");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this, "layoutpanel", psSysPanelParamImpl);
            this.iPSViewLayoutPanel = (IPSSysViewLayoutPanel)iPSControl;
        }
    }

    protected String getPSSysViewLayoutPanelId() {
        return this.psApplicationView.getPSSYSVIEWPANELID();
    }

    @Override
    public IPSSysViewLayoutPanel getPSSysViewLayoutPanel() {
        return this.iPSViewLayoutPanel;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public boolean isPickupMode() {
        return false;
    }

    @Override
    public String getViewUrl(String strQueryString) throws Exception {
        LinkedHashMap<String, String> urlParamMap = new LinkedHashMap<String, String>();
        String[] strLists = strQueryString.split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = set[1];
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) {
                        strValue = strValue.trim();
                    }
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) {
                        urlParamMap.put(set[0], strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
        return this.getPSApplication().getPSPF().getPSAppViewPageUrl(this, urlParamMap);
    }

    @Override
    public String getUIStyle() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIStyle)) {
            return this.strUIStyle;
        }
        return this.strAppUIStyle;
    }

    public String getUIStyle2(boolean bAppUIStyle) {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIStyle)) {
            return this.strUIStyle;
        }
        if (bAppUIStyle) {
            return this.strAppUIStyle;
        }
        return this.strUIStyle;
    }

    @Override
    public IPSAppViewLogic getPSAppViewLogic(String strLogicTag, boolean bTry) throws Exception {
        IPSAppViewLogic iPSAppViewLogic = null;
        if (this.psAppViewLogicMap != null) {
            iPSAppViewLogic = this.psAppViewLogicMap.get(strLogicTag);
        }
        if (iPSAppViewLogic == null && !bTry) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u903b\u8f91[%1$s]", (Object)strLogicTag));
        }
        return iPSAppViewLogic;
    }

    @Override
    public Iterator<IPSAppViewRef> getPSAppViewRefs(String strRefMode) throws Exception {
        if (this.psAppViewRefMap == null) {
            return null;
        }
        strRefMode = strRefMode.toUpperCase();
        ArrayList<IPSAppViewRef> psAppViewRefList = new ArrayList<IPSAppViewRef>();
        for (String strKey : this.psAppViewRefMap.keySet()) {
            IPSAppViewRef iPSAppViewRef;
            if (strKey.indexOf(strRefMode) != 0 || (iPSAppViewRef = this.psAppViewRefMap.get(strKey)) == null || iPSAppViewRef.getRefPSAppView() == null) continue;
            psAppViewRefList.add(iPSAppViewRef);
        }
        if (psAppViewRefList.size() == 0) {
            return null;
        }
        return psAppViewRefList.iterator();
    }

    @Override
    public void registerPSAppViewEngine(IPSAppViewEngine iPSAppViewEngine) throws Exception {
        this.registerPSAppViewEngine(null, iPSAppViewEngine);
    }

    @Override
    public void registerPSAppViewEngine(String strKey, IPSAppViewEngine iPSAppViewEngine) throws Exception {
        if (this.psAppViewEngineList == null) {
            this.psAppViewEngineList = new ArrayList();
        }
        if (this.psAppViewEngineMap == null) {
            this.psAppViewEngineMap = new LinkedHashMap<String, IPSAppViewEngine>();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strKey)) {
            strKey = iPSAppViewEngine.getName().toLowerCase();
        }
        this.psAppViewEngineMap.put(strKey, iPSAppViewEngine);
        this.psAppViewEngineList.add(iPSAppViewEngine);
        if (this.psAppViewEngineList.size() > 1) {
            PSModelUtil.sort(this.psAppViewEngineList);
        }
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u96c6\u5408", hideempty2=true, child=true, group="\u89c6\u56fe\u903b\u8f91", order=229)
    public Iterator<IPSAppViewEngine> getPSAppViewEngines() {
        if (this.psAppViewEngineList != null) {
            return this.psAppViewEngineList.iterator();
        }
        return emptyPSAppViewEngineList.iterator();
    }

    @Override
    public IPSAppViewEngine getPSAppViewEngine(String strEngineTag, boolean bTry) throws Exception {
        IPSAppViewEngine iPSAppViewEngine = null;
        if (this.psAppViewEngineMap != null) {
            iPSAppViewEngine = this.psAppViewEngineMap.get(strEngineTag);
        }
        if (iPSAppViewEngine == null && !bTry) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u754c\u9762\u5f15\u64ce[%1$s]", (Object)strEngineTag));
        }
        return iPSAppViewEngine;
    }

    @Override
    public boolean isPrepareDefaultPSAppViewLogics() {
        return this.getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public boolean isPrepareTemplV2logic() {
        return this.getPSPFStyle().getPFEngineVer() >= 20;
    }

    protected boolean isPrepareDefaultPSAppViewEngines() {
        return this.getPSPFStyle().getPFEngineVer() >= 20;
    }

    protected boolean isPrepareDefaultPSViewLayoutPanel() {
        return this.getPSPFStyle().getPFEngineVer() >= 20;
    }

    protected IPSAppViewEngine createDefaultPSAppViewEngine() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6837\u5f0f", codelist="AppUIStyle2")
    public String getViewStyle() {
        String strViewStyle = this.getUIStyle2(false);
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewStyle)) {
            return strViewStyle;
        }
        if (this.getPSSubViewType() != null && !this.isDesignMode()) {
            return this.getPSSubViewType().getTypeCode();
        }
        return this.getUIStyle();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u754c\u9762\u884c\u4e3a\u96c6\u5408", child=true, modeltype="SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction", group="\u89c6\u56fe\u903b\u8f91", order=221, outputdoc="false")
    public Iterator<IPSAppViewUIAction> getPSAppViewUIActions() {
        if (this.psAppViewUIActionList != null) {
            return this.psAppViewUIActionList.iterator();
        }
        return emptyPSAppViewUIActionList.iterator();
    }

    @Override
    public void registerPSAppViewUIAction(IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
        if (this.isEnableUIModelEx()) {
            return;
        }
        if (this.psAppViewUIActionList == null) {
            this.psAppViewUIActionList = new ArrayList();
        }
        if (!this.psAppViewUIActionList.contains(iPSAppViewUIAction)) {
            IPSAppUIAction iPSAppUIAction;
            this.psAppViewUIActionList.add(iPSAppViewUIAction);
            this.registerPSUIAction(iPSAppViewUIAction.getPSUIAction(), iPSAppViewUIAction.getUIActionParamJO());
            if (iPSAppViewUIAction.getPSUIAction() instanceof IPSAppUIAction && (iPSAppUIAction = (IPSAppUIAction)iPSAppViewUIAction.getPSUIAction()).getPSAppCounter() != null && iPSAppViewUIAction.getPSAppCounterRef() == null) {
                String strCounterParamJOString = iPSAppUIAction.getCounterParamJOString();
                JSONObject counterJO = null;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCounterParamJOString)) {
                    counterJO = JSONObjectHelper.fromString2((String)strCounterParamJOString);
                }
                IPSAppCounterRef iPSAppCounterRef = this.registerPSAppCounter(iPSAppUIAction.getPSAppCounter(), counterJO);
                if (iPSAppViewUIAction instanceof IPSAppViewUIActionRuntime) {
                    ((IPSAppViewUIActionRuntime)((Object)iPSAppViewUIAction)).setPSAppCounterRef(iPSAppCounterRef);
                }
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5e03\u5c40\u9762\u677f", child=true)
    public IPSViewLayoutPanel getPSViewLayoutPanel() {
        return this.getPSSysViewLayoutPanel();
    }

    @Override
    public void registerPSLayoutPanel(IPSLayoutPanel iPSLayoutPanel) throws Exception {
        if (this.psLayoutPanelMap == null) {
            this.psLayoutPanelMap = new LinkedHashMap<String, IPSLayoutPanel>();
        }
        this.psLayoutPanelMap.put(iPSLayoutPanel.getName(), iPSLayoutPanel);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u5e03\u5c40\u9762\u677f\u96c6\u5408", outputdoc="false")
    public Iterator<IPSLayoutPanel> getPSLayoutPanels() {
        if (this.psLayoutPanelMap != null) {
            return this.psLayoutPanelMap.values().iterator();
        }
        return emptyPSLayoutPanelMap.values().iterator();
    }

    @Override
    public boolean isRegisterPSLayoutPanel() {
        return this.getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    public void initPreview(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView, PSAppModule psAppModule, int nVersion) throws Exception {
        this.nPreviewVersion = nVersion;
        if (psAppModule == null) {
            psAppModule = new PSAppModule();
            psAppModule.setPSAPPMODULEID("DEMO");
            psAppModule.setPSAPPMODULENAME("DEMO");
            psAppModule.setCODENAME("DEMO");
        }
        PSAppModuleImpl psAppModuleImpl = new PSAppModuleImpl();
        psAppModuleImpl.init(iDAGlobalHelper, iPSApplication, psAppModule);
        this.iPSAppModule = psAppModuleImpl;
        this.init(iDAGlobalHelper, iPSApplication, psApplicationView);
    }

    @Override
    public void setPSPFStyle(IPSPFStyle iPSPFStyle) {
        this.iPSPFStyle = iPSPFStyle;
    }

    @Override
    public boolean isDesignMode() {
        if (this.nPreviewVersion > 0) {
            return true;
        }
        Boolean bRet = designMode.get();
        if (bRet == null) {
            return false;
        }
        return bRet;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u5173\u8054\u89c6\u56fe\uff08\u9012\u5f52\uff09", outputdoc="false")
    public Iterator<IPSAppView> getAllRelatedPSAppViewsEx() throws Exception {
        LinkedHashMap<String, IPSAppView> requireAppViewMap = new LinkedHashMap<String, IPSAppView>();
        ArrayList<IPSAppView> requireViewList = new ArrayList<IPSAppView>();
        requireViewList.add(this);
        requireAppViewMap.put(this.getId(), this);
        while (requireViewList.size() > 0) {
            IPSAppView iPSAppView = (IPSAppView)requireViewList.remove(0);
            ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
            iPSAppView.fillRelatedPSAppViews(psAppViewList);
            for (IPSAppView iPSAppView2 : psAppViewList) {
                if (requireAppViewMap.containsKey(iPSAppView2.getId())) continue;
                requireAppViewMap.put(iPSAppView2.getId(), iPSAppView2);
                requireViewList.add(iPSAppView2);
            }
        }
        requireAppViewMap.remove(this.getId());
        return requireAppViewMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5e94\u7528\u5b9e\u4f53", dumpref=true, fields={"PSAPPLOCALDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
        this.iPSAppDataEntity = iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84\u6570\u91cf", dump=false, outputdoc="false")
    public int getPSAppDERSPathCount() throws Exception {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSAppDERSPathCount();
        }
        return 0;
    }

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int nPathIndex) throws Exception {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSAppDERSPath(nPathIndex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[0]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath0() throws Exception {
        return this.getPSAppDERSPath(0);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[1]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath1() throws Exception {
        return this.getPSAppDERSPath(1);
    }

    @Override
    @PSModelRTMeta(description="\u63a5\u53e3\u5173\u7cfb\u8def\u5f84[2]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath2() throws Exception {
        return this.getPSAppDERSPath(2);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u8def\u5f84[3]", hideempty=true, dump=false, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath3() throws Exception {
        return this.getPSAppDERSPath(3);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84[4]", hideempty=true, outputdoc="false")
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath4() throws Exception {
        return this.getPSAppDERSPath(4);
    }

    @Override
    public String getAppViewParam(String strKey) throws Exception {
        IPSAppViewParam iPSAppViewParam = this.getPSAppViewParam(strKey);
        if (iPSAppViewParam != null) {
            return iPSAppViewParam.getValue();
        }
        return null;
    }

    @Override
    public IPSAppViewParam getPSAppViewParam(String strKey) throws Exception {
        this.getPSAppViewParams();
        if (this.psAppViewParamMap == null) {
            return null;
        }
        return this.psAppViewParamMap.get(strKey);
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSApplication().getDeployId(), (String)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u89c6\u56fe\u903b\u8f91", order=213)
    public Iterator<IPSAppViewNavParam> getPSAppViewNavParams() throws Exception {
        this.getPSAppViewParams();
        if (this.psAppViewNavParamMap == null || this.psAppViewNavParamMap.size() == 0) {
            return null;
        }
        return this.psAppViewNavParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u89c6\u56fe\u903b\u8f91", order=212)
    public Iterator<IPSAppViewNavContext> getPSAppViewNavContexts() throws Exception {
        this.getPSAppViewParams();
        if (this.psAppViewNavContextMap == null || this.psAppViewNavContextMap.size() == 0) {
            return null;
        }
        return this.psAppViewNavContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe\u96c6\u5408", outputdoc="false")
    public Iterator<IPSAppView> getAllEmbeddedPSAppViews() throws Exception {
        Iterator<IPSAppViewRef> psAppViewRefs = this.getEmbeddedPSAppViewRefs("");
        if (psAppViewRefs == null) {
            return null;
        }
        LinkedHashMap<String, IPSAppView> psAppViewMap = new LinkedHashMap<String, IPSAppView>();
        while (psAppViewRefs.hasNext()) {
            IPSAppViewRef iPSAppViewRef = psAppViewRefs.next();
            IPSAppView iPSAppView = iPSAppViewRef.getRefPSAppView();
            if (iPSAppView == null) continue;
            psAppViewMap.put(iPSAppView.getId(), iPSAppView);
        }
        if (psAppViewMap.size() == 0) {
            return null;
        }
        return psAppViewMap.values().iterator();
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
        try {
            LinkedHashMap<String, IPSCodePublisherParam> publisherParamMap = new LinkedHashMap<String, IPSCodePublisherParam>();
            this.fillPSPFCodePublisherParams(publisherParamMap);
            this.iPSPFPubHelp = PSPFViewPubHelpImpl.createPSPFPubHelp(this, publisherParamMap);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return null;
        }
        return this.iPSPFPubHelp;
    }

    @Override
    protected int onGetDynaInstMode() {
        if (this.getDynamicView() != null) {
            if (this.getDynamicView().booleanValue()) {
                if (this.getPSAppDataEntity() != null && this.getPSAppDataEntity().getDynaInstMode() == 2) {
                    return 2;
                }
                return 1;
            }
            return 0;
        }
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getDynaInstMode();
        }
        return 0;
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (this.getDynamicView() != null) {
            return this.getDynamicView() != false;
        }
        return super.onGetEnableDynaModel();
    }

    @Override
    protected String onGetDynaInstTag() {
        if (this.getDynamicView() != null && this.getDynamicView().booleanValue() && this.getPSAppDataEntity() != null && this.getPSAppDataEntity().getDynaInstMode() != 0) {
            return this.getPSAppDataEntity().getDynaInstTag();
        }
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getDynaInstTag();
        }
        return super.onGetDynaInstTag();
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getCodeName();
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        objectNode.put("viewType", this.getViewType());
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strModelRefType) && "APPLICATION".equals(strModelRefType)) {
            if (!this.isPSDEView()) {
                objectNode.put("view", this.getCodeName());
            }
            if (this.getPriority() >= 10) {
                objectNode.put("priority", this.getPriority());
            }
            if (this.getDynaSysMode() > 0) {
                objectNode.put("dynaSysMode", this.getDynaSysMode());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getAccessKey())) {
                objectNode.put("accessKey", this.getAccessKey());
            }
        }
    }

    public static Boolean getCurrentDesignMode() {
        return designMode.get();
    }

    public static void setCurrentDesignMode(Boolean bDesignMode) {
        designMode.set(bDesignMode);
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u4f18\u5148\u7ea7", codelist="AppViewPriority", ignoredumpvalues="-1")
    public int getPriority() {
        if (this.onGetPriority() == null) {
            if (this.getPSApplication().getPSApplicationUI().getDefaultAppViewPriority() != null) {
                return this.getPSApplication().getPSApplicationUI().getDefaultAppViewPriority();
            }
            return -1;
        }
        return this.onGetPriority();
    }

    protected Integer onGetPriority() {
        return this.nPriority;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898\u680f\u5bf9\u8c61")
    public IPSCaptionBar getPSCaptionBar() {
        return this.iPSCaptionBar;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DynaSysMode", ignoredumpvalues="0")
    public int getDynaSysMode() {
        Integer nDynaSysMode = this.onGetDynaSysMode();
        if (nDynaSysMode == null) {
            return 0;
        }
        return nDynaSysMode;
    }

    protected Integer onGetDynaSysMode() {
        ArrayList<IPSControl> psControls = this.getAllPSControls();
        if (psControls != null) {
            for (IPSControl iPSControl : psControls) {
                if (iPSControl.getDynaSysMode() == 0) continue;
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean isEnableUIModelEx() {
        return this.getPSApplication().getPSApplicationUI().isEnableUIModelEx();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (!objectNode.has("modelid") && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getId())) {
            PSAppViewImpl.putJsonProperty(objectNode, "modelid", this.getId());
            PSAppViewImpl.putJsonProperty(objectNode, "modeltype", this.getModelType());
        }
        if (this.getPSViewLayoutPanel() != null && this.getPSViewLayoutPanel().isViewProxyMode()) {
            objectNode.remove("getPSAppCounterRef");
            objectNode.remove("getPSAppCounterRefs");
            objectNode.remove("getPSAppViewEngines");
            objectNode.remove("getPSAppViewLogics");
            objectNode.remove("getPSAppViewRefs");
            objectNode.remove("getPSAppViewUIActions");
            objectNode.remove("getPSControls");
        }
    }
}

