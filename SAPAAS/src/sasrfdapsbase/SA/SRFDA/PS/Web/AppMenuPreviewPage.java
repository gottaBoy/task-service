/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.PSAppMenuPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Data.PSAppIndexView;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class AppMenuPreviewPage
extends DECtrlPreviewPage {
    public AppMenuPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        boolean bRet = super.PreparePageEnv();
        if (!bRet) {
            return false;
        }
        try {
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSTEMID");
            IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId);
            String strPSAppMenuId = this.getWebContext().GetParamValue("PSAPPMENUID");
            PSAppMenu psAppMenu = new PSAppMenu();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSAppMenu(strPSAppMenuId, psAppMenu);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u83dc\u5355"));
            }
            IPSApplication iPSApplication = this.getPSApplication(iPSSystem, psAppMenu.getPSSYSAPPID());
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAPPVIEWID("AppMenuPreviewView");
            psAppView.setPSAPPVIEWNAME("AppMenuPreviewView");
            PSAppIndexView psAppIndexView = new PSAppIndexView();
            psAppIndexView.setPSAPPINDEXVIEWID("AppMenuPreviewView");
            psAppIndexView.setPSAPPINDEXVIEWNAME("AppMenuPreviewView");
            psAppIndexView.setPSAPPMENUID(psAppMenu.getPSAPPMENUID());
            psAppIndexView.setPSAPPMENUNAME(psAppMenu.getPSAPPMENUNAME());
            PSAppMenuPreviewViewImpl psAppAppMenuPreviewViewImpl = new PSAppMenuPreviewViewImpl();
            psAppAppMenuPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, psAppIndexView);
            IPSPF iPSPF = iPSApplication.getPSPF();
            IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
            if (iPSPF.isUseJITDesignPreview()) {
                if (iPSPF.getPSAppType().isMobileApp()) {
                    iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFId());
                    iPSPFStyle = iPSPF.getPSPFStyle(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFStyleId());
                } else {
                    iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFId());
                    iPSPFStyle = iPSPF.getPSPFStyle(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFStyleId());
                }
            }
            this.setPFType(iPSPF.getId());
            IPSControl iPSControl = psAppAppMenuPreviewViewImpl.getPSControl("appmenu");
            Iterator<IPSPFPubCode> psPFPubCodes = iPSPF.getPSPFPubCodes("VIEW");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                if (StringHelper.IsNullOrEmpty((String)iPSPFPubCode.getPreviewCode())) continue;
                String strPreviewCode = iPSPFPubCode.getPreviewCode();
                IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), iPSPFPubCode);
                if (iPSPFCtrlTempl == null) continue;
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), (ISRFDAWebContext)this.getWebContext());
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(psPublishContextImpl, iPSControl);
                if (iPSGenerateCodeResult != null) {
                    this.psCodeResultMap.put(strPreviewCode, iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage());
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }
}

