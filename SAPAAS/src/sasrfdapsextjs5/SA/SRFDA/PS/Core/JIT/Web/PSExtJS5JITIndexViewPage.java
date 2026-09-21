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

public class PSExtJS5JITIndexViewPage
extends PSJITIndexViewPage {
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getViewName() throws Exception {
        IPSAppView iPSAppView = this.getPSJITWebContext().getPSApplication().getPSAppView(this.getPSJITWebContext().getPSAppViewId(), null);
        return StringHelper.Format((String)"%1$s.view.%2$s.%3$s", (Object)this.getPSJITWebContext().getPSAppName(), (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getCodeName());
    }
}

