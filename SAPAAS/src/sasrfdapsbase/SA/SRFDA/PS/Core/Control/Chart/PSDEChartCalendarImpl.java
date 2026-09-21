/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartCalendar;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartCalendarImpl
extends PSDEChartCoordinateSystemControlImplBase2
implements IPSDEChartCalendar {
    private static final Log log = LogFactory.getLog(PSDEChartCalendarImpl.class);

    @Override
    public String getModelType() {
        return "PSDECHARTGEO";
    }

    @Override
    protected String onGetType() {
        return "calendar";
    }
}

