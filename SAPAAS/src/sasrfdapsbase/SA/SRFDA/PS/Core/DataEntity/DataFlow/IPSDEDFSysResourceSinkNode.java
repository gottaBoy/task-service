/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysResourceSinkNode
extends IPSDEDataFlowSinkNode {
    public IPSSysResource getPSSysResource() throws Exception;
}

