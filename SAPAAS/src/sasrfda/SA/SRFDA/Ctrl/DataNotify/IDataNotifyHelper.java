/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DataNotify;

import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public interface IDataNotifyHelper {
    public CallResult Init(ISRFDAGlobalHelper var1);

    public CallResult QueueNotify(IDEDataCtrl var1, int var2, BaseDataEntity var3, BaseDataEntity var4);

    public CallResult Notify(IDEDataCtrl var1, DataNotify var2, BaseDataEntity var3, BaseDataEntity var4);

    public void RemoveTimeNotify(String var1, String var2);
}

