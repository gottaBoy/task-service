/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppSysPanelPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
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
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSSysPanel;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;

public class SysPanelPreviewPage
extends DECtrlPreviewPage {
    protected StringBuilderEx piLogicCodeSb = new StringBuilderEx();

    public SysPanelPreviewPage() {
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
            String strPSSysPanelId = this.getWebContext().GetParamValue("PSSYSVIEWPANELID");
            PSSysPanel psSysPanel = new PSSysPanel();
            CallResult callResult = this.getPSModelHelper(iPSSystem.getPSSysModelInstId()).getPSSysPanel(strPSSysPanelId, psSysPanel);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9762\u677f"));
            }
            IPSDataEntity iPSDataEntity = null;
            if (!StringHelper.IsNullOrEmpty((String)psSysPanel.getPSDEID()) && (iPSDataEntity = iPSSystem.getPSDataEntity(psSysPanel.getPSDEID(), false)) == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]", (Object)psSysPanel.getPSDEID()));
            }
            String strPFType = "";
            IPSApplication iPSApplication = null;
            if (StringHelper.IsNullOrEmpty((String)psSysPanel.getPSSYSAPPID())) {
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
            } else {
                iPSApplication = this.getPSApplication(iPSSystem, psSysPanel.getPSSYSAPPID());
            }
            if (StringHelper.IsNullOrEmpty((String)strPFType)) {
                strPFType = iPSApplication.getPFType();
            }
            this.setPFType(strPFType);
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAPPVIEWID("SysPanelPreviewView");
            psAppView.setPSAPPVIEWNAME("SysPanelPreviewView");
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME("panel");
            if (psSysPanel.getVIEWLAYOUTFLAG() != 0) {
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("VIEWLAYOUTPANEL");
            } else {
                psDEViewCtrl.setPSDEVIEWCTRLTYPE("PANEL");
            }
            psDEViewCtrl.setPSSYSVIEWPANELID(psSysPanel.getPSSYSVIEWPANELID());
            psDEViewCtrl.setPSSYSVIEWPANELNAME(psSysPanel.getPSSYSVIEWPANELNAME());
            PSAppSysPanelPreviewViewImpl psAppSysPanelPreviewViewImpl = new PSAppSysPanelPreviewViewImpl();
            psAppSysPanelPreviewViewImpl.init(this.getDAGlobalHelper(), iPSApplication, psAppView, iPSDataEntity, psDEViewCtrl);
            ArrayList<IPSAppView> relatedAppViewList = new ArrayList<IPSAppView>();
            psAppSysPanelPreviewViewImpl.fillRelatedPSAppViews(relatedAppViewList);
            IPSPF iPSPF = iPSApplication.getPSPF();
            IPSPFStyle iPSPFStyle = iPSApplication.getPSPFStyle();
            if (iPSPF.getPSAppType().isMobileApp()) {
                iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFId());
                iPSPFStyle = iPSPF.getPSPFStyle(PSTaskServerEnvImpl.getCurrent().getPreviewMobPFStyleId());
            } else {
                iPSPF = this.getPSModelStorage().getPSPF(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFId());
                iPSPFStyle = iPSPF.getPSPFStyle(PSTaskServerEnvImpl.getCurrent().getPreviewPCPFStyleId());
            }
            this.setPFType(iPSPF.getId());
            IPSControl iPSControl = null;
            iPSControl = psSysPanel.getVIEWLAYOUTFLAG() != 0 ? psAppSysPanelPreviewViewImpl.getPSSysViewLayoutPanel() : psAppSysPanelPreviewViewImpl.getPSControl("panel");
            Iterator<IPSPFPubCode> psPFPubCodes = iPSPF.getPSPFPubCodes("VIEW");
            while (psPFPubCodes.hasNext()) {
                IPSPFPubCode item = psPFPubCodes.next();
                if (StringHelper.IsNullOrEmpty((String)item.getPreviewCode())) continue;
                String strPreviewCode = item.getPreviewCode();
                IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSControl.getPSControlType(), item);
                if (iPSPFCtrlTempl == null) continue;
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), (ISRFDAWebContext)this.getWebContext());
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(psPublishContextImpl, iPSControl);
                if (iPSGenerateCodeResult != null) {
                    this.psCodeResultMap.put(strPreviewCode, iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
            this.genPILogicCode((IPSSysPanel)iPSControl);
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage(), ex);
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    protected void genPILogicCode(IPSSysPanel iPSSysPanel) throws Exception {
    }

    public String renderPILogicCode() {
        return this.piLogicCodeSb.toString();
    }
}

