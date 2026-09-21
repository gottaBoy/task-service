/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMUserSession;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMStateServerContext;
import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IIMUserSessionInstance {
    public void Init(ISRFDAGlobalHelper var1, IIMStateServerContext var2, IMUserSession var3) throws Exception;

    public String getUserId();

    public String getUserSessionId();

    public void AddMessageToQueue(IMMessageBase var1, boolean var2);

    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction var1) throws Exception;

    public void RegisterUserConnection(IIMCometEvent var1);

    public void UnregisterUserConnection();

    public void Close();

    public boolean isTimeout();
}

