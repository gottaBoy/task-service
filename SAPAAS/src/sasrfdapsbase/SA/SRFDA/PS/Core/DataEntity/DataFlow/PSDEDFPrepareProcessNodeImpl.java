/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFPrepareProcessNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowProcessNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFPREPAREPROCESS"})
public class PSDEDFPrepareProcessNodeImpl
extends PSDEDataFlowProcessNodeImpl
implements IPSDEDFPrepareProcessNode {
    private static final Log log = LogFactory.getLog(PSDEDFPrepareProcessNodeImpl.class);
    private boolean bReselectColumn = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDELogicNode.isPARAM9Null()) {
            this.bReselectColumn = this.psDELogicNode.getPARAM9();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u65b0\u9009\u62e9\u5217", ignoredumpvalues="false", fields={"PARAM9"})
    public boolean isReselectColumn() {
        return this.bReselectColumn;
    }
}

