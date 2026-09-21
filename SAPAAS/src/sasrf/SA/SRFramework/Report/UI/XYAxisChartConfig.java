/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.AxisLabelConfig;
import SA.SRFramework.Report.UI.ChartConfig;
import java.text.NumberFormat;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;

public abstract class XYAxisChartConfig
extends ChartConfig {
    private AxisLabelConfig xAxisLabelConfig = new AxisLabelConfig();
    private AxisLabelConfig yAxisLabelConfig = new AxisLabelConfig();
    private NumberFormat rangeFormat = null;
    protected ValueAxis rangeAxis = null;

    public void setRangeAxis(ValueAxis value) {
        this.rangeAxis = value;
    }

    public ValueAxis getRangeAxis() {
        if (this.rangeAxis == null) {
            this.rangeAxis = this.CreateRangeAxis();
        }
        return this.rangeAxis;
    }

    protected ValueAxis CreateRangeAxis() {
        return new NumberAxis();
    }

    public void setXAxisLabel(AxisLabelConfig value) {
        this.xAxisLabelConfig = value;
    }

    public void setYAxisLabel(AxisLabelConfig value) {
        this.yAxisLabelConfig = value;
    }

    public AxisLabelConfig getXAxisLabel() {
        return this.xAxisLabelConfig;
    }

    public AxisLabelConfig getYAxisLabel() {
        return this.yAxisLabelConfig;
    }

    @Override
    protected void OnFillChartInfo(JFreeChart freeChart) {
        if (this.rangeAxis != null) {
            freeChart.getXYPlot().setRangeAxis(this.rangeAxis);
        }
        super.OnFillChartInfo(freeChart);
    }
}

