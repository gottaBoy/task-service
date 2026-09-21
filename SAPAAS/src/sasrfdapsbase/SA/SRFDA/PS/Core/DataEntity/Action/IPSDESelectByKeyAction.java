/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u901a\u8fc7\u952e\u503c\u83b7\u53d6\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SELECTBYKEY"})
public interface IPSDESelectByKeyAction
extends IPSDEAction {
    public IPSDEDataQuery getPSDEDataQuery();
}

