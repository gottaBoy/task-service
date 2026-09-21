/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class MobileAppDBHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }
}

