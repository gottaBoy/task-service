/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5750\u6807\u7cfb\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="type")
public interface IPSChartCoordinateSystemControl
extends IPSChartObject {
    public static final String TYPE_GRID = "grid";
    public static final String TYPE_RADAR = "radar";
    public static final String TYPE_CALENDAR = "calendar";
    public static final String TYPE_POLAR = "polar";
    public static final String TYPE_PARALLEL = "parallel";
    public static final String TYPE_SINGLE = "single";
    public static final String TYPE_GEO = "geo";

    public IPSChartCoordinateSystem getPSChartCoordinateSystem();

    public IPSPFXCodeObject getRender();

    public String getType();

    public String getBaseOptionJOString();
}

