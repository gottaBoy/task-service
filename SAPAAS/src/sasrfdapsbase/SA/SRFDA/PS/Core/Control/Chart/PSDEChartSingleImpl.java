/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSingleAxisImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartSingleImpl
extends PSDEChartCoordinateSystemControlImplBase
implements IPSDEChartSingle {
    private static final Log log = LogFactory.getLog(PSDEChartSingleImpl.class);
    private IPSChartSingleAxis iPSChartSingleAxis = null;

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSDEChartAxes> psDEChartAxes = this.getPSDEChart().getPSDEChartAxeses();
        if (psDEChartAxes != null) {
            while (psDEChartAxes.hasNext()) {
                IPSDEChartAxes iPSDEChartAxes = psDEChartAxes.next();
                if ((iPSDEChartAxes.getCoordinateSystemIndex() != -1 ? iPSDEChartAxes.getCoordinateSystemIndex() != this.getPSChartCoordinateSystem().getIndex() : this.getPSChartCoordinateSystem().getOriginIndex() != -1) || StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"single", (boolean)false) != 0) continue;
                PSDEChartSingleAxisImpl psDEChartSingleAxisImpl = new PSDEChartSingleAxisImpl();
                psDEChartSingleAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                this.iPSChartSingleAxis = psDEChartSingleAxisImpl;
            }
        }
        if (this.getPSChartSingleAxis() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u5355\u8f74\u5750\u6807\u7cfb[%1$s]\u5b9a\u4e49\u5355\u8f74", (Object)this.getName()));
        }
        super.onInit();
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartSingle(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }

    @Override
    @PSModelRTMeta(description="\u5355\u8f74\u5bf9\u8c61")
    public IPSChartSingleAxis getPSChartSingleAxis() {
        return this.iPSChartSingleAxis;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTSINGLE";
    }

    @Override
    protected String onGetType() {
        return "single";
    }
}

