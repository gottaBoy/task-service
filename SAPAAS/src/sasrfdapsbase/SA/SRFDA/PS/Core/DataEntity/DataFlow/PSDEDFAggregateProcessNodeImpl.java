/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFAggregateProcessNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowProcessNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFAGGREGATEPROCESS"})
public class PSDEDFAggregateProcessNodeImpl
extends PSDEDataFlowProcessNodeImpl
implements IPSDEDFAggregateProcessNode {
    private static final Log log = LogFactory.getLog(PSDEDFAggregateProcessNodeImpl.class);
    private boolean bAggregateFromField = false;
    private String strDataStreamAggregateField = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDELogicNode.isPARAM10Null()) {
            this.bAggregateFromField = this.psDELogicNode.getPARAM10();
        }
        if (this.isAggregateFromField()) {
            this.strDataStreamAggregateField = this.psDELogicNode.getPARAM2();
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        int nRet = 0;
        return nRet + super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5c5e\u6027\u6570\u636e\u6e90\u805a\u5408", ignoredumpvalues="false", fields={"PARAM10"})
    public boolean isAggregateFromField() {
        return this.bAggregateFromField;
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u6e90\u5c5e\u6027", fields={"PARAM2"})
    public String getAggregateField() {
        return this.strDataStreamAggregateField;
    }
}

