/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMainStateRS")
public interface IPSDEMainStateRS
extends IPSDataEntityObject {
    @Override
    public String getCodeName();

    public IPSDEMainState getPrevPSDEMainState();

    public IPSDEMainState getNextPSDEMainState();
}

