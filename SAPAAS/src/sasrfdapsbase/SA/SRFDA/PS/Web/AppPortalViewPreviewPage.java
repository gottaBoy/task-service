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
import SA.SRFDA.PS.Core.App.View.PSAppPortalViewPreviewViewImpl;
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
import SA.SRFDA.PS.Data.PSAppPortalView;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

public class AppPortalViewPreviewPage
extends DECtrlPreviewPage {
    public AppPortalViewPreviewPage() {
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
            String strPSAppPortalViewId = this.getWebContext().GetParamValue("PSAPPPORTALVIEWID");
            PSAppPortalView psAppPortalView = new PSAppPortalView();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSAppPortalView(strPSAppPortalViewId, psAppPortalView);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u95e8\u6237\u89c6\u56fe"));
            }
            IPSApplication iPSApplication = this.getPSApplication(iPSSystem, psAppPortalView.getPSSYSAPPID());
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAPPVIEWID(strPSAppPortalViewId);
            psAppView.setPSAPPVIEWNAME("AppPortalViewPreviewView");
            PSAppPortalViewPreviewViewImpl psAppPortalViewPreviewViewImpl = new PSAppPortalViewPreviewViewImpl();
            psAppPortalViewPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView);
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
            IPSControl iPSControl = psAppPortalViewPreviewViewImpl.getPSControl("dashboard");
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

