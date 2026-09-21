/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 */
package SA.SRFDA.ND.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDModelHelperFactory;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;

public abstract class NDDEDataCtrl
extends BaseDEDataCtrl {
    protected final INDModelStorage getNDModelStorage() throws Exception {
        return NDModelStorageFactory.Create(this.globalHelperEx);
    }

    protected final INDModelHelper getNDModelHelper() throws Exception {
        return NDModelHelperFactory.Create(this.getGlobalHelper());
    }
}

