/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMFuncServerInstance;

public interface IIMStateServerInstance
extends IIMFuncServerInstance {
    public boolean RegisterUserConnection(String var1, String var2, IIMCometEvent var3) throws Exception;

    public void UnregisterUserConnection(String var1, String var2);
}

