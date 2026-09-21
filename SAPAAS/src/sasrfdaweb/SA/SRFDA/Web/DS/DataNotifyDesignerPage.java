/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Web.SRFDAPage;

public class DataNotifyDesignerPage
extends SRFDAPage {
    public String GetDEID() {
        return this.getWebContext().GetParamValue("SRFDEID");
    }

    public String GetCtrlID() {
        return this.getWebContext().GetParamValue("SRFCTRLID");
    }
}

