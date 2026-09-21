/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u56fe\u8868\u6570\u636e\u96c6\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartDataSetGroupImpl")
public interface IPSChartDataSetGroup
extends IPSChartObject {
    public IPSDEDataSet getPSDEDataSet();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEDataSet getPSAppDEDataSet();

    public Iterator<? extends IPSChartDataSet> getPSChartDataSets();
}

