/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u629b\u51fa\u5f02\u5e38\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"THROWEXCEPTION"})
public interface IPSDEUIThrowExceptionLogic
extends IPSDEUILogicNode {
    public String getErrorInfo();

    public String getExceptionObj();

    public int getErrorCode();

    public IPSDEUILogicParam getExceptionParam() throws Exception;
}

