/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFDEDataSyncSinkNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSinkNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFDEDATASYNCSINK"})
public class PSDEDFDEDataSyncSinkNodeImpl
extends PSDEDataFlowSinkNodeImpl
implements IPSDEDFDEDataSyncSinkNode {
    private IPSDataEntity dstPSDataEntity = null;
    private IPSDEDataSync dstPSDEDataSync = null;

    @Override
    protected int onCheck() throws Exception {
        this.getDstPSDataEntity();
        this.getDstPSDEDataSync();
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataSync", fields={"DSTPSDEDATASYNCID"})
    public IPSDEDataSync getDstPSDEDataSync() throws Exception {
        if (this.dstPSDEDataSync == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATASYNCID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6807\u8bc6");
            }
            this.dstPSDEDataSync = this.getDstPSDataEntity().getPSDEDataSync(this.psDELogicNode.getDSTPSDEDATASYNCID());
        }
        return this.dstPSDEDataSync;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u7c7b\u578b", codelist="DataSyncInformType", ignoredumpvalues="0", fields={"PARAM7"})
    public int getEventType() {
        return this.psDELogicNode.getPARAM7();
    }
}

