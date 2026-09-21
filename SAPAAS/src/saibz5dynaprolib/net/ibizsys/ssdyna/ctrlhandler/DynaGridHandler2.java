/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.ctrlhandler.GridHandlerBase2
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlhandler.GridHandlerBase2;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaGridHandler2
extends GridHandlerBase2
implements IDynaCtrlHandler {
    private IPSControl iPSControl = null;
    private IDynaCtrlModel iDynaCtrlModel = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.iDynaCtrlModel = (IDynaCtrlModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    protected IGridModel getGridModel() {
        return (IGridModel)this.iDynaCtrlModel;
    }
}

