/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFEndProcessModel;
import net.ibizsys.pswf.core.WFProcessModelBase;

public abstract class WFEndProcessModelBase
extends WFProcessModelBase
implements IWFEndProcessModel {
    private String strExitStateValue = "";

    @Override
    public String getExitStateValue() {
        return this.strExitStateValue;
    }

    public void setExitStateValue(String strExitStateValue) {
        this.strExitStateValue = strExitStateValue;
    }

    @Override
    public boolean isTerminalProcess() {
        return true;
    }

    public String getWFProcessType() {
        return "END";
    }
}

