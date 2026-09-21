/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMFuncServerInstance;
import SA.IM.Ctrl.IMException;

public interface IIMMeetingServerInstance
extends IIMFuncServerInstance {
    public void RegisterUserConnection(String var1, String var2, String var3, IIMCometEvent var4) throws IMException;

    public void UnregisterUserConnection(String var1, String var2) throws IMException;
}

