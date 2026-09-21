/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEExplorerView;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u8fb9\u680f\u5bfc\u822a\u89c6\u56fe\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", description="\u5bfc\u822a\u90e8\u4ef6\u4ee5\u8fb9\u680f\u5f62\u5f0f\u5448\u73b0\uff0c\u652f\u6301\u5b9a\u4e49\u8fb9\u680f\u7684\u653e\u7f6e\u4f4d\u7f6e", model="PSDEViewBase")
public interface IPSAppDESideBarExplorerView
extends IPSAppDEExplorerView {
    public static final String SIDEBARLAYOUT_TOP = "TOP";
    public static final String SIDEBARLAYOUT_LEFT = "LEFT";

    public String getSideBarLayout();
}

