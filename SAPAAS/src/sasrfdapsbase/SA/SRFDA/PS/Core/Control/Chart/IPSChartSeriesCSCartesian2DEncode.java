/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartYAxis;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u5e8f\u5217\u76f4\u89d2\u5750\u6807\u7cfb\u7f16\u7801\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"XY"})
public interface IPSChartSeriesCSCartesian2DEncode
extends IPSChartSeriesEncode {
    public String[] getX();

    public String[] getY();

    public IPSChartXAxis getPSChartXAxis();

    public IPSChartYAxis getPSChartYAxis();
}

