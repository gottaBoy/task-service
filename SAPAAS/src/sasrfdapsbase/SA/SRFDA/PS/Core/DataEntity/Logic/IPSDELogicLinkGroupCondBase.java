/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondBase;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSDELogicLinkGroupCondBase
extends IPSDELogicLinkCondBase {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<? extends IPSDELogicLinkCondBase> getPSDELogicLinkCondBases();
}

