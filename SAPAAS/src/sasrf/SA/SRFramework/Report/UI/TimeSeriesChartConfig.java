/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.xy.XYDataset
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.XYAxisChartConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesChartConfig
extends XYAxisChartConfig {
    private XYDataset xyDataset = null;

    public void setCollection(XYDataset dataset) {
        this.xyDataset = dataset;
    }

    @Override
    protected JFreeChart CreateChartObject() {
        JFreeChart jfreeChart = ChartFactory.createTimeSeriesChart((String)this.getTitleText().getValue(), (String)this.getXAxisLabel().getValue(), (String)this.getYAxisLabel().getValue(), (XYDataset)this.xyDataset, (boolean)this.getShowLegend(), (boolean)false, (boolean)false);
        this.OnFillChartInfo(jfreeChart);
        return jfreeChart;
    }
}

