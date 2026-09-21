/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Web.Admin;

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
            if (StringHelper.Compare((String)this.getWebContext().getCurUserMode(), (String)"EAI", (boolean)true) != 0) {
                this.getResponse().sendRedirect("internallogin.jsp");
                return;
            }
            String strCurUserId = this.getWebContext().getCurUserId();
            String strCurUserName = this.getWebContext().getCurUserName();
            String strCurLoginName = this.getWebContext().getCurLoginName();
            this.getWebContext().Logout();
            this.getWebContext().setCurUserId(strCurUserId);
            this.getWebContext().setCurUserName(strCurUserName);
            this.getWebContext().setCurUserMode("EAI");
            this.getWebContext().setCurLoginName(strCurLoginName);
            this.getWebContext().GetUserQueryModelStorage();
            this.getResponse().sendRedirect("index_real.jsp");
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

