/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.DataSync.IDataSyncEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngineParam;

public interface IDataSyncOutEngine
extends IDataSyncEngine {
    public boolean CheckSend();

    public void Send(IDataSyncEngineParam var1) throws Exception;
}

