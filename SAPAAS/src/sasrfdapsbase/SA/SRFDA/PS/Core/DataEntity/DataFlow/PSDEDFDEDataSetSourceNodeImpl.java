/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFDEDataSetSourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFDEDATASETSOURCE"})
public class PSDEDFDEDataSetSourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFDEDataSetSourceNode {
    private IPSDataEntity dstPSDataEntity = null;
    private IPSDEDataSet dstPSDEDataSet = null;

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSDataEntity();
        this.getDstPSDEDataSet();
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.dstPSDEDataSet == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATASETID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u6807\u8bc6");
            }
            this.dstPSDEDataSet = this.getDstPSDataEntity().getPSDEDataSet(this.psDELogicNode.getDSTPSDEDATASETID());
        }
        return this.dstPSDEDataSet;
    }
}

