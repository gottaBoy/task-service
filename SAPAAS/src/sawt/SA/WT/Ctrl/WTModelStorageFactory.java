/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.WTModelStorage;

public class WTModelStorageFactory {
    private static IWTModelStorage biModelStorage = null;

    public static IWTModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return WTModelStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static IWTModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelStorage != null) {
            return biModelStorage;
        }
        biModelStorage = new WTModelStorage();
        biModelStorage.Init(iDAGlobalHelper);
        return biModelStorage;
    }
}

