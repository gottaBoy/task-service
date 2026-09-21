/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.SRFDAPage
 */
package SA.SRFDA.EAI.Web;

import SA.SRFDA.EAI.Web.JSGear.EAIAppIntDGNewEditJSGear;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.SRFDAPage;

public class AppIntGridViewPage
extends GridViewPage {
    protected boolean IsLoadDataGridNewEditJSGear() {
        return false;
    }

    protected void OnInit() {
        super.OnInit();
        EAIAppIntDGNewEditJSGear.Load((SRFDAPage)this, this.dataGrid, true, true, true);
    }
}

