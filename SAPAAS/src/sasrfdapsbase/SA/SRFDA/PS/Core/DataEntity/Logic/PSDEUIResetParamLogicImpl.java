/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIResetParamLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUIResetParamLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIResetParamLogic {
    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }
}

