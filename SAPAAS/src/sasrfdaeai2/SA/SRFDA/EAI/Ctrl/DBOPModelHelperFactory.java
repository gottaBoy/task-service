/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPModelHelper;
import SA.SRFDA.EAI.Ctrl.IDBOPModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DBOPModelHelperFactory {
    private static IDBOPModelHelper iDBOPModelHelper = null;

    public static IDBOPModelHelper Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        if (iDBOPModelHelper != null) {
            return iDBOPModelHelper;
        }
        BaseDBOPModelHelper tempHelper = new BaseDBOPModelHelper();
        tempHelper.Init(iDAGlobalHelper);
        iDBOPModelHelper = tempHelper;
        return iDBOPModelHelper;
    }
}

