/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEPickupView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEPickupViewPanel;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEPICKUPVIEW", "DEPICKUPVIEW2", "DEPICKUPVIEW3"})
public class PSAppDEPickupViewImpl
extends PSAppDEViewImpl
implements IPSAppDEPickupView {
    public static final String CTRL_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    private boolean bConvertPickupData = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bConvertPickupData = this.psViewBase.getVIEWPARAM5();
        }
        super.onInit();
    }

    @Override
    public boolean isEnableMultiSelect() {
        return false;
    }

    @Override
    public boolean isPickupView() {
        return true;
    }

    @Override
    public boolean isConvertPickupData() {
        return this.bConvertPickupData;
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        Iterator<IPSControl> psControls = this.getPSControls();
        if (psControls != null) {
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                if (!(iPSControl instanceof IPSDEPickupViewPanel)) continue;
                return ((IPSDEPickupViewPanel)iPSControl).getADPSDEDQConditions();
            }
        }
        return null;
    }
}

