/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppUIStyle;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationUI;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUIStyleImpl
extends PSApplicationObjectImpl
implements IPSAppUIStyle {
    protected PSAppUIStyle psAppUIStyle = null;
    private static final Log log = LogFactory.getLog(PSAppUIStyleImpl.class);
    private String strStyleCode = null;
    private String strAppFolder = null;
    private IPSPF iPSPF = null;
    private IPSPFStyle iPSPFStyle = null;
    private Properties pfStyleParams = null;
    private String strMainMenuAlign = null;
    private int nButtonNoPrivDisplayMode = 0;
    private boolean bEnableCol12ToCol24 = false;
    private boolean bGridForceFit = false;
    private int nGridRowActiveMode = 0;
    private IPSAppView defaultPSAppView = null;
    private int nFormItemNoPrivDisplayMode = 0;
    private int nGridColumnNoPrivDisplayMode = 0;
    private boolean bOutputFormItemUpdatePrivTag = false;
    private String strDefaultControlStyle = "";
    private IPSSysCss defaultAppViewPSSysCss = null;
    private boolean bEnableFilterStorage = false;
    private boolean bEnableDynaDashboard = false;
    private int nGridColumnEnableLink = 0;
    private int nGridColumnEnableFilter = 0;
    private String strMDCtrlEmptyText = null;
    private IPSLanguageRes mdCtrlEmptyTextPSLanRes = null;
    private boolean bGridEnableCustomized = false;
    private String strFormItemEmptyText = null;
    private int nACMinChars = 0;
    private boolean bEnableUIModelEx = false;
    private Integer nDefaultAppViewPriority = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppUIStyle psAppUIStyle) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppUIStyle = psAppUIStyle;
            this.setId(this.psAppUIStyle.getPSAPPUISTYLEID());
            this.setName(this.psAppUIStyle.getPSAPPUISTYLENAME());
            this.setPSObjectData(this.psAppUIStyle);
            this.strStyleCode = this.psAppUIStyle.getAPPPKGNAME();
            this.strAppFolder = this.psAppUIStyle.getAPPFOLDER();
            if (StringHelper.isNullOrEmpty((String)this.strAppFolder)) {
                this.strAppFolder = this.iPSApplication.getAppFolder();
            }
            this.strMainMenuAlign = this.psAppUIStyle.getMAINMENUSIDE();
            IPSApplicationUI iPSApplicationUI = iPSApplication.getPSApplicationUI();
            if (StringHelper.isNullOrEmpty((String)this.strMainMenuAlign)) {
                this.strMainMenuAlign = iPSApplicationUI.getMainMenuAlign();
            }
            this.nButtonNoPrivDisplayMode = iPSApplicationUI.getButtonNoPrivDisplayMode();
            this.nFormItemNoPrivDisplayMode = iPSApplicationUI.getFormItemNoPrivDisplayMode();
            this.nGridColumnNoPrivDisplayMode = iPSApplicationUI.getGridColumnNoPrivDisplayMode();
            this.bEnableCol12ToCol24 = iPSApplicationUI.isEnableCol12ToCol24();
            this.bGridForceFit = iPSApplicationUI.isGridForceFit();
            this.bGridEnableCustomized = iPSApplicationUI.isGridEnableCustomized();
            this.nGridRowActiveMode = iPSApplicationUI.getGridRowActiveMode();
            this.bOutputFormItemUpdatePrivTag = iPSApplicationUI.isOutputFormItemUpdatePrivTag();
            this.iPSPF = this.getPSModelStorage().getPSPF(this.psAppUIStyle.getPSPFID());
            this.iPSPFStyle = this.getPSSystemUtil().getPSPFStyle(this.psAppUIStyle.getPSPFID(), this.psAppUIStyle.getPSPFSTYLEID(), this.getCodeName());
            this.strDefaultControlStyle = iPSApplicationUI.getDefaultControlStyle();
            this.defaultAppViewPSSysCss = iPSApplicationUI.getDefaultAppViewPSSysCss();
            this.bEnableFilterStorage = iPSApplicationUI.isEnableFilterStorage();
            this.bEnableDynaDashboard = iPSApplicationUI.isEnableDynaDashboard();
            this.nGridColumnEnableLink = iPSApplicationUI.getGridColumnEnableLink();
            this.nGridColumnEnableFilter = iPSApplicationUI.getGridColumnEnableFilter();
            this.strMDCtrlEmptyText = iPSApplicationUI.getMDCtrlEmptyText();
            this.strFormItemEmptyText = iPSApplicationUI.getFormItemEmptyText();
            this.mdCtrlEmptyTextPSLanRes = iPSApplicationUI.getMDCtrlEmptyTextPSLanguageRes();
            this.nACMinChars = iPSApplicationUI.getACMinChars();
            this.bEnableUIModelEx = iPSApplicationUI.isEnableUIModelEx();
            this.nDefaultAppViewPriority = iPSApplicationUI.getDefaultAppViewPriority();
            String strPFStyleParams = this.iPSPFStyle.getPFStyleParams();
            if (!StringHelper.isNullOrEmpty((String)strPFStyleParams)) {
                strPFStyleParams = String.valueOf(strPFStyleParams) + "\r\n";
            }
            strPFStyleParams = String.valueOf(strPFStyleParams) + this.psAppUIStyle.getPFSTYLEPARAM();
            this.pfStyleParams = PropertiesHelper.Load((String)strPFStyleParams);
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
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u6a21\u5f0f", codelist="AppUIStyle")
    public String getUIStyle() {
        return this.psAppUIStyle.getUISTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u76ee\u5f55\u540d\u79f0")
    public String getAppFolder() {
        return this.strAppFolder;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u67b6\u6784")
    public String getPFType() {
        return this.getPSPF().getId();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6837\u5f0f")
    public String getPFStyle() {
        return this.getPSPFStyle().getId();
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public Object getPFStyleParam(String strKey) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey);
    }

    @Override
    public boolean getPFStyleParam(String strKey, boolean bDefault) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (boolean)bDefault);
    }

    @Override
    public String getPFStyleParam(String strKey, String strDefault) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (String)strDefault);
    }

    @Override
    public int getPFStyleParam(String strKey, int nDefault) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (int)nDefault);
    }

    @Override
    public double getPFStyleParam(String strKey, double fDefault) throws Exception {
        return PropertiesHelper.GetProperty((Properties)this.pfStyleParams, (String)strKey, (double)fDefault);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u83dc\u5355\u5bf9\u9f50", codelist="AppIndexViewMenuAlign")
    public String getMainMenuAlign() {
        return this.strMainMenuAlign;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u6309\u94ae\u663e\u793a\u6a21\u5f0f", codelist="BtnNoPrivDisplayMode")
    public int getButtonNoPrivDisplayMode() {
        return this.nButtonNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes")
    public int getFormItemNoPrivDisplayMode() {
        return this.nFormItemNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes")
    public int getGridColumnNoPrivDisplayMode() {
        return this.nGridColumnNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u8f6c\u636212\u5217\u81f324\u5217\u5e03\u5c40")
    public boolean isEnableCol12ToCol24() {
        return this.bEnableCol12ToCol24;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u9ed8\u8ba4\u542f\u7528\u5168\u5c4f")
    public boolean isGridForceFit() {
        return this.bGridForceFit;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u9ed8\u8ba4\u652f\u6301\u5b9a\u5236")
    public boolean isGridEnableCustomized() {
        return this.bGridEnableCustomized;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u884c\u9ed8\u8ba4\u6fc0\u6d3b\u6a21\u5f0f", codelist="GridRowActiveMode")
    public int getGridRowActiveMode() {
        return this.nGridRowActiveMode;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5f0f\u4ee3\u7801")
    public String getStyleCode() {
        return this.strStyleCode;
    }

    @Override
    public IPSAppView getDefaultPSAppView() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psAppUIStyle.getROOTPSAPPVIEWID()) || this.defaultPSAppView != null) {
            return this.defaultPSAppView;
        }
        try {
            this.defaultPSAppView = this.getPSApplication().getPSAppView(this.psAppUIStyle.getROOTPSAPPVIEWID(), false);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6839\u5e94\u7528\u89c6\u56fe\uff0c%1$s", (Object)ex.getMessage()), ex);
        }
        return this.defaultPSAppView;
    }

    @Override
    public IPSAppIndexView getDefaultPSAppIndexView() throws Exception {
        IPSAppView iPSAppView = this.getDefaultPSAppView();
        if (iPSAppView != null && iPSAppView instanceof IPSAppIndexView) {
            return (IPSAppIndexView)iPSAppView;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u63a7\u4ef6\u6837\u5f0f")
    public String getDefaultControlStyle() {
        return this.strDefaultControlStyle;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5e94\u7528\u89c6\u56fe\u754c\u9762\u6837\u5f0f")
    public IPSSysCss getDefaultAppViewPSSysCss() {
        return this.defaultAppViewPSSysCss;
    }

    @Override
    public boolean isOutputFormItemUpdatePrivTag() {
        return this.bOutputFormItemUpdatePrivTag;
    }

    @Override
    public String getModelType() {
        return "PSAPPUISTYLE";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22\u6761\u4ef6\u5b58\u50a8")
    public boolean isEnableFilterStorage() {
        return this.bEnableFilterStorage;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6570\u636e\u770b\u677f")
    public boolean isEnableDynaDashboard() {
        return this.bEnableDynaDashboard;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u542f\u7528\u94fe\u63a5")
    public int getGridColumnEnableLink() {
        return this.nGridColumnEnableLink;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u542f\u7528\u8fc7\u6ee4\u5668")
    public int getGridColumnEnableFilter() {
        return this.nGridColumnEnableFilter;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6570\u636e\u90e8\u4ef6\u9ed8\u8ba4\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getMDCtrlEmptyTextPSLanguageRes() {
        return this.mdCtrlEmptyTextPSLanRes;
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6570\u636e\u90e8\u4ef6\u9ed8\u8ba4\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getMDCtrlEmptyText() {
        return this.strMDCtrlEmptyText;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getFormItemEmptyText() {
        return this.strFormItemEmptyText;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u586b\u5145\u6700\u5c0f\u89e6\u53d1\u5b57\u7b26\u6570")
    public int getACMinChars() {
        return this.nACMinChars;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u586b\u5145\u6700\u5c0f\u89e6\u53d1\u5b57\u7b26\u6570", ignoredumpvalues="false")
    public boolean isEnableUIModelEx() {
        return this.bEnableUIModelEx;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u89c6\u56fe\u4f18\u5148\u7ea7", dump=false)
    public Integer getDefaultAppViewPriority() {
        return this.nDefaultAppViewPriority;
    }
}

