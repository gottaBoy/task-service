/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355IFrame\u9762\u677f\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"IFRAME"})
public interface IPSDEFormIFrame
extends IPSDEFormDetail {
    public String getEmbedViewId();

    public String getRefreshItems();

    public String getIFrameUrl();

    public IPSAppView getLinkPSAppView();
}

