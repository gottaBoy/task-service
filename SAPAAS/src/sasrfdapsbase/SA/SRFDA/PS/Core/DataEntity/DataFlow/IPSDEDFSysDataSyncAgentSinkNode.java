/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysDataSyncAgentSinkNode
extends IPSDEDataFlowSinkNode {
    public static final String SUBTYPE_RAW = "RAW";
    public static final String SUBTYPE_DEDATASYNC = "DEDATASYNC";

    public String getSubType();

    public IPSSysDataSyncAgent getPSSysDataSyncAgent() throws Exception;

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public int getEventType();
}

