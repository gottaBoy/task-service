/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IViewWizardGroup
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEViewPlugin;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPlugin;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewEngineImpl;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.App.View.PSViewAjaxHandlerImpl;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSDEViewEngine;
import SA.SRFDA.PS.Data.PSDEViewLogic;
import SA.SRFDA.PS.Data.PSDEViewView;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizardGroup;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEViewImpl
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
    private String strWFUtilType = "";
    private IPSDEWF iPSWFDE = null;
    private IPSWFVersion iPSWFVersion = null;
    private IPSAppWF iPSAppWF = null;
    private IPSAppWFVer iPSAppWFVer = null;
    private boolean bEnableViewActions = false;
    private long nViewActions = 0L;
    private String strSubCaption = "";
    private Properties viewParamProperties = null;
    private IPSDEMainState iPSDEMainState = null;
    private int nAccUserMode = AccessUserModes.LOGINUSER;
    private IPSSysUniRes iPSSysUniRes = null;
    private IPSViewMsgGroup iPSViewMsgGroup = null;
    private IPSDEActionWizardGroup iPSDEActionWizardGroup = null;
    private IPSLanguageRes titlePSLanguageRes = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes subCapPSLanguageRes = null;
    private String strPSHelpModuleId = null;
    private Boolean bShowCaptionBar = null;
    private Boolean bDynamicView = null;
    private Integer nPriority = null;
    private IPSAjaxHandler iPSAjaxHandler = null;
    private IPSDER1N iPSDER1N = null;
    private Map<Integer, ArrayList<IPSAppDERS>> psAppDERSPathMap = null;
    private String[] SYNCFIELDS = new String[]{"MEMO", "USERCAT", "USERTAG", "USERTAG2", "USERTAG3", "USERTAG4"};
    private IPSAppCounter iPSAppCounter = null;
    private IPSSysCounterRef iPSSysCounterRef = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.setPSDEViewId(psApplicationView.getPSDEVIEWBASEID());
            this.setPSDEViewName(psApplicationView.getPSDEVIEWBASENAME());
            CallResult callResult = this.getPSModelHelper().getPSDEViewBase(this.getPSDEViewId(), this.psViewBase);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getTEMPLPSDEVIEWID())) {
                this.psViewBaseTempl = new PSDEViewBase();
                callResult = this.getPSModelHelper().getPSDEViewBase(this.psViewBase.getTEMPLPSDEVIEWID(), this.psViewBaseTempl);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            this.strPSHelpModuleId = this.psViewBase.getPSHELPMODULEID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psApplicationView.getPSSYSDYNAMODELID())) {
                psApplicationView.setPSSYSDYNAMODELID(this.psViewBase.getPSSYSDYNAMODELID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSDEID())) {
                this.setPSDataEntity(iPSApplication.getPSSystem().getPSDataEntity2(this.psViewBase.getPSDEID()));
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSDERID())) {
                this.iPSDER1N = this.getPSApplication().getPSSystem().getPSDER1N(this.psViewBase.getPSDERID());
            }
            if (this.getPSDataEntity() != null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSDEMAINSTATEID())) {
                    this.iPSDEMainState = this.getPSDataEntity().getPSDEMainState(this.psViewBase.getPSDEMAINSTATEID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSDEAWGROUPID())) {
                    this.iPSDEActionWizardGroup = this.getPSDataEntity().getPSDEActionWizardGroup(this.psViewBase.getPSDEAWGROUPID());
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSHelpModuleId)) {
                    this.strPSHelpModuleId = this.getPSDataEntity().getPSHelpModuleId();
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSVIEWMSGGROUPID())) {
                this.iPSViewMsgGroup = this.getPSApplication().getPSAppViewMsgGroup(this.psViewBase.getPSVIEWMSGGROUPID());
            }
            if (!this.psViewBase.isTEMPMODENull()) {
                this.nTempMode = this.psViewBase.getTEMPMODE();
            }
            if (!this.psViewBase.isENABLEVIEWACTIONSNull()) {
                this.bEnableViewActions = this.psViewBase.getENABLEVIEWACTIONS();
                if (this.bEnableViewActions) {
                    this.nViewActions = this.psViewBase.getVIEWACTIONS();
                }
            } else if (this.iPSDEMainState != null && this.iPSDEMainState.isEnableViewActions()) {
                this.bEnableViewActions = true;
                this.nViewActions = this.iPSDEMainState.getViewActions();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getSUBCAPTION())) {
                this.strSubCaption = this.psViewBase.getSUBCAPTION();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getACCUSERMODE())) {
                this.nAccUserMode = Integer.parseInt(this.psViewBase.getACCUSERMODE());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSApplication().getPSSystem().getPSSysUniRes(this.psViewBase.getPSSYSUNIRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getTITLEPSLANRESID())) {
                this.titlePSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psViewBase.getTITLEPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psViewBase.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getSUBCAPPSLANRESID())) {
                this.subCapPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psViewBase.getSUBCAPPSLANRESID());
            }
            if (!this.psViewBase.isSHOWCAPTIONBARNull()) {
                this.bShowCaptionBar = this.psViewBase.getSHOWCAPTIONBAR();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psApplicationView.getPSSYSIMAGEID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSYSIMAGEID())) {
                psApplicationView.setPSSYSIMAGEID(this.psViewBase.getPSSYSIMAGEID());
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psApplicationView.getPSSYSCSSID()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSYSCSSID())) {
                psApplicationView.setPSSYSCSSID(this.psViewBase.getPSSYSCSSID());
            }
            String[] stringArray = this.SYNCFIELDS;
            int n = this.SYNCFIELDS.length;
            int n2 = 0;
            while (n2 < n) {
                String strSyncField = stringArray[n2];
                String strValue = psApplicationView.getParamStringValue(strSyncField, null);
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strValue = this.psViewBase.getParamStringValue(strSyncField, null)))) {
                    psApplicationView.set(strSyncField, strValue);
                }
                ++n2;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSYSCOUNTERID())) {
                this.iPSAppCounter = this.getPSApplication().getPSAppCounter(this.psViewBase.getPSSYSCOUNTERID(), false);
                JSONObject refModeObj = new JSONObject();
                this.iPSSysCounterRef = this.registerPSAppCounter(this.iPSAppCounter, refModeObj);
            }
            if (!this.psViewBase.isDYNCMODENull() && this.psViewBase.getDYNCMODE() >= 10) {
                this.nPriority = this.psViewBase.getDYNCMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSACHANDLERID())) {
                this.iPSAjaxHandler = this.createPSAjaxHandler(this.psViewBase.getPSACHANDLERID());
            }
            this.viewParamProperties = PropertiesHelper.Load(null, (String)this.psViewBase.getVIEWPARAMS());
            this.onPrepareWFInfo();
            super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
        }
        catch (Exception ex) {
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
    protected void onInit() throws Exception {
        int nRSCount;
        IPSAppDEViewPlugin iPSAppDEViewPlugin;
        if (!this.psViewBase.isUPDATEDATENull() && (this.psApplicationView.isUPDATEDATENull() || this.psApplicationView.getUPDATEDATE().getTime() < this.psViewBase.getUPDATEDATE().getTime())) {
            String strLastModifyTime = DateHelper.toDateTimeString((Date)this.psViewBase.getUPDATEDATE());
            this.setLastModifyTimeStr(strLastModifyTime);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSYSPFPLUGINID())) {
            this.setPSSysPFPlugin(this.getPSApplication().getPSSysPFPlugin(this.psViewBase.getPSSYSPFPLUGINID(), "APPVIEW", this.getViewType(), null));
        }
        if (this.getPSSubViewType() == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSUBVIEWTYPEID())) {
            IPSSubViewType iPSSubViewType = this.getPSApplication().getPSSubViewType(this.psViewBase.getPSSUBVIEWTYPEID(), this.getViewType());
            this.setPSSubViewType(iPSSubViewType);
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSSYSPFPLUGINID()) && iPSSubViewType.getPSSysPFPlugin() != null) {
                this.setPSSysPFPlugin(this.getPSApplication().getPSSysPFPlugin(iPSSubViewType.getPSSysPFPlugin().getId(), "APPVIEW", this.getViewType(), null));
            }
        }
        if (this.getPSAppDataEntity() == null && this.getPSDataEntity() != null) {
            this.setPSAppDataEntity(this.getPSApplication().getPSAppDataEntityByDEId(this.getPSDataEntity().getId(), true));
        }
        if ((iPSAppDEViewPlugin = this.getPSAppDEViewPlugin()) == null || !iPSAppDEViewPlugin.preparePSDEViewCtrls(this)) {
            this.onPreparePSDEViewCtrls();
        }
        super.onInit();
        if (this.getPSDER1N() != null && this.getPSAppDataEntity() != null && (nRSCount = this.getPSAppDataEntity().getPSAppDERSPathCount()) > 0) {
            LinkedHashMap<Integer, ArrayList<IPSAppDERS>> psAppDERSPathMap = new LinkedHashMap<Integer, ArrayList<IPSAppDERS>>();
            int i = 0;
            while (i < nRSCount) {
                Iterator<? extends IPSAppDERS> psAppDERSs;
                IPSAppDERS iPSAppDERS = this.getPSAppDataEntity().getPSAppDERSPathLast(i);
                if (iPSAppDERS != null && iPSAppDERS.getPSDER1N() != null && SA.SRFramework.Utility.StringHelper.Compare((String)iPSAppDERS.getPSDER1N().getId(), (String)this.getPSDER1N().getId(), (boolean)false) == 0 && (psAppDERSs = this.getPSAppDataEntity().getPSAppDERSPath(i)) != null) {
                    ArrayList<IPSAppDERS> list = new ArrayList<IPSAppDERS>();
                    while (psAppDERSs.hasNext()) {
                        list.add(psAppDERSs.next());
                    }
                    psAppDERSPathMap.put(psAppDERSPathMap.size(), list);
                }
                ++i;
            }
            if (nRSCount != psAppDERSPathMap.size()) {
                this.psAppDERSPathMap = psAppDERSPathMap;
            }
        }
        if (iPSAppDEViewPlugin == null || !iPSAppDEViewPlugin.preparePSDEViewLogics(this)) {
            this.onPreparePSDEViewLogics();
        }
        this.onPreparePSDEViewEngines();
    }

    @Override
    protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
        PSACHandler psACHandler = null;
        psACHandler = this.getPSDataEntity() == null ? this.getPSSystem().getPSAjaxControlHandlerData(strPSAjaxHandlerId, false) : this.getPSDataEntity().getPSAjaxControlHandlerData(strPSAjaxHandlerId);
        PSViewAjaxHandlerImpl iPSAjaxHandler = new PSViewAjaxHandlerImpl();
        iPSAjaxHandler.init(this.getDAGlobalHelper(), this, psACHandler);
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
        CallResult callResult = this.getPSModelHelper().getPSDEViewCtrls(this.getPSDEViewId(), psDEViewCtrlList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u5173\u8054\u90e8\u4ef6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
                if (!this.isPrepareDefaultPSAppViewLogics()) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewCtrl.getPSPFID(), (String)this.getPSApplication().getPSPF().getId(), (boolean)true) != 0) continue;
                    psDEViewCtrlMap.put(strName, psDEViewCtrl);
                    continue;
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSPFID()) && SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewCtrl.getPSPFID(), (String)this.getPSApplication().getPSPF().getId(), (boolean)true) != 0 || !this.replacePSDEViewCtrl(psDEViewCtrl, lastPSDEViewCtrl)) continue;
                psDEViewCtrlMap.put(strName, psDEViewCtrl);
                continue;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEViewCtrl.getPSPFID()) && SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewCtrl.getPSPFID(), (String)this.getPSApplication().getPSPF().getId(), (boolean)true) != 0 || names.length != 1 && (names.length != 2 || SA.SRFramework.Utility.StringHelper.Compare((String)names[1], (String)this.getPSApplication().getPKGCodeName(), (boolean)true) != 0)) continue;
            psDEViewCtrlMap.put(strName, psDEViewCtrl);
        }
        this.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    protected boolean replacePSDEViewCtrl(PSDEViewCtrl curPSDEViewCtrl, PSDEViewCtrl lastPSDEViewCtrl) throws Exception {
        String strCurName = curPSDEViewCtrl.getParamStringValue(PSDEVIEWCTRL_ORIGINNAME, "");
        String strLastName = lastPSDEViewCtrl.getParamStringValue(PSDEVIEWCTRL_ORIGINNAME, "");
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCurName)) {
            throw new Exception("\u5f53\u524d\u90e8\u4ef6\u540d\u79f0\u4e0d\u80fd\u4e3a\u7a7a");
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLastName)) {
            throw new Exception("\u6e90\u90e8\u4ef6\u540d\u79f0\u4e0d\u80fd\u4e3a\u7a7a");
        }
        String[] curnames = strCurName.split("[.]");
        String[] lastnames = strLastName.split("[.]");
        if (SA.SRFramework.Utility.StringHelper.Compare((String)curPSDEViewCtrl.getPSPFID(), (String)lastPSDEViewCtrl.getPSPFID(), (boolean)false) == 0) {
            if (lastnames.length >= 2 && SA.SRFramework.Utility.StringHelper.Compare((String)lastnames[1], (String)this.getPSApplication().getPKGCodeName(), (boolean)true) == 0) {
                return false;
            }
            if (curnames.length >= 2 && SA.SRFramework.Utility.StringHelper.Compare((String)curnames[1], (String)this.getPSApplication().getPKGCodeName(), (boolean)true) == 0) {
                return true;
            }
            return curnames.length < lastnames.length;
        }
        return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)curPSDEViewCtrl.getPSPFID());
    }

    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlMap.values()) {
            this.registerPSDEViewCtrl(psDEViewCtrl);
        }
    }

    protected IPSControl registerPSDEViewCtrl(PSDEViewCtrl psDEViewCtrl) throws Exception {
        try {
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(psDEViewCtrl.getPSDEVIEWCTRLTYPE());
            IPSControlParam iPSControlParam = iPSControlType.createPSControlParam(psDEViewCtrl);
            iPSControlParam.init(this.getDAGlobalHelper(), this, psDEViewCtrl);
            IPSControl iPSControl = this.registerPSControl(psDEViewCtrl.getPSDEVIEWCTRLNAME().toLowerCase(), psDEViewCtrl.getPSDEVIEWCTRLTYPE(), iPSControlParam);
            return iPSControl;
        }
        catch (Exception ex) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ce8\u518c\u5b9e\u4f53\u89c6\u56fe\u63a7\u4ef6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psDEViewCtrl.getPSDEVIEWCTRLNAME(), (Object)ex.getMessage()), ex);
        }
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        super.onPreparePSAppViewRefs();
        Vector<PSDEViewView> psDEViewViewList = new Vector<PSDEViewView>();
        CallResult callResult = this.getPSModelHelper().getPSDEViewViews(this.getPSDEViewId(), psDEViewViewList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEViewView psDEViewView : psDEViewViewList) {
            PSDEViewBase pdtViewBase;
            String strRefMode = psDEViewView.getPSDEVIEWRVNAME().toUpperCase();
            if (this.getPSAppViewRef(strRefMode, true) != null) continue;
            String strMinorPSDEViewId = psDEViewView.getMINORPSDEVIEWID();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMinorPSDEViewId) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEViewView.getDEFVIEWTYPE()) && (pdtViewBase = this.getPSDataEntity().getPSDEViewDataByPDT(psDEViewView.getDEFVIEWTYPE(), true)) != null) {
                strMinorPSDEViewId = pdtViewBase.getPSDEVIEWBASEID();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMinorPSDEViewId)) continue;
            String strPSAppDEViewId = Helper.GenUniqueId((String)this.getPSApplication().getId(), (String)strMinorPSDEViewId);
            PSAppViewRef psAppViewRef = new PSAppViewRef();
            psAppViewRef.setPSAPPVIEWREFNAME(psDEViewView.getPSDEVIEWRVNAME().toUpperCase());
            psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
            psAppViewRef.setOPENMODE(psDEViewView.getOPENMODE());
            psAppViewRef.setUSERTAG(psDEViewView.getUSERTAG());
            psAppViewRef.setUSERTAG2(psDEViewView.getUSERTAG2());
            psAppViewRef.setVIEWPARAMS(psDEViewView.getVIEWPARAMS());
            psAppViewRef.set("MINORPSDEVIEWBASEID", strMinorPSDEViewId);
            this.registerPSAppViewRef(psAppViewRef);
        }
    }

    protected String getPSDEUILogicGroupId() {
        return this.psViewBase.getPSCTRLLOGICGROUPID();
    }

    /*
     * Unable to fully structure code
     */
    protected void onPreparePSDEViewLogics() throws Exception {
        block12: {
            psDEViewLogicList = new Vector<PSDEViewLogic>();
            callResult = this.getPSModelHelper().getPSDEViewLogics(this.getPSDEViewId(), psDEViewLogicList);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            map = new LinkedHashMap<String, IPSModelObject>();
            for (PSDEViewLogic psDEViewLogic : psDEViewLogicList) {
                if (!psDEViewLogic.isVALIDFLAGNull() && !psDEViewLogic.getVALIDFLAG()) continue;
                try {
                    psAppDEViewLogicImpl = new PSAppDEViewLogicImpl();
                    psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this, psDEViewLogic);
                    this.registerPSAppViewLogic(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
                    map.put(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
                }
                catch (Exception ex) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ce8\u518c\u89c6\u56fe[%1$s]\u903b\u8f91[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getPSAppView().getName(), (Object)psDEViewLogic.getPSDEVIEWLOGICNAME(), (Object)ex.getMessage()), ex);
                }
            }
            psAppDEUILogicGroupDetails = null;
            strPPSDEUILogicGroupId = this.getPSDEUILogicGroupId();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPPSDEUILogicGroupId)) break block12;
            if (this.getPSAppDataEntity() == null) {
                PSAppDEViewImpl.log.warn((Object)String.format("\u89c6\u56fe[%1$s]\u5e94\u7528\u5b9e\u4f53\u65e0\u6548\uff0c\u65e0\u6cd5\u52a0\u8f7d\u90e8\u4ef6\u903b\u8f91\u7ec4", new Object[]{this.getName()}));
                return;
            }
            list = new ArrayList<IPSAppDEUILogicGroup>();
            while (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPPSDEUILogicGroupId)) {
                parent = this.getPSAppDataEntity().getPSAppDEUILogicGroup(strPPSDEUILogicGroupId);
                if (list.contains(parent)) {
                    throw new Exception(String.format("\u754c\u9762\u903b\u8f91\u7ec4[%1$s]\u51fa\u73b0\u9012\u5f52\u5f15\u7528", new Object[]{parent.getFullName()}));
                }
                list.add(parent);
                strPPSDEUILogicGroupId = parent.getParentPSDEUILogicGroupId();
            }
            for (IPSAppDEUILogicGroup item : list) {
                psAppDEUILogicGroupDetails = item.getPSAppDEUILogicGroupDetails();
                if (psAppDEUILogicGroupDetails != null) ** GOTO lbl74
                continue;
lbl-1000:
                // 1 sources

                {
                    iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                    strName = iPSAppDEUILogicGroupDetail.getName();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strName) || map.containsKey(strName = strName.toLowerCase())) continue;
                    map.put(strName, iPSAppDEUILogicGroupDetail);
                    psDEViewLogic = new PSDEViewLogic();
                    psDEViewLogic.setPSDEVIEWBASEID(this.getPSDEViewId());
                    psDEViewLogic.setPSDEVIEWBASENAME(this.getPSDEViewName());
                    psDEViewLogic.setVALIDFLAG(true);
                    psDEViewLogic.setPSDEVIEWLOGICID(iPSAppDEUILogicGroupDetail.getId());
                    psDEViewLogic.setPSDEVIEWLOGICNAME(strName);
                    psDEViewLogic.setDSTLOGICTYPE(iPSAppDEUILogicGroupDetail.getLogicType());
                    psDEViewLogic.setPSDEVIEWLOGICTYPE(iPSAppDEUILogicGroupDetail.getTriggerType());
                    psDEViewLogic.setPSDEVIEWCTRLNAME(iPSAppDEUILogicGroupDetail.getCtrlName());
                    psDEViewLogic.setITEMNAME(iPSAppDEUILogicGroupDetail.getItemName());
                    psDEViewLogic.setATTRNAME(iPSAppDEUILogicGroupDetail.getAttrName());
                    psDEViewLogic.setLOGICPARAM(iPSAppDEUILogicGroupDetail.getLogicTag());
                    psDEViewLogic.setLOGICPARAM2(iPSAppDEUILogicGroupDetail.getLogicTag2());
                    psDEViewLogic.setCUSTOMCODE(iPSAppDEUILogicGroupDetail.getScriptCode());
                    psDEViewLogic.setTIMER(iPSAppDEUILogicGroupDetail.getTimer());
                    psDEViewLogic.setEVENTNAMES(iPSAppDEUILogicGroupDetail.getEventNames());
                    psDEViewLogic.setEVENTARG(iPSAppDEUILogicGroupDetail.getEventArg());
                    psDEViewLogic.setEVENTARG2(iPSAppDEUILogicGroupDetail.getEventArg2());
                    if (iPSAppDEUILogicGroupDetail.getPSDataEntity() != null) {
                        psDEViewLogic.setPSDEID(iPSAppDEUILogicGroupDetail.getPSDataEntity().getId());
                    }
                    psDEViewLogic.setPSSYSVIEWLOGICID(iPSAppDEUILogicGroupDetail.getPSSysViewLogicId());
                    psDEViewLogic.setPSDEUIACTIONID(iPSAppDEUILogicGroupDetail.getPSDEUIActionId());
                    psDEViewLogic.setPSDELOGICID(iPSAppDEUILogicGroupDetail.getPSDEUILogicId());
                    psDEViewLogic.setPSSYSVIEWPANELID(iPSAppDEUILogicGroupDetail.getPSSysViewPanelId());
                    try {
                        psAppDEViewLogicImpl = new PSAppDEViewLogicImpl();
                        psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this, psDEViewLogic);
                        this.registerPSAppViewLogic(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
                        map.put(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
                        continue;
                    }
                    catch (Exception ex) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ce8\u518c\u89c6\u56fe[%1$s]\u903b\u8f91[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getPSAppView().getName(), (Object)psDEViewLogic.getPSDEVIEWLOGICNAME(), (Object)ex.getMessage()), ex);
                    }
