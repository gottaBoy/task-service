/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMModelHelper;
import SA.IM.Ctrl.IMModelHelper;
import SA.IM.Ctrl.IMModelRemoteHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class IMModelHelperFactory {
    private static IIMModelHelper iIMModelHelper = null;

    public static IIMModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        if (iIMModelHelper != null) {
            return iIMModelHelper;
        }
        boolean bLocalMode = iDAGlobalHelper.getWebConfig().GetExtValue("IMLOCALMODE", true);
        iIMModelHelper = bLocalMode ? new IMModelHelper() : new IMModelRemoteHelper();
        iIMModelHelper.Init(iDAGlobalHelper);
        return iIMModelHelper;
    }
}

