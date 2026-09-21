/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase
 *  net.ibizsys.paas.ctrlmodel.ISearchFormModel
 */
package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase;
import net.ibizsys.paas.ctrlmodel.ISearchFormModel;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaSearchFormHandler
extends SearchFormHandlerBase
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

    protected ISearchFormModel getSearchFormModel() {
        return (ISearchFormModel)this.iDynaCtrlModel;
    }
}

