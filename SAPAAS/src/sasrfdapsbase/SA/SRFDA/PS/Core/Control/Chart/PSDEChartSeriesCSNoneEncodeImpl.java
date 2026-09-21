/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCSNoneEncode;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesEncodeImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartSeriesEncode", typevalues={"NONE"})
public class PSDEChartSeriesCSNoneEncodeImpl
extends PSDEChartSeriesEncodeImplBase
implements IPSChartSeriesCSNoneEncode {
    @Override
    @PSModelRTMeta(description="\u5206\u7c7b\u5c5e\u6027")
    public String getCategory() {
        return this.getPSDEChartSeries().getCatalogField();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027")
    public String getValue() {
        return this.getPSDEChartSeries().getValueField();
    }

    @Override
    protected String onGetType() {
        return "NONE";
    }
}