lbl74:
                    // 3 sources

                    ** while (psAppDEUILogicGroupDetails.hasNext())
                }
lbl75:
                // 1 sources

            }
        }
    }

    protected void onPreparePSDEViewEngines() throws Exception {
        Iterator<IPSControl> psControls;
        Vector<PSDEViewEngine> psDEViewEngineList = new Vector<PSDEViewEngine>();
        CallResult callResult = this.getPSModelHelper().getPSDEViewEngines(this.getPSDEViewId(), psDEViewEngineList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEViewEngine psDEViewEngine : psDEViewEngineList) {
            if (!psDEViewEngine.isVALIDFLAGNull() && !psDEViewEngine.getVALIDFLAG()) continue;
            try {
                PSAppDEViewEngineImpl psAppDEViewEngineImpl = new PSAppDEViewEngineImpl();
                psAppDEViewEngineImpl.init(this.getDAGlobalHelper(), this, psDEViewEngine);
                this.registerPSAppViewEngine(psDEViewEngine.getPSDEVIEWENGINENAME().toLowerCase(), psAppDEViewEngineImpl);
            }
            catch (Exception ex) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ce8\u518c\u89c6\u56fe[%1$s]\u754c\u9762\u5f15\u64ce[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getPSAppView().getName(), (Object)psDEViewEngine.getPSDEVIEWLOGICNAME(), (Object)ex.getMessage()), ex);
            }
        }
        if (this.isPrepareDefaultPSAppViewEngines() && (psControls = this.getPSControls()) != null) {
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                try {
                    IPSControl refPSControl;
                    IPSUIEngineType iPSUIEngineType;
                    String strUIEngineType;
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControl.getInstallUIEngine())) {
                        strUIEngineType = String.format("CTRL_%1$s", iPSControl.getInstallUIEngine());
                        iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(strUIEngineType, true);
                        if (iPSUIEngineType != null) {
                            refPSControl = iPSControl.getRefPSControl();
                            this.installPSControlUIEngine(iPSControl, refPSControl, iPSControl.getInstallUIEngine(), iPSUIEngineType, "default", 100);
                        }
                    }
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSControl.getInstallUIEngine2())) continue;
                    strUIEngineType = String.format("CTRL_%1$s", iPSControl.getInstallUIEngine2());
                    iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(strUIEngineType, true);
                    if (iPSUIEngineType == null) continue;
                    refPSControl = iPSControl.getRefPSControl2();
                    this.installPSControlUIEngine(iPSControl, refPSControl, iPSControl.getInstallUIEngine2(), iPSUIEngineType, "default2", 200);
                }
                catch (Exception ex) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ce8\u518c\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u9ed8\u8ba4\u754c\u9762\u5f15\u64ce\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.getPSAppView().getName(), (Object)iPSControl.getName(), (Object)ex.getMessage()), ex);
                }
            }
        }
    }

    protected void installPSControlUIEngine(IPSControl iPSControl, IPSControl refPSControl, String strRefUsage, IPSUIEngineType iPSUIEngineType, String strTag, int nOrder) throws Exception {
        PSDEViewEngine psDEViewEngine = new PSDEViewEngine();
        String strEngineName = String.format("engine_%1$s_%2$s", iPSControl.getName(), strTag).toLowerCase();
        psDEViewEngine.setPSDEVIEWENGINEID(strEngineName);
        psDEViewEngine.setPSDEVIEWENGINENAME(strEngineName);
        psDEViewEngine.setPSUIENGINETYPEID(iPSUIEngineType.getId());
        psDEViewEngine.setORDERVALUE(nOrder + iPSControl.getOrderValue());
        psDEViewEngine.setPSDEVIEWCTRLNAME(iPSControl.getName());
        if (refPSControl != null) {
            psDEViewEngine.setNO2PSDEVIEWCTRLNAME(refPSControl.getName());
        }
        PSAppDEViewEngineImpl psAppDEViewEngineImpl = new PSAppDEViewEngineImpl();
        psAppDEViewEngineImpl.init(this.getDAGlobalHelper(), this, psDEViewEngine);
        this.registerPSAppViewEngine(psDEViewEngine.getPSDEVIEWENGINENAME().toLowerCase(), psAppDEViewEngineImpl);
    }

    @Override
    protected String onGetViewType() {
        return this.iPSViewType.getId();
    }

    @Override
    protected String onGetCodeName() {
        if (this.isEnableUIModelEx() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getDEVIEWTAG2())) {
            return this.psViewBase.getDEVIEWTAG2();
        }
        if (this.isEnableUIModelEx() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSApplication().getViewCodeNameMode()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSApplication().getViewCodeNameMode(), (String)"NONE", (boolean)false) != 0 && (this.psApplicationView.isSYNCCODENAMENull() || this.psApplicationView.getSYNCCODENAME()) && this.getPSAppDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getCODENAME())) {
            return this.getPSApplication().getViewCodeName(null, this.getPSAppDataEntity().getCodeName(), this.psViewBase.getCODENAME());
        }
        return super.onGetCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
        this.iPSDataEntity = iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6", fields={"PSDEVIEWBASEID"})
    public String getPSDEViewId() {
        return this.strPSDEViewId;
    }

    @Override
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

    @Override
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
    @PSModelRTMeta(description="\u89c6\u56fe\u62ac\u5934", fields={"TITLE"}, doc="\u4f18\u5148\u4f7f\u7528\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u6807\u9898{@link net.ibizsys.centralstudio.dto.PSAppDEViewDTO#TAG_TITLE}")
    public String getTitle() {
        String strTitle = super.getTitle();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strTitle) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strTitle = this.psViewBase.getTITLE()))) {
            return this.psViewBase.getPSDEVIEWBASENAME();
        }
        return strTitle;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6807\u9898", group="\u57fa\u672c", order=120, fields={"CAPTION"}, doc="\u4f18\u5148\u4f7f\u7528\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u6807\u9898{@link net.ibizsys.centralstudio.dto.PSAppDEViewDTO#TAG_CAPTION}")
    public String getCaption() {
        String strCaption = super.getCaption();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCaption) && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strCaption = this.psViewBase.getCAPTION()))) {
            return this.getPSDataEntity().getLogicName(this.getLanguage());
        }
        return strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5b50\u6807\u9898", fields={"SUBCAPTION"})
    public String getSubCaption() {
        String strSubCaption = super.getSubCaption();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strSubCaption)) {
            return this.strSubCaption;
        }
        return strSubCaption;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u5bbd\u5ea6", ignoredumpvalues="0", outputdoc="(%1$s.getWidth() gt 0)", fields={"WIDTH"})
    public int getWidth() {
        if (this.psViewBase.getWIDTH() > 0) {
            return this.psViewBase.getWIDTH();
        }
        return super.getWidth();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u9ad8\u5ea6", ignoredumpvalues="0", outputdoc="(%1$s.getHeight() gt 0)", fields={"HEIGHT"})
    public int getHeight() {
        if (this.psViewBase.getHEIGHT() > 0) {
            return this.psViewBase.getHEIGHT();
        }
        return super.getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", ignoredumpvalues="0", fields={"TEMPMODE"})
    public int getTempMode() {
        return this.nTempMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6a21\u5f0f", codelist="DEViewOpenMode", fields={"OPENMODE"})
    public String getOpenMode() {
        return this.psViewBase.getOPENMODE();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5de5\u4f5c\u6d41", ignoredumpvalues="false")
    public boolean isEnableWF() {
        return false;
    }

    protected void onPrepareWFInfo() throws Exception {
        this.iPSWFDE = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSWFDEID()) ? this.getPSDataEntity().getPSDEWF(this.psViewBase.getPSWFDEID()) : this.getPSDataEntity().getDefaultPSDEWF();
        if (this.getPSDEWF() != null) {
            this.iPSWFVersion = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSWFVERSIONID()) ? this.getPSDEWF().getPSWorkflow().getPSWFVersion(this.psViewBase.getPSWFVERSIONID()) : this.getPSDEWF().getPSWorkflow().getLastPSWFVersion();
        }
        if (this.getPSWorkflow() != null) {
            this.iPSAppWF = this.getPSApplication().getPSAppWF(this.getPSWorkflow().getId(), true);
        }
        if (this.getPSWFVersion() != null) {
            this.iPSAppWFVer = this.getPSApplication().getPSAppWFVer(this.getPSWFVersion().getId(), true);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true, ignorepf=true)
    public IPSDEWF getPSDEWF() {
        return this.iPSWFDE;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true)
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true)
    public IPSWorkflow getPSWorkflow() {
        if (this.getPSDEWF() == null) {
            return null;
        }
        return this.getPSDEWF().getPSWorkflow();
    }

    @Override
    public boolean isWFIAMode() {
        return this.bWFIAMode;
    }

    protected void setWFIAMode(boolean bWFIAMode) {
        this.bWFIAMode = bWFIAMode;
    }

    @Override
    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    protected void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }

    @Override
    public String getWFUtilType() {
        return this.strWFUtilType;
    }

    protected void setWFUtilType(String strWFUtilType) {
        this.strWFUtilType = strWFUtilType;
    }

    protected boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    protected long getViewActions() {
        return this.nViewActions;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5e2e\u52a9", dump=false)
    public boolean isEnableHelp() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x200L) > 0L;
        }
        return super.isEnableHelp();
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        IPSAppDataEntity majorPSAppDataEntity;
        if (this.getPSDER1N() != null && (majorPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDER1N().getMajorPSDataEntity(), true)) != null) {
            this.registerPSAppViewParam(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s", (Object)"SRFNAVCTX.", (Object)majorPSAppDataEntity.getName()), "%SRFPARENTKEY%", "\u7236\u952e\u503c\u8f6c\u5316\u4e3a\u5bfc\u822a\u4e0a\u4e0b\u6587\u5173\u7cfb\u4e3b\u5b9e\u4f53\u952e\u503c");
        }
        if (this.viewParamProperties != null) {
            for (Object objKey : this.viewParamProperties.keySet()) {
                this.registerPSAppViewParam(objKey.toString(), PropertiesHelper.GetProperty((Properties)this.viewParamProperties, (String)objKey.toString()), "");
            }
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers", fields={"ACCUSERMODE"})
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
            return SA.SRFramework.Utility.StringHelper.Format((String)"DEDATA:%1$s:READ", (Object)this.getDataEntity().getName().toUpperCase());
        }
        return super.getDefaultAccessKey();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", dump=false)
    public boolean isPSDEView() {
        return true;
    }

    @Override
    public int getExtendMode() {
        return 0;
    }

    @Override
    public String getModelType() {
        return "PSAPPDEVIEW";
    }

    protected String getPDTParamPre() {
        return this.psViewBase.getPDTPARAMPRE();
    }

    @Override
    public IPSDEActionWizardGroup getPSDEActionWizardGroup() {
        return this.iPSDEActionWizardGroup;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u7ec4", hideempty=true)
    public IPSViewMsgGroup getPSViewMsgGroup() {
        if (super.getPSViewMsgGroup() != null) {
            return super.getPSViewMsgGroup();
        }
        return this.iPSViewMsgGroup;
    }

    @Override
    public IViewWizardGroup getViewWizardGroup() {
        if (super.getViewWizardGroup() != null) {
            return super.getViewWizardGroup();
        }
        return this.getPSDEActionWizardGroup();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934\u8bed\u8a00\u8d44\u6e90", fields={"TITLEPSLANRESID"})
    public IPSLanguageRes getTitlePSLanguageRes() {
        if (super.getTitlePSLanguageRes() != null) {
            return super.getTitlePSLanguageRes();
        }
        return this.titlePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (super.getCapPSLanguageRes() != null) {
            return super.getCapPSLanguageRes();
        }
        if (this.capPSLanguageRes == null) {
            return this.getPSDataEntity().getLNPSLanguageRes();
        }
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"SUBCAPPSLANRESID"})
    public IPSLanguageRes getSubCapPSLanguageRes() {
        if (super.getSubCapPSLanguageRes() != null) {
            return super.getSubCapPSLanguageRes();
        }
        return this.subCapPSLanguageRes;
    }

    @Override
    public String getPSHelpModuleId() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)super.getPSHelpModuleId())) {
            return super.getPSHelpModuleId();
        }
        return this.strPSHelpModuleId;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f", ignoredumpvalues="true", fields={"SHOWCAPTIONBAR"})
    public boolean isShowCaptionBar() {
        if (this.bShowCaptionBar == null) {
            return super.isShowCaptionBar();
        }
        return this.bShowCaptionBar;
    }

    @Override
    protected void logPSModelIssue(PSSysIssue psSysIssueV3) throws Exception {
        psSysIssueV3.setPSOBJ2ID(this.getPSDEViewId());
        psSysIssueV3.setPSOBJ2NAME(this.getPSDEViewName());
        super.logPSModelIssue(psSysIssueV3);
    }

    @Override
    protected IPSAppViewPlugin createPSAppViewPlugin() throws Exception {
        IPSViewEngine iPSViewEngine;
        IPSAppViewPlugin iPSAppViewPlugin = super.createPSAppViewPlugin();
        if (iPSAppViewPlugin != null) {
            return iPSAppViewPlugin;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewBase.getPSVIEWENGINEID()) && SA.SRFramework.Utility.StringHelper.Compare((String)(iPSViewEngine = this.getPSModelStorage().getPSViewEngine(this.psViewBase.getPSVIEWENGINEID())).getEngineType(), (String)"PLUGIN", (boolean)false) == 0) {
            iPSAppViewPlugin = (IPSAppViewPlugin)ObjectHelper.Create((String)iPSViewEngine.getEngineObj());
            return iPSAppViewPlugin;
        }
        return null;
    }

    protected IPSAppDEViewPlugin getPSAppDEViewPlugin() {
        if (this.getPSAppViewPlugin() != null && this.getPSAppViewPlugin() instanceof IPSAppDEViewPlugin) {
            return (IPSAppDEViewPlugin)this.getPSAppViewPlugin();
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

    @Override
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
    protected String getPSSysViewLayoutPanelId() {
        String strPSSysViewLayoutPanelId = super.getPSSysViewLayoutPanelId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysViewLayoutPanelId)) {
            strPSSysViewLayoutPanelId = this.psViewBase.getPSSYSVIEWPANELID();
        }
        return strPSSysViewLayoutPanelId;
    }

    @Override
    protected IPSAppViewEngine createDefaultPSAppViewEngine() throws Exception {
        IPSUIEngineType iPSUIEngineType = null;
        if (this.getPSSubViewType() != null && this.getPSSubViewType().isExtendCtrl()) {
            iPSUIEngineType = this.getPSSubViewType().getPSUIEngineType();
        }
        if (iPSUIEngineType == null) {
            iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(this.getViewType(), true);
        }
        if (iPSUIEngineType == null) {
            return null;
        }
        PSDEViewEngine psDEViewEngine = new PSDEViewEngine();
        psDEViewEngine.setPSDEVIEWENGINEID("engine");
        psDEViewEngine.setPSDEVIEWENGINENAME("engine");
        psDEViewEngine.setPSUIENGINETYPEID(this.getViewType());
        psDEViewEngine.setORDERVALUE(0);
        Iterator<String> engineParams = iPSUIEngineType.getEngineParamNames();
        if (engineParams != null) {
            while (engineParams.hasNext()) {
                IPSAppViewLogic iPSAppViewLogic;
                IPSControl iPSControl;
                String strKey = engineParams.next();
                String strValue = iPSUIEngineType.getEngineParamKey(strKey);
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue)) continue;
                if (strValue.indexOf("PSDEVIEWCTRLNAME") != -1) {
                    if (!this.hasPSControl(strKey)) continue;
                    iPSControl = this.getPSControl(strKey);
                    psDEViewEngine.set(strValue, iPSControl.getName());
                    continue;
                }
                if (strValue.indexOf("PSDEVIEWLOGICNAME") != -1) {
                    iPSAppViewLogic = this.getPSAppViewLogic(strKey.toLowerCase(), true);
                    if (iPSAppViewLogic == null) continue;
                    psDEViewEngine.set(strValue, iPSAppViewLogic.getName());
                    continue;
                }
                if (strValue.indexOf("CTRLNAME") != -1) {
                    if (!this.hasPSControl(strKey)) continue;
                    iPSControl = this.getPSControl(strKey);
                    psDEViewEngine.set(strValue.replace("CTRLNAME", "PSDEVIEWCTRLNAME"), iPSControl.getName());
                    continue;
                }
                if (strValue.indexOf("LOGICNAME") == -1 || (iPSAppViewLogic = this.getPSAppViewLogic(strKey.toLowerCase(), true)) == null) continue;
                psDEViewEngine.set(strValue.replace("LOGICNAME", "PSDEVIEWLOGICNAME"), iPSAppViewLogic.getName());
            }
        }
        psDEViewEngine.setVIEWPARAM(this.psViewBase.getVIEWPARAM());
        psDEViewEngine.setVIEWPARAM2(this.psViewBase.getVIEWPARAM2());
        psDEViewEngine.setVIEWPARAM3(this.psViewBase.getVIEWPARAM3());
        psDEViewEngine.setVIEWPARAM4(this.psViewBase.getVIEWPARAM4());
        psDEViewEngine.setVIEWPARAM5(this.psViewBase.getVIEWPARAM5());
        psDEViewEngine.setVIEWPARAM6(this.psViewBase.getVIEWPARAM6());
        psDEViewEngine.setVIEWPARAM7(this.psViewBase.getVIEWPARAM7());
        psDEViewEngine.setVIEWPARAM8(this.psViewBase.getVIEWPARAM8());
        psDEViewEngine.setVIEWPARAM9(this.psViewBase.getVIEWPARAM9());
        psDEViewEngine.setVIEWPARAM10(this.psViewBase.getVIEWPARAM10());
        psDEViewEngine.setWFVIEWPARAM(this.psViewBase.getWFVIEWPARAM());
        psDEViewEngine.setWFVIEWPARAM2(this.psViewBase.getWFVIEWPARAM2());
        psDEViewEngine.setWFVIEWPARAM3(this.psViewBase.getWFVIEWPARAM3());
        psDEViewEngine.setWFVIEWPARAM4(this.psViewBase.getWFVIEWPARAM4());
        PSAppDEViewEngineImpl psAppDEViewEngineImpl = new PSAppDEViewEngineImpl();
        psAppDEViewEngineImpl.init(this.getDAGlobalHelper(), this, iPSUIEngineType, psDEViewEngine);
        return psAppDEViewEngineImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u89c6\u56fe\u4ee3\u7801\u540d\u79f0")
    public String getPSDEViewCodeName() {
        return this.psViewBase.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u89c6\u56fe\u63a7\u5236\u5173\u7cfb")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5e94\u7528\u5b9e\u4f53", dumpref=true, ignorert=3)
    public IPSAppDataEntity getParentPSAppDataEntity() throws Exception {
        if (this.getPSDER1N() != null) {
            return this.getPSApplication().getPSAppDataEntity(this.getPSDER1N().getMajorPSDataEntity(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u8def\u5f84\u6570\u91cf", dump=false)
    public int getPSAppDERSPathCount() throws Exception {
        if (this.psAppDERSPathMap != null) {
            return this.psAppDERSPathMap.size();
        }
        return super.getPSAppDERSPathCount();
    }

    @Override
    public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int nPathIndex) throws Exception {
        if (this.psAppDERSPathMap != null) {
            ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
        return super.getPSAppDERSPath(nPathIndex);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41", hideempty=true, dumpref=true, from="IPSApplication")
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c", hideempty=true, dumpref=true, from="__self__", from_method="getPSAppWFMust().getPSAppWFVer")
    public IPSAppWFVer getPSAppWFVer() {
        return this.iPSAppWFVer;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u89c6\u56fe\u6a21\u5f0f", codelist="PredefinedViewType", hideempty2=true)
    public String getFuncViewMode() {
        return this.psViewBase.getPREDEFINEVIEWTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u89c6\u56fe\u53c2\u6570", hideempty2=true)
    public String getFuncViewParam() {
        return this.psViewBase.getPDVTPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668", hideempty=true)
    public IPSSysCounter getPSSysCounter() {
        return this.iPSAppCounter;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, from="__self__")
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
    protected Integer onGetPriority() {
        if (super.onGetPriority() != null) {
            return super.onGetPriority();
        }
        if (this.nPriority == null && "DESUBAPPREFVIEW".equalsIgnoreCase(this.getViewType())) {
            return 100;
        }
        return this.nPriority;
    }

    @Override
    protected void onPreparePSAppViewEngines() throws Exception {
    }

    @Override
    protected void onPreparePSAppViewLogics() throws Exception {
    }

    @Override
    public void registerPSAppViewLogic(String strKey, IPSAppViewLogic iPSAppViewLogic) throws Exception {
        super.registerPSAppViewLogic(strKey, iPSAppViewLogic);
    }

    @Override
    protected Integer onGetDynaSysMode() {
        return super.onGetDynaSysMode();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        int nCount = this.getPSAppDERSPathCount();
        if (nCount > 0) {
            ArrayNode arrayNode = objectNode.putArray("getPSAppDERSPaths");
            int i = 0;
            while (i < nCount) {
                Iterator<? extends IPSAppDERS> psAppDERSs = this.getPSAppDERSPath(i);
                if (psAppDERSs != null) {
                    ArrayNode subArray = arrayNode.addArray();
                    while (psAppDERSs.hasNext()) {
                        IPSAppDERS iPSAppDERS = psAppDERSs.next();
                        ObjectNode childNode = iPSAppDERS.getModel();
                        subArray.add((JsonNode)childNode);
                    }
                }
                ++i;
            }
        }
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strModelRefType)) {
            if ("APPLICATION".equals(strModelRefType)) {
                if (this.getPSAppDataEntity() != null) {
                    objectNode.put("resource", this.getPSAppDataEntity().getCodeName());
                }
                objectNode.put("view", this.getPSDEViewCodeName());
                if (!this.getCodeName().equals(this.getName())) {
                    objectNode.put("name", this.getName());
                }
            }
            if ("DATAENTITY".equals(strModelRefType)) {
                objectNode.put("app", this.getPSApplication().getCodeName());
                objectNode.put("view", this.getPSDEViewCodeName());
            }
        }
    }
}

