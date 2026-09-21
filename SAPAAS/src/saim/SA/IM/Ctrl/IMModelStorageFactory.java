/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMModelStorage;
import SA.IM.Ctrl.IMModelStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class IMModelStorageFactory {
    private static IIMModelStorage biModelStorage = null;

    public static IIMModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return IMModelStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static IIMModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelStorage != null) {
            return biModelStorage;
        }
        biModelStorage = new IMModelStorage();
        biModelStorage.Init(iDAGlobalHelper);
        return biModelStorage;
    }
}

