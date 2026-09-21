/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelCtrlPos;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import java.util.ArrayList;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"CTRLPOS"})
public class PSSysPanelCtrlPosImpl
extends PSSysPanelItemImpl
implements IPSSysPanelCtrlPos {
    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_CTRLPOS";
    }
}

