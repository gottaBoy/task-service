/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datasync;

import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;

public interface IDataSyncEngine {
    public static final String SYNCDIR_IN = "IN";
    public static final String SYNCDIR_OUT = "OUT";

    public void init(DataSyncAgent var1) throws Exception;

    public void quit() throws Exception;

    public String getId();

    public String getName();

    public String getSyncDir();
}

