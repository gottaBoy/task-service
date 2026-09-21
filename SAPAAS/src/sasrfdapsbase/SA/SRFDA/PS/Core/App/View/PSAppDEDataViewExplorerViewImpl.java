/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEDataViewExplorerView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSDataViewExpBar;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEDATAVIEWEXPVIEW"})
public class PSAppDEDataViewExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEDataViewExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDEDataViewExplorerViewImpl.class);
    private IPSDataViewExpBar iPSDataViewExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSDataViewExpBar = (IPSDataViewExpBar)this.getPSControl("DATAVIEWEXPBAR");
    }

    public IPSDEDataView getPSDEDataView() {
        if (this.getPSDataViewExpBar() != null) {
            return this.getPSDataViewExpBar().getPSDEDataView();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5361\u7247\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSDataViewExpBar getPSDataViewExpBar() {
        return this.iPSDataViewExpBar;
    }
}

