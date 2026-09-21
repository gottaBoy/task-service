/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.DataSync.IDataSyncEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngineParam;

public interface IDataSyncInEngine
extends IDataSyncEngine {
    public boolean CheckRecv();

    public void Recv(IDataSyncEngineParam var1) throws Exception;
}

