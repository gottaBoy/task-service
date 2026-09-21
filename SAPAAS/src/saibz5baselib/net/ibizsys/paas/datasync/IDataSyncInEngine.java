/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datasync;

import net.ibizsys.paas.datasync.IDataSyncEngine;
import net.ibizsys.paas.datasync.IDataSyncParam;

public interface IDataSyncInEngine
extends IDataSyncEngine {
    public boolean checkRecv() throws Exception;

    public void recv(IDataSyncParam var1) throws Exception;
}

