/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSAppModuleImpl;
import SA.SRFDA.PS.Core.App.View.PSAppPortalViewImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public class PSAppPortalViewPreviewViewImpl
extends PSAppPortalViewImpl {
    private PSAppModuleImpl psAppModuleImpl = null;

    @Override
    public synchronized void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        PSAppModule psAppModule = new PSAppModule();
        psAppModule.setPSAPPMODULEID("DEMO");
        psAppModule.setPSAPPMODULENAME("DEMO");
        psAppModule.setCODENAME("DEMO");
        this.psAppModuleImpl = new PSAppModuleImpl();
        this.psAppModuleImpl.init(iDAGlobalHelper, iPSApplication, psAppModule);
        super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
    }

    @Override
    public IPSAppModule getPSAppModule() throws Exception {
        return this.psAppModuleImpl;
    }
}

