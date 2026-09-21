/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetField;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataSetGroup;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEChartDataSetField;

@PSModelIgnoreMeta
public interface IPSDEChartDataSetRuntime {
    public IPSDEChartDataSetField registerPSDEChartDataSetField(PSDEChartDataSetField var1) throws Exception;

    public void setPSDEChartDataSetGroup(IPSDEChartDataSetGroup var1);
}

