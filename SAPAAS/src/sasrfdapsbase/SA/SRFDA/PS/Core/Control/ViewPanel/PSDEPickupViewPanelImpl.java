/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEPickupViewPanel;
import SA.SRFDA.PS.Core.Control.ViewPanel.PSDEViewPanelImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSControl", typevalues={"PICKUPVIEWPANEL"})
public class PSDEPickupViewPanelImpl
extends PSDEViewPanelImpl
implements IPSDEPickupViewPanel {
    @Override
    protected String onGetControlType() {
        return "PICKUPVIEWPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe\u5bf9\u8c61", child=true)
    public IPSAppDEView getEmbeddedPSAppDEView() {
        return super.getEmbeddedPSAppDEView();
    }
}

