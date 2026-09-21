/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.PS.Data.PSDEChartCS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u56fe\u8868\u5750\u6807\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEChartCoordinateSystem
extends IPSChartCoordinateSystem,
IPSDEChartObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEChart var2, PSDEChart var3, PSDEChartCS var4) throws Exception;
}

