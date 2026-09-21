/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;

@PSModelExtendMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u9759\u6001\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"STATIC"})
public interface IPSDETreeStaticNode
extends IPSDETreeNode {
    public String getNodeValue();

    public String getText();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public String getTooltip();
}

