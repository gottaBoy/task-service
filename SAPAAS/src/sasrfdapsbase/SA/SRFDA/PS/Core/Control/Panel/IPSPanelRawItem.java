/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.IPSRawItem;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u9762\u677f\u76f4\u63a5\u5185\u5bb9\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewPanelItem", implement="PSSysPanelRawItemImpl")
@PSModelExtendMeta(extend="IPSPanelItem", typevalue={"RAWITEM"})
public interface IPSPanelRawItem
extends IPSPanelItem,
IPSRawItem,
IPSRawItemContainer {
    public static final String CONTENTTYPE_RAW = "RAW";
    public static final String CONTENTTYPE_HTML = "HTML";

    @Override
    public String getContentType();

    @Override
    public String getRawContent();

    @Override
    public String getHtmlContent();
}

