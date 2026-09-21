/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;

@PSModelInterfaceMeta(title="\u56fe\u8868\u6807\u9898\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEChart")
public interface IPSChartTitle
extends IPSChartObject {
    public static final String TITLEPOS_TOP = "TOP";
    public static final String TITLEPOS_BOTTOM = "BOTTOM";
    public static final String TITLEPOS_LEFT = "LEFT";
    public static final String TITLEPOS_RIGHT = "RIGHT";

    public String getTitle();

    public String getSubTitle();

    public boolean isShowTitle();

    public IPSLanguageRes getTitlePSLanguageRes();

    public IPSLanguageRes getSubTitlePSLanguageRes();

    public String getTitlePos();
}

