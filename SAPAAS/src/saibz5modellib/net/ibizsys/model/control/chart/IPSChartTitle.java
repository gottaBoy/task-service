/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.control.chart.IPSChartObject;

public interface IPSChartTitle
extends IPSChartObject {
    public static final String TITLEPOS_TOP = "TOP";
    public static final String TITLEPOS_BOTTOM = "BOTTOM";
    public static final String TITLEPOS_LEFT = "LEFT";
    public static final String TITLEPOS_RIGHT = "RIGHT";

    public String getTitle();

    public String getSubTitle();

    public boolean isShowTitle();

    public String getTitlePos();
}

