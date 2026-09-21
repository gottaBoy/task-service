/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe\u9762\u677f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEPickupViewPanel
extends IPSDEViewPanel {
    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception;
}

