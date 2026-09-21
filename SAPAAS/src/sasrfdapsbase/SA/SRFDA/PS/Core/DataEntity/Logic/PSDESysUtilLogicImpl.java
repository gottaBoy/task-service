/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysUtilLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;

@PSModelPFIgnoreMeta
public class PSDESysUtilLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysUtilLogic {
    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u529f\u80fd\u7ec4\u4ef6\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSUTILDEID"})
    public IPSSysUtil getPSSysUtil() throws Exception {
        return super.getPSSysUtil();
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u529f\u80fd\u64cd\u4f5c", fields={"PARAM1"})
    public String getUtilAction() {
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

