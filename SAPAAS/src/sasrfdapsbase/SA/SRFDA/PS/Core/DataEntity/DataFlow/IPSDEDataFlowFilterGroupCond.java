/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterCond;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u8fc7\u6ee4\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
public interface IPSDEDataFlowFilterGroupCond
extends IPSDEDataFlowFilterCond {
    public Iterator<? extends IPSDEDataFlowFilterCond> getPSDEDataFlowFilterConds();

    public boolean isNotMode();
}

