/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;

public interface IIMFuncServerContext {
    public void AddRemoteActionToQueue(IMRemoteAction var1);

    public IMMessagePackage SendRemoteAction(IMRemoteAction var1) throws Exception;

    public String getServerPath();

    public String getServerCometPath();

    public String getServerId();

    public boolean isLocalMode();
}

