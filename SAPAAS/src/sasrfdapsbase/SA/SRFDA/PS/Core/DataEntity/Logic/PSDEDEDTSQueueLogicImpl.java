/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.DTS.IPSDEDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEDEDTSQueueLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDEDEDTSQueueLogicImpl
extends PSDELogicNodeImpl
implements IPSDEDEDTSQueueLogic {
    private IPSDEDTSQueue iPSDEDTSQueue = null;

    @Override
    protected void onInit() throws Exception {
        if (this.getDstPSDataEntity() != null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDTSQUEUEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5f02\u6b65\u5904\u7406\u961f\u5217\u5bf9\u8c61");
            }
            this.iPSDEDTSQueue = this.getDstPSDataEntity().getPSDEDTSQueue(this.psDELogicNode.getDSTPSDEDTSQUEUEID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5f02\u6b65\u5904\u7406\u961f\u5217\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDTSQueue", fields={"DSTPSDEDTSQUEUEID"})
    public IPSDEDTSQueue getDstPSDEDTSQueue() throws Exception {
        return this.iPSDEDTSQueue;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }
}

