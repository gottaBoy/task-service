/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u76f4\u89d2\u5750\u6807\u7cfb\u5185\u7ed8\u56fe\u7f51\u683c\u8f74\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSChartGridAxis
extends IPSChartAxis {
    public static final String POSITION_TOP = "top";
    public static final String POSITION_BOTTOM = "bottom";
    public static final String POSITION_LEFT = "left";
    public static final String POSITION_RIGHT = "right";

    public IPSChartGrid getPSChartGrid();

    @Override
    public Double getMaxValue();

    @Override
    public Double getMinValue();

    @Override
    public String getPosition();

    @Override
    public String getType();
}

