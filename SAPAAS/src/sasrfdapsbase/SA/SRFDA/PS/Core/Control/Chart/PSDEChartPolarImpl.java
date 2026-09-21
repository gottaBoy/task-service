/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolarAngleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolarRadiusAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartPolarAngleAxisImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartPolarRadiusAxisImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartPolarImpl
extends PSDEChartCoordinateSystemControlImplBase
implements IPSDEChartPolar {
    private static final Log log = LogFactory.getLog(PSDEChartPolarImpl.class);
    private IPSChartPolarAngleAxis iPSChartPolarAngleAxis = null;
    private IPSChartPolarRadiusAxis iPSChartPolarRadiusAxis = null;

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSDEChartAxes> psDEChartAxes = this.getPSDEChart().getPSDEChartAxeses();
        if (psDEChartAxes != null) {
            while (psDEChartAxes.hasNext()) {
                IPSDEChartAxes iPSDEChartAxes = psDEChartAxes.next();
                if (iPSDEChartAxes.getCoordinateSystemIndex() != -1 ? iPSDEChartAxes.getCoordinateSystemIndex() != this.getPSChartCoordinateSystem().getIndex() : this.getPSChartCoordinateSystem().getOriginIndex() != -1) continue;
                if (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"angular", (boolean)false) == 0) {
                    PSDEChartPolarAngleAxisImpl psDEChartPolarAngleAxisImpl = new PSDEChartPolarAngleAxisImpl();
                    psDEChartPolarAngleAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                    this.iPSChartPolarAngleAxis = psDEChartPolarAngleAxisImpl;
                    continue;
                }
                if (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"radial", (boolean)false) != 0) continue;
                PSDEChartPolarRadiusAxisImpl psDEChartPolarRadiusAxisImpl = new PSDEChartPolarRadiusAxisImpl();
                psDEChartPolarRadiusAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                this.iPSChartPolarRadiusAxis = psDEChartPolarRadiusAxisImpl;
            }
        }
        if (this.getPSChartPolarAngleAxis() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u6781\u5750\u6807\u7cfb[%1$s]\u5b9a\u4e49\u89d2\u5ea6\u8f74", (Object)this.getName()));
        }
        if (this.getPSChartPolarRadiusAxis() == null) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u4e3a\u6781\u5750\u6807\u7cfb[%1$s]\u5b9a\u4e49\u5f84\u5411\u8f74", (Object)this.getName()));
        }
        super.onInit();
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartPolar(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u5ea6\u8f74", child=true)
    public IPSChartPolarAngleAxis getPSChartPolarAngleAxis() {
        return this.iPSChartPolarAngleAxis;
    }

    @Override
    @PSModelRTMeta(description="\u5f84\u5411\u8f74", child=true)
    public IPSChartPolarRadiusAxis getPSChartPolarRadiusAxis() {
        return this.iPSChartPolarRadiusAxis;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPOLAR";
    }

    @Override
    protected String onGetType() {
        return "polar";
    }
}

