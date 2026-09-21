/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortletRuntime;
import SA.SRFDA.PS.Core.App.Control.IPSControlContainerView;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSAppModuleImpl;
import SA.SRFDA.PS.Core.App.View.PSAppPortalViewImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBSysPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDashboardParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppPortalViewPart;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public class PSAppPortletContainerViewImpl
extends PSAppPortalViewImpl
implements IPSControlContainerView {
    private PSAppModuleImpl psAppModuleImpl = null;
    private ArrayList<IPSControl> allPSControlList = new ArrayList();

    public synchronized void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication) throws Exception {
        PSAppModule psAppModule = new PSAppModule();
        psAppModule.setPSAPPMODULEID("UTIL");
        psAppModule.setPSAPPMODULENAME("UTIL");
        psAppModule.setCODENAME("UTIL");
        this.psAppModuleImpl = new PSAppModuleImpl();
        this.psAppModuleImpl.init(iDAGlobalHelper, iPSApplication, psAppModule);
        PSAppView psAppPortalView = new PSAppView();
        psAppPortalView.setPSAPPVIEWID(String.valueOf(iPSApplication.getId()) + "__APPPORTLET");
        psAppPortalView.setPSAPPVIEWNAME("AppPortletContainerView");
        psAppPortalView.setPSAPPVIEWTYPE("APPPORTALVIEW");
        this.init(iDAGlobalHelper, iPSApplication, psAppPortalView);
    }

    @Override
    public IPSAppModule getPSAppModule() throws Exception {
        return this.psAppModuleImpl;
    }

    @Override
    protected void initPSDashboard() throws Exception {
        String strLayoutMode = this.getPSApplication().getPSPF().getPanelLayoutMode();
        PSDashboardParamImpl psDashboardParamImpl = new PSDashboardParamImpl();
        psDashboardParamImpl.setColumnModels(this.calcColModels(this.psAppPortalView.getCOLMODEL()));
        psDashboardParamImpl.setLayoutMode(strLayoutMode);
        psDashboardParamImpl.setFlexDir(this.psAppPortalView.getFLEXDIR());
        psDashboardParamImpl.setFlexAlign(this.psAppPortalView.getFLEXALIGN());
        psDashboardParamImpl.setFlexVAlign(this.psAppPortalView.getFLEXVALIGN());
        psDashboardParamImpl.setEnableCustomized(this.psAppPortalView.getENABLECUSTOMIZE() > 0);
        if (psDashboardParamImpl.isEnableCustomized().booleanValue()) {
            psDashboardParamImpl.setCustomizeMode(this.psAppPortalView.getENABLECUSTOMIZE());
        }
        this.setPSDashboard((IPSDashboard)this.registerPSControl("dashboard", "DASHBOARD", psDashboardParamImpl));
        ArrayList<PSAppPortalViewPart> psAppPortalViewPartList = new ArrayList<PSAppPortalViewPart>();
        Iterator<IPSAppPortlet> psAppPortlets = this.getPSApplication().getAllPSAppPortlets();
        if (psAppPortlets != null) {
            while (psAppPortlets.hasNext()) {
                IPSAppPortlet iPSAppPortlet = psAppPortlets.next();
                PSAppPortalViewPart psAppPortalViewPart = new PSAppPortalViewPart();
                psAppPortalViewPart.setPSAPPPVPARTID(iPSAppPortlet.getId());
                psAppPortalViewPart.setPSAPPPVPARTNAME(iPSAppPortlet.getCodeName());
                psAppPortalViewPart.setSHOWTITLEBAR(false);
                psAppPortalViewPart.setPVPARTTYPE("SYSPORTLET");
                psAppPortalViewPart.setPORTLETTYPE(iPSAppPortlet.getPSSysPortlet().getPortletType());
                psAppPortalViewPart.setPSSYSPORTLETID(iPSAppPortlet.getPSSysPortlet().getId());
                psAppPortalViewPart.setPSSYSPORTLETNAME(iPSAppPortlet.getPSSysPortlet().getName());
                psAppPortalViewPartList.add(psAppPortalViewPart);
            }
        }
        int nMaxColCount = 12;
        boolean bConvert12Ro24 = false;
        int nScale = 1;
        if (StringHelper.Compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            nMaxColCount = 24;
            bConvert12Ro24 = this.getPSApplication().getPSApplicationUI().isEnableCol12ToCol24();
            if (bConvert12Ro24) {
                nScale = 2;
            }
        }
        this.registerPSAppPortalViewParts(this.getPSDashboard(), psAppPortalViewPartList, nMaxColCount, nScale);
        Iterator<IPSDBPortletPart> psDBPortletParts = this.getPSDashboard().getAllPSPortlets();
        if (psDBPortletParts != null) {
            while (psDBPortletParts.hasNext()) {
                IPSDBSysPortletPart iPSDBSysPortletPart;
                IPSDBPortletPart iPSDBPortletPart = psDBPortletParts.next();
                if (!(iPSDBPortletPart instanceof IPSDBSysPortletPart) || (iPSDBSysPortletPart = (IPSDBSysPortletPart)iPSDBPortletPart).getPSSysPortlet() == null) continue;
                IPSAppPortlet iPSAppPortlet = this.getPSApplication().getPSAppPortlet(iPSDBSysPortletPart.getPSSysPortlet().getId(), true);
                if (iPSAppPortlet != null && iPSAppPortlet instanceof IPSAppPortletRuntime) {
                    ((IPSAppPortletRuntime)((Object)iPSAppPortlet)).setPSControl(iPSDBSysPortletPart);
                }
                this.allPSControlList.add(iPSDBSysPortletPart);
                if (!(iPSDBSysPortletPart instanceof IPSControlContainer)) continue;
                this.fillContainerControls(iPSDBSysPortletPart, this.allPSControlList);
            }
        }
    }

    @Override
    protected String getPortletPartName(String strName) {
        return "portlet_" + strName;
    }

    @Override
    public ArrayList<IPSControl> getAllPSControls() {
        return this.allPSControlList;
    }
}

