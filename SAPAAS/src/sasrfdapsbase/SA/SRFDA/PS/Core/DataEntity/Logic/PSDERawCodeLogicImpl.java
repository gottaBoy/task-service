/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDERawCodeLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDERawCodeLogicImpl
extends PSDELogicNodeImpl
implements IPSDERawCodeLogic {
    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u4ee3\u7801", fields={"PARAM4"})
    public String getCode() {
        return this.psDELogicNode.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u7c7b\u578b", fields={"PARAM1"})
    public String getCodeType() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7ed1\u5b9a\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"RETPSDLPARAMID"})
    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return super.getRetPSDELogicParam();
    }
}

