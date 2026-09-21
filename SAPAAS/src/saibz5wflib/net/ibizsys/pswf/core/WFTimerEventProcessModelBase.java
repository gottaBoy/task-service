/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFTimerEventProcessModel;
import net.ibizsys.pswf.core.WFProcessModelBase;

public abstract class WFTimerEventProcessModelBase
extends WFProcessModelBase
implements IWFTimerEventProcessModel {
    @Override
    public boolean isSuspendProcess() {
        return true;
    }

    public String getWFProcessType() {
        return "TIMEREVENT";
    }
}

