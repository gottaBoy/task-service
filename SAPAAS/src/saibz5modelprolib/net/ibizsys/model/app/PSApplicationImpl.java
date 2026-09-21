/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSAppModule
 *  net.ibizsys.model.app.IPSAppUtilPage
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.IPSApplicationUI
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppIndexView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IView
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.IPSAppUtilPage;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.IPSApplicationUI;
import net.ibizsys.model.app.PSAppLanGlobalModel;
import net.ibizsys.model.app.PSAppModuleGlobalModel;
import net.ibizsys.model.app.PSAppPDTViewGlobalModel;
import net.ibizsys.model.app.PSAppUtilPageGlobalModel;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.func.PSAppFuncGlobalModel;
import net.ibizsys.model.app.menu.PSAppMenuModelGlobalModel;
import net.ibizsys.model.app.view.IPSAppIndexView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewGlobalModel;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSApplicationImpl
extends PSSystemObjectImpl
implements IPSApplication,
IPSApplicationRuntime,
IPSApplicationUI {
    private static final Log log = LogFactory.getLog(PSApplicationImpl.class);
    protected PSSystemApplication psSystemApplication = null;
    protected PSAppViewGlobalModel psApplicationViewGlobalModel = new PSAppViewGlobalModel();
    protected PSAppModuleGlobalModel psAppModuleGlobalModel = new PSAppModuleGlobalModel();
    protected PSAppFuncGlobalModel psAppFuncGlobalModel = new PSAppFuncGlobalModel();
    protected PSAppMenuModelGlobalModel psAppMenuModelGlobalModel = new PSAppMenuModelGlobalModel();
    protected PSAppUtilPageGlobalModel psAppUtilPageGlobalModel = new PSAppUtilPageGlobalModel();
    protected PSAppLanGlobalModel psAppLanGlobalModel = new PSAppLanGlobalModel();
    protected PSAppPDTViewGlobalModel psAppPDTViewGlobalModel = new PSAppPDTViewGlobalModel();
    private int nLoadedLevel = IPSSystemRuntime.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystemRuntime.LOADLEVEL_NONE;
    private boolean bDefaultFlag = false;
    private IPSPF iPSPF = null;
    private IPSPFStyle iPSPFStyle = null;
    private Properties pfStyleParams = null;
    private boolean bUseServiceApi = false;
    private boolean bMobileApp = false;
    private HashMap<String, IPSPFStyle> psPFStyleMap = new HashMap();
    private String strAppFolder = null;
    private String strMainMenuAlign = "";
    private String strUpdatePSAppViewSysRefFlagSql = "UPDATE T_SRFPSAPPVIEW SET SYSREFFLAG = ? WHERE PSAPPVIEWID=?";
    private String strResetPSAppViewSysRefFlagSql = "UPDATE T_SRFPSAPPVIEW SET SYSREFFLAG = 0 WHERE PSSYSAPPID=? AND SYSREFFLAG IS NULL";
    private boolean bPubSysRefViewOnly = false;
    private boolean bLoading = false;
    private int nButtonNoPrivDisplayMode = 2;
    private IPSAppView defaultPSAppView = null;
    private IPSAppIndexView defaultPSAppIndexView = null;
    private boolean bEnableCol12ToCol24 = false;
    private ArrayList<IPSAppView> refPSAppViewList = null;
    private boolean bAutoAddAppDEView = false;
    private boolean bGridForceFit = false;
    private int nGridRowActiveMode = 2;
    private String strServiceCodeName = null;
    private boolean bEnableUACLogin = false;
    private boolean bPreviewMode = false;
    private HashMap<String, Integer> psAppViewUsageMap = new HashMap();
    private HashMap<String, Long> psAppViewLastModifyTimeMap = new HashMap();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSystemApplication psSystemApplication) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSystemApplication = psSystemApplication;
            this.setId(this.psSystemApplication.getPSSYSAPPID());
            this.setName(this.psSystemApplication.getPSSYSAPPNAME());
            this.setPSObjectData(this.psSystemApplication);
            if (!this.psSystemApplication.isDEFAULTPUBNull()) {
                this.bDefaultFlag = this.psSystemApplication.getDEFAULTPUB();
            }
            this.strAppFolder = this.psSystemApplication.getAPPFOLDER();
            if (StringHelper.isNullOrEmpty((String)this.strAppFolder)) {
                this.strAppFolder = this.getPKGCodeName();
            }
            this.strMainMenuAlign = this.psSystemApplication.getMAINMENUSIDE();
            if (!this.psSystemApplication.isBTNNOPRIVDMNull()) {
                this.nButtonNoPrivDisplayMode = this.psSystemApplication.getBTNNOPRIVDM();
            }
            if (!this.psSystemApplication.isENABLEC12TOC24Null()) {
                this.bEnableCol12ToCol24 = this.psSystemApplication.getENABLEC12TOC24();
            }
            if (!this.psSystemApplication.isPUBREFVIEWONLYNull()) {
                this.bPubSysRefViewOnly = this.psSystemApplication.getPUBREFVIEWONLY();
            }
            if (!this.psSystemApplication.isAUTOADDAPPVIEWNull()) {
                this.bAutoAddAppDEView = this.psSystemApplication.getAUTOADDAPPVIEW();
            }
            if (!this.psSystemApplication.isGRIDFORCEFITNull()) {
                this.bGridForceFit = this.psSystemApplication.getGRIDFORCEFIT();
            }
            if (!this.psSystemApplication.isGRIDROWACTIVEMODENull()) {
                this.nGridRowActiveMode = this.psSystemApplication.getGRIDROWACTIVEMODE();
            }
            if (!this.psSystemApplication.isUACLOGINNull()) {
                this.bEnableUACLogin = this.psSystemApplication.getUACLOGIN();
            }
            this.strServiceCodeName = this.psSystemApplication.getSERVICECODENAME();
            this.iPSPF = this.getPSModelStorageContext().getPSPF(this.psSystemApplication.getPSPFID());
            this.iPSPFStyle = this.iPSPF.getPSPFStyle(this.psSystemApplication.getPSPFSTYLEID());
            this.psAppUtilPageGlobalModel.init(iPSModelStorageContext, this);
            this.psAppLanGlobalModel.init(iPSModelStorageContext, this);
            this.psApplicationViewGlobalModel.init(iPSModelStorageContext, this);
            this.psAppModuleGlobalModel.init(iPSModelStorageContext, this);
            this.psAppFuncGlobalModel.init(iPSModelStorageContext, this);
            this.psAppMenuModelGlobalModel.init(iPSModelStorageContext, this);
            this.psAppPDTViewGlobalModel.init(iPSModelStorageContext, this);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u9ed8\u8ba4\u5e94\u7528")
    public boolean getDefaultFlag() {
        return this.bDefaultFlag;
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    public String getPFType() {
        return this.psSystemApplication.getPSPFID();
    }

    public String getPFStyle() {
        if (this.iPSPFStyle != null) {
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
        IPSAppView iPSAppView = this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, true);
        if (iPSAppView == null && !bTryMode) {
            if (!StringHelper.isNullOrEmpty((String)strOriginViewId)) {
                PSDEViewBase psDEViewBase = new PSDEViewBase();
                CallResult callResult = this.getPSModelQueryHelper().getPSDEViewBase(strOriginViewId, psDEViewBase);
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
        long nLastTime;
        IPSAppView iPSAppView = this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, bTryMode);
        if (iPSAppView != null && (nLastTime = this.getPSAppViewLastModifyTime(iPSAppView.getId())) != -1L && iPSAppView.getLastModifyTime() != nLastTime) {
            this.psApplicationViewGlobalModel.resetModel(strPSApplicationViewId);
            return this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, bTryMode);
        }
        return iPSAppView;
    }

    public IPSAppModule getPSAppModule(String strPSAppModuleId) throws Exception {
        return (IPSAppModule)this.psAppModuleGlobalModel.findModelHelper(strPSAppModuleId);
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u5305\u540d\u79f0")
    public String getPKGCodeName() {
        return this.psSystemApplication.getAPPPKGNAME();
    }

    public String getCodeFolder() {
        return this.psSystemApplication.getCODEFOLDER();
    }

    public IPSAppFunc getPSAppFunc(String strPSAppFuncId) throws Exception {
        return (IPSAppFunc)this.psAppFuncGlobalModel.findModelHelper(strPSAppFuncId);
    }

    public IView getView(String strViewId) throws Exception {
        return this.getPSAppView(strViewId, null);
    }

    @Override
    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u9875\u9762\u96c6\u5408")
    public Iterator<IPSAppUtilPage> getAllPSAppUtilPages() throws Exception {
        return this.psAppUtilPageGlobalModel.getAllModelHelpers();
    }

    public IPSAppUtilPage getPSAppUtilPage(String strPSAppUtilPageId) throws Exception {
        return (IPSAppUtilPage)this.psAppUtilPageGlobalModel.findModelHelper(strPSAppUtilPageId);
    }

    public Object getPFStyleParam(String strKey) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.pfStyleParams, (String)strKey);
    }

    public boolean getPFStyleParam(String strKey, boolean bDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.pfStyleParams, (String)strKey, (boolean)bDefault);
    }

    public String getPFStyleParam(String strKey, String strDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.pfStyleParams, (String)strKey, (String)strDefault);
    }

    public int getPFStyleParam(String strKey, int nDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.pfStyleParams, (String)strKey, (int)nDefault);
    }

    public double getPFStyleParam(String strKey, double fDefault) throws Exception {
        return PropertiesHelper.getProperty((Properties)this.pfStyleParams, (String)strKey, (double)fDefault);
    }

    @PSModelRTMeta(description="\u662f\u5426\u79fb\u52a8\u7aef\u5e94\u7528")
    public boolean isMobileApp() {
        return this.bMobileApp;
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public IPSAppView getPSAppViewByDEViewId(String strPSDEViewId, boolean bTryMode) throws Exception {
        String strPSApplicationViewId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strPSDEViewId);
        IPSAppView iPSAppView = this.psApplicationViewGlobalModel.findModelHelper(strPSApplicationViewId, true);
        if (iPSAppView == null && !bTryMode) {
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEViewBase(strPSDEViewId, psDEViewBase);
            if (callResult.isOk()) {
                String strInfo = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]\uff0c\u8bf7\u786e\u8ba4\u5b9e\u4f53\u89c6\u56fe[%2$s][%3$s]\u5df2\u7ecf\u6dfb\u52a0\u5230\u5e94\u7528[%4$s]\u4e2d", (Object)strPSApplicationViewId, (Object)psDEViewBase.getPSDENAME(), (Object)psDEViewBase.getPSDEVIEWBASENAME(), (Object)this.getName());
                throw new PSApplicationException(this, 40012, strInfo, strPSApplicationViewId, strPSDEViewId);
            }
        }
        return iPSAppView;
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
        HashMap<String, IPSPFStyle> hashMap = this.psPFStyleMap;
        synchronized (hashMap) {
            iPSPFStyle = this.psPFStyleMap.get(strPSPFStyleId);
        }
        if (iPSPFStyle != null) {
            return iPSPFStyle;
        }
        iPSPFStyle = this.getPSPF().getPSPFStyle(strPSPFStyleId);
        hashMap = this.psPFStyleMap;
        synchronized (hashMap) {
            this.psPFStyleMap.put(strPSPFStyleId, iPSPFStyle);
        }
        return iPSPFStyle;
    }

    @PSModelRTMeta(description="\u5e94\u7528\u76ee\u5f55\u540d\u79f0")
    public String getAppFolder() {
        return this.strAppFolder;
    }

    public String getMainMenuAlign() {
        return this.strMainMenuAlign;
    }

    protected void calcRelatedPSAppViews(IPSAppView iPSAppView, HashMap<String, IPSAppView> relatedPSAppViewMap) throws Exception {
        if (relatedPSAppViewMap.containsKey(iPSAppView.getId())) {
            return;
        }
        relatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
        ArrayList<IPSAppView> relatedPSAppViewList = new ArrayList<IPSAppView>();
        ((IPSAppViewRuntime)iPSAppView).fillRelatedPSAppViews(relatedPSAppViewList);
        for (IPSAppView relatedPSAppView : relatedPSAppViewList) {
            this.calcRelatedPSAppViews(relatedPSAppView, relatedPSAppViewMap);
        }
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }

    protected void logPSModelLoadLog(int nLogLevel, String strInfo, Exception exception) {
    }

    public int getButtonNoPrivDisplayMode() {
        return this.nButtonNoPrivDisplayMode;
    }

    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u8bbe\u7f6e")
    public IPSApplicationUI getPSApplicationUI() {
        return this;
    }

    public boolean isEnableCol12ToCol24() {
        return this.bEnableCol12ToCol24;
    }

    public boolean isGridForceFit() {
        return this.bGridForceFit;
    }

    public int getGridRowActiveMode() {
        return this.nGridRowActiveMode;
    }

    @PSModelRTMeta(description="\u542f\u7528\u7edf\u4e00\u8ba4\u8bc1\u767b\u5f55")
    public boolean isEnableUACLogin() {
        return this.bEnableUACLogin;
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

    public String getFormLayoutMode() {
        return "TABLE_24COL";
    }

    public int getEditFormLabelWidth() {
        return 130;
    }

    protected long getPSAppViewLastModifyTime(String strPSAppViewId) throws Exception {
        Long nValue = this.psAppViewLastModifyTimeMap.get(strPSAppViewId);
        if (nValue == null) {
            return -1L;
        }
        return nValue;
    }

    @Override
    protected void onRefreshModelVer() {
        super.onRefreshModelVer();
    }

    @Override
    public IPSAppPDTView getPSAppPDTView(String strPSAppPDTViewId, boolean bTryMode) throws Exception {
        return (IPSAppPDTView)this.psAppPDTViewGlobalModel.findModelHelper(strPSAppPDTViewId, bTryMode);
    }
}

