/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSPanelLogicInvokeCtrl
extends IPSPanelLogicNode {
    public IPSPanelLogicParam getPSPanelLogicParam() throws Exception;

    public IPSPanelItem getPSPanelItem();

    public String getInvokeMethod();
}

