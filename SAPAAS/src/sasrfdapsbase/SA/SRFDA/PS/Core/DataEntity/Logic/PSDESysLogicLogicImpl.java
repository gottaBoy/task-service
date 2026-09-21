/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysLogicLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;

@PSModelPFIgnoreMeta
public class PSDESysLogicLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysLogicLogic {
    @Override
    protected int onCheck() throws Exception {
        if (this.getPSSysLogic() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61");
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u903b\u8f91\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSDELOGICNODEID"})
    public IPSSysLogic getPSSysLogic() throws Exception {
        return super.getPSSysLogic();
    }

    @Override
    @Deprecated
    public String strLogicParam() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8c03\u7528\u53c2\u6570", fields={"PARAM1"})
    public String getLogicParam() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8c03\u7528\u53c2\u65702", fields={"PARAM2"})
    public String getLogicParam2() {
        return this.psDELogicNode.getPARAM2();
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

