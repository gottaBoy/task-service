/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u9ed8\u8ba4\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDQJoin")
public interface IPSDEDQMain
extends IPSDEDQJoin {
    public boolean isExcludeMode();

    public boolean isDistinctMode();
}

