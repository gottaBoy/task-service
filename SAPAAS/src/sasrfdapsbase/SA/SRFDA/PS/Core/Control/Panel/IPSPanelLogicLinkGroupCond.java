/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicLinkCond;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSPanelLogicLinkGroupCond
extends IPSPanelLogicLinkCond {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IPSPanelLogicLinkCond> getPSPanelLogicLinkConds();
}

