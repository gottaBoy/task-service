/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDETabSearchView;
import SA.SRFDA.PS.Core.App.View.PSAppDETabExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DETABSEARCHVIEW", "DETABSEARCHVIEW9"})
public class PSAppDETabSearchViewImpl
extends PSAppDETabExplorerViewImpl
implements IPSAppDETabSearchView {
    private IPSSearchBar iPSSearchBar = null;

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("searchbar");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSSearchBar) {
            this.iPSSearchBar = (IPSSearchBar)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u680f\u90e8\u4ef6", hideempty=true)
    public IPSSearchBar getPSSearchBar() {
        return this.iPSSearchBar;
    }
}

