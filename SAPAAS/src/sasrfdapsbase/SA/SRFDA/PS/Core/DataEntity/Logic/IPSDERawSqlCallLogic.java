/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u76f4\u63a5SQL\u8c03\u7528\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"RAWSQLCALL"})
@PSModelPFIgnoreMeta
public interface IPSDERawSqlCallLogic
extends IPSDELogicNode {
    public IPSSysDBScheme getPSSysDBScheme() throws Exception;

    public String getSql();

    public boolean isFillDstLogicParam();

    public boolean isIgnoreResetDstLogicParam();

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;
}

