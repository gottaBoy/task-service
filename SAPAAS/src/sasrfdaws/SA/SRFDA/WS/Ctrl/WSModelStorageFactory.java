/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.IWSModelStorage;
import SA.SRFDA.WS.Ctrl.WSModelStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class WSModelStorageFactory {
    private static IWSModelStorage biModelStorage = null;

    public static IWSModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return WSModelStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static IWSModelStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (biModelStorage != null) {
            return biModelStorage;
        }
        biModelStorage = new WSModelStorage();
        biModelStorage.Init(iDAGlobalHelper);
        return biModelStorage;
    }
}

