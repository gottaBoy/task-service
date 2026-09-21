/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
public interface IPSDEUILogicLinkGroupCond
extends IPSDEUILogicLinkCond,
IPSDELogicLinkGroupCondBase {
    public Iterator<? extends IPSDEUILogicLinkCond> getPSDEUILogicLinkConds();
}

