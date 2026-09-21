/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;

@PSModelPFIgnoreMeta
public interface IPSDEDFSubSysServiceAPISourceNode
extends IPSDEDataFlowSourceNode {
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception;

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception;

    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception;
}

