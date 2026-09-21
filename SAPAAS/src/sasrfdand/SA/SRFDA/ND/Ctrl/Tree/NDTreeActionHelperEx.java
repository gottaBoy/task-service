/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.ND.Ctrl.Tree;

import SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx;
import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDModelHelperFactory;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class NDTreeActionHelperEx
extends BaseDATreeActionHelperEx {
    protected INDModelHelper getNDModelHelper() throws Exception {
        return NDModelHelperFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    protected INDModelStorage getNDModelStorage() throws Exception {
        return NDModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }
}

