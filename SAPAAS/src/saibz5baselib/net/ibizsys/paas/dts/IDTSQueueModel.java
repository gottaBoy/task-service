/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.dts;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.IDTSQueue;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface IDTSQueueModel
extends IDTSQueue {
    public void init(ISystemModel var1) throws Exception;

    public IDataEntityModel getDEModel();

    public void push(IEntity var1) throws Exception;

    public int getQueryCancelTimeout();
}

