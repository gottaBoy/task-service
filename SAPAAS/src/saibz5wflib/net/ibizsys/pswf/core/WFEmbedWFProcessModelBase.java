/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFEmbedWFProcessModel;
import net.ibizsys.pswf.core.WFEmbedWFProcessModelBaseBase;

public abstract class WFEmbedWFProcessModelBase
extends WFEmbedWFProcessModelBaseBase
implements IWFEmbedWFProcessModel {
    public String getWFProcessType() {
        return "EMBED";
    }

    @Override
    public boolean isSuspendProcess() {
        return true;
    }
}

