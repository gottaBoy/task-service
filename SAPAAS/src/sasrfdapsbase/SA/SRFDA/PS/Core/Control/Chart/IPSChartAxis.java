/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u56fe\u8868\u8f74\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSChartAxis
extends IPSChartObject,
IPSControlItem {
    public static final String ECHARTSPOS_XAXIS = "xAxis";
    public static final String ECHARTSPOS_YAXIS = "yAxis";
    public static final String ECHARTSPOS_ANGLEAXIS = "angleAxis";
    public static final String ECHARTSPOS_RADIUSAXIS = "radiusAxis";
    public static final String ECHARTSPOS_RARALLELAXIS = "rarallelAxis";
    public static final String ECHARTSPOS_SINGLEAXIS = "singleAxis";
    public static final String ECHARTSTYPE_VALUE = "value";
    public static final String ECHARTSTYPE_CATEGORY = "category";
    public static final String ECHARTSTYPE_TIME = "time";
    public static final String ECHARTSTYPE_LOG = "log";

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getEChartsType();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSPFXCodeObject getRender();

    public Double getMaxValue();

    public Double getMinValue();

    public String getType();

    public IPSDEChartAxes getPSDEChartAxes();

    public String getEChartsPos();

    public String getPosition();

    public String getBaseOptionJOString();

    public int getDataShowMode();
}

