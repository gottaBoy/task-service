/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppMenuItem", typevalues={"SEPERATOR"})
public class PSAppMenuSeperatorImpl
extends PSAppMenuItemImplBase
implements IPSAppMenuItem {
    private static final Log log = LogFactory.getLog(PSAppMenuSeperatorImpl.class);
    private boolean bSpanMode = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psAppMenuItem.isSPANFLAGNull()) {
            this.bSpanMode = this.psAppMenuItem.getSPANFLAG();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9694\u680f", ignoredumpvalues="false", ignorert=3)
    public boolean isSeperator() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u5ef6\u5c55", ignoredumpvalues="false", fields={"SPANFLAG"})
    public boolean isSpanMode() {
        return this.bSpanMode;
    }
}

