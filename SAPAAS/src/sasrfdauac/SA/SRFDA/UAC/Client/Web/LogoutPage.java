/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 */
package SA.SRFDA.UAC.Client.Web;

import SA.SRFDA.Web.SRFDAPage;

public class LogoutPage
extends SRFDAPage {
    protected String strServerPath = "";

    public LogoutPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            this.getWebContext().Logout(true);
            this.getResponse().sendRedirect(this.getWebContext().GetParamValue("RU"));
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

