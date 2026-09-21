/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u5b9e\u4f53\u884c\u4e3a\u6d88\u8d39\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DFDEACTIONSINK"})
public interface IPSDEDFDEActionSinkNode
extends IPSDEDataFlowSinkNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEAction getDstPSDEAction() throws Exception;
}

