/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUICtrlFireEventLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUICtrlFireEventLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUICtrlFireEventLogic {
    @Override
    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception {
        return super.getSrcPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5bf9\u8c61", dumpref=true, from="IPSDEUILogic", fields={"SRCPSDLPARAMID"})
    public IPSDEUILogicParam getFireCtrl() throws Exception {
        return this.getSrcPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0", fields={"PARAM2"})
    public String getEventName() throws Exception {
        return this.psDELogicNode.getPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570", dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getEventParam() throws Exception {
        return this.getDstPSDEUILogicParam();
    }
}

