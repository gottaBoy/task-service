/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u81ea\u5b9a\u4e49\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"CUSTOM"})
public interface IPSDEDQCustomCondition
extends IPSDEDQCondition {
    public String getCondition();

    public String getCustomType();
}

