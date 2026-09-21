/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDTSQueue;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.dts.IDTSQueueModel;

public interface IDEDTSQueueModel
extends IDEDTSQueue,
IModelBase3 {
    public IDTSQueueModel getDTSQueueModel() throws Exception;
}

