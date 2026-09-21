/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParamBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelIgnoreMeta
@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEMSLogicParam
extends IPSDELogicParamBase {
    public IPSDEMSLogic getPSDEMSLogic();
}

