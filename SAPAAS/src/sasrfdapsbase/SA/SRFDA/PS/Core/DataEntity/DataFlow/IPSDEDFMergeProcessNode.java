/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowProcessNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFMergeProcessNode
extends IPSDEDataFlowProcessNode {
    public String getMergeType();

    public boolean isCopyIfNotExists();

    public boolean isMergeIntoField();

    public String getMergeField();
}

