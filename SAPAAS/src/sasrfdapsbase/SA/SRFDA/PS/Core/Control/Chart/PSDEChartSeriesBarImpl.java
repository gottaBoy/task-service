/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesBar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesBarSupportable;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"bar", "bar3d", "column"})
public class PSDEChartSeriesBarImpl
extends PSDEChartSeriesImpl2
implements IPSChartSeriesBar {
    private Object objBarWidth = null;
    private Object objBarMaxWidth = null;
    private Object objBarMinWidth = null;
    private Integer nBarMinHeight = null;
    private Object objBarGap = null;
    private Object objBarCategoryGap = null;
    private boolean bStack = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.getPSDEChartSeriesData().isSTACKNull()) {
            this.bStack = this.getPSDEChartSeriesData().getSTACK();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBARWIDTH())) {
            this.objBarWidth = PSDEChartSeriesBarImpl.getNumberOrString(this.getPSDEChartSeriesData().getBARWIDTH());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBARMAXWIDTH())) {
            this.objBarMaxWidth = PSDEChartSeriesBarImpl.getNumberOrString(this.getPSDEChartSeriesData().getBARMAXWIDTH());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBARMINWIDTH())) {
            this.objBarMinWidth = PSDEChartSeriesBarImpl.getNumberOrString(this.getPSDEChartSeriesData().getBARMINWIDTH());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBARMINHEIGHT())) {
            this.nBarMinHeight = DataObject.getIntegerValue((Object)this.getPSDEChartSeriesData().getBARMINHEIGHT());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBARGAP())) {
            this.objBarGap = this.getPSDEChartSeriesData().getBARGAP();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBARCATEGORYGAP())) {
            this.objBarCategoryGap = this.getPSDEChartSeriesData().getBARCATEGORYGAP();
        }
    }

    @Override
    protected String onGetEChartsType() {
        return "bar";
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }

    @Override
    protected String getDefaultCoordinateSystem() throws Exception {
        return "XY";
    }

    @Override
    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return iPSChartCoordinateSystem instanceof IPSChartSeriesBarSupportable;
    }

    @Override
    @PSModelRTMeta(description="\u67f1\u6761\u5bbd\u5ea6", fields={"BARWIDTH"})
    public Object getBarWidth() {
        return this.objBarWidth;
    }

    @Override
    @PSModelRTMeta(description="\u67f1\u6761\u6700\u5927\u5bbd\u5ea6", fields={"BARMAXWIDTH"})
    public Object getBarMaxWidth() {
        return this.objBarMaxWidth;
    }

    @Override
    @PSModelRTMeta(description="\u67f1\u6761\u6700\u5c0f\u5bbd\u5ea6", fields={"BARMINWIDTH"})
    public Object getBarMinWidth() {
        return this.objBarMinWidth;
    }

    @Override
    @PSModelRTMeta(description="\u67f1\u6761\u6700\u5c0f\u9ad8\u5ea6", fields={"BARMINHEIGHT"})
    public Integer getBarMinHeight() {
        return this.nBarMinHeight;
    }

    @Override
    @PSModelRTMeta(description="\u4e0d\u540c\u7cfb\u5217\u67f1\u95f4\u8ddd\u79bb", fields={"BARGAP"})
    public Object getBarGap() {
        return this.objBarGap;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u7cfb\u5217\u67f1\u95f4\u8ddd\u79bb", fields={"BARCATEGORYGAP"})
    public Object getBarCategoryGap() {
        return this.objBarCategoryGap;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5806\u53e0", fields={"STACK"})
    public boolean isStack() {
        return this.bStack;
    }
}

