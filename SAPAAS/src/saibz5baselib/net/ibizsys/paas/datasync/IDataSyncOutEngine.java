/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.datasync;

import net.ibizsys.paas.datasync.IDataSyncEngine;
import net.ibizsys.paas.datasync.IDataSyncParam;

public interface IDataSyncOutEngine
extends IDataSyncEngine {
    public boolean checkSend() throws Exception;

    public void send(IDataSyncParam var1) throws Exception;
}

