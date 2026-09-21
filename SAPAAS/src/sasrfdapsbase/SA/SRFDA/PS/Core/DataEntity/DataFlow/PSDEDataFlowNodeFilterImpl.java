/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNodeFilter;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowFilterGroupCondImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PSDEDataFlowNodeFilterImpl
extends PSDEDataFlowFilterGroupCondImpl
implements IPSDEDataFlowNodeFilter {
    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataFlowNode iPSDEDataFlowNode, ObjectNode objectNode) throws Exception {
        super.init(iDAGlobalHelper, iPSDEDataFlowNode, null, objectNode);
    }
}

