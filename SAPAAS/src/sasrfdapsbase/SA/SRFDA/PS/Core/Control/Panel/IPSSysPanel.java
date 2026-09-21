/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelLogic2;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9762\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewPanel")
public interface IPSSysPanel
extends IPSPanel {
    public Iterator<? extends IPSSysPanelLogic2> getPSSysPanelLogic2s();
}

