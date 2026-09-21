/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8282\u70b9\u5173\u7cfb\u5bfc\u822a\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDETreeNodeRSNavParam
extends IPSDETreeNodeRSParam,
IPSNavigateParam {
    @Override
    public boolean isRawValue();
}

