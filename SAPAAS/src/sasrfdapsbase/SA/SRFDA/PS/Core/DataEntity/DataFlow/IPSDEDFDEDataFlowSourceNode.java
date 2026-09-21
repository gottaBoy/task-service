/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFDEDataFlowSourceNode
extends IPSDEDataFlowSourceNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEDataFlow getDstPSDEDataFlow() throws Exception;
}

