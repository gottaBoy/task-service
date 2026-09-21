/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDECalendarExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.PSAppDESideBarExplorerViewImpl;
import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSCalendarExpBar;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DECALENDAREXPVIEW"})
public class PSAppDECalendarExplorerViewImpl
extends PSAppDESideBarExplorerViewImpl
implements IPSAppDEView,
IPSAppDECalendarExplorerView {
    private static final Log log = LogFactory.getLog(PSAppDECalendarExplorerViewImpl.class);
    private IPSCalendarExpBar iPSCalendarExpBar = null;

    @Override
    protected void onPreparePSDEViewCtrls() throws Exception {
        super.onPreparePSDEViewCtrls();
        this.iPSCalendarExpBar = (IPSCalendarExpBar)this.getPSControl("CALENDAREXPBAR");
    }

    public IPSSysCalendar getPSSysCalendar() {
        if (this.getPSCalendarExpBar() != null) {
            return this.getPSCalendarExpBar().getPSSysCalendar();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u65e5\u5386\u89c6\u56fe\u5bfc\u822a\u680f")
    public IPSCalendarExpBar getPSCalendarExpBar() {
        return this.iPSCalendarExpBar;
    }
}

