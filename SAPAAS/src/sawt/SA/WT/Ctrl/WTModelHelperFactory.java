/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Ctrl.WTModelHelper;

public class WTModelHelperFactory {
    private static IWTModelHelper iWTModelHelper = null;

    public static IWTModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        if (iWTModelHelper != null) {
            return iWTModelHelper;
        }
        iWTModelHelper = new WTModelHelper();
        iWTModelHelper.Init(iDAGlobalHelper);
        return iWTModelHelper;
    }
}

