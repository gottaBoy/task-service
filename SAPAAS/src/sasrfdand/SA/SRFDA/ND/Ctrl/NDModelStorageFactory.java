/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDModelStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class NDModelStorageFactory {
    private static INDModelStorage biModelStorage = null;

    public static INDModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return NDModelStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static INDModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelStorage != null) {
            return biModelStorage;
        }
        biModelStorage = new NDModelStorage();
        biModelStorage.Init(iDAGlobalHelper);
        return biModelStorage;
    }
}

