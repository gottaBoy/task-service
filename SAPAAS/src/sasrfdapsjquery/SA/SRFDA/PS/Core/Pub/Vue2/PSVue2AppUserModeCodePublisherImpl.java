/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode
 *  SA.SRFDA.PS.Core.Pub.IPSPFAppUserModeCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.Pub.IPSPFAppUserModeCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2AppCodePublisherImpl;
import java.util.Iterator;

public class PSVue2AppUserModeCodePublisherImpl
extends PSVue2AppCodePublisherImpl
implements IPSPFAppUserModeCodePublisher {
    protected void onGenerateCode() throws Exception {
        Iterator psAppUserModes = this.iPSApplication.getAllPSAppUserModes();
        while (psAppUserModes.hasNext()) {
            IPSAppUserMode iPSAppUserMode = (IPSAppUserMode)psAppUserModes.next();
            if (iPSAppUserMode.getPSAppMenuModel() == null) continue;
            this.onGenerateCode(iPSAppUserMode, iPSAppUserMode.getPSAppMenuModel().getCodeName().toLowerCase());
        }
    }

    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSApplication iPSApplication, IPSAppUserMode iPSAppUserMode) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSApplication = iPSApplication;
        this.iPSPF = this.iPSApplication.getPSPF();
        this.iPSPFStyle = this.iPSApplication.getPSPFStyle();
        this.onGenerateCode(iPSAppUserMode, iPSAppUserMode.getPSAppMenuModel().getCodeName().toLowerCase());
    }
}

