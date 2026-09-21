/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report.Web.Storage;

import SA.SRFramework.Report.UI.ChartConfig;

public interface BaseChartConfigMgr {
    public String RegisterChart(ChartConfig var1);

    public void RemoveChart(String var1);

    public ChartConfig GetChart(String var1);
}

