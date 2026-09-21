/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFDEDataSyncSinkNode
extends IPSDEDataFlowSinkNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEDataSync getDstPSDEDataSync() throws Exception;

    public int getEventType();
}

