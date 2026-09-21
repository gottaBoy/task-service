/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysDataSyncAgentSourceNode
extends IPSDEDataFlowSourceNode {
    public static final String SUBTYPE_RAW = "RAW";

    public String getSubType();

    public IPSSysDataSyncAgent getPSSysDataSyncAgent() throws Exception;
}

