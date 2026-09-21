/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEPICKUPVIEW", "DEPICKUPVIEW2", "DEPICKUPVIEW3"})
public interface IPSAppDEPickupView
extends IPSAppDEView {
    public boolean isEnableMultiSelect();

    public boolean isConvertPickupData();

    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception;
}

