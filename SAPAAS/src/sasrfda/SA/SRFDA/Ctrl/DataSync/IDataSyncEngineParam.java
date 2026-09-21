/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.Data.DataSyncIn;
import SA.SRFDA.Ctrl.Data.DataSyncOut;

public interface IDataSyncEngineParam {
    public DataSyncOut getDataSyncOut();

    public void AddDataSyncIn(DataSyncIn var1);
}

