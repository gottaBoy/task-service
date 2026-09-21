/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysResourceSourceNode
extends IPSDEDataFlowSourceNode {
    public IPSSysResource getPSSysResource() throws Exception;
}

