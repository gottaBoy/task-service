/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IChartModel
extends ICtrlModel,
IChart {
    public Iterator<IChartAxisModel> getChartAxisModels();

    public Iterator<IChartSeriesModel> getChartSeriesModels();

    public void fillFetchResult(MDAjaxActionResult var1, IDataTable var2) throws Exception;
}

