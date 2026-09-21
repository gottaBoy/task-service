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
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEToolbarPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEToolbar;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class DEToolbarPreviewPage
extends DECtrlPreviewPage {
    public DEToolbarPreviewPage() {
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
            String strPSDEToolbarId = this.getWebContext().GetParamValue("PSDETOOLBARID");
            PSDEToolbar psDEToolbar = new PSDEToolbar();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSDEToolbar(strPSDEToolbarId, psDEToolbar);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5de5\u5177\u680f"));
            }
            IPSDataEntity iPSDataEntity = null;
            if (StringHelper.IsNullOrEmpty((String)psDEToolbar.getPSDEID())) {
                Iterator<IPSDataEntity> psDataEntities = iPSSystem.getAllPSDataEntities();
                if (psDataEntities.hasNext()) {
                    iPSDataEntity = psDataEntities.next();
                }
            } else {
                iPSDataEntity = iPSSystem.getPSDataEntity(psDEToolbar.getPSDEID(), true);
                if (iPSDataEntity == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psDEToolbar.getPSDEID()));
                }
            }
            String strPFType = "";
            IPSModelObject iPSApplication = null;
            Iterator<IPSApplication> apps = iPSSystem.getAllPSApps();
            while (apps.hasNext()) {
                IPSApplication iPSApplication2 = apps.next();
                if (iPSApplication == null) {
                    if (!StringHelper.IsNullOrEmpty((String)strPFType)) {
                        if (StringHelper.Compare((String)strPFType, (String)iPSApplication2.getPFType(), (boolean)true) != 0) continue;
                        iPSApplication = iPSApplication2;
                        continue;
                    }
                    iPSApplication = iPSApplication2;
                    continue;
                }
                if (!iPSApplication2.getDefaultFlag()) continue;
                if (!StringHelper.IsNullOrEmpty((String)strPFType)) {
                    if (StringHelper.Compare((String)strPFType, (String)iPSApplication2.getPFType(), (boolean)true) != 0) continue;
                    iPSApplication = iPSApplication2;
                    break;
                }
                iPSApplication = iPSApplication2;
                break;
            }
            if (iPSApplication == null) {
                throw new Exception(StringHelper.Format((String)"\u8fd8\u672a\u5efa\u7acb\u5e94\u7528\u7a0b\u5e8f"));
            }
            iPSApplication = this.getPSApplication(iPSSystem, iPSApplication.getId());
            if (StringHelper.IsNullOrEmpty((String)strPFType)) {
                strPFType = iPSApplication.getPFType();
            }
            this.setPFType(strPFType);
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAPPVIEWID("DEToolbarPreviewView");
            psAppView.setPSAPPVIEWNAME("DEToolbarPreviewView");
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME("toolbar");
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("TOOLBAR");
            psDEViewCtrl.setPSDETOOLBARID(psDEToolbar.getPSDETOOLBARID());
            psDEViewCtrl.setPSDETOOLBARNAME(psDEToolbar.getPSDETOOLBARNAME());
            PSAppDEToolbarPreviewViewImpl psAppDEToolbarPreviewViewImpl = new PSAppDEToolbarPreviewViewImpl();
            psAppDEToolbarPreviewViewImpl.init(this.getDAGlobalHelper(), (IPSApplication)iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
            ArrayList<IPSAppView> relatedAppViewList = new ArrayList<IPSAppView>();
            psAppDEToolbarPreviewViewImpl.fillRelatedPSAppViews(relatedAppViewList);
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
            IPSControl iPSControl = psAppDEToolbarPreviewViewImpl.getPSControl("toolbar");
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

