/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IListModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class ListHandlerBase
extends MDCtrlHandlerBase {
    protected abstract IListModel getListModel();

    @Override
    protected void onInit() throws Exception {
        if (this.getListModel().getPageSize() > 0) {
            this.setDefaultPageSize(this.getListModel().getPageSize());
        }
        super.onInit();
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getListModel();
    }

    @Override
    protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        this.getListModel().fillFetchResult(fetchResult, dt);
    }
}

