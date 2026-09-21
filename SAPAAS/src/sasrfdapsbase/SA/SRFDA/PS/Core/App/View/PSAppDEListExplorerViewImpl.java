/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEListExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSListExpBar;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DELISTEXPVIEW"})
public class PSAppDEListExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEListExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDEListExplorerViewImpl.class);
    private IPSListExpBar iPSListExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSListExpBar = (IPSListExpBar)this.getPSControl("LISTEXPBAR");
    }

    public IPSDEList getPSDEList() {
        if (this.getPSListExpBar() != null) {
            return this.getPSListExpBar().getPSDEList();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u8868\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSListExpBar getPSListExpBar() {
        return this.iPSListExpBar;
    }
}

