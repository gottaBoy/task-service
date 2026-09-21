/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IChartRender;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class ChartHandlerBase
extends MDCtrlHandlerBase {
    protected abstract IChartModel getChartModel();

    @Override
    protected void onInit() throws Exception {
        if (this.getDefaultPageSize() < 0) {
            this.setDefaultPageSize(10000);
        }
        super.onInit();
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getChartModel();
    }

    @Override
    protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender != null) {
            ((IChartRender)iCtrlRender).fillFetchResult(this.getChartModel(), fetchResult, dt);
            return;
        }
        this.getChartModel().fillFetchResult(fetchResult, dt);
    }
}

