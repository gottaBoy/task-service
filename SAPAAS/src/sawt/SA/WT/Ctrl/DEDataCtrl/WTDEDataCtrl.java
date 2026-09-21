/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 */
package SA.WT.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.WTModelHelperFactory;
import SA.WT.Ctrl.WTModelStorageFactory;

public abstract class WTDEDataCtrl
extends BaseDEDataCtrl {
    protected IWTModelHelper getWTModelHelper() throws Exception {
        return WTModelHelperFactory.Create(this.getGlobalHelper());
    }

    protected IWTModelStorage getWTModelStorage() throws Exception {
        return WTModelStorageFactory.Create(this.getGlobalHelper());
    }
}

