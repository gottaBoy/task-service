/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIMsgBoxLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUIMsgBoxLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIMsgBoxLogic {
    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u62ac\u5934", fields={"PARAM3"})
    public String getTitle() {
        return this.psDELogicNode.getPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u5185\u5bb9", fields={"PARAM4"})
    public String getMessage() {
        return this.psDELogicNode.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6846\u7c7b\u578b", codelist="DELNMsgBoxType", fields={"PARAM2"})
    public String getMsgBoxType() {
        return this.psDELogicNode.getPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u96c6\u7c7b\u578b", codelist="DELNMsgBoxButtonsType", fields={"PARAM1"})
    public String getButtonsType() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6a21\u5f0f", codelist="DELNMsgBoxShowMode", fields={"PARAM11"})
    public String getShowMode() {
        return this.psDELogicNode.getPARAM11();
    }

    @Override
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u6846\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getMsgBoxParam() throws Exception {
        return this.getDstPSDEUILogicParam();
    }
}

