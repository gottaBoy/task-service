/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridYAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartYAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase2;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartGridXAxisImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartGridYAxisImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartGridImpl
extends PSDEChartCoordinateSystemControlImplBase2
implements IPSDEChartGrid {
    private static final Log log = LogFactory.getLog(PSDEChartGridImpl.class);
    private IPSChartGridXAxis iPSChartGridXAxis0 = null;
    private IPSChartGridXAxis iPSChartGridXAxis1 = null;
    private IPSChartGridYAxis iPSChartGridYAxis0 = null;
    private IPSChartGridYAxis iPSChartGridYAxis1 = null;
    private List<IPSChartXAxis> psChartXAxisList = null;
    private List<IPSChartYAxis> psChartYAxisList = null;

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSDEChartAxes> psDEChartAxes = this.getPSDEChart().getPSDEChartAxeses();
        if (psDEChartAxes != null) {
            while (psDEChartAxes.hasNext()) {
                PSDEChartGridYAxisImpl psDEChartGridYAxisImpl;
                PSDEChartGridXAxisImpl psDEChartGridXAxisImpl;
                IPSDEChartAxes iPSDEChartAxes = psDEChartAxes.next();
                if (iPSDEChartAxes.getCoordinateSystemIndex() != -1 ? iPSDEChartAxes.getCoordinateSystemIndex() != this.getPSChartCoordinateSystem().getIndex() : this.getPSChartCoordinateSystem().getOriginIndex() != -1) continue;
                if (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"bottom", (boolean)false) == 0) {
                    psDEChartGridXAxisImpl = new PSDEChartGridXAxisImpl();
                    psDEChartGridXAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                    this.iPSChartGridXAxis0 = psDEChartGridXAxisImpl;
                    continue;
                }
                if (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"top", (boolean)false) == 0) {
                    psDEChartGridXAxisImpl = new PSDEChartGridXAxisImpl();
                    psDEChartGridXAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                    this.iPSChartGridXAxis1 = psDEChartGridXAxisImpl;
                    continue;
                }
                if (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"left", (boolean)false) == 0) {
                    psDEChartGridYAxisImpl = new PSDEChartGridYAxisImpl();
                    psDEChartGridYAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                    this.iPSChartGridYAxis0 = psDEChartGridYAxisImpl;
                    continue;
                }
                if (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"right", (boolean)false) != 0) continue;
                psDEChartGridYAxisImpl = new PSDEChartGridYAxisImpl();
                psDEChartGridYAxisImpl.init(this.getDAGlobalHelper(), this, iPSDEChartAxes);
                this.iPSChartGridYAxis1 = psDEChartGridYAxisImpl;
            }
        }
        this.psChartXAxisList = new ArrayList<IPSChartXAxis>();
        this.psChartYAxisList = new ArrayList<IPSChartYAxis>();
        if (this.getPSChartGridXAxis0() != null) {
            this.psChartXAxisList.add(this.getPSChartGridXAxis0());
        }
        if (this.getPSChartGridXAxis1() != null) {
            this.psChartXAxisList.add(this.getPSChartGridXAxis1());
        }
        if (this.getPSChartGridYAxis0() != null) {
            this.psChartYAxisList.add(this.getPSChartGridYAxis0());
        }
        if (this.getPSChartGridYAxis1() != null) {
            this.psChartYAxisList.add(this.getPSChartGridYAxis1());
        }
        super.onInit();
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartGrid(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868X\u8f74\u96c6\u5408")
    public Iterator<? extends IPSChartXAxis> getPSChartXAxises() {
        if (this.psChartXAxisList == null || this.psChartXAxisList.size() == 0) {
            return null;
        }
        return this.psChartXAxisList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868Y\u8f74\u96c6\u5408")
    public Iterator<? extends IPSChartYAxis> getPSChartYAxises() {
        if (this.psChartYAxisList == null || this.psChartYAxisList.size() == 0) {
            return null;
        }
        return this.psChartYAxisList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u56fe\u8868\u683cX\u8f74[0]", dumpref=true, from="IPSDEChart", from_method="getPSChartXAxis", origin="IPSChartGridXAxis")
    public IPSChartGridXAxis getPSChartGridXAxis0() {
        return this.iPSChartGridXAxis0;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u56fe\u8868\u683cX\u8f74[1]", dumpref=true, from="IPSDEChart", from_method="getPSChartXAxis", origin="IPSChartGridXAxis")
    public IPSChartGridXAxis getPSChartGridXAxis1() {
        return this.iPSChartGridXAxis1;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u56fe\u8868\u683cY\u8f74[0]", dumpref=true, from="IPSDEChart", from_method="getPSChartYAxis", origin="IPSChartGridYAxis")
    public IPSChartGridYAxis getPSChartGridYAxis0() {
        return this.iPSChartGridYAxis0;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u56fe\u8868\u683cY\u8f74[1]", dumpref=true, from="IPSDEChart", from_method="getPSChartYAxis", origin="IPSChartGridYAxis")
    public IPSChartGridYAxis getPSChartGridYAxis1() {
        return this.iPSChartGridYAxis1;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTGRID";
    }

    @Override
    protected String onGetType() {
        return "grid";
    }
}

