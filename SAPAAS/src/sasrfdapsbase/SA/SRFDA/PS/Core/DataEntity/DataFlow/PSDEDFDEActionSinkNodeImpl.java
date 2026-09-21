/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFDEActionSinkNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSinkNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFDEACTIONSINK"})
public class PSDEDFDEActionSinkNodeImpl
extends PSDEDataFlowSinkNodeImpl
implements IPSDEDFDEActionSinkNode {
    private IPSDataEntity dstPSDataEntity = null;
    private IPSDEAction dstPSDEAction = null;

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSDataEntity();
        this.getDstPSDEAction();
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEAction", fields={"DSTPSDEACTIONID"})
    public IPSDEAction getDstPSDEAction() throws Exception {
        if (this.dstPSDEAction == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEACTIONID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a\u6807\u8bc6");
            }
            this.dstPSDEAction = this.getDstPSDataEntity().getPSDEAction(this.psDELogicNode.getDSTPSDEACTIONID());
        }
        return this.dstPSDEAction;
    }
}

