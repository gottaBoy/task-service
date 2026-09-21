/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.PDA;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;

public class BasePDAPage
extends SRFDAPage {
    protected String OnGetDataEntityId() {
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            return this.strPageDataEntityId;
        }
        return this.getWebContext().getSRFDEID();
    }

    protected boolean isSubmitMode() {
        String strSubmitMode = this.getWebContext().GetParamValue("SUBMITMODE");
        return StringHelper.Compare((String)strSubmitMode, (String)"TRUE", (boolean)true) == 0;
    }
}

