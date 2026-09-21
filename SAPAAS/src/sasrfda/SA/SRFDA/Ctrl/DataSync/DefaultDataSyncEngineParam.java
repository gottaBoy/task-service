/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.Data.DataSyncIn;
import SA.SRFDA.Ctrl.Data.DataSyncOut;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngineParam;
import java.util.Vector;

public class DefaultDataSyncEngineParam
implements IDataSyncEngineParam {
    private DataSyncOut dataSyncOut = null;
    private Vector<DataSyncIn> dataSyncInList = new Vector();

    @Override
    public DataSyncOut getDataSyncOut() {
        return this.dataSyncOut;
    }

    public void setDataSyncOut(DataSyncOut dataSyncOut) {
        this.dataSyncOut = dataSyncOut;
    }

    @Override
    public void AddDataSyncIn(DataSyncIn dataSyncIn) {
        this.dataSyncInList.add(dataSyncIn);
    }

    public void ResetDataSyncIns() {
        this.dataSyncInList.clear();
    }

    public Vector<DataSyncIn> getDataSyncIns() {
        return this.dataSyncInList;
    }
}

