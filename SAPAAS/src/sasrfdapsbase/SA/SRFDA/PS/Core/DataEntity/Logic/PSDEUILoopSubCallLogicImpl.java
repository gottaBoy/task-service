/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILoopSubCallLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEUILoopSubCallLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUILoopSubCallLogic {
    @Override
    @PSModelRTMeta(description="\u5217\u8868\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"SRCPSDLPARAMID"})
    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception {
        return super.getSrcPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u586b\u5145\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }
}

