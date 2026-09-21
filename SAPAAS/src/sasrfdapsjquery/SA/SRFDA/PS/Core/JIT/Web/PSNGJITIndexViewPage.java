/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.JIT.Web.PSJITIndexViewPage
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.JIT.Web.PSJITIndexViewPage;
import SA.SRFramework.Utility.StringHelper;

public class PSNGJITIndexViewPage
extends PSJITIndexViewPage {
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getViewUrl() throws Exception {
        IPSAppView iPSAppView = this.getPSJITWebContext().getPSApplication().getPSAppView(this.getPSJITWebContext().getPSAppViewId(), null);
        return StringHelper.Format((String)"jsp/%1$s/%2$s.jsp", (Object)iPSAppView.getPSAppModule().getCodeName().toLowerCase(), (Object)iPSAppView.getCodeName().toLowerCase());
    }
}

