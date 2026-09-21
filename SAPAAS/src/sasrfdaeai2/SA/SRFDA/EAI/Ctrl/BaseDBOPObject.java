/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.DBOPModelHelperFactory;
import SA.SRFDA.EAI.Ctrl.IDBOPModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseDBOPObject {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    protected void setGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected IDBOPModelHelper getDBOPModelHelper() throws Exception {
        return DBOPModelHelperFactory.Create(this.iDAGlobalHelper);
    }
}

