/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMServer;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IIMServerStub {
    public void Init(ISRFDAGlobalHelper var1, String var2) throws Exception;

    public void Init(ISRFDAGlobalHelper var1, IMServer var2) throws Exception;

    public String getServerId();

    public String getServerType();

    public String getServerPath();

    public String getServerCometPath();

    public void setLocalMode(boolean var1);

    public boolean isLocalMode();

    public boolean isShuttingDown();

    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction var1) throws Exception;

    public IMMessagePackage SendRemoteAction(IIMRemoteAction var1) throws Exception;

    public String getServerStatus();
}

