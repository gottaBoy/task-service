/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRSingleCondition;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u503c\u9012\u5f52\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"VALUERECURSION"}, model="PSDEFVRCond")
public interface IPSDEFVRValueRecursionCondition
extends IPSDEFVRSingleCondition {
    public IPSDataEntity getMajorPSDataEntity();

    public boolean isAlwaysCheck();
}

