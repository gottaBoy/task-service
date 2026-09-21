/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIModelStorage;
import SA.SRFDA.BI.Ctrl.IBIModelStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BIModelStorageFactory {
    private static IBIModelStorage biModelStorage = null;

    public static IBIModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return BIModelStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static IBIModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelStorage != null) {
            return biModelStorage;
        }
        BIModelStorage biModelStorage = new BIModelStorage();
        biModelStorage.Init(iDAGlobalHelper);
        BIModelStorageFactory.biModelStorage = biModelStorage;
        return biModelStorage;
    }
}

