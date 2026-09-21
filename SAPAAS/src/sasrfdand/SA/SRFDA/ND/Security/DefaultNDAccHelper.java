/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.ND.Security;

import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Security.NDBaseAccHelper;

public class DefaultNDAccHelper
extends NDBaseAccHelper {
    @Override
    protected boolean OnTest(INDActionContext iNDActionContext, NDDisk ndDisk, NDFSObject ndFSObject, int nTestActions) throws Exception {
        return true;
    }
}

