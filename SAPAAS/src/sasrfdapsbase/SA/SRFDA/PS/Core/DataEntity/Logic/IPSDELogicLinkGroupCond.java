/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCondBase;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
public interface IPSDELogicLinkGroupCond
extends IPSDELogicLinkCond,
IPSDELogicLinkGroupCondBase {
    public Iterator<? extends IPSDELogicLinkCond> getPSDELogicLinkConds();
}

