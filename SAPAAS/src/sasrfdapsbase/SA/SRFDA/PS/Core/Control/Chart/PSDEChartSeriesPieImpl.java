/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesPie;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCSNoneImplBase2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"pie", "pie3d"})
public class PSDEChartSeriesPieImpl
extends PSDEChartSeriesCSNoneImplBase2
implements IPSChartSeriesPie {
    private Object objCenter = null;
    private Object objRadius = null;
    private Integer nStartAngle = null;
    private Integer nMinAngle = null;
    private Integer nMinShowLabelAngle = null;
    private Object objRoseType = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getCENTER())) {
            this.objCenter = PSDEChartSeriesPieImpl.getCenterValue(this.getPSDEChartSeriesData().getCENTER());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getRADIUS())) {
            this.objRadius = PSDEChartSeriesPieImpl.getRadiusValue(this.getPSDEChartSeriesData().getRADIUS());
        }
        if (!this.getPSDEChartSeriesData().isSTARTANGLENull()) {
            this.nStartAngle = this.getPSDEChartSeriesData().getSTARTANGLE();
        }
        if (!this.getPSDEChartSeriesData().isMINANGLENull()) {
            this.nMinAngle = this.getPSDEChartSeriesData().getMINANGLE();
        }
        if (!this.getPSDEChartSeriesData().isMINSHOWLABELANGLENull()) {
            this.nMinShowLabelAngle = this.getPSDEChartSeriesData().getMINSHOWLABELANGLE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getROSETYPE())) {
            this.objRoseType = PSDEChartSeriesPieImpl.getBooleanOrString(this.getPSDEChartSeriesData().getROSETYPE());
        }
    }

    @Override
    protected String onGetEChartsType() {
        return "pie";
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u5706\u5fc3")
    public Object getCenter() {
        return this.objCenter;
    }

    @Override
    @PSModelRTMeta(description="\u534a\u5f84")
    public Object getRadius() {
        return this.objRadius;
    }

    @Override
    @PSModelRTMeta(description="\u8d77\u59cb\u89d2\u5ea6")
    public Integer getStartAngle() {
        return this.nStartAngle;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u6247\u533a\u89d2\u5ea6")
    public Integer getMinAngle() {
        return this.nMinAngle;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6807\u7b7e\u6247\u533a\u89d2\u5ea6")
    public Integer getMinShowLabelAngle() {
        return this.nMinShowLabelAngle;
    }

    @Override
    @PSModelRTMeta(description="\u5c55\u793a\u5357\u4e01\u683c\u5c14\u56fe")
    public Object getRoseType() {
        return this.objRoseType;
    }
}

