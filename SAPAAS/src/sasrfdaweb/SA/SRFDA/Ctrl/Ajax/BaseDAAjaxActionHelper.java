/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxActionHelper
 */
package SA.SRFDA.Ctrl.Ajax;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionHelper;

public class BaseDAAjaxActionHelper
extends SRFExAjaxActionHelper {
    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }
}

