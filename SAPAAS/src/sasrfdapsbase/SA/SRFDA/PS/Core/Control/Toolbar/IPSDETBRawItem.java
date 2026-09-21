/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSRawItem;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u5177\u680f\u76f4\u63a5\u5185\u5bb9\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDETBRawItemImpl", model="PSDETBItem")
@PSModelExtendMeta(extend="IPSDEToolbarItem", typevalue={"RAWITEM"})
public interface IPSDETBRawItem
extends IPSDEToolbarItem,
IPSRawItem,
IPSRawItemContainer {
    @Override
    public String getRawContent();
}

