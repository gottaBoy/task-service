/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8c03\u7528\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEDATAFLOW"})
public interface IPSDEDEDataFlowLogic
extends IPSDELogicNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEDataFlow getDstPSDEDataFlow() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getRetPSDELogicParam() throws Exception;
}

