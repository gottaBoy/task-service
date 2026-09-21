/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.general.PieDataset
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.ChartConfig;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

public class PieChartConfig
extends ChartConfig {
    private PieDataset pieDataset = null;
    private boolean bSupport3D = false;

    public void setSupport3D(boolean value) {
        this.bSupport3D = value;
    }

    public boolean getSupport3D() {
        return this.bSupport3D;
    }

    public void setCollection(PieDataset dataset) {
        this.pieDataset = dataset;
    }

    @Override
    protected JFreeChart CreateChartObject() {
        JFreeChart jfreeChart = null;
        jfreeChart = this.bSupport3D ? ChartFactory.createPieChart3D((String)this.getTitleText().getValue(), (PieDataset)this.pieDataset, (boolean)this.getShowLegend(), (boolean)true, (boolean)true) : ChartFactory.createPieChart((String)this.getTitleText().getValue(), (PieDataset)this.pieDataset, (boolean)this.getShowLegend(), (boolean)true, (boolean)true);
        this.OnFillChartInfo(jfreeChart);
        return jfreeChart;
    }
}

