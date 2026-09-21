/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSRawItem;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u4e0a\u4e0b\u6587\u76f4\u63a5\u5185\u5bb9\u83dc\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDETBRawItemImpl", model="PSDETBItem")
@PSModelExtendMeta(extend="IPSDEContextMenuItem", typevalue={"RAWITEM"})
public interface IPSDECMRawItem
extends IPSDEContextMenuItem,
IPSRawItem,
IPSRawItemContainer {
    @Override
    public String getRawContent();
}

