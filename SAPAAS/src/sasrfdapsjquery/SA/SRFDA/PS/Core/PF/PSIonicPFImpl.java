/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.PF.PSPFImpl
 *  SA.SRFDA.PS.Data.PSAppModule
 *  SA.SRFDA.PS.Data.PSAppView
 *  SA.SRFDA.PS.Data.PSSubAppView
 *  SA.SRFDA.PS.Data.PSSysApp
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PF.PSPFImpl;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFramework.Utility.StringHelper;

public class PSIonicPFImpl
extends PSPFImpl {
    public void fillPSSubAppView(PSSubAppView psSubAppView, PSSysApp psSysApp, PSAppModule psAppModule, PSAppView psAppView) throws Exception {
        String strPageUrl = StringHelper.Format((String)"/%1$s/%2$s.jsp", (Object)psAppModule.getCODENAME(), (Object)psAppView.getPSAPPVIEWNAME()).toLowerCase();
        psSubAppView.setPAGEURL(strPageUrl);
    }

    public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception {
        String strPageUrl = StringHelper.Format((String)"/%1$s/%2$s.jsp", (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getName()).toLowerCase();
        return strPageUrl;
    }
}

