/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.WFProcessModelBase;

public abstract class WFStartProcessModelBase
extends WFProcessModelBase {
    @Override
    public boolean isStartProcess() {
        return true;
    }

    public String getWFProcessType() {
        return "START";
    }
}

