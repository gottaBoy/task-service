/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlActionHandlerBase;
import net.ibizsys.paas.ctrlhandler.IGridActionHandler;
import net.ibizsys.paas.ctrlhandler.IGridHandler;
import net.ibizsys.paas.ctrlmodel.IGridModel;

public abstract class GridActionHandlerBase
extends CtrlActionHandlerBase
implements IGridActionHandler {
    protected IGridHandler getGridHandler() {
        return (IGridHandler)this.getCtrlHandler();
    }

    protected IGridModel getGridModel() {
        return (IGridModel)this.getGridHandler().getCtrlModel();
    }
}

