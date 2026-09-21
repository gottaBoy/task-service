/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMModelHelper;
import SA.IM.Ctrl.IMModelHelperFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class IMObjectBase {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    protected void setGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected IIMModelHelper getIMModelHelper() throws Exception {
        return IMModelHelperFactory.Create(this.iDAGlobalHelper);
    }
}

