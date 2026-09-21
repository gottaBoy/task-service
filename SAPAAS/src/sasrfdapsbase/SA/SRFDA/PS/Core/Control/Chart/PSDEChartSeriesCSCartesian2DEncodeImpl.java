/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemCartesian2D;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridYAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCSCartesian2DEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartYAxis;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesEncodeImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSChartSeriesEncode", typevalues={"XY"})
public class PSDEChartSeriesCSCartesian2DEncodeImpl
extends PSDEChartSeriesEncodeImplBase
implements IPSChartSeriesCSCartesian2DEncode {
    private IPSChartGridXAxis iPSChartGridXAxis = null;
    private IPSChartGridYAxis iPSChartGridYAxis = null;
    private String[] x = null;
    private String[] y = null;

    @Override
    protected void onInit() throws Exception {
        IPSChartGrid iPSChartGrid = null;
        IPSChartCoordinateSystem iPSChartCoordinateSystem = this.getPSDEChartSeries().getPSChartCoordinateSystem();
        if (iPSChartCoordinateSystem instanceof IPSChartCoordinateSystemCartesian2D) {
            iPSChartGrid = ((IPSChartCoordinateSystemCartesian2D)iPSChartCoordinateSystem).getPSChartGrid();
        }
        if (iPSChartGrid == null) {
            throw new Exception("\u56fe\u8868\u76f4\u89d2\u5750\u6807\u7cfb\u8868\u683c\u7ec4\u4ef6\u65e0\u6548");
        }
        if (this.getPSChartSeries().getXPSChartAxes() != null) {
            if (iPSChartGrid.getPSChartGridXAxis0() != null && StringHelper.compare((String)iPSChartGrid.getPSChartGridXAxis0().getPSDEChartAxes().getId(), (String)this.getPSChartSeries().getXPSChartAxes().getId(), (boolean)false) == 0) {
                this.iPSChartGridXAxis = iPSChartGrid.getPSChartGridXAxis0();
            }
            if (iPSChartGrid.getPSChartGridXAxis1() != null && StringHelper.compare((String)iPSChartGrid.getPSChartGridXAxis1().getPSDEChartAxes().getId(), (String)this.getPSChartSeries().getXPSChartAxes().getId(), (boolean)false) == 0) {
                this.iPSChartGridXAxis = iPSChartGrid.getPSChartGridXAxis1();
            }
        } else {
            this.iPSChartGridXAxis = iPSChartGrid.getPSChartGridXAxis0();
            if (this.iPSChartGridXAxis == null) {
                this.iPSChartGridXAxis = iPSChartGrid.getPSChartGridXAxis1();
            }
        }
        if (this.getPSChartSeries().getYPSChartAxes() != null) {
            if (iPSChartGrid.getPSChartGridYAxis0() != null && StringHelper.compare((String)iPSChartGrid.getPSChartGridYAxis0().getPSDEChartAxes().getId(), (String)this.getPSChartSeries().getYPSChartAxes().getId(), (boolean)false) == 0) {
                this.iPSChartGridYAxis = iPSChartGrid.getPSChartGridYAxis0();
            }
            if (iPSChartGrid.getPSChartGridYAxis1() != null && StringHelper.compare((String)iPSChartGrid.getPSChartGridYAxis1().getPSDEChartAxes().getId(), (String)this.getPSChartSeries().getYPSChartAxes().getId(), (boolean)false) == 0) {
                this.iPSChartGridYAxis = iPSChartGrid.getPSChartGridYAxis1();
            }
        } else {
            this.iPSChartGridYAxis = iPSChartGrid.getPSChartGridYAxis0();
            if (this.iPSChartGridYAxis == null) {
                this.iPSChartGridYAxis = iPSChartGrid.getPSChartGridYAxis1();
            }
        }
        if (this.getPSChartXAxis() != null) {
            if (StringHelper.compare((String)this.getPSChartXAxis().getEChartsType(), (String)"category", (boolean)false) == 0 || StringHelper.compare((String)this.getPSChartXAxis().getEChartsType(), (String)"time", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getCatalogField())) {
                    this.x = new String[]{this.getPSDEChartSeries().getCatalogField()};
                }
            } else {
                this.x = this.calcValues();
            }
        }
        if (this.getPSChartYAxis() != null) {
            if (StringHelper.compare((String)this.getPSChartYAxis().getEChartsType(), (String)"category", (boolean)false) == 0 || StringHelper.compare((String)this.getPSChartYAxis().getEChartsType(), (String)"time", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getCatalogField())) {
                    this.y = new String[]{this.getPSDEChartSeries().getCatalogField()};
                }
            } else {
                this.y = this.calcValues();
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="X\u8f74\u7ef4\u5ea6\u96c6\u5408", child=true)
    public String[] getX() {
        return this.x;
    }

    @Override
    @PSModelRTMeta(description="Y\u8f74\u7ef4\u5ea6\u96c6\u5408", child=true)
    public String[] getY() {
        return this.y;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868X\u5750\u6807\u8f74", dumpref=true, from="IPSDEChart", from_method="getPSChartXAxis")
    public IPSChartXAxis getPSChartXAxis() {
        return this.iPSChartGridXAxis;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868Y\u5750\u6807\u8f74", dumpref=true, from="IPSDEChart", from_method="getPSChartYAxis")
    public IPSChartYAxis getPSChartYAxis() {
        return this.iPSChartGridYAxis;
    }

    protected String[] calcValues() {
        ArrayList<String> valueList = new ArrayList<String>();
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getValueField()) && !valueList.contains(this.getPSDEChartSeries().getValueField())) {
            valueList.add(this.getPSDEChartSeries().getValueField());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getValue3Field()) && !valueList.contains(this.getPSDEChartSeries().getValue3Field())) {
            valueList.add(this.getPSDEChartSeries().getValue3Field());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getValue4Field()) && !valueList.contains(this.getPSDEChartSeries().getValue4Field())) {
            valueList.add(this.getPSDEChartSeries().getValue4Field());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getValue5Field()) && !valueList.contains(this.getPSDEChartSeries().getValue5Field())) {
            valueList.add(this.getPSDEChartSeries().getValue5Field());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeries().getValue6Field()) && !valueList.contains(this.getPSDEChartSeries().getValue6Field())) {
            valueList.add(this.getPSDEChartSeries().getValue6Field());
        }
        if (valueList.size() > 0) {
            return valueList.toArray(new String[valueList.size()]);
        }
        return null;
    }

    @Override
    protected String onGetType() {
        return "XY";
    }
}

