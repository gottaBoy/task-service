/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterCondContainer;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u8fc7\u6ee4\u5668\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="condType")
public interface IPSDEDataFlowFilterCond
extends IPSModelObject {
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_SINGLE = "SINGLE";

    public void init(ISRFDAGlobalHelper var1, IPSDEDataFlowFilterCondContainer var2, IPSDEDataFlowFilterCond var3, ObjectNode var4) throws Exception;

    public String getCondType();

    public String getCondOp();

    public IPSDEDataFlowFilterCondContainer getPSDEDataFlowFilterCondContainer();
}

