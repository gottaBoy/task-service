/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.chart;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.chart.IChartDataItem;

public interface IChart
extends IControl {
    public Iterator<IChartDataItem> getChartDataItems();
}

