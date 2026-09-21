/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSChartAxes
extends IPSModelObject {
    public static final int DATASHOWMODE_LONGITUDINAL = 1;
    public static final int DATASHOWMODE_HORIZONTAL = 2;
    public static final int DATASHOWMODE_OBLIQUE = 3;

    public String getCaption();

    public String getAxesType();

    public String getAxesPos();

    public IPSChart getPSChart();

    public String[] getFields();

    public int getDataShowMode();

    public Double getMaxValue();

    public Double getMinValue();
}

