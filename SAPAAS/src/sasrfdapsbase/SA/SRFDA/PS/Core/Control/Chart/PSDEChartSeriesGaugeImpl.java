/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesGauge;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCSNoneImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"gauge"})
public class PSDEChartSeriesGaugeImpl
extends PSDEChartSeriesCSNoneImplBase
implements IPSChartSeriesGauge {
    private Object objRadius = null;
    private Integer nStartAngle = null;
    private Integer nEndAngle = null;
    private boolean bClockwise = true;
    private Integer nMinValue = null;
    private Integer nMaxValue = null;
    private Integer nSplitNumber = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getRADIUS())) {
            this.objRadius = PSDEChartSeriesGaugeImpl.getNumberOrString(this.getPSDEChartSeriesData().getRADIUS());
        }
        if (!this.getPSDEChartSeriesData().isSTARTANGLENull()) {
            this.nStartAngle = this.getPSDEChartSeriesData().getSTARTANGLE();
        }
        if (!this.getPSDEChartSeriesData().isENDANGLENull()) {
            this.nEndAngle = this.getPSDEChartSeriesData().getENDANGLE();
        }
        if (!this.getPSDEChartSeriesData().isCLOCKWISENull()) {
            this.bClockwise = this.getPSDEChartSeriesData().getCLOCKWISE();
        }
        if (!this.getPSDEChartSeriesData().isMINVALUENull()) {
            this.nMinValue = this.getPSDEChartSeriesData().getMINVALUE();
        }
        if (!this.getPSDEChartSeriesData().isMAXVALUENull()) {
            this.nMaxValue = this.getPSDEChartSeriesData().getMAXVALUE();
        }
        if (!this.getPSDEChartSeriesData().isSPLITNUMBERNull()) {
            this.nSplitNumber = this.getPSDEChartSeriesData().getSPLITNUMBER();
        }
    }

    @Override
    protected String onGetEChartsType() {
        return "gauge";
    }

    @Override
    @PSModelRTMeta(description="\u534a\u5f84", fields={"RADIUS"})
    public Object getRadius() {
        return this.objRadius;
    }

    @Override
    @PSModelRTMeta(description="\u8d77\u59cb\u89d2\u5ea6", fields={"STARTANGLE"})
    public Integer getStartAngle() {
        return this.nStartAngle;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u89d2\u5ea6", fields={"ENDANGLE"})
    public Integer getEndAngle() {
        return this.nEndAngle;
    }

    @Override
    @PSModelRTMeta(description="\u987a\u65f6\u9488", fields={"CLOCKWISE"})
    public boolean isClockwise() {
        return this.bClockwise;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c", fields={"MINVALUE"})
    public Integer getMinValue() {
        return this.nMinValue;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c", fields={"MAXVALUE"})
    public Integer getMaxValue() {
        return this.nMaxValue;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u5272\u6bb5\u6570", fields={"SPLITNUMBER"})
    public Integer getSplitNumber() {
        return this.nSplitNumber;
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }
}

