/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5750\u6807\u7cfb\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="type")
public interface IPSChartCoordinateSystem
extends IPSModelObject {
    public String getType();

    public String getEChartsType();

    public int getIndex();

    public int getOriginIndex();

    public Iterator<IPSChartSeries> getPSChartSerieses();

    public int getPSChartSeriesCount();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSChartCoordinateSystemControl getPSChartCoordinateSystemControl();
}

