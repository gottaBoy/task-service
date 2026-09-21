/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.TMModelStorage;

public class TMModelStorageFactory {
    private static ITMModelStorage biModelStorage = null;

    public static ITMModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return TMModelStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static ITMModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelStorage != null) {
            return biModelStorage;
        }
        biModelStorage = new TMModelStorage();
        biModelStorage.Init(iDAGlobalHelper);
        return biModelStorage;
    }
}

