/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIBindParamLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUIBindParamLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIBindParamLogic {
    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"SRCPSDLPARAMID"})
    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception {
        return super.getSrcPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMSRCPARAM"})
    public String getSrcFieldName() throws Exception {
        return this.psDELogicNode.getCUSTOMSRCPARAM();
    }
}

