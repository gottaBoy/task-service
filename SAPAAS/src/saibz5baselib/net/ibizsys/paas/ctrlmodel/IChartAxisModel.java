/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IModelBase;

public interface IChartAxisModel
extends IModelBase {
    public static final String AXISPOS_LEFT = "left";
    public static final String AXISPOS_BOTTOM = "bottom";
    public static final String AXISPOS_RIGHT = "right";
    public static final String AXISPOS_TOP = "top";
    public static final String AXISPOS_RADIAL = "radial";
    public static final String AXISPOS_ANGULAR = "angular";
    public static final String AXISTYPE_NUMERIC = "numeric";
    public static final String AXISTYPE_TIME = "time";
    public static final String AXISTYPE_CATEGORY = "category";

    public String getCaption();

    public String getAxisType();

    public String getAxisPos();
}

