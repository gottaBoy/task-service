/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.PSException;
import SA.SRFDA.PS.Data.PSAppEditorTempl;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppPDTView;
import SA.SRFDA.PS.Data.PSAppPortlet;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFDA.PS.Data.PSAppUserMode;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class PSApplicationException
extends PSException {
    private static final long serialVersionUID = 679921482501444730L;
    public static final int ERROR_APPMENUNOTFOUND = 40000;
    public static final int ERROR_APPFUNCNOTFOUND = 40001;
    public static final int ERROR_APPEDITORTEMPLNOTFOUND = 40002;
    public static final int ERROR_APPUSERMODENOTFOUND = 40003;
    public static final int ERROR_APPMODULENOTFOUND = 40004;
    public static final int ERROR_APPUTILPAGENOTFOUND = 40005;
    public static final int ERROR_APPLANNOTFOUND = 40006;
    public static final int ERROR_APPPKGNOTFOUND = 40007;
    public static final int ERROR_MOBAPPSTARTPAGENOTFOUND = 40008;
    public static final int ERROR_MOBAPPPACKNOTFOUND = 40009;
    public static final int ERROR_MOBAPPICONNOTFOUND = 40010;
    public static final int ERROR_APPLOCALDENOTFOUND = 40011;
    public static final int ERROR_APPVIEWNOTFOUND = 40012;
    public static final int ERROR_APPUISTYLENOTFOUND = 40013;
    public static final int ERROR_APPUITHEMENOTFOUND = 40014;
    public static final int ERROR_APPPDTVIEWNOTFOUND = 40015;
    public static final int ERROR_APPWFNOTFOUND = 40016;
    public static final int ERROR_APPWFVERNOTFOUND = 40017;
    public static final int ERROR_APPDERSNOTFOUND = 40018;
    public static final int ERROR_APPRESOURCENOTFOUND = 40019;
    public static final int ERROR_APPUTILNOTFOUND = 40020;
    public static final int ERROR_APPPORTLETNOTFOUND = 40021;
    public static final int ERROR_APPLOGICNOTFOUND = 40022;
    private IPSApplication iPSApplication = null;

    public PSApplicationException(IPSApplication iPSApplication, int nErrorCode, String strErrorInfo) {
        super(nErrorCode, strErrorInfo);
        this.setPSApplication(iPSApplication);
    }

    public PSApplicationException(IPSApplication iPSApplication, int nErrorCode, String strErrorInfo, Object objArg, Object objArg2) {
        super(nErrorCode, strErrorInfo);
        this.setPSApplication(iPSApplication);
        this.setArg(objArg);
        this.setArg2(objArg2);
    }

    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected void setPSApplication(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
    }

    public static PSApplicationException create(IPSApplication iPSApplication, int nErrorCode, Object objArg) throws Exception {
        return PSApplicationException.create(iPSApplication, nErrorCode, objArg, null);
    }

    public static PSApplicationException create(IPSApplication iPSApplication, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 40000: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppMenu psAppMenu = new PSAppMenu();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppMenu((String)objArg, psAppMenu);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppMenu.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u83dc\u5355[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppMenu.getPSAPPMENUNAME(), (Object)psAppMenu.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u83dc\u5355[%2$s]", (Object)iPSApplication.getName(), (Object)psAppMenu.getPSAPPMENUNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u83dc\u5355[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40001: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppFunc psAppFunc = new PSAppFunc();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppFunc((String)objArg, psAppFunc);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppFunc.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u529f\u80fd[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppFunc.getPSAPPFUNCNAME(), (Object)psAppFunc.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u529f\u80fd[%2$s]", (Object)iPSApplication.getName(), (Object)psAppFunc.getPSAPPFUNCNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u529f\u80fd[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40002: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppEditorTempl psAppEditorTempl = new PSAppEditorTempl();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppEditorTempl((String)objArg, psAppEditorTempl);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppEditorTempl.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7f16\u8f91\u5668\u6a21\u677f[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppEditorTempl.getPSAPPEDITORTEMPLNAME(), (Object)psAppEditorTempl.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7f16\u8f91\u5668\u6a21\u677f[%2$s]", (Object)iPSApplication.getName(), (Object)psAppEditorTempl.getPSAPPEDITORTEMPLNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7f16\u8f91\u5668\u6a21\u677f[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40003: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppUserMode psAppUserMode = new PSAppUserMode();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppUserMode((String)objArg, psAppUserMode);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppUserMode.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7528\u6237\u6a21\u5f0f[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppUserMode.getPSAPPUSERMODENAME(), (Object)psAppUserMode.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7528\u6237\u6a21\u5f0f[%2$s]", (Object)iPSApplication.getName(), (Object)psAppUserMode.getPSAPPUSERMODENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7528\u6237\u6a21\u5f0f[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40004: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppModule psAppModule = new PSAppModule();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppModule((String)objArg, psAppModule);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppModule.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u6a21\u5757[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppModule.getPSAPPMODULENAME(), (Object)psAppModule.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u6a21\u5757[%2$s]", (Object)iPSApplication.getName(), (Object)psAppModule.getPSAPPMODULENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u6a21\u5757[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40005: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppUtilPage psAppUtilPage = new PSAppUtilPage();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppUtilPage((String)objArg, psAppUtilPage);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppUtilPage.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u9875\u9762[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppUtilPage.getPSAPPUTILPAGENAME(), (Object)psAppUtilPage.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u9875\u9762[%2$s]", (Object)iPSApplication.getName(), (Object)psAppUtilPage.getPSAPPUTILPAGENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u9875\u9762[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40011: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppLocalDE psAppLocalDE = new PSAppLocalDE();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppLocalDE((String)objArg, psAppLocalDE);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppLocalDE.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppLocalDE.getPSAPPLOCALDENAME(), (Object)psAppLocalDE.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53[%2$s]", (Object)iPSApplication.getName(), (Object)psAppLocalDE.getPSAPPLOCALDENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40012: {
                if (objArg == null || !(objArg instanceof String)) break;
                String strPSApplicationViewId = (String)objArg;
                String strOriginViewId = null;
                if (objArg2 != null && objArg2 instanceof String) {
                    strOriginViewId = (String)objArg2;
                }
                if (!StringHelper.IsNullOrEmpty(strOriginViewId)) {
                    PSDEViewBase psDEViewBase = new PSDEViewBase();
                    CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSDEViewBase(strOriginViewId, psDEViewBase);
                    if (callResult.isOk()) {
                        String strInfo = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]\uff0c\u8bf7\u786e\u8ba4\u5b9e\u4f53\u89c6\u56fe[%2$s][%3$s]\u5df2\u7ecf\u6dfb\u52a0\u5230\u5e94\u7528[%4$s]\u4e2d", (Object)strPSApplicationViewId, (Object)psDEViewBase.getPSDENAME(), (Object)psDEViewBase.getPSDEVIEWBASENAME(), (Object)iPSApplication.getName());
                        return new PSApplicationException(iPSApplication, nErrorCode, strInfo, objArg, objArg2);
                    }
                }
                String strInfo = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]\uff0c\u5f53\u524d\u5e94\u7528[%2$s]", (Object)strPSApplicationViewId, (Object)iPSApplication.getName());
                return new PSApplicationException(iPSApplication, nErrorCode, strInfo);
            }
            case 40013: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppUIStyle psAppUIStyle = new PSAppUIStyle();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppUIStyle((String)objArg, psAppUIStyle);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppUIStyle.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u754c\u9762\u6a21\u5f0f[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppUIStyle.getPSAPPUISTYLENAME(), (Object)psAppUIStyle.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u754c\u9762\u6a21\u5f0f[%2$s]", (Object)iPSApplication.getName(), (Object)psAppUIStyle.getPSAPPUISTYLENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u754c\u9762\u6a21\u5f0f[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40014: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppUITheme psAppUITheme = new PSAppUITheme();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppUITheme((String)objArg, psAppUITheme);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppUITheme.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u754c\u9762\u4e3b\u9898[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppUITheme.getPSAPPUITHEMENAME(), (Object)psAppUITheme.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u754c\u9762\u4e3b\u9898[%2$s]", (Object)iPSApplication.getName(), (Object)psAppUITheme.getPSAPPUITHEMENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u754c\u9762\u4e3b\u9898[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40015: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppPDTView psAppPDTView = new PSAppPDTView();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppPDTView((String)objArg, psAppPDTView);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppPDTView.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u89c6\u56fe[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppPDTView.getPSAPPPDTVIEWNAME(), (Object)psAppPDTView.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)iPSApplication.getName(), (Object)psAppPDTView.getPSAPPPDTVIEWNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u89c6\u56fe[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40016: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppWF psAppWF = new PSAppWF();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppWF((String)objArg, psAppWF);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppWF.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppWF.getPSAPPWFNAME(), (Object)psAppWF.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41[%2$s]", (Object)iPSApplication.getName(), (Object)psAppWF.getPSAPPWFNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40017: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppWFVer psAppWFVer = new PSAppWFVer();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppWFVer((String)objArg, psAppWFVer);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppWFVer.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppWFVer.getPSAPPWFVERNAME(), (Object)psAppWFVer.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c[%2$s]", (Object)iPSApplication.getName(), (Object)psAppWFVer.getPSAPPWFVERNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40019: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppResource psAppResource = new PSAppResource();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppResource((String)objArg, psAppResource);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppResource.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u8d44\u6e90[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppResource.getPSAPPRESOURCENAME(), (Object)psAppResource.getPSSYSAPPNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u8d44\u6e90[%2$s]", (Object)iPSApplication.getName(), (Object)psAppResource.getPSAPPRESOURCENAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u8d44\u6e90[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40020: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppUtil psAppUtil = new PSAppUtil();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppUtil((String)objArg, psAppUtil);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppUtil.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7ec4\u4ef6[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppUtil.getPSAPPUTILNAME(), (Object)psAppUtil.getPSSYSAPPNAME()));
                    }
                    if (!psAppUtil.isVALIDFLAGNull() && !psAppUtil.getVALIDFLAG()) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u6307\u5b9a\u5e94\u7528\u7ec4\u4ef6[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSApplication.getName(), (Object)psAppUtil.getPSAPPUTILNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7ec4\u4ef6[%2$s]", (Object)iPSApplication.getName(), (Object)psAppUtil.getPSAPPUTILNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u7ec4\u4ef6[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
            case 40021: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSAppPortlet psAppPortlet = new PSAppPortlet();
                CallResult callResult = PSApplicationException.getPSModelHelper(iPSApplication).getPSAppPortlet((String)objArg, psAppPortlet);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSApplication.getId(), (String)psAppPortlet.getPSSYSAPPID(), (boolean)false) != 0) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u95e8\u6237\u90e8\u4ef6[%2$s]\uff0c\u9519\u8bef\u7684\u5e94\u7528[%3$s]", (Object)iPSApplication.getName(), (Object)psAppPortlet.getPSAPPPORTLETNAME(), (Object)psAppPortlet.getPSSYSAPPNAME()));
                    }
                    if (!psAppPortlet.isVALIDFLAGNull() && !psAppPortlet.getVALIDFLAG()) {
                        return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u6307\u5b9a\u5e94\u7528\u95e8\u6237\u90e8\u4ef6[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSApplication.getName(), (Object)psAppPortlet.getPSAPPPORTLETNAME()));
                    }
                    return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u95e8\u6237\u90e8\u4ef6[%2$s]", (Object)iPSApplication.getName(), (Object)psAppPortlet.getPSAPPPORTLETNAME()));
                }
                return new PSApplicationException(iPSApplication, nErrorCode, StringHelper.Format((String)"\u5e94\u7528[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5e94\u7528\u95e8\u6237\u90e8\u4ef6[%2$s]", (Object)iPSApplication.getName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSApplicationException(iPSApplication, nErrorCode, (String)objArg);
        }
        return new PSApplicationException(iPSApplication, nErrorCode, null);
    }
}

