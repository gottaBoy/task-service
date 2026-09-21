/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallelAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase2;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParallelAxisImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartParallelImpl
extends PSDEChartCoordinateSystemControlImplBase2
implements IPSDEChartParallel {
    private static final Log log = LogFactory.getLog(PSDEChartParallelImpl.class);
    private ArrayList<IPSChartParallelAxis> psChartParallelAxisList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSDEChartAxes> psDEChartAxes = this.getPSDEChart().getPSDEChartAxeses();
        if (psDEChartAxes != null) {
            while (psDEChartAxes.hasNext()) {
                IPSDEChartAxes iPSDEChartAxes = psDEChartAxes.next();
                if ((iPSDEChartAxes.getCoordinateSystemIndex() != -1 ? iPSDEChartAxes.getCoordinateSystemIndex() != this.getPSChartCoordinateSystem().getIndex() : this.getPSChartCoordinateSystem().getOriginIndex() != -1) || StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"parallel", (boolean)false) != 0) continue;
                PSDEChartParallelAxisImpl psDEChartParallelAxisImpl = new PSDEChartParallelAxisImpl();
                psDEChartParallelAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                this.psChartParallelAxisList.add(psDEChartParallelAxisImpl);
            }
        }
        super.onInit();
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartParallel(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u884c\u8f74\u96c6\u5408")
    public Iterator<IPSChartParallelAxis> getPSChartParallelAxises() {
        if (this.psChartParallelAxisList == null || this.psChartParallelAxisList.size() == 0) {
            return null;
        }
        return this.psChartParallelAxisList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPARALLEL";
    }

    @Override
    protected String onGetType() {
        return "parallel";
    }
}

