/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u90e8\u4ef6\u56fe\u4f8b\u5bf9\u8c61\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEChart")
public interface IPSChartLegend
extends IPSChartObject {
    public static final String LEGENDPOS_TOP = "TOP";
    public static final String LEGENDPOS_BOTTOM = "BOTTOM";
    public static final String LEGENDPOS_LEFT = "LEFT";
    public static final String LEGENDPOS_RIGHT = "RIGHT";

    public boolean isShowLegend();

    public String getLegendPos();
}

