/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDataViewModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class DataViewHandlerBase
extends MDCtrlHandlerBase {
    protected abstract IDataViewModel getDataViewModel();

    @Override
    protected void onInit() throws Exception {
        if (this.getDataViewModel().getPageSize() > 0) {
            this.setDefaultPageSize(this.getDataViewModel().getPageSize());
        }
        super.onInit();
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getDataViewModel();
    }

    @Override
    protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        this.getDataViewModel().fillFetchResult(fetchResult, dt);
    }
}

