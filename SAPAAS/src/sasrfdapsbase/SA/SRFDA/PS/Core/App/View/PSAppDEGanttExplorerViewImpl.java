/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEGanttExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSGanttExpBar;
import SA.SRFDA.PS.Core.Control.Tree.IPSDEGantt;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEGANTTEXPVIEW"})
public class PSAppDEGanttExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEGanttExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDEGanttExplorerViewImpl.class);
    private IPSGanttExpBar iPSGanttExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSGanttExpBar = (IPSGanttExpBar)this.getPSControl("GANTTEXPBAR");
    }

    public IPSDEGantt getPSDEGantt() {
        if (this.getPSGanttExpBar() != null) {
            return this.getPSGanttExpBar().getPSDEGantt();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7518\u7279\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSGanttExpBar getPSGanttExpBar() {
        return this.iPSGanttExpBar;
    }
}

