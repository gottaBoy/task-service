/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDataSyncEngine {
    public void Init(ISRFDAGlobalHelper var1, DataSyncAgent var2) throws Exception;

    public void Quit() throws Exception;

    public String getId();

    public String getName();

    public String getSyncDir();
}

