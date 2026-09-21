/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelUserControl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9762\u677f\u81ea\u5b9a\u4e49\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysPanelUserControlImpl", model="PSSysViewPanelItem")
public interface IPSSysPanelUserControl
extends IPSSysPanelItem,
IPSPanelUserControl {
    public String getSampleContent();
}

