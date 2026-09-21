/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u5b9e\u4f53\u6570\u636e\u96c6\u6e90\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DFDEDATASETSOURCE"})
public interface IPSDEDFDEDataSetSourceNode
extends IPSDEDataFlowSourceNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEDataSet getDstPSDEDataSet() throws Exception;
}

