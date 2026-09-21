/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterGroupCond;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u8282\u70b9\u8fc7\u6ee4\u5668\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDataFlowNodeFilter
extends IPSDEDataFlowFilterGroupCond {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataFlowNode var2, ObjectNode var3) throws Exception;
}

