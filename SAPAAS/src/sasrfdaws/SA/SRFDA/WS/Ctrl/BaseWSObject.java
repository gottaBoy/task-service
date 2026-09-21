/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFDA.WS.Ctrl.IWSModelStorage;
import SA.SRFDA.WS.Ctrl.WSModelHelperFactory;
import SA.SRFDA.WS.Ctrl.WSModelStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseWSObject {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    protected IWSModelHelper getWSModelHelper() throws Exception {
        return WSModelHelperFactory.Create(this.iDAGlobalHelper);
    }

    protected IWSModelStorage getWSModelStorage() throws Exception {
        return WSModelStorageFactory.Create(this.iDAGlobalHelper);
    }
}

