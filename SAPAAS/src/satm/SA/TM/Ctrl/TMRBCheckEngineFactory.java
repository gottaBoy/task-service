/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.ITMRBCheckEngine;
import SA.TM.Ctrl.TMRBCheckEngine;

public class TMRBCheckEngineFactory {
    private static ITMRBCheckEngine iTMRBCheckEngine = null;

    public static ITMRBCheckEngine Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return TMRBCheckEngineFactory.Create(iDAGlobalHelper, "");
    }

    public static ITMRBCheckEngine Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (iTMRBCheckEngine != null) {
            return iTMRBCheckEngine;
        }
        iTMRBCheckEngine = new TMRBCheckEngine();
        iTMRBCheckEngine.Init(iDAGlobalHelper);
        return iTMRBCheckEngine;
    }
}

