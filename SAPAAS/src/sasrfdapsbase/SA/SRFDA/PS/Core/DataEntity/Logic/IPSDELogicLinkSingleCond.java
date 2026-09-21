/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkSingleCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u5355\u9879\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SINGLE"})
public interface IPSDELogicLinkSingleCond
extends IPSDELogicLinkCond,
IPSDELogicLinkSingleCondBase {
    @Override
    public IPSDELogicParam getDstLogicParam() throws Exception;

    public String getPSDBValueOPId();
}

