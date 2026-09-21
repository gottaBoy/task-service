/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Ctrl.Data.SyncAgentType;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngine;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ISyncAgentTypeHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, SyncAgentType var2) throws Exception;

    public IDataSyncEngine CreateDataSyncEngine(DataSyncAgent var1) throws Exception;
}

