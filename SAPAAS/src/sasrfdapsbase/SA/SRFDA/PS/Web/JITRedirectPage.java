/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Web.SRFDAPSPage;

public class JITRedirectPage
extends SRFDAPSPage {
    public JITRedirectPage() {
        this.setJSCache(false);
    }

    protected boolean PreparePageEnv() {
        boolean bRet = super.PreparePageEnv();
        if (!bRet) {
            return false;
        }
        try {
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSTEMID");
            String string = this.getWebContext().GetParamValue("PSAPPVIEWID");
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage());
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }
}

