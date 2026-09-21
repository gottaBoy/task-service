/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetField;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSetGroup;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u56fe\u8868\u6570\u636e\u96c6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartDataSetImpl")
public interface IPSChartDataSet
extends IPSChartObject {
    public IPSDEDataSet getPSDEDataSet();

    public Iterator<? extends IPSChartDataSetField> getPSChartDataSetFields();

    public IPSChartDataSetGroup getPSChartDataSetGroup();

    public IPSChartSeries getPSChartSeries();
}

