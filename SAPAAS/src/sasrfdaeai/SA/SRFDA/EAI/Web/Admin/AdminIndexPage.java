/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.IndexPage
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Web.Admin;

import SA.SRFDA.Web.Default.IndexPage;
import SA.SRFramework.Utility.StringHelper;

public class AdminIndexPage
extends IndexPage {
    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            if (StringHelper.Compare((String)this.getWebContext().getCurUserMode(), (String)"EAI", (boolean)true) != 0) {
                this.getWebContext().Logout();
                this.SetStopPage(true);
                this.getResponse().sendRedirect("internallogin.jsp");
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected boolean OnGetUserIdDirectMode() {
        return false;
    }
}

