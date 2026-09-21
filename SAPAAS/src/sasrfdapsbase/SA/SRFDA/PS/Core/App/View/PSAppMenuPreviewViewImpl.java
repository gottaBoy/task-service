/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSAppModuleImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuParamImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppIndexView;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelIgnoreMeta
public class PSAppMenuPreviewViewImpl
extends PSAppViewImpl
implements IPSAppIndexView {
    protected PSAppIndexView psAppIndexView = null;
    private PSAppModuleImpl psAppModuleImpl = null;
    public static final String CTRL_APPMENU = "appmenu";

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView, PSAppIndexView psAppIndexView) throws Exception {
        this.psAppIndexView = psAppIndexView;
        PSAppModule psAppModule = new PSAppModule();
        psAppModule.setPSAPPMODULEID("DEMO");
        psAppModule.setPSAPPMODULENAME("DEMO");
        psAppModule.setCODENAME("DEMO");
        this.psAppModuleImpl = new PSAppModuleImpl();
        this.psAppModuleImpl.init(iDAGlobalHelper, iPSApplication, psAppModule);
        super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strPSAppMenuId = this.psAppIndexView.getPSAPPMENUID();
        if (!StringHelper.IsNullOrEmpty((String)strPSAppMenuId)) {
            PSAppMenuParamImpl psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(strPSAppMenuId);
            this.registerPSControl(CTRL_APPMENU, "APPMENU", psAppMenuParamImpl);
        }
        String strCounterId = this.psAppIndexView.getPSSYSCOUNTERID();
        IPSSysCounter iPSSysCounter = null;
        if (StringHelper.IsNullOrEmpty((String)strCounterId)) {
            strCounterId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getPSSystem().getId(), (String)"INDEXVIEW");
            iPSSysCounter = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCounter(strCounterId, true);
        } else {
            iPSSysCounter = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCounter(strCounterId, false);
        }
        if (iPSSysCounter != null) {
            JSONObject refModeObj = new JSONObject();
            refModeObj.put("srfappviewid", (Object)this.getId());
            this.registerPSSysCounter(iPSSysCounter, refModeObj);
        }
    }

    @Override
    public boolean isEnableDP() {
        return false;
    }

    @Override
    public IPSAppModule getPSAppModule() throws Exception {
        return this.psAppModuleImpl;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    @Override
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        return null;
    }

    @Override
    public IPSAppMenu getPSAppMenu() {
        return null;
    }

    @Override
    public boolean isDefaultPage() {
        return true;
    }

    @Override
    public String getAppIconPath() {
        return this.psAppIndexView.getAPPICONPATH();
    }

    @Override
    public String getAppIconPath2() {
        return this.psAppIndexView.getAPPICONPATH2();
    }

    @Override
    public IPSSysCounterRef getPortalPSSysCounterRef() {
        return null;
    }

    @Override
    public IPSAppCounterRef getPortalPSAppCounterRef() {
        return null;
    }

    @Override
    public String getMainMenuAlign() {
        return null;
    }

    @Override
    public IPSAppView getDefPSAppView() {
        return null;
    }

    @Override
    public String getModelType() {
        return null;
    }

    @Override
    public Iterator<IPSAppView> getAllRelatedPSAppViewsEx() throws Exception {
        return null;
    }

    @Override
    public boolean isBlankMode() {
        return true;
    }

    @Override
    public boolean isEnableAppSwitch() {
        return false;
    }

    @Override
    public int getAppSwitchMode() {
        return 0;
    }

    @Override
    public String getHeaderInfo() {
        return null;
    }

    @Override
    public String getBottomInfo() {
        return null;
    }

    @Override
    public IPSAppMenu getLeftSidePSAppMenu() {
        return null;
    }

    @Override
    public IPSAppMenu getRightSidePSAppMenu() {
        return null;
    }

    @Override
    public IPSAppMenu getTopSidePSAppMenu() {
        return null;
    }

    @Override
    public IPSAppMenu getBottomSidePSAppMenu() {
        return null;
    }
}

