/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u56fe\u8868\u8f74\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEChartAxes")
public interface IPSChartAxes
extends IPSModelObject {
    public static final int DATASHOWMODE_LONGITUDINAL = 1;
    public static final int DATASHOWMODE_HORIZONTAL = 2;
    public static final int DATASHOWMODE_OBLIQUE = 3;
    public static final String AXESPOS_LEFT = "left";
    public static final String AXESPOS_BOTTOM = "bottom";
    public static final String AXESPOS_RIGHT = "right";
    public static final String AXESPOS_TOP = "top";
    public static final String AXESPOS_RADIAL = "radial";
    public static final String AXESPOS_ANGULAR = "angular";
    public static final String AXESPOS_PARALLEL = "parallel";
    public static final String AXESPOS_SINGLE = "single";

    public String getCaption();

    public String getAxesType();

    public String getAxesPos();

    public IPSChart getPSChart();

    public String[] getFields();

    public IPSLanguageRes getCapPSLanguageRes();

    public int getDataShowMode();

    public Double getMaxValue();

    public Double getMinValue();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public int getCoordinateSystemIndex();
}

