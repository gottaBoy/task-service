/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Web.DECtrlPreviewPage;
import SA.SRFramework.Utility.StringHelper;

public class DEFVRPreviewPage
extends DECtrlPreviewPage {
    public DEFVRPreviewPage() {
        this.setJSCache(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        boolean bRet = super.PreparePageEnv();
        if (!bRet) {
            return false;
        }
        try {
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSTEMID");
            IPSSystem iPSSystem = null;
            if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
                IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
                iPSSystem = iPSDevSlnSys.getPSSystem();
            } else {
                iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            this.PageLog((Object)this, 1, ex.getMessage());
            this.OutputAlertMsg(ex.getMessage(), false);
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
    }
}

