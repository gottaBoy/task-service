/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFJoinGroupCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowProcessNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFJoinProcessNode
extends IPSDEDataFlowProcessNode {
    public IPSDEDFJoinGroupCond getPSDEDFJoinGroupCond();

    public String getJoinType();
}

