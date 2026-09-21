/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF.UIAction;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionRuntime;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Core.View.PSUIActionImpl;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionImpl
extends PSUIActionImpl
implements IPSWFUIAction,
IPSUIActionRuntime,
IPSAppWFUIAction {
    private static final Log log = LogFactory.getLog(PSWFUIActionImpl.class);
    protected PSDEUIAction psDEUIAction = null;
    private IPSWorkflow iPSWorkflow = null;
    private IPSWFVersion iPSWFVersion = null;
    private String strUIActionTag = "";
    private String strUIActionFullTag = null;
    private String strCodeName = "";
    private String strFullCodeName = "";
    private boolean bValid = true;
    private IPSSysImage iPSSysImage = null;
    private long nTimeout = 60000L;
    private String strConfirmMsg = null;
    private boolean bReloadData = false;
    private boolean bCloseEditView = false;
    private String strSuccessMsg = null;
    private String strViewLogicAttachMode = null;
    private String strViewLogicType = null;
    private String strPSDEViewLogicId = null;
    private String strPSSysViewLogicId = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private IPSLanguageRes cmPSLanguageRes = null;
    private IPSLanguageRes smPSLanguageRes = null;
    private int nNoPrivDisplayMode = 2;
    private boolean bHasNoPrivDisplayMode = false;
    private JSONObject uiActionParamJO = null;
    private JSONObject uiActionContextJO = null;
    private String strUIActionParam = null;
    private String strValueItem = null;
    private String strTextItem = null;
    private String strParamItem = null;
    private boolean bEnableRuntimeModel = false;
    private boolean bPDTFrontView = false;
    private IPSSysPDTView iPSSysPDTView = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private boolean bShowBusyIndicator = true;
    private int nRefreshMode = 0;
    private IPSUIAction nextPSUIAction = null;
    private IPSWFProcess iPSWFProcess = null;
    private IPSWFLink iPSWFLink = null;
    private IPSAppWF iPSAppWF = null;
    private IPSAppWFVer iPSAppWFVer = null;
    private IPSAppView frontPSAppView = null;
    private boolean bSaveTargetFirst = true;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEMethod iPSAppDEMethod = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private boolean bEnableConfirm = true;
    private int nActionLevel = 100;
    private String strButtonStyle = null;
    private int nCloseWindowMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWF iPSAppWF, IPSAppWFVer iPSAppWFVer, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSAppWF = iPSAppWF;
        this.iPSAppWFVer = iPSAppWFVer;
        if (this.getPSAppWFVer() != null) {
            this.init(iDAGlobalHelper, this.getPSAppWF().getPSWorkflow(), this.getPSAppWFVer().getPSWFVersion(), psDEUIAction);
        } else {
            this.init(iDAGlobalHelper, this.getPSAppWF().getPSWorkflow(), null, psDEUIAction);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow, IPSWFVersion iPSWFVersion, PSDEUIAction psDEUIAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWorkflow = iPSWorkflow;
            this.iPSWFVersion = iPSWFVersion;
            if (this.iPSWorkflow == null && this.iPSWFVersion != null) {
                this.iPSWorkflow = this.iPSWFVersion.getPSWorkflow();
            }
            this.psDEUIAction = psDEUIAction;
            this.setId(this.psDEUIAction.getPSDEUIACTIONID());
            this.setName(this.psDEUIAction.getPSDEUIACTIONNAME());
            this.setPSObjectData(this.psDEUIAction);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSWFPROCESSID())) {
                this.iPSWFProcess = this.getPSWFVersion().getPSWFProcess(this.psDEUIAction.getPSWFPROCESSID(), true);
                if (this.iPSWFProcess == null) {
                    log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u6d41\u7a0b\u754c\u9762\u884c\u4e3a[%1$s]\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\u6807\u8bc6[%2$s]\u65e0\u6548", (Object)this.getId(), (Object)this.psDEUIAction.getPSWFPROCESSID()));
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSWFPLINKID())) {
                this.iPSWFLink = this.getPSWFVersion().getPSWFLink(this.psDEUIAction.getPSWFPLINKID(), true);
                if (this.iPSWFLink == null) {
                    log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u6d41\u7a0b\u754c\u9762\u884c\u4e3a[%1$s]\u6307\u5b9a\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u6807\u8bc6[%2$s]\u65e0\u6548", (Object)this.getId(), (Object)this.psDEUIAction.getPSWFPLINKID()));
                }
            }
            this.strUIActionTag = this.psDEUIAction.getCODENAME();
            this.strCodeName = this.psDEUIAction.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEUIAction.getPSDEUIACTIONNAME();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"SYS", (boolean)true) != 0 && this.iPSWFVersion != null) {
                this.strUIActionFullTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s", (Object)this.getUIActionTag(), (Object)this.iPSWFVersion.getCodeName());
                this.strFullCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.iPSWFVersion.getCodeName(), (Object)this.getCodeName());
            }
            if (this.getPSWFProcess() != null && this.getPSWFLink() != null) {
                JSONObject contextJO = this.getContextJO(true);
                JSONObjectHelper.put((JSONObject)contextJO, (String)"srfwfiatag", (Object)this.getPSWFLink().getName());
                JSONObjectHelper.put((JSONObject)contextJO, (String)"srfwfstep", (Object)this.getPSWFProcess().getWFStepValue());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSWorkflow().getPSSystem().getPSSysImage(this.psDEUIAction.getPSSYSIMAGEID());
            }
            if (this.psDEUIAction.getTIMEOUT() > 0) {
                this.nTimeout = this.psDEUIAction.getTIMEOUT();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCONFIRMINFO())) {
                this.strConfirmMsg = this.psDEUIAction.getCONFIRMINFO();
            }
            if (!this.psDEUIAction.isRELOADDATANull()) {
                this.nRefreshMode = this.psDEUIAction.GetParamIntValue("RELOADDATA", this.nRefreshMode);
                this.setReloadData(this.nRefreshMode > 0);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getSUCCESSINFO())) {
                this.strSuccessMsg = this.psDEUIAction.getSUCCESSINFO();
            }
            if (!this.psDEUIAction.isCLOSEEDITVIEWNull()) {
                this.nCloseWindowMode = this.psDEUIAction.getCLOSEEDITVIEW();
                this.setCloseEditView(this.nCloseWindowMode != 0);
            }
            if (!this.psDEUIAction.isENABLERTMODELNull()) {
                this.setEnableRuntimeModel(psDEUIAction.getENABLERTMODEL());
            }
            if (!this.psDEUIAction.isPDTVIEWFLAGNull()) {
                this.bPDTFrontView = psDEUIAction.getPDTVIEWFLAG();
            }
            if (this.isFrontPDTView() && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getFrontPSSysPDTViewId())) {
                this.iPSSysPDTView = this.getPSSystem().getPSSysPDTView(this.getFrontPSSysPDTViewId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getVLEXCEMODE())) {
                this.strViewLogicAttachMode = this.psDEUIAction.getVLEXCEMODE();
                this.strViewLogicType = this.psDEUIAction.getVIEWLOGICTYPE();
                this.strPSDEViewLogicId = this.psDEUIAction.getPSDEVIEWLOGICID();
                this.strPSSysViewLogicId = this.psDEUIAction.getPSSYSVIEWLOGICID();
            }
            if (this.getPSApplication() != null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCAPPSLANRESID())) {
                    this.capPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getCAPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getTIPPSLANRESID())) {
                    this.tooltipPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getTIPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCMPSLANRESID())) {
                    this.cmPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getCMPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getSMPSLANRESID())) {
                    this.smPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getSMPSLANRESID());
                }
            } else {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCAPPSLANRESID())) {
                    this.capPSLanguageRes = this.getPSWorkflow().getPSSystem().getPSLanguageRes(this.psDEUIAction.getCAPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getTIPPSLANRESID())) {
                    this.tooltipPSLanguageRes = this.getPSWorkflow().getPSSystem().getPSLanguageRes(this.psDEUIAction.getTIPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCMPSLANRESID())) {
                    this.cmPSLanguageRes = this.getPSWorkflow().getPSSystem().getPSLanguageRes(this.psDEUIAction.getCMPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getSMPSLANRESID())) {
                    this.smPSLanguageRes = this.getPSWorkflow().getPSSystem().getPSLanguageRes(this.psDEUIAction.getSMPSLANRESID());
                }
            }
            if (!this.psDEUIAction.isNOPRIVDMNull()) {
                this.bHasNoPrivDisplayMode = true;
                this.nNoPrivDisplayMode = this.psDEUIAction.getNOPRIVDM();
            }
            if (!this.psDEUIAction.isBUSYINDICATORNull()) {
                this.bShowBusyIndicator = this.psDEUIAction.getBUSYINDICATOR();
            }
            this.bEnableConfirm = !this.psDEUIAction.isUSERCONFIRMNull() ? this.psDEUIAction.getUSERCONFIRM() : SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"WFBACKEND", (boolean)true) == 0;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psDEUIAction.getPSSYSPFPLUGINID());
            }
            this.strUIActionParam = psDEUIAction.getUIACTIONPARAMS().trim();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIActionParam)) {
                if (this.strUIActionParam.charAt(0) == '{') {
                    this.uiActionParamJO = JSONObject.fromString((String)this.strUIActionParam);
                } else {
                    this.uiActionParamJO = new JSONObject();
                    Properties properties = PropertiesHelper.load((String)this.strUIActionParam);
                    this.onPreparePSUIActionParams(properties);
                }
            }
            this.strValueItem = this.psDEUIAction.getDATAITEM().trim();
            this.strTextItem = this.psDEUIAction.getTEXTITEM().trim();
            this.strParamItem = this.psDEUIAction.getPARAMITEM().trim();
            if (!this.psDEUIAction.isACTIONLEVELNull()) {
                this.nActionLevel = this.psDEUIAction.getACTIONLEVEL();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getBUTTONSTYLE())) {
                this.strButtonStyle = this.psDEUIAction.getBUTTONSTYLE();
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
    protected void onInit() throws Exception {
        if (this.getPSSysPFPlugin() != null && this.getPSApplication() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
            }
        }
        if (this.getPSWFProcess() != null && this.getPSWFLink() != null) {
            PSNavigateContextImpl PSNavigateContextImpl2;
            if (this.psNavigateContextMap == null) {
                this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
            }
            if (!this.psNavigateContextMap.containsKey("srfwfiatag")) {
                PSNavigateContextImpl2 = new PSNavigateContextImpl();
                PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, "srfwfiatag", this.getPSWFLink().getName(), null, true);
                this.psNavigateContextMap.put("srfwfiatag", PSNavigateContextImpl2);
            }
            if (!this.psNavigateContextMap.containsKey("srfwfstep")) {
                PSNavigateContextImpl2 = new PSNavigateContextImpl();
                PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, "srfwfstep", this.getPSWFProcess().getWFStepValue(), null, true);
                this.psNavigateContextMap.put("srfwfstep", PSNavigateContextImpl2);
            }
        }
        super.onInit();
    }

    protected void onPreparePSUIActionParams(Properties uiactionParams) throws Exception {
        if (uiactionParams != null) {
            for (Object objKey : uiactionParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)uiactionParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag.toLowerCase(), strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag.toLowerCase(), PSNavigateParamImpl2);
                this.uiActionParamJO.put(strKey, (Object)PropertiesHelper.getProperty((Properties)uiactionParams, (String)strKey));
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41", hideempty=true, dumpref=true, from="IPSApplication")
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c", hideempty=true, dumpref=true, from="IPSAppWF")
    public IPSAppWFVer getPSAppWFVer() {
        return this.iPSAppWFVer;
    }

    public IPSSystem getPSSystem() {
        return this.getPSWorkflow().getPSSystem();
    }

    @Override
    public String getCaption(String strLanguage) {
        return this.psDEUIAction.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7c7b\u578b", displayvalue="\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a(WFUIACTION)")
    public String getUIActionType() {
        return "WFUIACTION";
    }

    @Override
    public boolean isUIActionGroup(Object obj) throws Exception {
        return false;
    }

    @Override
    public boolean isEnableUIActionGroupExMode(Object obj) throws Exception {
        return false;
    }

    @Override
    public String getUIActionTag() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIActionTag)) {
            return this.getId();
        }
        return this.strUIActionTag;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange")
    public String getActionTarget() {
        return this.psDEUIAction.getACTIONTARGET();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u53f0\u5904\u7406\u7c7b\u578b", codelist="DEUIActionFrontType", hideempty2=true)
    public String getFrontProcessType() {
        return this.psDEUIAction.getFRONTPROTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public boolean isValid(Object obj) {
        return this.isValid();
    }

    protected boolean isValid() {
        return this.bValid;
    }

    protected void setValid(boolean bValid) {
        this.bValid = bValid;
    }

    @Override
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6a21\u5f0f", codelist="DEUIActionType")
    public String getUIActionMode() {
        return this.psDEUIAction.getUIACTIONTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u56fe\u6807\u5bf9\u8c61", hideempty=true)
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public String getTooltip(String strLanguage) {
        return this.getTooltip();
    }

    @Override
    @PSModelRTMeta(description="Html\u9875\u9762\u8def\u5f84")
    public String getHtmlPageUrl() {
        return this.psDEUIAction.getHTMLPAGEURL();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWorkflow().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09")
    public long getTimeout() {
        return this.nTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u786e\u8ba4\u4fe1\u606f", hideempty2=true)
    public String getConfirmMsg() {
        return this.strConfirmMsg;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5237\u65b0\u5f53\u524d\u754c\u9762")
    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6210\u529f\u63d0\u793a\u4fe1\u606f", hideempty2=true)
    public String getSuccessMsg() {
        return this.strSuccessMsg;
    }

    public void setSuccessMsg(String strSuccessMsg) {
        this.strSuccessMsg = strSuccessMsg;
    }

    @Override
    public String getDataAccessAction() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5173\u95ed\u7f16\u8f91\u89c6\u56fe")
    public boolean isCloseEditView() {
        return this.bCloseEditView;
    }

    public void setCloseEditView(boolean bCloseEditView) {
        this.bCloseEditView = bCloseEditView;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5173\u95ed\u5f39\u51fa\u89c6\u56fe")
    public boolean isClosePopupView() {
        return this.bCloseEditView;
    }

    @Override
    public boolean isEnableToggleMode() {
        return false;
    }

    @Override
    public String getViewLogicAttachMode() {
        return this.strViewLogicAttachMode;
    }

    @Override
    public String getViewLogicType() {
        return this.strViewLogicType;
    }

    @Override
    public String getPSDEUILogicId() {
        return this.strPSDEViewLogicId;
    }

    @Override
    public String getPSSysViewLogicId() {
        return this.strPSSysViewLogicId;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u903b\u8f91\u9644\u52a0\u7c7b\u578b", codelist="DEUIActionVLExecMode")
    public String getUILogicAttachMode() {
        return this.getViewLogicAttachMode();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u903b\u8f91\u7c7b\u578b")
    public String getUILogicType() {
        return this.getViewLogicType();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u786e\u8ba4\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getCMPSLanguageRes() {
        return this.cmPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u529f\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getSMPSLanguageRes() {
        return this.smPSLanguageRes;
    }

    @Override
    public int getNoPrivDisplayMode(IPSAppView iPSAppView) {
        if (this.bHasNoPrivDisplayMode || iPSAppView == null) {
            return this.nNoPrivDisplayMode;
        }
        return iPSAppView.getButtonNoPrivDisplayMode();
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.psDEUIAction.getCAPTION();
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getTOOLTIPINFO())) {
            return this.psDEUIAction.getTOOLTIPINFO();
        }
        return this.getCaption();
    }

    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    public String getTooltipLanResTag() {
        if (this.getTooltipPSLanguageRes() != null) {
            return this.getTooltipPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f", hideempty2=true, dump=false)
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84", hideempty2=true, dump=false)
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\uff08X\uff09", hideempty2=true, dump=false)
    public String getIconClsX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClassX();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\uff08X\uff09", hideempty2=true, dump=false)
    public String getIconPathX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePathX();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppWFVer() != null) {
            return "PSAPPWFVERUIACTION";
        }
        if (this.getPSAppWF() != null) {
            return "PSAPPWFUIACTION";
        }
        return "PSWFUIACTION";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppWFVer() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppWFVer().getModelId(), (Object)super.getModelId());
        }
        if (this.getPSAppWF() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppWF().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFVersion().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWorkflow().getPSSystem());
    }

    @Override
    public String getUIActionParam() {
        return this.strUIActionParam;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u53c2\u6570\u5bf9\u8c61", hideempty2=true)
    public JSONObject getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", hideempty2=true)
    public String getValueItem() {
        return this.strValueItem;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u9879\u540d\u79f0", hideempty2=true)
    public String getTextItem() {
        return this.strTextItem;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u9879\u540d\u79f0", hideempty2=true)
    public String getParamItem() {
        return this.strParamItem;
    }

    @PSModelRTMeta(description="\u652f\u6301\u8fd0\u884c\u65f6\u6a21\u578b")
    public boolean isEnableRuntimeModel() {
        return this.bEnableRuntimeModel;
    }

    public boolean isGlobalUIAction() {
        return false;
    }

    public void setEnableRuntimeModel(boolean bEnableRuntimeModel) {
        this.bEnableRuntimeModel = bEnableRuntimeModel;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5b8c\u5168\u6807\u8bb0", dump=false)
    public String getUIActionFullTag() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIActionFullTag)) {
            return this.getUIActionTag();
        }
        return this.strUIActionFullTag;
    }

    @Override
    public boolean isFrontPDTView() {
        return this.bPDTFrontView;
    }

    @Override
    public String getFrontPSSysPDTViewId() {
        return this.psDEUIAction.getPSSYSPDTVIEWID();
    }

    @Override
    public IPSAppView getFrontPSAppView(Object obj) throws Exception {
        if (this.isFrontPDTView()) {
            String strFrontPSSysPDTViewId = this.getFrontPSSysPDTViewId();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFrontPSSysPDTViewId)) {
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                IPSSysPDTView iPSSysPDTView = this.getPSSystem().getPSSysPDTView(strFrontPSSysPDTViewId);
                return PSSystemUtil.getPSAppView(iPSApplication, iPSSysPDTView, false);
            }
        } else {
            String strFrontPSDEViewId = this.getFrontPSDEViewId(obj);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFrontPSDEViewId)) {
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                String strPSAppViewId = Helper.GenUniqueId((String)iPSApplication.getId(), (String)strFrontPSDEViewId);
                return iPSApplication.getPSAppView(strPSAppViewId, strFrontPSDEViewId);
            }
        }
        return null;
    }

    @Override
    public String getFrontPSDEViewId(Object obj) {
        return this.getFrontPSDEViewId();
    }

    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }

    @Override
    public String getFrontPSDEViewId() {
        if (this.isFrontPDTView() && this.getPSSysPDTView() != null) {
            return this.getPSSysPDTView().getPSDEViewBaseId();
        }
        return this.psDEUIAction.getPSDEVIEWBASEID();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        String strPluginCode = null;
        if (this.getPSSysPFPlugin() != null) {
            strPluginCode = this.getPSSysPFPlugin().getPluginCode();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"SYS", (boolean)true) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPluginCode)) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getUIActionMode(), (Object)this.getCodeName()).toUpperCase();
            }
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s#%3$s", (Object)this.getUIActionMode(), (Object)this.getCodeName(), (Object)strPluginCode).toUpperCase();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPluginCode)) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)this.getUIActionMode()).toUpperCase();
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getUIActionMode(), (Object)strPluginCode).toUpperCase();
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u5168\u4ee3\u7801\u540d\u79f0")
    public String getFullCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strFullCodeName)) {
            return this.getCodeName();
        }
        return this.strFullCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public IPSViewLogic getPSViewLogic(Object obj) throws Exception {
        String strPSSysViewLogicId = this.getPSSysViewLogicId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysViewLogicId)) {
            IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
            return iPSApplication.getPSAppUILogic(strPSSysViewLogicId);
        }
        return null;
    }

    @Override
    public boolean hasViewLogic() {
        return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysViewLogicId());
    }

    @Override
    public String getViewLogicCodeName() {
        if (this.hasViewLogic()) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_VL", (Object)this.getFullCodeName());
        }
        return null;
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return this.getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a", ignoredumpvalues="true")
    public boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u5f15\u7528\u89c6\u56fe\u6a21\u5f0f", codelist="UIActionReloadDataMode", ignoredumpvalues="0")
    public int getRefreshMode() {
        return this.nRefreshMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u754c\u9762\u884c\u4e3a", rtname="getNext", dumpref=true)
    public IPSUIAction getNextPSUIAction() {
        return this.nextPSUIAction;
    }

    @Override
    public void setNextPSUIAction(IPSUIAction iPSUIAction) {
        this.nextPSUIAction = iPSUIAction;
    }

    @Override
    public String getPSSysDEUIActionId(Object obj) throws Exception {
        return this.psDEUIAction.getPSSYSUIACTIONID();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406\u5bf9\u8c61")
    public IPSWFProcess getPSWFProcess() {
        return this.iPSWFProcess;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u8fde\u63a5\u5bf9\u8c61")
    public IPSWFLink getPSWFLink() {
        return this.iPSWFLink;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u89c6\u56fe", hideempty=true, dumpref=true)
    public IPSAppView getFrontPSAppView() throws Exception {
        if (this.frontPSAppView == null && this.getPSAppWF() != null) {
            this.frontPSAppView = this.getFrontPSAppView(this.getPSAppWF().getPSApplication());
        }
        return this.frontPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ec4", hideempty=true)
    public boolean isGroup() throws Exception {
        return this.isUIActionGroup(null);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSApplication")
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.iPSAppDataEntity != null) {
            return this.iPSAppDataEntity;
        }
        try {
            Iterator<IPSAppDataEntity> psAppDataEntities;
            if (this.getPSAppWF() != null && (psAppDataEntities = this.getPSAppWF().getPSApplication().getAllPSAppDataEntities()) != null) {
                while (psAppDataEntities.hasNext()) {
                    IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                    if (iPSAppDataEntity.getPSAppWF() == null || SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSAppWF().getId(), (String)iPSAppDataEntity.getPSAppWF().getId(), (boolean)false) != 0) continue;
                    this.iPSAppDataEntity = iPSAppDataEntity;
                    break;
                }
            }
            return this.iPSAppDataEntity;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEMethod getPSAppDEMethod() {
        if (this.iPSAppDEMethod != null) {
            return this.iPSAppDEMethod;
        }
        try {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"WFBACKEND", (boolean)false) == 0 && this.getPSAppDataEntity() != null) {
                this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod("WFACTION", "WFSUBMIT", true);
            }
            return this.iPSAppDEMethod;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5148\u4fdd\u5b58\u76ee\u6807\u6570\u636e", ignoredumpvalues="false")
    public boolean isSaveTargetFirst() {
        return this.bSaveTargetFirst;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u53c2\u6570Json\u5b57\u7b26\u4e32", dump=false)
    public String getParamJOString() {
        if (this.getUIActionParamJO() != null) {
            return this.getUIActionParamJO().toString();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u4e0a\u4e0b\u6587Json\u5b57\u7b26\u4e32")
    public String getContextJOString() {
        if (this.uiActionContextJO != null) {
            return this.uiActionContextJO.toString();
        }
        return null;
    }

    @Override
    public IPSApplication getPSApplication() {
        if (this.getPSAppWF() != null) {
            return this.getPSAppWF().getPSApplication();
        }
        return null;
    }

    protected JSONObject getContextJO(boolean bCreateIfEmpty) {
        if (this.uiActionContextJO == null && bCreateIfEmpty) {
            this.uiActionContextJO = new JSONObject();
        }
        return this.uiActionContextJO;
    }

    @Override
    public String getCounterId() {
        return null;
    }

    @Override
    public IPSAppCounter getPSAppCounter() throws Exception {
        return null;
    }

    @Override
    public String getCounterParamJOString() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7528\u6237\u64cd\u4f5c\u786e\u8ba4")
    public boolean isEnableConfirm() {
        return this.bEnableConfirm;
    }

    @Override
    public String getModelRefId() {
        return this.getUIActionFullTag();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ea7\u522b", codelist="UIActionLevel", ignoredumpvalues="100")
    public int getActionLevel() {
        return this.nActionLevel;
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", ignoredumpvalues="100")
    public String getButtonStyle() {
        return this.strButtonStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5f39\u7a97\u5173\u95ed\u7ed3\u679c", codelist="UIActionDialogResult")
    public String getDialogResult() {
        if (this.isClosePopupView()) {
            switch (this.nCloseWindowMode) {
                case 1: {
                    return "OK";
                }
                case 2: {
                    return "CANCEL";
                }
            }
            return "OK";
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u884c\u4e3a\u7c7b\u578b", hideempty2=true)
    public String getPredefinedType() {
        try {
            String strPredefinedType = this.getPSSysDEUIActionId(null);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPredefinedType)) {
                return strPredefinedType;
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
        return null;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        if (this.getPSAppWF() != null) {
            objectNode.put("getPSAppWF", (JsonNode)this.getPSAppWF().getModelRef());
        }
        if (this.getPSAppWFVer() != null) {
            objectNode.put("getPSAppWFVer", (JsonNode)this.getPSAppWFVer().getModelRef());
        }
        super.onFillModelRefNode(objectNode, strModelRefType);
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return null;
    }
}

