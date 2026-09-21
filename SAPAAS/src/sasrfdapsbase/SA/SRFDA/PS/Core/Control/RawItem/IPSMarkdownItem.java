/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.RawItem;

import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="MARKDOWN\u76f4\u63a5\u5185\u5bb9\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSMarkdownItemImpl")
@PSModelExtendMeta(extend="IPSRawItemBase", typevalue={"MARKDOWN"})
public interface IPSMarkdownItem
extends IPSRawItemBase {
    public String getContent();
}

