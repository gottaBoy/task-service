/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESortParamLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDESortParamLogicImpl
extends PSDELogicNodeImpl
implements IPSDESortParamLogic {
    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5217\u8868\u6392\u5e8f\u6a21\u5f0f", codelist="SortMode", fields={"DSTSORTDIR"})
    public String getDstSortDir() {
        return this.psDELogicNode.getDSTSORTDIR();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6392\u5e8f\u5c5e\u6027", fields={"CUSTOMDSTPARAM"})
    public String getDstFieldName() throws Exception {
        return this.psDELogicNode.getCUSTOMDSTPARAM();
    }
}

