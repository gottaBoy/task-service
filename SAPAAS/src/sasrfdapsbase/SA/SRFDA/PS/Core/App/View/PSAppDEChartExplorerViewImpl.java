/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEChartExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSChartExpBar;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DECHARTEXPVIEW"})
public class PSAppDEChartExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEView,
IPSAppDEChartExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDEChartExplorerViewImpl.class);
    private IPSChartExpBar iPSChartExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSChartExpBar = (IPSChartExpBar)this.getPSControl("CHARTEXPBAR");
    }

    public IPSDEChart getPSDEChart() {
        if (this.getPSChartExpBar() != null) {
            return this.getPSChartExpBar().getPSDEChart();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSChartExpBar getPSChartExpBar() {
        return this.iPSChartExpBar;
    }
}

