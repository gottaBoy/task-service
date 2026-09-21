/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.IPSAppModule
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppRedirectView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewParam
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 *  net.ibizsys.model.control.titlebar.IPSTitleBar
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.security.IPSSysUniRes
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSViewType
 *  net.ibizsys.paas.control.IControl
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IApplication
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IAjaxActionContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.PSApplicationObjectImpl;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.view.IPSAppRedirectView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewParam;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRefRuntime;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewParamImpl;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.app.view.PSViewAjaxHandlerImpl;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.PSControlParamImpl;
import net.ibizsys.model.control.PSViewProxyControl;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.ajax.counter.IPSSysCounterRefRuntime;
import net.ibizsys.model.control.ajax.counter.PSSysCounterRefImpl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.titlebar.IPSTitleBar;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSDynaAppView;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionRuntime;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppViewImpl
extends PSApplicationObjectImpl
implements IPSAppView,
IPSAppViewRuntime {
    private static final Log log = LogFactory.getLog(PSAppViewImpl.class);
    private static final HashMap<String, IPSSysCounterRef> emptyPSSysCounterRefMap = new HashMap();
    private static final ArrayList<IPSUIAction> emptyPSUIActionList = new ArrayList();
    private static final HashMap<String, IPSSysImage> emptyPSSysImageMap = new HashMap();
    private static final HashMap<String, IPSSysCss> emptyPSSysCssMap = new HashMap();
    private static final HashMap<String, IPSAppFunc> emptyPSAppFuncMap = new HashMap();
    protected PSAppView psApplicationView = null;
    private HashMap<String, IPSControl> psControlMap = new HashMap();
    private HashMap<String, IPSAjaxControl> psControlMap2 = new HashMap();
    protected IPSViewType iPSViewType = null;
    protected HashMap<String, IPSAppViewRef> psAppViewRefMap = new HashMap();
    private HashMap<String, IPSSysCounterRef> psSysCounterRefMap = null;
    private ArrayList<IPSUIAction> psUIActionList = null;
    private HashMap<String, IPSUIAction> psUIActionMap = null;
    private HashMap<String, ObjectNode> psUIActionParamMap = null;
    private HashMap<String, IPSSysImage> psSysImageMap = null;
    private HashMap<String, IPSSysCss> psSysCssMap = null;
    private HashMap<String, IPSAppFunc> psAppFuncMap = null;
    protected HashMap<String, IPSAppViewParam> psAppViewParamMap = null;
    private String strCodeName = "";
    private String strFullCodeName = "";
    private String strBackendUrl = "";
    private boolean bUserRefMode = false;
    private String strCaption = null;
    private String strTitle = null;
    private String strSubCaption = null;
    private Integer nChildControlIndex = 0;
    private Integer nChildViewIndex = 0;
    private String strPageUrl = null;
    private boolean bInited = false;
    private int nAccUserMode = AccessUserModes.UNKNOWN;
    private IPSSysUniRes iPSSysUniRes = null;
    private long nLastModifyTime = 0L;
    private IPSPFStyle iPSPFStyle = null;
    private String strMainMenuAlign = null;
    private Boolean bShowCaptionBar = null;
    private Boolean bSysRefFlag = null;
    private boolean bEnableViewModelDefault = false;
    private IPSSysImage iPSSysImage = null;
    private boolean bCustomViewStyle = false;
    private Boolean bDynamicView = null;
    private IPSTitleBar iPSTitleBar = null;
    private IPSSysCss iPSSysCss = null;
    private IPSAjaxHandler iPSAjaxHandler = null;
    public static final String TITLEBARNAME = "titlebar";
    private int nViewUsage = 0;
    private PSDynaAppView psDynaAppView = null;
    private String strDynaModelContent = null;

    @Override
    public synchronized void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        if (this.bInited) {
            return;
        }
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.psApplicationView = psApplicationView;
            this.setId(this.psApplicationView.getPSAPPVIEWID());
            this.setName(this.psApplicationView.getPSAPPVIEWNAME());
            this.setPSObjectData(this.psApplicationView);
            if (this.psApplicationView.getDYNCMODE()) {
                PSDynaAppView psDynaAppView = new PSDynaAppView();
                CallResult callResult = this.getPSModelQueryHelper().getPSDynaAppView(this.getId(), psDynaAppView);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u89c6\u56fe[%1$s][%2$s]\u52a8\u6001\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.getId(), (Object)this.getName(), (Object)callResult.getErrorInfo()));
                } else {
                    this.psDynaAppView = psDynaAppView;
                }
            }
            this.calcPSAppViewRuntimeInfo();
            this.bUserRefMode = !this.psApplicationView.isUSERREFFLAGNull() ? this.psApplicationView.getUSERREFFLAG() : this.isUserRefModeDefault();
            if (!this.psApplicationView.isSYSREFFLAGNull()) {
                this.bSysRefFlag = this.psApplicationView.getSYSREFFLAG();
            }
            this.strCaption = psApplicationView.getCAPTION();
            this.strTitle = psApplicationView.getTITLE();
            if (!StringHelper.isNullOrEmpty((String)psApplicationView.getSUBCAPTION())) {
                this.strSubCaption = this.psApplicationView.getSUBCAPTION();
            }
            if (this.getPSDynaAppViewData() != null) {
                if (!StringHelper.isNullOrEmpty((String)this.getPSDynaAppViewData().getTITLE())) {
                    this.strTitle = this.getPSDynaAppViewData().getTITLE();
                }
                if (!StringHelper.isNullOrEmpty((String)this.getPSDynaAppViewData().getCAPTION())) {
                    this.strCaption = this.getPSDynaAppViewData().getCAPTION();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psApplicationView.getACCUSERMODE())) {
                this.nAccUserMode = Integer.parseInt(this.psApplicationView.getACCUSERMODE());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psApplicationView.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSApplication().getPSSystem().getPSSysUniRes(this.psApplicationView.getPSSYSUNIRESID());
            }
            if (!psApplicationView.isUPDATEDATENull()) {
                this.nLastModifyTime = psApplicationView.getUPDATEDATE().getTime();
            }
            if (this.getPSDynaAppViewData() != null && !this.getPSDynaAppViewData().isUPDATEDATENull()) {
                this.nLastModifyTime = this.getPSDynaAppViewData().getUPDATEDATE().getTime();
            }
            this.iPSPFStyle = !StringHelper.isNullOrEmpty((String)psApplicationView.getPSPFSTYLEID()) ? this.getPSApplicationRuntime().getPSPFStyle(psApplicationView.getPSPFSTYLEID()) : this.getPSApplicationRuntime().getPSPFStyle();
            if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
                if (!this.psApplicationView.isSHOWCAPTIONBARNull()) {
                    this.bShowCaptionBar = this.psApplicationView.getSHOWCAPTIONBAR();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psApplicationView.getPSSYSIMAGEID())) {
                    this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psApplicationView.getPSSYSIMAGEID());
                    this.registerPSSysImage(this.iPSSysImage);
                }
                if (!StringHelper.isNullOrEmpty((String)this.psApplicationView.getPSSYSCSSID())) {
                    this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psApplicationView.getPSSYSCSSID());
                    this.registerPSSysCss(this.iPSSysCss);
                }
                if (!this.psApplicationView.isENABLEVIEWSTYLENull()) {
                    this.bCustomViewStyle = this.psApplicationView.getENABLEVIEWSTYLE();
                }
                if (!this.psApplicationView.isDYNCMODENull()) {
                    this.bDynamicView = this.psApplicationView.getDYNCMODE();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psApplicationView.getPSACHANDLERID())) {
                    this.iPSAjaxHandler = this.createPSAjaxHandler(this.psApplicationView.getPSACHANDLERID());
                }
            }
            this.bInited = true;
            this.onInit();
        }
        catch (Exception ex) {
            this.bInited = false;
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    protected void calcPSAppViewRuntimeInfo() throws Exception {
        if (this.getPSAppModule() == null) {
            return;
        }
        this.strCodeName = this.psApplicationView.getPSAPPVIEWNAME();
        this.strFullCodeName = String.valueOf(this.getPSAppModule().getCodeName()) + "." + this.strCodeName;
        this.strBackendUrl = this.getPSApplicationRuntime().getPSPF().getPSAppViewBackendUrl(this);
        this.strPageUrl = this.getPSApplicationRuntime().getPSPF().getPSAppViewPageUrl(this);
    }

    @Override
    public synchronized boolean isInited() {
        return this.bInited;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.nViewUsage = this.isPickupView() ? 2 : (this.isEmbeddedView() ? 4 : 1);
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            this.onPreparePSTitleBar();
            this.onPreparePSAppViewRefs();
        }
    }

    protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSystemRuntime().getPSAjaxControlHandlerData(strPSAjaxHandlerId, false);
        PSViewAjaxHandlerImpl iPSAjaxHandlerRuntime = new PSViewAjaxHandlerImpl();
        iPSAjaxHandlerRuntime.init(this.getPSModelStorageContext(), this, psACHandler);
        return this.iPSAjaxHandler;
    }

    protected void onPreparePSAppViewRefs() throws Exception {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final String generateCtrlUniId() {
        boolean bHex = true;
        String curId = "";
        if (StringHelper.length((String)curId) == 0) {
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
            return StringHelper.format((String)"%1$s%2$s", (Object)curId, (Object)(bHex ? Integer.toHexString(this.nChildControlIndex) : PSAppViewImpl.getUniId(this.nChildControlIndex)));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final String generateViewUniId() {
        boolean bHex = true;
        String curId = "";
        if (StringHelper.length((String)curId) == 0) {
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
            return StringHelper.format((String)"%1$s%2$s", (Object)curId, (Object)(bHex ? Integer.toHexString(this.nChildViewIndex) : PSAppViewImpl.getUniId(this.nChildViewIndex)));
        }
    }

    public static String getControlUniId(String strParentId, int nIndex) {
        boolean bHex = true;
        if (StringHelper.length((String)strParentId) == 0) {
            strParentId = "M";
        } else {
            char ch = strParentId.charAt(strParentId.length() - 1);
            if (ch < 'g' || ch > 'z') {
                bHex = false;
            }
        }
        return StringHelper.format((String)"%1$s%2$s", (Object)strParentId, (Object)(bHex ? Integer.toHexString(nIndex) : PSAppViewImpl.getUniId(nIndex)));
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

    @PSModelRTMeta(description="\u89c6\u56fe\u7c7b\u578b", codelist="DEViewType")
    public String getViewType() {
        if (this.getPSViewType() != null) {
            return this.getPSViewType().getId();
        }
        return "UNKNOWN";
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    protected void setCodeName(String strCodeName) {
        this.strCodeName = strCodeName;
    }

    @Override
    public String getFullCodeName() {
        return this.strFullCodeName;
    }

    protected void setFullCodeName(String strFullCodeName) {
        this.strFullCodeName = strFullCodeName;
    }

    public IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception {
        IPSControlTypeRuntime iPSControlType = (IPSControlTypeRuntime)this.getPSModelStorageContext().getPSControlType(strPSCtrlType);
        IPSControl iPSControl = iPSControlType.createPSControl(iPSControlParam);
        ((IPSControlRuntime)iPSControl).init(this.getPSModelStorageContext(), (IPSControlContainer)this, strKey, iPSControlParam);
        this.registerPSControl(strKey, iPSControl);
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerPSControl(String strKey, IPSControl iPSControl) {
        HashMap<String, IPSControl> hashMap = this.psControlMap;
        synchronized (hashMap) {
            this.psControlMap.put(strKey, iPSControl);
            if (iPSControl instanceof IPSAjaxControl) {
                this.psControlMap2.put(strKey, (IPSAjaxControl)iPSControl);
            }
        }
    }

    public IControl getControl(String strControlName) throws Exception {
        return this.getPSControl(strControlName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<IPSControl> getPSControls(String strControlName, int nCount) {
        ArrayList<IPSControl> list = new ArrayList<IPSControl>();
        int i = 0;
        while (i < nCount) {
            String strNewName = StringHelper.format((String)"%1$s%2$s", (Object)strControlName, (Object)(i == 0 ? "" : Integer.valueOf(i)));
            HashMap<String, IPSControl> hashMap = this.psControlMap;
            synchronized (hashMap) {
                IPSControl iPSControl = this.psControlMap.get(strNewName.toLowerCase());
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
    public IPSControl getPSControl(String strControlName) throws Exception {
        strControlName = strControlName.toLowerCase();
        IPSControl iPSControl = null;
        HashMap<String, IPSControl> hashMap = this.psControlMap;
        synchronized (hashMap) {
            iPSControl = this.psControlMap.get(strControlName);
        }
        if (iPSControl == null) {
            throw new Exception(StringHelper.format((String)"\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%2$s]", (Object)this.getFullCodeName(), (Object)strControlName));
        }
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasPSControl(String strControlName) {
        HashMap<String, IPSControl> hashMap = this.psControlMap;
        synchronized (hashMap) {
            return this.psControlMap.containsKey(strControlName.toLowerCase());
        }
    }

    @PSModelRTMeta(description="\u6839\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSControl> getPSControls() {
        return this.psControlMap.values().iterator();
    }

    public Iterator<IPSAjaxControl> getPSAjaxControls() {
        return this.psControlMap2.values().iterator();
    }

    @PSModelRTMeta(description="\u5e94\u7528\u6a21\u5757")
    public IPSAppModule getPSAppModule() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psApplicationView.getPSAPPMODULEID())) {
            return null;
        }
        return this.getPSApplication().getPSAppModule(this.psApplicationView.getPSAPPMODULEID());
    }

    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }

    @Override
    public void setPSViewType(IPSViewType iPSViewType) {
        this.iPSViewType = iPSViewType;
    }

    public AjaxActionResult process(IAjaxActionContext iAjaxActionContext) throws Exception {
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8bf7\u6c42"));
    }

    public IDataEntity getDataEntity() {
        return null;
    }

    public Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception {
        ArrayList<IPSAppView> relatedPSAppViewList = new ArrayList<IPSAppView>();
        this.fillRelatedPSAppViews(relatedPSAppViewList);
        HashMap<String, IPSAppView> relatedPSAppViewMap = new HashMap<String, IPSAppView>();
        for (IPSAppView iPSAppView : relatedPSAppViewList) {
            relatedPSAppViewMap.put(iPSAppView.getId(), iPSAppView);
        }
        return relatedPSAppViewMap.values().iterator();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        this.onFillRelatedPSAppViews(relatedAppViewList);
    }

    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        ArrayList<IPSAppView> relatedAppViewList2 = new ArrayList<IPSAppView>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            try {
                ((IPSControlRuntime)iPSControl).fillRelatedPSAppViews(relatedAppViewList2);
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u586b\u5145\u5173\u8054\u89c6\u56fe\u53d1\u751f\u5f02\u5e38", (Object)this.getName(), (Object)iPSControl.getName()), ex);
            }
        }
        for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
            try {
                if (iPSAppViewRef.getRefPSAppView() == null) continue;
                relatedAppViewList2.add(iPSAppViewRef.getRefPSAppView());
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u89c6\u56fe\u5f15\u7528[%2$s]\u53d1\u751f\u5f02\u5e38", (Object)this.getName(), (Object)iPSAppViewRef.getName()), ex);
            }
        }
        if (this.psUIActionList != null) {
            for (IPSUIAction iPSUIAction : this.psUIActionList) {
                IPSAppView refPSAppView = ((IPSUIActionRuntime)iPSUIAction).getFrontPSAppView(this);
                if (refPSAppView == null) continue;
                relatedAppViewList2.add(refPSAppView);
            }
        }
        for (IPSAppView iPSAppView : relatedAppViewList2) {
            IPSAppRedirectView iPSAppRedirectView;
            Iterator redirectPSAppViews;
            relatedAppViewList.add(iPSAppView);
            if (!(iPSAppView instanceof IPSAppRedirectView) || (redirectPSAppViews = (iPSAppRedirectView = (IPSAppRedirectView)iPSAppView).getRedirectPSAppViews()) == null) continue;
            while (redirectPSAppViews.hasNext()) {
                relatedAppViewList.add((IPSAppView)redirectPSAppViews.next());
            }
        }
    }

    public IApplication getApplication() {
        return this.getPSApplication();
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5bbd\u5ea6")
    public int getWidth() {
        return 0;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u9ad8\u5ea6")
    public int getHeight() {
        return 0;
    }

    public IPSAppView getRefPSAppView(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef.getRefPSAppView();
    }

    public Iterator<IPSAppView> getRefPSAppViews(String strRefMode) throws Exception {
        strRefMode = strRefMode.toUpperCase();
        ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
        for (String strKey : this.psAppViewRefMap.keySet()) {
            if (strKey.indexOf(strRefMode) != 0) continue;
            IPSAppViewRef iPSAppViewRef = this.psAppViewRefMap.get(strKey);
            if (iPSAppViewRef == null) {
                iPSAppViewRef = null;
            }
            if (iPSAppViewRef.getRefPSAppView() == null) continue;
            psAppViewList.add(iPSAppViewRef.getRefPSAppView());
        }
        if (psAppViewList.size() == 0) {
            return null;
        }
        return psAppViewList.iterator();
    }

    @Override
    public IPSAppViewRef registerPSAppViewRef(PSAppViewRef psAppViewRef) throws Exception {
        PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
        ((IPSAppViewRefRuntime)iPSAppViewRef).init(this.getPSModelStorageContext(), this, psAppViewRef);
        this.psAppViewRefMap.put(psAppViewRef.getPSAPPVIEWREFNAME().toUpperCase(), iPSAppViewRef);
        return iPSAppViewRef;
    }

    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList != null) {
            return this.psUIActionList.iterator();
        }
        return emptyPSUIActionList.iterator();
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction, ObjectNode actionParam) throws Exception {
        if (this.psUIActionList == null) {
            this.psUIActionList = new ArrayList();
        }
        if (this.psUIActionMap == null) {
            this.psUIActionMap = new HashMap();
        }
        if (!StringHelper.isNullOrEmpty((String)iPSUIAction.getId())) {
            if (this.psUIActionMap.containsKey(iPSUIAction.getId())) {
                return;
            }
            this.psUIActionMap.put(iPSUIAction.getId(), iPSUIAction);
            if (actionParam != null) {
                if (this.psUIActionParamMap == null) {
                    this.psUIActionParamMap = new HashMap();
                }
                this.psUIActionParamMap.put(iPSUIAction.getId(), actionParam);
            }
        }
        this.psUIActionList.add(iPSUIAction);
        IPSAppView refPSAppView = ((IPSUIActionRuntime)iPSUIAction).getFrontPSAppView(this);
        if (refPSAppView != null) {
            if (StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0 || StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"WFBACKEND", (boolean)true) == 0) {
                this.getPSApplicationRuntime().markPSAppViewUsage(refPSAppView.getId(), 2, this);
            } else if ((StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 || StringHelper.compare((String)iPSUIAction.getUIActionMode(), (String)"WFFRONT", (boolean)true) == 0) && StringHelper.compare((String)iPSUIAction.getFrontProcessType(), (String)"WIZARD", (boolean)true) == 0) {
                this.getPSApplicationRuntime().markPSAppViewUsage(refPSAppView.getId(), 2, this);
            } else {
                this.getPSApplicationRuntime().markPSAppViewUsage(refPSAppView.getId(), 1, this);
            }
        }
        if (iPSUIAction.getNextPSUIAction() != null) {
            this.registerPSUIAction(iPSUIAction.getNextPSUIAction());
        }
    }

    @Override
    public void registerPSUIAction(IPSUIAction iPSUIAction) throws Exception {
        this.registerPSUIAction(iPSUIAction, null);
    }

    public ObjectNode getPSUIActionParamJO(IPSUIAction iPSUIAction) throws Exception {
        if (this.psUIActionParamMap == null) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)iPSUIAction.getId())) {
            return this.psUIActionParamMap.get(iPSUIAction.getId());
        }
        return null;
    }

    public String getLanguage() {
        return "";
    }

    @PSModelRTMeta(description="\u540e\u53f0\u8def\u5f84")
    public String getBackendUrl() {
        return this.strBackendUrl;
    }

    protected void setBackendUrl(String strBackendUrl) {
        this.strBackendUrl = strBackendUrl;
    }

    public Iterator<String> getAppViewRefModes() {
        return this.psAppViewRefMap.keySet().iterator();
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u62ac\u5934")
    public String getTitle() {
        return this.strTitle;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898")
    public String getSubCaption() {
        return this.strSubCaption;
    }

    public String getViewIcon() {
        return "";
    }

    public String getOpenMode() {
        return "";
    }

    public IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception {
        IPSAppViewRef iPSAppViewRef = this.psAppViewRefMap.get(strRefMode.toUpperCase());
        if (iPSAppViewRef == null) {
            if (bTry) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f15\u7528\u89c6\u56fe[%2$s]", (Object)this.getName(), (Object)strRefMode));
        }
        return iPSAppViewRef;
    }

    public String getTitle(IPSAppViewRef iPSAppViewRef) {
        return this.getTitle();
    }

    public String getCaption(IPSAppViewRef iPSAppViewRef) {
        return this.getCaption();
    }

    public String getOpenMode(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef != null && !StringHelper.isNullOrEmpty((String)iPSAppViewRef.getOpenMode())) {
            return iPSAppViewRef.getOpenMode();
        }
        return this.getOpenMode();
    }

    public int getWidth(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef.getWidth() > 0) {
            return iPSAppViewRef.getWidth();
        }
        return this.getWidth();
    }

    public int getHeight(IPSAppViewRef iPSAppViewRef) {
        if (iPSAppViewRef.getHeight() > 0) {
            return iPSAppViewRef.getHeight();
        }
        return this.getHeight();
    }

    public boolean isEnableViewModel() {
        return this.isEnableViewModelDefault();
    }

    protected boolean isEnableViewModelDefault() {
        return this.bEnableViewModelDefault;
    }

    protected void setEnableViewModelDefault(boolean bEnableViewModelDefault) {
        this.bEnableViewModelDefault = bEnableViewModelDefault;
    }

    public String getViewModelUrl() {
        return "";
    }

    public boolean isUserRefMode() {
        return this.bUserRefMode;
    }

    public IPSAppView getPSAppView() {
        return this;
    }

    protected IPSAppViewRuntime getPSAppViewRuntime() {
        return (IPSAppViewRuntime)this.getPSAppView();
    }

    @PSModelRTMeta(description="\u5168\u90e8\u90e8\u4ef6\u96c6\u5408")
    public ArrayList<IPSControl> getAllPSControls() {
        ArrayList<IPSControl> psControlList = new ArrayList<IPSControl>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            psControlList.add(iPSControl);
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerControls((IPSControlContainer)iPSControl, psControlList);
        }
        Collections.sort(psControlList, new Comparator<IPSControl>(){

            @Override
            public int compare(IPSControl arg0, IPSControl arg1) {
                return ((IPSControlRuntime)arg0).getOrderValue() - ((IPSControlRuntime)arg1).getOrderValue();
            }
        });
        return psControlList;
    }

    protected void fillContainerControls(IPSControlContainer iPSControlContainer, ArrayList<IPSControl> psControlList) {
        Iterator psControls = iPSControlContainer.getPSControls();
        while (psControls.hasNext()) {
            IPSControl iPSControl = (IPSControl)psControls.next();
            psControlList.add(iPSControl);
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerControls((IPSControlContainer)iPSControl, psControlList);
        }
    }

    public ArrayList<IPSAjaxControl> getAllPSAjaxControls() {
        ArrayList<IPSAjaxControl> psAjaxControlList = new ArrayList<IPSAjaxControl>();
        for (IPSControl iPSControl : this.psControlMap.values()) {
            if (iPSControl instanceof IPSAjaxControl) {
                psAjaxControlList.add((IPSAjaxControl)iPSControl);
            }
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerAjaxControls((IPSControlContainer)iPSControl, psAjaxControlList);
        }
        Collections.sort(psAjaxControlList, new Comparator<IPSControl>(){

            @Override
            public int compare(IPSControl arg0, IPSControl arg1) {
                return ((IPSControlRuntime)arg0).getOrderValue() - ((IPSControlRuntime)arg1).getOrderValue();
            }
        });
        return psAjaxControlList;
    }

    protected void fillContainerAjaxControls(IPSControlContainer iPSControlContainer, ArrayList<IPSAjaxControl> psAjaxControlList) {
        Iterator psControls = iPSControlContainer.getPSControls();
        while (psControls.hasNext()) {
            IPSControl iPSControl = (IPSControl)psControls.next();
            if (iPSControl instanceof IPSAjaxControl) {
                psAjaxControlList.add((IPSAjaxControl)iPSControl);
            }
            if (!(iPSControl instanceof IPSControlContainer)) continue;
            this.fillContainerAjaxControls((IPSControlContainer)iPSControl, psAjaxControlList);
        }
    }

    @PSModelRTMeta(description="\u63d0\u4f9b\u89c6\u56fe\u5e2e\u52a9")
    public boolean isEnableHelp() {
        return true;
    }

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
            for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                if (StringHelper.isNullOrEmpty((String)iPSAppViewRef.getEmbedId())) continue;
                PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRefImpl.init(this.getPSModelStorageContext(), this, psAppViewRef);
                psAppViewRefImpl.setRefPSAppView(iPSAppViewRef.getRefPSAppView());
                String strFullViewId = "";
                strFullViewId = StringHelper.isNullOrEmpty((String)strContainerId) ? iPSAppViewRef.getEmbedId() : StringHelper.format((String)"%1$s_%2$s", (Object)strContainerId, (Object)iPSAppViewRef.getEmbedId());
                psAppViewRefImpl.setEmbedId(strFullViewId);
                embeddedPSAppViewRefList.add(iPSAppViewRef);
                Iterator subEmbeddedPSAppViewRefs = iPSAppViewRef.getRefPSAppView().getEmbeddedPSAppViewRefs(strFullViewId);
                if (subEmbeddedPSAppViewRefs == null) continue;
                while (subEmbeddedPSAppViewRefs.hasNext()) {
                    embeddedPSAppViewRefList.add((IPSAppViewRef)subEmbeddedPSAppViewRefs.next());
                }
            }
            for (IPSControl iPSControl : this.psControlMap.values()) {
                ((IPSControlRuntime)iPSControl).fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
            }
            HashMap<String, IPSAppViewRef> embeddedPSAppViewRefMap = new HashMap<String, IPSAppViewRef>();
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

    public Iterator<IPSCodeList> getRelatedPSCodeLists(boolean bIncludeEmbed) throws Exception {
        ArrayList<IPSCodeList> relatedPSCodeListList = new ArrayList<IPSCodeList>();
        this.fillRelatedPSCodeLists(relatedPSCodeListList);
        if (bIncludeEmbed) {
            for (IPSAppViewRef iPSAppViewRef : this.psAppViewRefMap.values()) {
                if (StringHelper.isNullOrEmpty((String)iPSAppViewRef.getEmbedId()) || iPSAppViewRef.getRefPSAppView() == null) continue;
                ((IPSAppViewRuntime)iPSAppViewRef.getRefPSAppView()).fillRelatedPSCodeLists(relatedPSCodeListList);
            }
        }
        HashMap<String, IPSCodeList> relatedPSCodeListMap = new HashMap<String, IPSCodeList>();
        for (IPSCodeList iPSCodeList : relatedPSCodeListList) {
            if (relatedPSCodeListMap.containsKey(iPSCodeList.getId())) continue;
            relatedPSCodeListMap.put(iPSCodeList.getId(), iPSCodeList);
        }
        return relatedPSCodeListMap.values().iterator();
    }

    public Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception {
        return this.getRelatedPSCodeLists(true);
    }

    @PSModelRTMeta(description="\u5f15\u7528\u4ee3\u7801\u8868\u96c6\u5408")
    public Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception {
        return this.getRelatedPSCodeLists(false);
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSControl iPSControl : this.psControlMap.values()) {
            ((IPSControlRuntime)iPSControl).fillRelatedPSCodeLists(relatedPSCodeListList);
        }
    }

    public String getPageUrl() {
        return this.strPageUrl;
    }

    protected void setPageUrl(String strPageUrl) {
        this.strPageUrl = strPageUrl;
    }

    @Override
    public IPSSysCounterRef registerPSSysCounter(IPSSysCounter iPSSysCounter, ObjectNode jsonRefMode) throws Exception {
        String strId;
        IPSSysCounterRef iPSSysCounterRef;
        if (this.psSysCounterRefMap == null) {
            this.psSysCounterRefMap = new HashMap();
        }
        if (jsonRefMode == null) {
            jsonRefMode = JsonNodeHelper.createObjectNode();
        }
        if ((iPSSysCounterRef = this.psSysCounterRefMap.get(strId = StringHelper.format((String)"%1$s|%2$s", (Object)iPSSysCounter.getId(), (Object)jsonRefMode.toString()))) == null) {
            iPSSysCounterRef = new PSSysCounterRefImpl();
            ((IPSSysCounterRefRuntime)iPSSysCounterRef).init(this.getPSModelStorageContext(), iPSSysCounter, jsonRefMode);
            this.psSysCounterRefMap.put(strId, iPSSysCounterRef);
        }
        return iPSSysCounterRef;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528\u96c6\u5408")
    public Iterator<IPSSysCounterRef> getPSSysCounterRefs() {
        if (this.psSysCounterRefMap != null) {
            return this.psSysCounterRefMap.values().iterator();
        }
        return emptyPSSysCounterRefMap.values().iterator();
    }

    public synchronized IPSAppViewParam registerPSAppViewParam(String strKey, String strValue, String strDesc) throws Exception {
        if (this.psAppViewParamMap == null) {
            return null;
        }
        strKey = strKey.toUpperCase();
        PSAppViewParamImpl psAppViewParamImpl = new PSAppViewParamImpl();
        psAppViewParamImpl.setKey(strKey);
        psAppViewParamImpl.setValue(strValue);
        psAppViewParamImpl.setDesc(strDesc);
        this.psAppViewParamMap.put(strKey, psAppViewParamImpl);
        return psAppViewParamImpl;
    }

    public synchronized Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception {
        if (this.psAppViewParamMap == null) {
            this.psAppViewParamMap = new HashMap();
            this.onPreparePSAppViewParams();
        }
        return this.psAppViewParamMap.values().iterator();
    }

    protected void onPreparePSAppViewParams() throws Exception {
        for (String strCtrlName : this.psControlMap.keySet()) {
            String strParam = StringHelper.format((String)"%1$s.%2$s", (Object)"UI.CTRL", (Object)strCtrlName);
            this.registerPSAppViewParam(strParam.toUpperCase(), "TRUE", "");
        }
        if (!this.isShowCaptionBar()) {
            this.registerPSAppViewParam("UI.SHOWCAPTIONBAR", "FALSE", "\u4e0d\u663e\u793a\u6807\u9898\u680f");
        }
    }

    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers")
    public int getAccUserMode() {
        return this.nAccUserMode;
    }

    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
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

    public boolean isRedirectView() {
        return false;
    }

    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe")
    public boolean isPSDEView() {
        return false;
    }

    public long getLastModifyTime() {
        return this.nLastModifyTime;
    }

    protected void setLastModifyTime(long nLastModifyTime) {
        this.nLastModifyTime = nLastModifyTime;
    }

    public boolean isMobileView() {
        return false;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5bf9\u8c61\u5f15\u7528")
    public Iterator<IPSAppViewRef> getPSAppViewRefs() {
        return this.psAppViewRefMap.values().iterator();
    }

    public boolean isPickupView() {
        return false;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u662f\u5426\u88ab\u5f15\u7528")
    public boolean getRefFlag() {
        return this.isUserRefMode() || this.getSysRefFlag();
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    public String getMainMenuAlign() {
        return this.strMainMenuAlign;
    }

    public String getTitleLanResTag() {
        return null;
    }

    public String getTitleLanResTag(IPSAppViewRef iPSAppViewRef) {
        return this.getTitleLanResTag();
    }

    public String getCapLanResTag() {
        return null;
    }

    public String getSubCapLanResTag() {
        return null;
    }

    public boolean isShowCaptionBar() {
        if (this.bShowCaptionBar == null) {
            return true;
        }
        return this.bShowCaptionBar;
    }

    public boolean getSysRefFlag() {
        if (this.bSysRefFlag == null) {
            return false;
        }
        return this.bSysRefFlag;
    }

    protected boolean isUserRefModeDefault() {
        return false;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f\u5bf9\u8c61")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    public boolean isCustomViewStyle() {
        return this.bCustomViewStyle;
    }

    @Override
    public void registerPSAppFunc(IPSAppFunc iPSAppFunc) throws Exception {
        if (this.psAppFuncMap == null) {
            this.psAppFuncMap = new HashMap();
        }
        this.psAppFuncMap.put(iPSAppFunc.getId(), iPSAppFunc);
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u5e94\u7528\u529f\u80fd\u96c6\u5408")
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        if (this.psAppFuncMap != null) {
            return this.psAppFuncMap.values().iterator();
        }
        return emptyPSAppFuncMap.values().iterator();
    }

    public int getButtonNoPrivDisplayMode() {
        return this.getPSApplication().getPSApplicationUI().getButtonNoPrivDisplayMode();
    }

    @Override
    public void registerPSSysCss(IPSSysCss iPSSysCss) throws Exception {
        if (this.psSysCssMap == null) {
            this.psSysCssMap = new HashMap();
        }
        this.psSysCssMap.put(iPSSysCss.getId(), iPSSysCss);
    }

    @Override
    public void registerPSSysImage(IPSSysImage iPSSysImage) throws Exception {
        if (this.psSysImageMap == null) {
            this.psSysImageMap = new HashMap();
        }
        this.psSysImageMap.put(iPSSysImage.getId(), iPSSysImage);
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u6837\u5f0f\u8d44\u6e90\u96c6\u5408")
    public Iterator<IPSSysCss> getPSSysCsses() {
        if (this.psSysCssMap != null) {
            return this.psSysCssMap.values().iterator();
        }
        return emptyPSSysCssMap.values().iterator();
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u5f15\u7528\u56fe\u7247\u8d44\u6e90\u96c6\u5408")
    public Iterator<IPSSysImage> getPSSysImages() {
        if (this.psSysImageMap != null) {
            return this.psSysImageMap.values().iterator();
        }
        return emptyPSSysImageMap.values().iterator();
    }

    @PSModelRTMeta(description="\u662f\u5426\u52a8\u6001\u89c6\u56fe")
    public boolean isDynamicView() {
        if (this.getDynamicView() == null) {
            return false;
        }
        return this.getDynamicView();
    }

    protected Boolean getDynamicView() {
        return this.bDynamicView;
    }

    public IPSAjaxHandler getPSAjaxHandler() {
        return this.iPSAjaxHandler;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898\u680f", hideempty=true)
    public IPSTitleBar getPSTitleBar() {
        return this.iPSTitleBar;
    }

    @PSModelRTMeta(description="\u662f\u5426\u4e3a\u5d4c\u5165\u89c6\u56fe")
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

    public boolean testViewUsage(int nViewUsage) {
        return (this.getViewUsage() & nViewUsage) == nViewUsage;
    }

    @PSModelRTMeta(description="\u89c6\u56fe\u4f7f\u7528\u573a\u666f")
    public int getViewUsage() {
        return this.nViewUsage | this.getPSApplicationRuntime().getPSAppViewUsage(this.getId());
    }

    protected void onPreparePSTitleBar() throws Exception {
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSApplicationRuntime().getPSSysModelInstId();
    }

    public IPSDataEntity getPSDataEntity() {
        return null;
    }

    @Override
    public ISystem getSystem() {
        return this.getPSSystem();
    }

    protected PSDynaAppView getPSDynaAppViewData() {
        return this.psDynaAppView;
    }

    public String getDynaModelContent() throws Exception {
        IPSPF iPSPF = ((IPSApplicationRuntime)this.getPSApplication()).getPSPF();
        if (iPSPF.getDynaModelPSPFPubCode() == null) {
            log.error((Object)StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u6846\u67b6\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u6a21\u578b\u53d1\u5e03\u4ee3\u7801\u7c7b\u578b"));
            return "";
        }
        PSViewProxyControl psViewProxyControl = new PSViewProxyControl();
        IPSControlType iPSControlType = this.getPSModelStorageContext().getPSControlType("VIEWPROXY");
        psViewProxyControl.init(this.getPSModelStorageContext(), (IPSControlContainer)this, "proxy", new PSControlParamImpl());
        IPSPFCtrlTempl iPSPFCtrlTempl = this.getPSPFStyle().getPSPFCtrlTempl(iPSControlType, iPSPF.getDynaModelPSPFPubCode());
        if (iPSPFCtrlTempl == null) {
            log.error((Object)StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u6846\u67b6\u6ca1\u6709\u4e3a\u89c6\u56fe\u6307\u5b9a\u6a21\u578b\u6a21\u677f"));
            return "";
        }
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(psViewProxyControl);
        this.strDynaModelContent = iPSGenerateCodeResult.getCode();
        return this.strDynaModelContent;
    }
}

