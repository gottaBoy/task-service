/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datasync;

import java.util.ArrayList;
import net.ibizsys.paas.datasync.IDataSyncParam;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;

public class DefaultDataSyncParam
implements IDataSyncParam {
    private DataSyncOut dataSyncOut = null;
    private ArrayList<DataSyncIn> dataSyncInList = new ArrayList();

    @Override
    public DataSyncOut getDataSyncOut() {
        return this.dataSyncOut;
    }

    public void setDataSyncOut(DataSyncOut dataSyncOut) {
        this.dataSyncOut = dataSyncOut;
    }

    @Override
    public void addDataSyncIn(DataSyncIn dataSyncIn) {
        this.dataSyncInList.add(dataSyncIn);
    }

    public void resetDataSyncIns() {
        this.dataSyncInList.clear();
    }

    public ArrayList<DataSyncIn> getDataSyncIns() {
        return this.dataSyncInList;
    }
}

