/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPosition;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEChartCoordinateSystemControlImplBase2
extends PSDEChartCoordinateSystemControlImplBase
implements IPSChartPosition {
    private Object objWidth = null;
    private Object objHeight = null;
    private Object objLeft = null;
    private Object objTop = null;
    private Object objRight = null;
    private Object objBottom = null;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDEChartCSData().getWIDTH())) {
            try {
                this.objWidth = Integer.parseInt(this.getPSDEChartCSData().getWIDTH());
            }
            catch (Exception ex) {
                this.objWidth = this.getPSDEChartCSData().getWIDTH();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.getPSDEChartCSData().getHEIGHT())) {
            try {
                this.objHeight = Integer.parseInt(this.getPSDEChartCSData().getHEIGHT());
            }
            catch (Exception ex) {
                this.objHeight = this.getPSDEChartCSData().getHEIGHT();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.getPSDEChartCSData().getLEFTPOS())) {
            try {
                this.objLeft = Integer.parseInt(this.getPSDEChartCSData().getLEFTPOS());
            }
            catch (Exception ex) {
                this.objLeft = this.getPSDEChartCSData().getLEFTPOS();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.getPSDEChartCSData().getTOPPOS())) {
            try {
                this.objTop = Integer.parseInt(this.getPSDEChartCSData().getTOPPOS());
            }
            catch (Exception ex) {
                this.objTop = this.getPSDEChartCSData().getTOPPOS();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.getPSDEChartCSData().getRIGHTPOS())) {
            try {
                this.objRight = Integer.parseInt(this.getPSDEChartCSData().getRIGHTPOS());
            }
            catch (Exception ex) {
                this.objRight = this.getPSDEChartCSData().getRIGHTPOS();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.getPSDEChartCSData().getBOTTOMPOS())) {
            try {
                this.objBottom = Integer.parseInt(this.getPSDEChartCSData().getBOTTOMPOS());
            }
            catch (Exception ex) {
                this.objBottom = this.getPSDEChartCSData().getBOTTOMPOS();
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6")
    public Object getWidth() {
        return this.objWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public Object getHeight() {
        return this.objHeight;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u95f4\u9694")
    public Object getTop() {
        return this.objTop;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u95f4\u9694")
    public Object getLeft() {
        return this.objLeft;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u65b9\u95f4\u9694")
    public Object getBottom() {
        return this.objBottom;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u95f4\u9694")
    public Object getRight() {
        return this.objRight;
    }
}

