/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.BaseChartConfig;
import SA.SRFramework.Report.UI.TitleTextConfig;

public abstract class ChartConfig
extends BaseChartConfig {
    protected int curChartStyle = 100;
    protected TitleTextConfig curTitleTextConfig = new TitleTextConfig();
    protected boolean bPlotVertical = true;
    protected boolean bShowLegend = true;

    public TitleTextConfig getTitleText() {
        return this.curTitleTextConfig;
    }

    public void setTitleText(TitleTextConfig value) {
        this.curTitleTextConfig = value;
    }

    public void setPlotVertical(boolean value) {
        this.bPlotVertical = value;
    }

    public boolean getPlotVertical() {
        return this.bPlotVertical;
    }

    public void setShowLegend(boolean bShowLegend) {
        this.bShowLegend = bShowLegend;
    }

    public boolean getShowLegend() {
        return this.bShowLegend;
    }
}

