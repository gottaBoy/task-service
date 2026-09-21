/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMapExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSMapExpBar;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMap;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMAPEXPVIEW"})
public class PSAppDEMapExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEMapExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDEMapExplorerViewImpl.class);
    private IPSMapExpBar iPSMapExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSMapExpBar = (IPSMapExpBar)this.getPSControl("MAPEXPBAR");
    }

    public IPSSysMap getPSSysMap() {
        if (this.getPSMapExpBar() != null) {
            return this.getPSMapExpBar().getPSSysMap();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5730\u56fe\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSMapExpBar getPSMapExpBar() {
        return this.iPSMapExpBar;
    }
}

