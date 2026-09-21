/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUICtrlInvokeLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUICtrlInvokeLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUICtrlInvokeLogic {
    @Override
    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception {
        return super.getSrcPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u90e8\u4ef6", dumpref=true, from="IPSDEUILogic", fields={"SRCPSDLPARAMID"})
    public IPSDEUILogicParam getInvokeCtrl() throws Exception {
        return this.getSrcPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u65b9\u6cd5", fields={"PARAM2"})
    public String getInvokeMethod() throws Exception {
        return this.psDELogicNode.getPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u53c2\u6570", dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getInvokeParam() throws Exception {
        return this.getDstPSDEUILogicParam();
    }
}

