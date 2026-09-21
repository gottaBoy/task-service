/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDECancelWFLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;

public class PSDECancelWFLogicImpl
extends PSDELogicNodeImpl
implements IPSDECancelWFLogic {
    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSWORKFLOWID"})
    public IPSWorkflow getPSWorkflow() throws Exception {
        return super.getPSWorkflow();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getPSWorkflowMust().getPSWFDE", fields={"PSWFDEID"})
    public IPSDEWF getPSDEWF() throws Exception {
        return super.getPSDEWF();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, doc="\u8c03\u7528{@link #getPSDEWF}.getPSDataEntity()")
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return this.getPSDEWF().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSApplication")
    public IPSAppWF getPSAppWF() {
        return super.getPSAppWF();
    }
}

