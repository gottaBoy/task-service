/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCalendar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemCalendar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartCalendar;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCalendarImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"CALENDAR"})
public class PSDEChartCoordinateSystemCalendarImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemCalendar {
    private IPSDEChartCalendar iPSDEChartCalendar = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartCalendarImpl psDEChartCalendarImpl = new PSDEChartCalendarImpl();
        psDEChartCalendarImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartCalendar = psDEChartCalendarImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5730\u7406\u5750\u6807\u7cfb\u7ec4\u4ef6", child=true)
    public IPSChartCalendar getPSChartCalendar() {
        return this.iPSDEChartCalendar;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartCalendar();
    }

    @Override
    protected String onGetEChartsType() {
        return "calendar";
    }

    @Override
    protected String onGetType() {
        return "CALENDAR";
    }
}

