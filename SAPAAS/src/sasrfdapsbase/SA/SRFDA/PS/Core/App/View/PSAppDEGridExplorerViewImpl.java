/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEGridExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSGridExpBar;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEGRIDEXPVIEW"})
public class PSAppDEGridExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEGridExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDEGridExplorerViewImpl.class);
    private IPSGridExpBar iPSGridExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSGridExpBar = (IPSGridExpBar)this.getPSControl("GRIDEXPBAR");
    }

    public IPSDEGrid getPSDEGrid() {
        if (this.getPSGridExpBar() != null) {
            return this.getPSGridExpBar().getPSDEGrid();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSGridExpBar getPSGridExpBar() {
        return this.iPSGridExpBar;
    }
}

