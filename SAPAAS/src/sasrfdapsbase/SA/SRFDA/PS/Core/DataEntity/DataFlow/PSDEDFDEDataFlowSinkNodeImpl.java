/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSinkNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFDEDATAFLOWSINK"})
public class PSDEDFDEDataFlowSinkNodeImpl
extends PSDEDataFlowSinkNodeImpl
implements IPSDEDFDEDataFlowSinkNode {
    private IPSDataEntity dstPSDataEntity = null;
    private IPSDEDataFlow dstPSDEDataFlow = null;

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSDataEntity();
        this.getDstPSDEDataFlow();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        if (this.dstPSDataEntity == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6807\u8bc6");
            }
            this.dstPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDELogicNode.getDSTPSDEID());
        }
        return this.dstPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataFlow", fields={"DSTPSDEDATAFLOWID"})
    public IPSDEDataFlow getDstPSDEDataFlow() throws Exception {
        if (this.dstPSDEDataFlow == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATAFLOWID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u6807\u8bc6");
            }
            this.dstPSDEDataFlow = this.getDstPSDataEntity().getPSDEDataFlow(this.psDELogicNode.getDSTPSDEDATAFLOWID());
        }
        return this.dstPSDEDataFlow;
    }
}

