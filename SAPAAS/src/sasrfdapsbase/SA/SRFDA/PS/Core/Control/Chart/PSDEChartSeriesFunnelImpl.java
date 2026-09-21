/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesFunnel;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCSNoneImplBase2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"funnel"})
public class PSDEChartSeriesFunnelImpl
extends PSDEChartSeriesCSNoneImplBase2
implements IPSChartSeriesFunnel {
    private String strFunnelAlign = null;
    private Integer nMinValue = null;
    private Integer nMaxValue = null;
    private Object objMaxSize = null;
    private Object objMinSize = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getFUNNELALIGN())) {
            this.strFunnelAlign = this.getPSDEChartSeriesData().getFUNNELALIGN();
        }
        if (!this.getPSDEChartSeriesData().isMINVALUENull()) {
            this.nMinValue = this.getPSDEChartSeriesData().getMINVALUE();
        }
        if (!this.getPSDEChartSeriesData().isMAXVALUENull()) {
            this.nMaxValue = this.getPSDEChartSeriesData().getMAXVALUE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getMAXSIZE())) {
            this.objMaxSize = PSDEChartSeriesFunnelImpl.getNumberOrString(this.getPSDEChartSeriesData().getMAXSIZE());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getMINSIZE())) {
            this.objMinSize = PSDEChartSeriesFunnelImpl.getNumberOrString(this.getPSDEChartSeriesData().getMINSIZE());
        }
    }

    @Override
    protected String onGetEChartsType() {
        return "funnel";
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6f0f\u6597\u56fe\u65b9\u5411", fields={"FUNNELALIGN"})
    public String getFunnelAlign() {
        return this.strFunnelAlign;
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
    @PSModelRTMeta(description="\u6700\u5927\u9762\u79ef", fields={"MAXSIZE"})
    public Object getMaxSize() {
        return this.objMaxSize;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u9762\u79ef", fields={"MINSIZE"})
    public Object getMinSize() {
        return this.objMinSize;
    }
}

