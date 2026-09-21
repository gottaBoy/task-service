/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.chart.IPSChartObject;

public interface IPSChartLegend
extends IPSChartObject {
    public static final String LEGENDPOS_TOP = "TOP";
    public static final String LEGENDPOS_BOTTOM = "BOTTOM";
    public static final String LEGENDPOS_LEFT = "LEFT";
    public static final String LEGENDPOS_RIGHT = "RIGHT";

    public boolean isShowLegend();

    public String getLegendPos();
}

