/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.BaseWSModelHelper;
import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class WSModelHelperFactory {
    private static IWSModelHelper iWSModelHelper = null;

    public static IWSModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        if (iWSModelHelper != null) {
            return iWSModelHelper;
        }
        BaseWSModelHelper tempHelper = new BaseWSModelHelper();
        tempHelper.Init(iDAGlobalHelper);
        iWSModelHelper = tempHelper;
        return iWSModelHelper;
    }
}

