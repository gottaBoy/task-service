/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMModelHelper;
import SA.TM.Ctrl.ITMModelHelper;

public class TMModelHelperFactory {
    private static ITMModelHelper iTMModelHelper = null;

    public static ITMModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        if (iTMModelHelper != null) {
            return iTMModelHelper;
        }
        BaseTMModelHelper tempHelper = new BaseTMModelHelper();
        tempHelper.Init(iDAGlobalHelper);
        iTMModelHelper = tempHelper;
        return iTMModelHelper;
    }
}

