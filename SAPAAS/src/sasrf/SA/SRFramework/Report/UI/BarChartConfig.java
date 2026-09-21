/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.XYAxisChartConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class BarChartConfig
extends XYAxisChartConfig {
    private boolean bSupport3D = false;
    private CategoryDataset categoryDataset = null;

    public void setSupport3D(boolean value) {
        this.bSupport3D = value;
    }

    public boolean getSupport3D() {
        return this.bSupport3D;
    }

    public void setCollection(CategoryDataset dataset) {
        this.categoryDataset = dataset;
    }

    @Override
    protected JFreeChart CreateChartObject() {
        PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
        if (!this.getPlotVertical()) {
            plotOrientation = PlotOrientation.HORIZONTAL;
        }
        JFreeChart jfreeChart = null;
        jfreeChart = this.bSupport3D ? ChartFactory.createBarChart3D((String)this.getTitleText().getValue(), (String)this.getXAxisLabel().getValue(), (String)this.getYAxisLabel().getValue(), (CategoryDataset)this.categoryDataset, (PlotOrientation)plotOrientation, (boolean)this.getShowLegend(), (boolean)true, (boolean)true) : ChartFactory.createBarChart((String)this.getTitleText().getValue(), (String)this.getXAxisLabel().getValue(), (String)this.getYAxisLabel().getValue(), (CategoryDataset)this.categoryDataset, (PlotOrientation)plotOrientation, (boolean)this.getShowLegend(), (boolean)true, (boolean)true);
        this.OnFillChartInfo(jfreeChart);
        return jfreeChart;
    }
}

