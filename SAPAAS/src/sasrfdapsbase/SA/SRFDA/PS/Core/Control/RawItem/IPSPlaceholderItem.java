/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5360\u4f4d\u76f4\u63a5\u5185\u5bb9\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSPlaceholderItemImpl")
@PSModelExtendMeta(extend="IPSRawItemBase", typevalue={"PLACEHOLDER"})
public interface IPSPlaceholderItem
extends IPSRawItemBase {
    public String getCaption();

    public String getContent();
}

