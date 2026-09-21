/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8c03\u7528\u7cfb\u7edf\u9884\u7f6e\u529f\u80fd\u7ec4\u4ef6\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SYSUTIL"})
@PSModelPFIgnoreMeta
public interface IPSDESysUtilLogic
extends IPSDELogicNode {
    public IPSSysUtil getPSSysUtil() throws Exception;

    public String getUtilAction();

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getRetPSDELogicParam() throws Exception;
}

