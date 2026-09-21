/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Func;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppFuncImpl
extends PSApplicationObjectImpl
implements IPSAppFunc,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSAppFuncImpl.class);
    protected PSAppFunc psAppFunc = null;
    protected IPSSubApp iPSSubApp = null;
    protected IPSSubAppRef iPSSubAppRef = null;
    protected IPSSubAppView iPSSubAppView = null;
    private String strUserData = null;
    private String strUserData2 = null;
    private int nViewWidth = 0;
    private int nViewHeight = 0;
    private String strViewTitle = "";
    private JSONObject joOpenViewParams = new JSONObject();
    private Properties openViewParams = null;
    private IPSAppView iPSAppView = null;
    private int nAccUserMode = AccessUserModes.UNKNOWN;
    private String strAccessKey = null;
    private String strHtmlPageUrl = null;
    private String strJSCode = null;
    private String strTooltip = null;
    private IPSLanguageRes namePSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private String strCodeName = null;
    private String strPSAppViewId = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private boolean bSystemReserved = false;
    private IPSAppUIAction iPSAppUIAction = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEACMode iPSAppDEACMode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppFunc psAppFunc) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppFunc = psAppFunc;
            this.setId(this.psAppFunc.getPSAPPFUNCID());
            this.setName(this.psAppFunc.getPSAPPFUNCNAME());
            this.setPSObjectData(psAppFunc);
            if (StringHelper.Compare((String)this.getAppFuncType(), (String)"SUBAPPVIEW", (boolean)true) == 0) {
                this.iPSSubAppRef = iPSApplication.getPSSubAppRefBySubApp(psAppFunc.getPSSUBAPPID(), false);
                this.iPSSubApp = this.iPSSubAppRef.getPSSubApp();
                this.iPSSubAppView = this.iPSSubApp.getPSSubAppView(psAppFunc.getPSSUBAPPVIEWID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getUSERDATA())) {
                this.strUserData = this.psAppFunc.getUSERDATA();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getUSERDATA2())) {
                this.strUserData2 = this.psAppFunc.getUSERDATA2();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPAGEURL())) {
                this.strHtmlPageUrl = this.psAppFunc.getPAGEURL();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getJSCODE())) {
                this.strJSCode = this.psAppFunc.getJSCODE();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getTOOLTIPINFO())) {
                this.strTooltip = this.psAppFunc.getTOOLTIPINFO();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getCODENAME())) {
                this.strCodeName = this.psAppFunc.getCODENAME();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPSAPPVIEWID())) {
                this.strPSAppViewId = this.psAppFunc.getPSAPPVIEWID();
            }
            if (StringHelper.Compare((String)this.getAppFuncType(), (String)"UIACTION", (boolean)false) == 0 && StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPSDEUIACTIONID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61");
            }
            if (StringHelper.Compare((String)this.getAppFuncType(), (String)"SEARCH", (boolean)false) == 0) {
                if (StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPSAPPLOCALDEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61");
                }
                if (StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPSDEACMODEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u5bf9\u8c61");
                }
            }
            this.iPSAppView = this.getPSAppView();
            if (this.iPSAppView != null) {
                ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList;
                IPSSystemRuntime iPSSystemRuntime;
                String strDynaInstTag2;
                this.nViewWidth = this.iPSAppView.getWidth();
                this.nViewHeight = this.iPSAppView.getHeight();
                this.strViewTitle = this.iPSAppView.getTitle();
                this.nAccUserMode = this.iPSAppView.getAccUserMode();
                this.strAccessKey = this.iPSAppView.getAccessKey();
                if (StringHelper.Compare((String)this.getOpenMode(), (String)"INDEXVIEWPOPUPMODAL", (boolean)true) == 0 || StringHelper.Compare((String)this.getOpenMode(), (String)"INDEXVIEWPOPUP", (boolean)true) == 0) {
                    this.iPSAppView.markViewUsage(2, this);
                } else {
                    this.iPSAppView.markViewUsage(1, this);
                }
                if (this.iPSAppView.getDynaInstMode() == 2 && !StringHelper.IsNullOrEmpty((String)(strDynaInstTag2 = this.psAppFunc.getDYNAINSTTAG2())) && this.getPSSystem() instanceof IPSSystemRuntime && (iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem())).getDynaInstMode() == 1 && (psDevSlnSysDynaInstList = iPSSystemRuntime.getPSDevSlnSysDynaInstList()) != null) {
                    String strPSDynaInstId = null;
                    for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
                        if (StringHelper.Compare((String)psDevSlnSysDynaInst.getINSTTAG(), (String)this.iPSAppView.getDynaInstTag(), (boolean)false) != 0 || StringHelper.Compare((String)psDevSlnSysDynaInst.getINSTTAG2(), (String)strDynaInstTag2, (boolean)false) != 0) continue;
                        strPSDynaInstId = psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID();
                        break;
                    }
                    if (!StringHelper.IsNullOrEmpty(strPSDynaInstId)) {
                        String strTag = "srfdynainstid".toUpperCase();
                        PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                        PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strPSDynaInstId, null, true);
                        if (this.psNavigateContextMap == null) {
                            this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                        }
                        this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    }
                }
            }
            if (StringHelper.IsNullOrEmpty((String)this.strViewTitle)) {
                this.strViewTitle = this.getName();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getNAMEPSLANRESID())) {
                this.namePSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psAppFunc.getNAMEPSLANRESID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psAppFunc.getTIPPSLANRESID());
            }
            if (!this.psAppFunc.isSYSTEMFLAGNull()) {
                this.bSystemReserved = this.psAppFunc.getSYSTEMFLAG();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.onFillViewParamJO();
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSAppDataEntity();
        this.getPSUIAction();
        this.getPSAppDEACMode();
        return super.onCheck();
    }

    protected void onFillViewParamJO() throws Exception {
        this.openViewParams = PropertiesHelper.load((String)this.psAppFunc.getOPENVIEWPARAM());
        if (this.openViewParams != null) {
            for (Object objKey : this.openViewParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)this.openViewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                boolean bRawValue = true;
                if (!StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag.toLowerCase(), strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag.toLowerCase(), PSNavigateParamImpl2);
                this.joOpenViewParams.put(strKey.toLowerCase(), (Object)PropertiesHelper.getProperty((Properties)this.openViewParams, (String)strKey));
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u7c7b\u578b", codelist="AppFuncType", group="\u57fa\u672c", order=125, fields={"APPFUNCTYPE"})
    public String getAppFuncType() {
        return this.psAppFunc.getAPPFUNCTYPE();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (StringHelper.Compare((String)this.psAppFunc.getAPPFUNCTYPE(), (String)"APPVIEW", (boolean)true) == 0 && this.getPSAppView() != null) {
            relatedAppViewList.add(this.getPSAppView());
        }
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7f16\u53f7", fields={"FUNCSN"})
    public String getFuncSN() {
        return this.psAppFunc.getFUNCSN();
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u89c6\u56fe", dumpref=true, fields={"PSAPPVIEWID"})
    public IPSAppView getPSAppView() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPSAPPVIEWID())) {
            return null;
        }
        if (this.iPSAppView == null) {
            this.iPSAppView = this.iPSApplication.getPSAppView(this.psAppFunc.getPSAPPVIEWID(), null);
        }
        return this.iPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6253\u5f00\u6a21\u5f0f", codelist="AppFuncOpenMode", fields={"OPENMODE"})
    public String getOpenMode() {
        return this.psAppFunc.getOPENMODE();
    }

    @Override
    public IPSSubAppView getPSSubAppView() throws Exception {
        return this.iPSSubAppView;
    }

    @Override
    public IPSSubAppRef getPSSubAppRef() throws Exception {
        return this.iPSSubAppRef;
    }

    @Override
    public IPSSubApp getPSSubApp() throws Exception {
        return this.iPSSubApp;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e", fields={"USERDATA"})
    public String getUserData() {
        return this.strUserData;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e2", fields={"USERDATA2"})
    public String getUserData2() {
        return this.strUserData2;
    }

    @Override
    public int getViewWidth() {
        return this.nViewWidth;
    }

    @Override
    public int getViewHeight() {
        return this.nViewHeight;
    }

    @Override
    public String getViewTitle() {
        return this.strViewTitle;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u89c6\u56fe\u53c2\u6570", fields={"OPENVIEWPARAM"})
    public JSONObject getOpenViewParam() {
        return this.joOpenViewParams;
    }

    @Override
    public int getAccUserMode() {
        return this.nAccUserMode;
    }

    @Override
    public String getAccessKey() {
        return this.strAccessKey;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u529f\u80fd\u6807\u8bc6", fields={"PSPDTAPPFUNCID"})
    public String getPSPDTAppFuncId() {
        return this.psAppFunc.getPSPDTAPPFUNCID();
    }

    @Override
    public String getModelType() {
        return "PSAPPFUNC";
    }

    @Override
    @PSModelRTMeta(description="Html\u5730\u5740", fields={"PAGEURL"})
    public String getHtmlPageUrl() {
        return this.strHtmlPageUrl;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"JSCODE"})
    public String getJSCode() {
        return this.strJSCode;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0\u8bed\u8a00\u8d44\u6e90", fields={"NAMEPSLANRESID"})
    public IPSLanguageRes getNamePSLanguageRes() {
        return this.namePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        return this.strTooltip;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return "APPFUNC";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        return this.getAppFuncType();
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return null;
    }

    @Override
    public String getPSAppViewId() {
        return this.strPSAppViewId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4fdd\u7559", ignoredumpvalues="false", fields={"SYSTEMFLAG"})
    public boolean isSystemReserved() {
        return this.bSystemReserved;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u884c\u4e3a", dumpref=true, fields={"PSDEUIACTIONID"})
    public IPSUIAction getPSUIAction() throws Exception {
        if (this.iPSAppUIAction != null) {
            return this.iPSAppUIAction;
        }
        if (StringHelper.Compare((String)this.getAppFuncType(), (String)"UIACTION", (boolean)false) != 0) {
            return null;
        }
        if (this.iPSAppUIAction == null) {
            if (!StringHelper.IsNullOrEmpty((String)this.psAppFunc.getPSAPPLOCALDEID())) {
                IPSAppDataEntity iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.psAppFunc.getPSAPPLOCALDEID(), false);
                this.iPSAppUIAction = iPSAppDataEntity.getPSAppDEUIAction(this.psAppFunc.getPSDEUIACTIONID());
            } else {
                this.iPSAppUIAction = this.getPSApplication().getPSAppDEUIAction(this.psAppFunc.getPSDEUIACTIONID());
            }
        }
        return this.iPSAppUIAction;
    }

    protected void setPSAppUIAction(IPSAppUIAction iPSAppUIAction) {
        this.iPSAppUIAction = iPSAppUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.psAppFunc.getPREDEFINEDTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b\u53c2\u6570", fields={"PREDEFINEDTYPEPARAM"})
    public String getPredefinedTypeParam() {
        return this.psAppFunc.getPREDEFINEDTYPEPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", dumpref=true, fields={"PSAPPLOCALDEID"})
    public IPSAppDataEntity getPSAppDataEntity() throws Exception {
        if (this.iPSAppDataEntity != null) {
            return this.iPSAppDataEntity;
        }
        if (StringHelper.Compare((String)this.getAppFuncType(), (String)"SEARCH", (boolean)false) != 0) {
            return null;
        }
        if (this.iPSAppUIAction == null) {
            this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.psAppFunc.getPSAPPLOCALDEID(), false);
        }
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", dumpref=true, from="IPSAppDataEntity", fields={"PSDEACMODEID"})
    public IPSAppDEACMode getPSAppDEACMode() throws Exception {
        if (this.iPSAppDEACMode != null) {
            return this.iPSAppDEACMode;
        }
        if (StringHelper.Compare((String)this.getAppFuncType(), (String)"SEARCH", (boolean)false) != 0) {
            return null;
        }
        if (this.iPSAppDEACMode == null) {
            this.iPSAppDEACMode = this.iPSAppDataEntity.getPSAppDEACMode(this.psAppFunc.getPSDEACMODEID());
        }
        return this.iPSAppDEACMode;
    }
}

