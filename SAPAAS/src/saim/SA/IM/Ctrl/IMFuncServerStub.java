/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMFuncServerStub;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMServerStub;

public abstract class IMFuncServerStub
extends IMServerStub
implements IIMFuncServerStub {
    @Override
    public int CalcPriority(IIMRemoteAction iIMRemoteAction) throws Exception {
        return this.OnCalcPriority(iIMRemoteAction);
    }

    protected int OnCalcPriority(IIMRemoteAction iIMRemoteAction) throws Exception {
        return 1;
    }
}

