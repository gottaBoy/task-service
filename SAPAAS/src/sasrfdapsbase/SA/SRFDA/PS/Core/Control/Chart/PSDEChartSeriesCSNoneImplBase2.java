/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPosition;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCSNoneImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEChartSeriesCSNoneImplBase2
extends PSDEChartSeriesCSNoneImplBase
implements IPSChartPosition {
    private Object objWidth = null;
    private Object objHeight = null;
    private Object objLeft = null;
    private Object objTop = null;
    private Object objRight = null;
    private Object objBottom = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getWIDTH())) {
            try {
                this.objWidth = Integer.parseInt(this.getPSDEChartSeriesData().getWIDTH());
            }
            catch (Exception ex) {
                this.objWidth = this.getPSDEChartSeriesData().getWIDTH();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getHEIGHT())) {
            try {
                this.objHeight = Integer.parseInt(this.getPSDEChartSeriesData().getHEIGHT());
            }
            catch (Exception ex) {
                this.objHeight = this.getPSDEChartSeriesData().getHEIGHT();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getLEFTPOS())) {
            try {
                this.objLeft = Integer.parseInt(this.getPSDEChartSeriesData().getLEFTPOS());
            }
            catch (Exception ex) {
                this.objLeft = this.getPSDEChartSeriesData().getLEFTPOS();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getTOPPOS())) {
            try {
                this.objTop = Integer.parseInt(this.getPSDEChartSeriesData().getTOPPOS());
            }
            catch (Exception ex) {
                this.objTop = this.getPSDEChartSeriesData().getTOPPOS();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getRIGHTPOS())) {
            try {
                this.objRight = Integer.parseInt(this.getPSDEChartSeriesData().getRIGHTPOS());
            }
            catch (Exception ex) {
                this.objRight = this.getPSDEChartSeriesData().getRIGHTPOS();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getBOTTOMPOS())) {
            try {
                this.objBottom = Integer.parseInt(this.getPSDEChartSeriesData().getBOTTOMPOS());
            }
            catch (Exception ex) {
                this.objBottom = this.getPSDEChartSeriesData().getBOTTOMPOS();
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", fields={"WIDTH"})
    public Object getWidth() {
        return this.objWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", fields={"HEIGHT"})
    public Object getHeight() {
        return this.objHeight;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u95f4\u9694", fields={"TOPPOS"})
    public Object getTop() {
        return this.objTop;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u95f4\u9694", fields={"LEFTPOS"})
    public Object getLeft() {
        return this.objLeft;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u65b9\u95f4\u9694", fields={"BOTTOMPOS"})
    public Object getBottom() {
        return this.objBottom;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u95f4\u9694", fields={"RIGHTPOS"})
    public Object getRight() {
        return this.objRight;
    }
}

