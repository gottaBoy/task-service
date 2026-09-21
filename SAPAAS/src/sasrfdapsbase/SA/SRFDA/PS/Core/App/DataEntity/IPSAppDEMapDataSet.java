/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataSet;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6620\u5c04\u6570\u636e\u96c6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMapDS")
public interface IPSAppDEMapDataSet
extends IPSDEMapDataSet {
    public IPSAppDEDataSet getSrcPSAppDEDataSet();

    public IPSAppDEDataSet getDstPSAppDEDataSet();
}

