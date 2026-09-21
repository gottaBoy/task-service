/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEExplorerView;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanel;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u5206\u9875\u5bfc\u822a\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5bfc\u822a\u90e8\u4ef6\u4ee5\u5206\u9875\u5f62\u5f0f\u5448\u73b0\uff0c\u652f\u6301\u5b9a\u4e49\u5206\u9875\u90e8\u4ef6\u7684\u653e\u7f6e\u4f4d\u7f6e", typevalue={"DETABEXPVIEW", "DETABEXPVIEW9"})
public interface IPSAppDETabExplorerView
extends IPSAppDEExplorerView {
    public static final String CONTROL_TABVIEWPANEL = "tabviewpanel";
    public static final String CONTROL_TABEXPPANEL = "tabexppanel";
    public static final String TABLAYOUT_TOP = "TOP";
    public static final String TABLAYOUT_LEFT = "LEFT";
    public static final String TABLAYOUT_BOTTOM = "BOTTOM";
    public static final String TABLAYOUT_RIGHT = "RIGHT";
    public static final String TABLAYOUT_FLOW = "FLOW";
    public static final String TABLAYOUT_FLOW_NOHEADER = "FLOW_NOHEADER";
    public static final String TABLAYOUT_NOHEADER = "NOHEADER";

    public IPSTabExpPanel getPSTabExpPanel();

    public String getTabLayout();
}

