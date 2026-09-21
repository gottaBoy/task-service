/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSortProcessNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowProcessNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSORTROCESS"})
public class PSDEDFSortProcessNodeImpl
extends PSDEDataFlowProcessNodeImpl
implements IPSDEDFSortProcessNode {
    private int nSkip = -1;
    private int nLimit = -1;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDELogicNode.isPARAM7Null()) {
            this.nSkip = this.psDELogicNode.getPARAM7();
        }
        if (!this.psDELogicNode.isPARAM8Null()) {
            this.nLimit = this.psDELogicNode.getPARAM8();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8df3\u8fc7\u8bb0\u5f55\u6570", ignoredumpvalues="-1", fields={"PARAM7"})
    public int getSkip() {
        return this.nSkip;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u8bb0\u5f55\u6570", ignoredumpvalues="-1", fields={"PARAM8"})
    public int getLimit() {
        return this.nLimit;
    }
}

