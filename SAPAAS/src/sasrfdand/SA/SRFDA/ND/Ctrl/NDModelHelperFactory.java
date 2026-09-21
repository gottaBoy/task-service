/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.NDModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class NDModelHelperFactory {
    private static INDModelHelper biModelHelper = null;

    public static INDModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return NDModelHelperFactory.Create(iDAGlobalHelper, "");
    }

    public static INDModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelHelper != null) {
            return biModelHelper;
        }
        biModelHelper = new NDModelHelper();
        biModelHelper.Init(iDAGlobalHelper);
        return biModelHelper;
    }
}

