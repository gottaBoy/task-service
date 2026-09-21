/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDataRegion;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelTabPage;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u9762\u677f\u5206\u9875\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysPanelTabPanelImpl", model="PSSysViewPanelItem")
@PSModelExtendMeta(extend="IPSPanelItem", typevalue={"TABPANEL"})
public interface IPSPanelTabPanel
extends IPSPanelItem,
IPSPanelDataRegion {
    public Iterator<IPSPanelTabPage> getPSPanelTabPages();
}

