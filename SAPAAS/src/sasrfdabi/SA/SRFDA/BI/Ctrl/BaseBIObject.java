/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIModelHelperFactory;
import SA.SRFDA.BI.Ctrl.BIModelStorageFactory;
import SA.SRFDA.BI.Ctrl.IBIModelHelper;
import SA.SRFDA.BI.Ctrl.IBIModelStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseBIObject {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    protected IBIModelHelper getBIModelHelper() throws Exception {
        return BIModelHelperFactory.Create(this.iDAGlobalHelper);
    }

    protected IBIModelStorage getBIModelStorage() throws Exception {
        return BIModelStorageFactory.Create(this.iDAGlobalHelper);
    }
}

