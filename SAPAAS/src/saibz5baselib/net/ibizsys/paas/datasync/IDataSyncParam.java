/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datasync;

import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;

public interface IDataSyncParam {
    public DataSyncOut getDataSyncOut();

    public void addDataSyncIn(DataSyncIn var1);
}

