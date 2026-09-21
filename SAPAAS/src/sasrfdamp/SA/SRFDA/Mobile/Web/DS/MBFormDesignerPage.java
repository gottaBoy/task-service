/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.Web.DS;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;

public class MBFormDesignerPage
extends SRFDAPage {
    public MBFormDesignerPage() {
        this.setJSCache(false);
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    public String GetDEID() {
        return this.getWebContext().getSRFDEID();
    }

    public String GetCtrlID() {
        return this.getWebContext().GetParamValue("SRFCTRLID");
    }

    public boolean GetSearchFormMode() {
        String strSFMode = this.getWebContext().GetParamValue("SRFSFMODE");
        return StringHelper.Compare((String)strSFMode, (String)"TRUE", (boolean)true) == 0;
    }

    public boolean GetDEFGroupSPMode() {
        String strDEFGroupSFMode = this.getWebContext().GetParamValue("SRFDEFGROUPSFMODE");
        return StringHelper.Compare((String)strDEFGroupSFMode, (String)"TRUE", (boolean)true) == 0;
    }
}

