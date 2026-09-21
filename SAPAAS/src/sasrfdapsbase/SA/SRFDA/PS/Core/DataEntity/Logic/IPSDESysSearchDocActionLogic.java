/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u5168\u6587\u68c0\u7d22\u6587\u6863\u64cd\u4f5c\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SYSSEARCHDOCACTION"})
@PSModelPFIgnoreMeta
public interface IPSDESysSearchDocActionLogic
extends IPSDELogicNode {
    public IPSSysSearchScheme getPSSysSearchScheme() throws Exception;

    public IPSSysSearchDoc getPSSysSearchDoc() throws Exception;

    public String getSearchDocAction();

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;
}

