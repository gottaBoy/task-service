/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDashboardModel;

public abstract class DashboardHandlerBase
extends CtrlHandlerBase {
    protected abstract IDashboardModel getDashboardModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getDashboardModel();
    }
}

