/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.model.app.view.IPSAppDEWFView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.security.IPSSysUniRes
 *  net.ibizsys.model.view.IPSViewType
 *  net.ibizsys.model.wf.IPSWFInteractiveProcess
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRefRuntime;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewImpl;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.app.view.PSViewAjaxHandlerImpl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlParamRuntime;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerRuntime;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.model.entity.PSDEViewView;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppDEViewImpl
extends PSAppViewImpl
implements IPSAppDEView,
IPSAppDEWFView,
IPSAppDEWFActionView {
    private static final Log log = LogFactory.getLog(PSAppDEViewImpl.class);
    protected static final String PSDEVIEWCTRL_ORIGINNAME = "ORIGINNAME";
    protected String strPSDEViewId = "";
    protected String strPSDEViewName = "";
    protected IPSViewType iPSViewType = null;
    protected PSDEViewBase psViewBase = new PSDEViewBase();
    protected PSDEViewBase psViewBaseTempl = null;
    private IPSDataEntity iPSDataEntity = null;
    private boolean bEnableDP = true;
    protected String strPSAjaxControlId = "";
    private int nTempMode = 0;
    private boolean bWFIAMode = false;
    private String strWFStepValue = "";
    private IPSDEWF iPSWFDE = null;
    private IPSWFVersion iPSWFVersion = null;
    private boolean bEnableViewActions = false;
    private long nViewActions = 0L;
    private String strSubCaption = "";
    private Properties viewParamProperties = null;
    private IPSDEMainState iPSDEMainState = null;
    private int nAccUserMode = AccessUserModes.LOGINUSER;
    private IPSSysUniRes iPSSysUniRes = null;
    private Boolean bShowCaptionBar = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private Boolean bDynamicView = null;
    private IPSAjaxHandler iPSAjaxHandler = null;
    private IPSAppViewRuntime iPSAppDynaDEView = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.setPSDEViewId(psApplicationView.getPSDEVIEWBASEID());
            this.setPSDEViewName(psApplicationView.getPSDEVIEWBASENAME());
            CallResult callResult = this.getPSModelQueryHelper().getPSDEViewBase(this.getPSDEViewId(), this.psViewBase);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getPSDYNADEVIEWTEMPLID())) {
                IPSAppView iPSAppView = this.getPSApplication().getPSAppView(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)this.psViewBase.getPSDYNADEVIEWTEMPLID()), true);
                if (iPSAppView == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u5b9e\u4f53\u5e94\u7528\u89c6\u56fe[%1$s]\uff0c\u8bf7\u786e\u8ba4\u89c6\u56fe\u662f\u5426\u5df2\u7ecf\u52a0\u5165\u5230\u5e94\u7528\u4e2d", (Object)this.psViewBase.getPSDYNADEVIEWTEMPLNAME()));
                }
                this.iPSAppDynaDEView = (IPSAppViewRuntime)iPSAppView;
            }
            if (this.iPSAppDynaDEView != null) {
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getPSDEID())) {
                    this.setPSDataEntity(iPSApplication.getPSSystem().getPSDataEntity(this.psViewBase.getPSDEID(), true));
                    this.logPSModelInfo(0, StringHelper.format((String)"\u7ed1\u5b9a\u5b9e\u4f53[%1$s]", (Object)this.getPSDataEntity().getName()));
                }
                if (this.getPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.psViewBase.getPSDEMAINSTATEID())) {
                    this.iPSDEMainState = this.getPSDataEntity().getPSDEMainState(this.psViewBase.getPSDEMAINSTATEID());
                    this.logPSModelInfo(0, StringHelper.format((String)"\u7ed1\u5b9a\u5b9e\u4f53\u4e3b\u72b6\u6001[%1$s]", (Object)this.iPSDEMainState.getName()));
                }
                if (!this.psViewBase.isTEMPMODENull()) {
                    this.nTempMode = this.psViewBase.getTEMPMODE();
                }
                if (!this.psViewBase.isENABLEVIEWACTIONSNull()) {
                    this.bEnableViewActions = this.psViewBase.getENABLEVIEWACTIONS();
                    if (this.bEnableViewActions) {
                        this.nViewActions = this.psViewBase.getVIEWACTIONS();
                        this.logPSModelInfo(0, StringHelper.format((String)"\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236"));
                    }
                } else if (this.iPSDEMainState != null && this.iPSDEMainState.isEnableViewActions()) {
                    this.bEnableViewActions = true;
                    this.nViewActions = this.iPSDEMainState.getViewActions();
                    this.logPSModelInfo(0, StringHelper.format((String)"\u542f\u52a8\u5b9e\u4f53\u4e3b\u72b6\u6001[%1$s]\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236", (Object)this.iPSDEMainState.getName()));
                }
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getSUBCAPTION())) {
                    this.strSubCaption = this.psViewBase.getSUBCAPTION();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getACCUSERMODE())) {
                    this.nAccUserMode = Integer.parseInt(this.psViewBase.getACCUSERMODE());
                }
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getPSSYSUNIRESID())) {
                    this.iPSSysUniRes = this.getPSApplication().getPSSystem().getPSSysUniRes(this.psViewBase.getPSSYSUNIRESID());
                }
                if (!this.psViewBase.isSHOWCAPTIONBARNull()) {
                    this.bShowCaptionBar = this.psViewBase.getSHOWCAPTIONBAR();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getPSSYSIMAGEID())) {
                    this.iPSSysImage = this.getPSSystem().getPSSysImage(this.psViewBase.getPSSYSIMAGEID());
                    this.registerPSSysImage(this.iPSSysImage);
                }
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getPSSYSCSSID())) {
                    this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psViewBase.getPSSYSCSSID());
                    this.registerPSSysCss(this.iPSSysCss);
                }
                if (!this.psViewBase.isDYNCMODENull()) {
                    this.bDynamicView = this.psViewBase.getDYNCMODE();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getPSACHANDLERID())) {
                    this.iPSAjaxHandler = this.createPSAjaxHandler(this.psViewBase.getPSACHANDLERID());
                }
                this.viewParamProperties = PropertiesHelper.load(null, (String)this.psViewBase.getVIEWPARAMS());
                this.onPrepareWFInfo();
            }
            super.init(this.getPSModelStorageContext(), iPSApplication, psApplicationView);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void calcPSAppViewRuntimeInfo() throws Exception {
        if (this.iPSAppDynaDEView != null) {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("SRFVIEWID", this.getId());
            this.setBackendUrl(this.getPSApplicationRuntime().getPSPF().getPSAppViewBackendUrl(this.iPSAppDynaDEView, params));
            this.setPageUrl(this.getPSApplicationRuntime().getPSPF().getPSAppViewPageUrl(this.iPSAppDynaDEView, params));
            this.setCodeName(this.iPSAppDynaDEView.getCodeName());
            this.setName(this.iPSAppDynaDEView.getCodeName());
            this.setFullCodeName(this.iPSAppDynaDEView.getFullCodeName());
            return;
        }
        super.calcPSAppViewRuntimeInfo();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            this.onPreparePSDEViewCtrls();
        }
        super.onInit();
    }

    @Override
    protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
        PSACHandler psACHandler = null;
        psACHandler = this.getPSDataEntity() == null ? this.getPSSystemRuntime().getPSAjaxControlHandlerData(strPSAjaxHandlerId, false) : this.getPSDataEntityRuntime().getPSAjaxControlHandlerData(strPSAjaxHandlerId);
        PSViewAjaxHandlerImpl iPSAjaxHandler = new PSViewAjaxHandlerImpl();
        ((IPSAjaxHandlerRuntime)iPSAjaxHandler).init(this.getPSModelStorageContext(), this, psACHandler);
        return iPSAjaxHandler;
    }

    protected BaseDataEntity createRealViewDataEntity() {
        return new PSDEViewBase();
    }

    protected BaseDataEntity createRealViewTemplDataEntity() {
        return new PSDEViewBase();
    }

    protected void onPreparePSDEViewCtrls() throws Exception {
        Vector<PSDEViewCtrl> psDEViewCtrlList = new Vector<PSDEViewCtrl>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEViewCtrls(this.getPSDEViewId(), psDEViewCtrlList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u89c6\u56fe\u5173\u8054\u90e8\u4ef6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEViewCtrl> psDEViewCtrlMap = new HashMap<String, PSDEViewCtrl>();
        for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
            String strName;
            if (!psDEViewCtrl.isVALIDFLAGNull() && !psDEViewCtrl.getVALIDFLAG()) continue;
            String strOriginName = strName = psDEViewCtrl.getPSDEVIEWCTRLNAME();
            String[] names = strName.split("[.]");
            strName = names[0];
            psDEViewCtrl.setPSDEVIEWCTRLNAME(strName);
            psDEViewCtrl.set(PSDEVIEWCTRL_ORIGINNAME, strOriginName);
            strName = strName.toLowerCase();
            PSDEViewCtrl lastPSDEViewCtrl = psDEViewCtrlMap.get(strName);
            if (lastPSDEViewCtrl != null) {
                if (StringHelper.compare((String)psDEViewCtrl.getPSPFID(), (String)((IPSApplicationRuntime)this.getPSApplication()).getPSPF().getId(), (boolean)true) != 0) continue;
                psDEViewCtrlMap.put(strName, psDEViewCtrl);
                continue;
            }
            if (!StringHelper.isNullOrEmpty((String)psDEViewCtrl.getPSPFID()) && StringHelper.compare((String)psDEViewCtrl.getPSPFID(), (String)((IPSApplicationRuntime)this.getPSApplication()).getPSPF().getId(), (boolean)true) != 0) continue;
            psDEViewCtrlMap.put(strName, psDEViewCtrl);
        }
        this.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlMap.values()) {
            this.registerPSDEViewCtrl(psDEViewCtrl);
        }
    }

    protected IPSControl registerPSDEViewCtrl(PSDEViewCtrl psDEViewCtrl) throws Exception {
        try {
            this.logPSModelInfo(0, StringHelper.format((String)"\u6ce8\u518c\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6[%1$s][%2$s]", (Object)psDEViewCtrl.getPSDEVIEWCTRLNAME(), (Object)psDEViewCtrl.get(PSDEVIEWCTRL_ORIGINNAME)));
            IPSControlTypeRuntime iPSControlType = (IPSControlTypeRuntime)this.getPSModelStorageContext().getPSControlType(psDEViewCtrl.getPSDEVIEWCTRLTYPE());
            IPSControlParamRuntime iPSControlParam = (IPSControlParamRuntime)iPSControlType.createPSControlParam(psDEViewCtrl);
            iPSControlParam.init(this.getPSModelStorageContext(), this, psDEViewCtrl);
            IPSControl iPSControl = this.registerPSControl(psDEViewCtrl.getPSDEVIEWCTRLNAME().toLowerCase(), psDEViewCtrl.getPSDEVIEWCTRLTYPE(), iPSControlParam);
            return iPSControl;
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u6ce8\u518c\u5b9e\u4f53\u89c6\u56fe\u63a7\u4ef6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDEViewCtrl.getPSDEVIEWCTRLNAME(), (Object)ex.getMessage()), ex);
        }
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        super.onPreparePSAppViewRefs();
        this.logPSModelInfo(0, StringHelper.format((String)"\u5f00\u59cb\u52a0\u8f7d\u5b9e\u4f53\u5e94\u7528\u89c6\u56fe\u5f15\u7528\u89c6\u56fe"));
        Vector<PSDEViewView> psDEViewViewList = new Vector<PSDEViewView>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEViewViews(this.getPSDEViewId(), psDEViewViewList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEViewView psDEViewView : psDEViewViewList) {
            PSDEViewBase pdtViewBase;
            String strRefMode = psDEViewView.getPSDEVIEWRVNAME().toUpperCase();
            if (this.psAppViewRefMap.containsKey(strRefMode)) {
                this.logPSModelInfo(0, StringHelper.format((String)"\u5f15\u7528\u89c6\u56fe\u5df2\u5b58\u5728\u6a21\u5f0f[%1$s]\uff0c\u5ffd\u7565", (Object)strRefMode));
                continue;
            }
            String strMinorPSDEViewId = psDEViewView.getMINORPSDEVIEWID();
            if (StringHelper.isNullOrEmpty((String)strMinorPSDEViewId) && !StringHelper.isNullOrEmpty((String)psDEViewView.getDEFVIEWTYPE()) && (pdtViewBase = this.getPSDataEntityRuntime().getPSDEViewDataByPDT(psDEViewView.getDEFVIEWTYPE(), true)) != null) {
                strMinorPSDEViewId = pdtViewBase.getPSDEVIEWBASEID();
            }
            if (StringHelper.isNullOrEmpty((String)strMinorPSDEViewId)) continue;
            String strPSAppDEViewId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)strMinorPSDEViewId);
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(psDEViewView.getPSDEVIEWRVNAME().toUpperCase());
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.setOPENMODE(psDEViewView.getOPENMODE());
            psAppViewRef.set("MINORPSDEVIEWBASEID", strMinorPSDEViewId);
            PSAppViewRefImpl iPSAppViewRef = new PSAppViewRefImpl();
            ((IPSAppViewRefRuntime)iPSAppViewRef).init(this.getPSModelStorageContext(), this, psAppViewRef);
            this.psAppViewRefMap.put(psDEViewView.getPSDEVIEWRVNAME().toUpperCase(), iPSAppViewRef);
        }
    }

    @Override
    public String getViewType() {
        return this.iPSViewType.getId();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
        this.iPSDataEntity = iPSDataEntity;
    }

    protected IPSDataEntityRuntime getPSDataEntityRuntime() {
        return (IPSDataEntityRuntime)this.getPSDataEntity();
    }

    public String getPSDEViewId() {
        return this.strPSDEViewId;
    }

    public String getPSDEViewName() {
        return this.strPSDEViewName;
    }

    protected void setPSDEViewId(String strPSDEViewId) {
        this.strPSDEViewId = strPSDEViewId;
    }

    protected void setPSDEViewName(String strPSDEViewName) {
        this.strPSDEViewName = strPSDEViewName;
    }

    @Override
    public void setPSViewType(IPSViewType iPSViewType) {
        this.iPSViewType = iPSViewType;
    }

    @Override
    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return this.bEnableDP;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    public String getPSAjaxControlHandlerId() {
        return this.strPSAjaxControlId;
    }

    protected void setPSAjaxControlHandlerId(String strPSAjaxControlId) {
        this.strPSAjaxControlId = strPSAjaxControlId;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u62ac\u5934")
    public String getTitle() {
        String strTitle = super.getTitle();
        if (StringHelper.isNullOrEmpty((String)strTitle) && StringHelper.isNullOrEmpty((String)(strTitle = this.psViewBase.getTITLE()))) {
            return this.psViewBase.getPSDEVIEWBASENAME();
        }
        return strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898")
    public String getCaption() {
        String strCaption = super.getCaption();
        if (StringHelper.isNullOrEmpty((String)strCaption) && StringHelper.isNullOrEmpty((String)(strCaption = this.psViewBase.getCAPTION()))) {
            return this.getPSDataEntity().getLogicName(this.getLanguage());
        }
        return strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898")
    public String getSubCaption() {
        if (StringHelper.isNullOrEmpty((String)this.strSubCaption)) {
            return super.getSubCaption();
        }
        return this.strSubCaption;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bbd\u5ea6")
    public int getWidth() {
        if (this.psViewBase.getWIDTH() > 0) {
            return this.psViewBase.getWIDTH();
        }
        return super.getWidth();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u9ad8\u5ea6")
    public int getHeight() {
        if (this.psViewBase.getHEIGHT() > 0) {
            return this.psViewBase.getHEIGHT();
        }
        return super.getHeight();
    }

    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode")
    public int getTempMode() {
        return this.nTempMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6a21\u5f0f", codelist="DEViewOpenMode")
    public String getOpenMode() {
        return this.psViewBase.getOPENMODE();
    }

    public boolean isEnableWF() {
        return false;
    }

    protected void onPrepareWFInfo() throws Exception {
        this.iPSWFDE = !StringHelper.isNullOrEmpty((String)this.psViewBase.getPSWFDEID()) ? this.getPSDataEntity().getPSDEWF(this.psViewBase.getPSWFDEID()) : this.getPSDataEntity().getDefaultPSDEWF();
        if (this.getPSDEWF() != null) {
            this.iPSWFVersion = !StringHelper.isNullOrEmpty((String)this.psViewBase.getPSWFVERSIONID()) ? this.getPSDEWF().getPSWorkflow().getPSWFVersion(this.psViewBase.getPSWFVERSIONID()) : this.getPSDEWF().getPSWorkflow().getLastPSWFVersion();
        }
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true)
    public IPSDEWF getPSDEWF() {
        return this.iPSWFDE;
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61", hideempty=true)
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true)
    public IPSWorkflow getPSWorkflow() {
        if (this.getPSDEWF() == null) {
            return null;
        }
        return this.getPSDEWF().getPSWorkflow();
    }

    public boolean isWFIAMode() {
        return this.bWFIAMode;
    }

    protected void setWFIAMode(boolean bWFIAMode) {
        this.bWFIAMode = bWFIAMode;
    }

    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    protected void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }

    protected boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    protected long getViewActions() {
        return this.nViewActions;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u5e2e\u52a9")
    public boolean isEnableHelp() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x200L) > 0L;
        }
        return super.isEnableHelp();
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (this.viewParamProperties != null) {
            for (Object objKey : this.viewParamProperties.keySet()) {
                this.registerPSAppViewParam(objKey.toString(), PropertiesHelper.getProperty((Properties)this.viewParamProperties, (String)objKey.toString()), "");
            }
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers")
    public int getAccUserMode() {
        if (super.getAccUserMode() != AccessUserModes.UNKNOWN.intValue()) {
            return super.getAccUserMode();
        }
        return this.nAccUserMode;
    }

    @Override
    protected IPSSysUniRes getPSSysUniRes() {
        if (super.getPSSysUniRes() != null) {
            return super.getPSSysUniRes();
        }
        return this.iPSSysUniRes;
    }

    @Override
    protected String getDefaultAccessKey() {
        if ((this.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0) {
            return StringHelper.format((String)"DEDATA:%1$s:READ", (Object)this.getDataEntity().getName().toUpperCase());
        }
        return super.getDefaultAccessKey();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe")
    public boolean isPSDEView() {
        return true;
    }

    @Override
    public String getModelType() {
        return "PSAPPDEVIEW";
    }

    protected String getPDTParamPre() {
        return this.psViewBase.getPDTPARAMPRE();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f")
    public boolean isShowCaptionBar() {
        if (this.bShowCaptionBar == null) {
            return super.isShowCaptionBar();
        }
        return this.bShowCaptionBar;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() != null) {
            return super.getPSSysImage();
        }
        if (this.iPSSysImage != null) {
            return this.iPSSysImage;
        }
        return this.getPSDataEntity().getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f\u5bf9\u8c61")
    public IPSSysCss getPSSysCss() {
        if (super.getPSSysCss() != null) {
            return super.getPSSysCss();
        }
        if (this.iPSSysCss != null) {
            return this.iPSSysCss;
        }
        return null;
    }

    @Override
    protected Boolean getDynamicView() {
        Boolean bRet = super.getDynamicView();
        if (bRet != null) {
            return bRet;
        }
        return this.bDynamicView;
    }

    @Override
    protected void onPreparePSTitleBar() throws Exception {
        super.onPreparePSTitleBar();
        if (super.getPSTitleBar() != null) {
            return;
        }
    }

    public IPSWFInteractiveProcess getPSWFInteractiveProcess() {
        return null;
    }

    @Override
    public IPSAjaxHandler getPSAjaxHandler() {
        IPSAjaxHandler iPSAjaxHandler = super.getPSAjaxHandler();
        if (iPSAjaxHandler != null) {
            return iPSAjaxHandler;
        }
        return this.iPSAjaxHandler;
    }

    @Override
    public boolean isDynamicView() {
        if (this.iPSAppDynaDEView != null) {
            return true;
        }
        return super.isDynamicView();
    }
}

