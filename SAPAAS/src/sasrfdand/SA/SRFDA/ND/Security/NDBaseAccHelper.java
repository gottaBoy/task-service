/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.ND.Security;

import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Security.INDAccHelper;

public abstract class NDBaseAccHelper
implements INDAccHelper {
    @Override
    public boolean Test(INDActionContext iNDActionContext, NDDisk ndDisk, NDFSObject ndFSObject, int nTestActions) throws Exception {
        return this.OnTest(iNDActionContext, ndDisk, ndFSObject, nTestActions);
    }

    protected abstract boolean OnTest(INDActionContext var1, NDDisk var2, NDFSObject var3, int var4) throws Exception;
}

