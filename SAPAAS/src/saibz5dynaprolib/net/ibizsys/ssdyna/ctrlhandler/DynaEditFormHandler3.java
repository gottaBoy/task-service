/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.ctrlhandler.EditFormHandlerBase3
 *  net.ibizsys.paas.ctrlmodel.IEditFormModel
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase3;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaEditFormHandler3
extends EditFormHandlerBase3
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

    protected IEditFormModel getEditFormModel() {
        return (IEditFormModel)this.iDynaCtrlModel;
    }
}

