/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapField;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6620\u5c04\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMapDetail", implement="PSDEMapDetailImpl")
public interface IPSAppDEMapField
extends IPSDEMapField {
    public IPSAppDEField getSrcPSAppDEField();

    public IPSAppDEField getDstPSAppDEField();
}

