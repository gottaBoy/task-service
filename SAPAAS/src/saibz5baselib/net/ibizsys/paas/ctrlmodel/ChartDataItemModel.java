/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.demodel.IDataEntityModel;

public class ChartDataItemModel
extends DataItemModel
implements IChartDataItem {
    protected IChart iChart = null;

    public void init(IChart iChart) throws Exception {
        this.setChart(iChart);
        this.onInit();
    }

    protected IChart getChart() {
        return this.iChart;
    }

    protected void setChart(IChart iChart) {
        this.iChart = iChart;
    }

    @Override
    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        return this.getChart().getDataEntity().getSystem();
    }

    @Override
    protected IDataEntityModel getDEModel() throws Exception {
        return (IDataEntityModel)this.getChart().getDataEntity();
    }
}

