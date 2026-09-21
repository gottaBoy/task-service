/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.WFEmbedWFProcessModelBaseBase;

public abstract class WFParallelSubWFProcessModelBase
extends WFEmbedWFProcessModelBaseBase
implements IWFParallelSubWFProcessModel {
    public String getWFProcessType() {
        return "PARALLEL";
    }
}

