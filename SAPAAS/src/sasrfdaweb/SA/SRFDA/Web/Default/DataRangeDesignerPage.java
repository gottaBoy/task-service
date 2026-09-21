/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;

public class DataRangeDesignerPage
extends SRFDAPage {
    public DataRangeDesignerPage() {
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

    protected void OnInitComponents() {
        super.OnInitComponents();
    }
}

