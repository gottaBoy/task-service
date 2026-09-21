/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Admin;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;

public class LoginDealPage
extends SRFDAPage {
    public LoginDealPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) != 0) {
                this.getResponse().sendRedirect("../srfadmin/internallogin.jsp");
                return;
            }
            if (StringHelper.Compare((String)this.getWebContext().getCurUserMode(), (String)"SYSTEMDEVELOP", (boolean)true) != 0) {
                this.getResponse().sendRedirect("../srfadmin/internallogin.jsp");
                return;
            }
            String strCurUserId = this.getWebContext().getCurUserId();
            String strCurUserName = this.getWebContext().getCurUserName();
            this.getWebContext().Logout();
            this.getWebContext().setCurUserId(strCurUserId);
            this.getWebContext().setCurUserName(strCurUserName);
            this.getWebContext().setCurUserMode("SYSTEMDEVELOP");
            this.getWebContext().GetUserQueryModelStorage();
            this.getResponse().sendRedirect("../srfadmin/index_real.jsp");
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

