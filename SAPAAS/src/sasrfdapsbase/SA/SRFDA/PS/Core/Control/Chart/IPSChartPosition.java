/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u4f4d\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEChartSeries")
public interface IPSChartPosition {
    public Object getTop();

    public Object getLeft();

    public Object getBottom();

    public Object getRight();

    public Object getWidth();

    public Object getHeight();
}

