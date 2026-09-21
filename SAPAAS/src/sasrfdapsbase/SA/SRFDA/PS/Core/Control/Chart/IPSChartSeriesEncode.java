/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5e8f\u5217\u7f16\u7801\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="type")
public interface IPSChartSeriesEncode
extends IPSChartObject {
    public IPSChartSeries getPSChartSeries();

    public String[] getTooltip();

    public String[] getSeriesName();

    public String getItemId();

    public String getItemName();

    public String getType();
}

