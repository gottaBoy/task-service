/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIModelHelper;
import SA.SRFDA.BI.Ctrl.IBIModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BIModelHelperFactory {
    private static IBIModelHelper iBIModelHelper = null;

    public static IBIModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        if (iBIModelHelper != null) {
            return iBIModelHelper;
        }
        BaseBIModelHelper tempHelper = new BaseBIModelHelper();
        tempHelper.Init(iDAGlobalHelper);
        iBIModelHelper = tempHelper;
        return iBIModelHelper;
    }
}

