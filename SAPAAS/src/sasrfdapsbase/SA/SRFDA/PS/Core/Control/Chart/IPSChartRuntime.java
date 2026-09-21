/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEChartCS;

@PSModelIgnoreMeta
public interface IPSChartRuntime {
    public IPSChartCoordinateSystem createPSChartCoordinateSystem(PSDEChartCS var1) throws Exception;
}

