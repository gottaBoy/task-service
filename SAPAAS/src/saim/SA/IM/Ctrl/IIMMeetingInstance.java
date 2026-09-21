/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMMeetingServerContext;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;

public interface IIMMeetingInstance {
    public void Init(ISRFDAGlobalHelper var1, IIMMeetingServerContext var2, IMMeeting var3) throws Exception;

    public String getMeetingId();

    public int getMeetingType();

    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction var1) throws Exception;

    public void RegisterUserConnection(String var1, String var2, IIMCometEvent var3) throws IMException;

    public void UnregisterUserConnection(String var1) throws IMException;

    public void DispatchMessage();

    public void FillSaveDatas(Vector<BaseDataEntity> var1);

    public void TestTimeout();

    public boolean isTimeout();

    public void Close();
}

